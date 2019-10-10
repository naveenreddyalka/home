#include "input.lp".

%#const horizon=1.
time(1..horizon).

direction((X,Y)) :- X=-1..1, Y=-1..1, |X+Y|=1.
nextto((X,Y),(X',Y'),(X+X',Y+Y')) :- position((X,Y)), direction((X',Y')), position((X+X',Y+Y')).



 {    move(R,D,T) : direction(D) ;
    pickup(R,S,T) : isShelf(S)   ;
   putdown(R,S,T) : isShelf(S)   } 1 :- isRobot(R), time(T).

waits(R,T) :- not pickup(R,_,T), not putdown(R,_,T), not move(R,_,T), isRobot(R), time(T).

% - move/3 ----------------------------------------------------------------------
position(R,C,T) :- move(R,D,T),    position(R,C',T-1),     nextto(C',D,C).
                :- move(R,D,T),    position(R,C ,T-1), not nextto(C, D,_).

% - pickup/3 --------------------------------------------------------------------
 carries(R,S,T) :- pickup(R,S,T).
                :- pickup(R,S,T),   carries(R,_,T-1).
                :- pickup(R,S,T),   carries(_,S,T-1).                                                    % NEEDED (position of two robots)!?
                :- pickup(R,S,T),  position(R,C,T-1), not position(S,C,T-1).
                :- pickup(R,S,T),  position(S,C,T-1), not position(R,C,T-1).

% - putdown/3 -------------------------------------------------------------------
                :- putdown(R,S,T), not carries(R,S,T-1).

% - serves/4 --------------------------------------------------------------------
serves(R,S,P,T) :- position(R,C,T), carries(R,S,T), position(P,C), strategy.

% - inertia ---------------------------------------------------------------------
position(R,C,T) :- position(R,C,T-1), not    move(R,_,T), isRobot(R), time(T).
 carries(R,S,T) :-  carries(R,S,T-1), not putdown(R,S,T),             time(T).

% - (in)direct effects ----------------------------------------------------------
position(S,C,T) :- position(R,C,T  ),     carries(R,S,T).
position(S,C,T) :- position(S,C,T-1), not carries(_,S,T), isShelf(S), time(T).

% - edge collision --------------------------------------------------------------
moveto(C',C,T) :- nextto(C',D,C), position(R,C',T-1), move(R,D,T).
 :- moveto(C',C,T), moveto(C,C',T), C < C'.

% - vertex collision ------------------------------------------------------------
 :- { position(R,C,T) : isRobot(R) }  > 1, position(C), time(T).
 :- { position(S,C,T) : isShelf(S) }  > 1, position(C), time(T).

% - auxiliaries -----------------------------------------------------------------
 :- { position(R,C,T) } != 1, isRobot(R), time(T).
 :- { position(S,C,T) } != 1, isShelf(S), time(T).

 :- { carries(R,S,T) } > 1, isRobot(R), time(T).
 :- { carries(R,S,T) } > 1, isShelf(S), time(T).
strategy.

candoShelf(S,P,C) :- shelved(S,A), ordered(O,A), target(O,P), position(P,C).
candoShelf(S)     :- candoShelf(S,_,_).
cannoShelf(S,C)   :- candoShelf(S), position(P,C), not candoShelf(S,P,C).

candiShelf(S,P) :- candoShelf(S,P,C), not cannoShelf(S,C).
candiShelf(S)   :- candiShelf(S,P), position(S,C,0), not cannoShelf(S,C).



 :- carries(_,S,_), not candiShelf(S).

 :- serves(_,S,P,_), candiShelf(S), not candiShelf(S,P).

 :- move(R,_,_), not serves(R,_,_,_).

 :- pickup(R,S,T), not instant(S), not serves(R,S,_,T') : time(T'), T' > T.
 :- serves(R,S,_,T), not instant(S), not pickup(R,S,T') : time(T'), T' < T.

 :- putdown(R,S,T), not serves(R,S,_,T') : time(T'), T' < T.
 :- putdown(R,S,T), not   pickup(R,S,T') : time(T'), T' < T.
#include "./quantities.lp".



:- ordered(_,_,1,horizon).

:- carries(_,_,horizon).

:- position(_,C), position(_,C,horizon).
#show.
#show init/2.



#show occurs(object(robot,R), action(move,   D      ), T) :    move(robot(R),D,T).
#show occurs(object(robot,R), action(pickup, ()     ), T) :  pickup(robot(R),_,T).
#show occurs(object(robot,R), action(putdown,()     ), T) : putdown(robot(R),_,T).

#show occurs(object(robot,R), action(deliver,(O,A  )), T) : process(product(A),order(O),C,T), toShelf(S,C), position(robot(R),C,T-1).
#show occurs(object(robot,R), action(deliver,(O,A  )), T) : process(product(A),order(O),C,T), atShelf(S,C,T-1), carries(robot(R),S,T-1).
#show occurs(object(robot,R), action(deliver,(O,A  )), T) : process(product(A),order(O),C,T), position(S,C,T), carries(robot(R),S,T-1), shelved(S,product(A)).
#show occurs(object(robot,R), action(deliver,(O,A,N)), T) : process(product(A),order(O),S,N,T), carries(robot(R),S,T-1).
