%location(B), block(B), on(B,L,T), move(B,L,T).

%sort and declarations
location(B):- block(B).
location(table).

%%state description

%two blocks not on same block
:- 2{on(BB,B,T)}, block(B), T=0..m.

%%effects and condition

%moving
on(B,L,T+1) :- move(B,L,T).

%concurrent moves
:- not {move(BB,LL,T)} hands, T=0..m-1.

%move block only when clear
:- move(B,L,T), on(B1,B,T).

%can't move on top if its being moved
:- move(B,B1,T), move(B1,L,T).

%fluents are initially exogenous
1{on(B,LL,0):location(LL)}1 :- block(B).

%uniqueness
:- not 1{on(B,LL,T)}1, block(B), T=1..m.

%actions are exogenous
{move(B,L,T)} :- block(B),location(L),T=0..m-1.

%commonsense law of inertia
{on(B,L,T+1)} :- on(B,L,T), T=0..m-1.
