%%%%%%%%%%%%%%%%%%%
% File: warehouse.lp: Automated Warehouse
%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%
% Testing - Use this area to add specific facts that will break the program, to remove later
%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% sort and object declaration
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
pair(1..n,1..n).
boolean(t;f).
object(node,1..n*n;highway,1..n*n;pickingStation,1..n*n;robot,1..n*n;shelf,1..n*n;product,1..n*n;order,1..n*n).

node(N,X,Y) :- init(object(node,N),value(at,pair(X,Y))).
highway(H,X,Y) :- init(object(highway,H),value(at,pair(X,Y))).
pickingStation(P,X,Y) :- init(object(pickingStation,P),value(at,pair(X,Y))).
robot(R,X,Y,0) :- init(object(robot,R),value(at,pair(X,Y))).
shelf(S,X,Y,0) :- init(object(shelf,S),value(at,pair(X,Y))).
product(I,S,U,0) :- init(object(product,I),value(on,pair(S,U))).
order(O,I,U,0) :- init(object(order,O),value(line,pair(I,U))).
order(O,P) :- init(object(order,O),value(pickingStation,P)).

% ???  highway, pickingStation, robot, shelf can only be in a node
% ???  no object can be placed out of the grid
% for order and shelf - quantity can't be negative

%%%%%%%%%%%%%%%%%%%%%%%%%%
% state description
%%%%%%%%%%%%%%%%%%%%%%%%%%
% Node, Highway, PickingStation, Robot, Shelf: same object can't have two locations
:-  2{node(N,X,Y)},pair(X,Y).

:-  2{highway(H,X,Y)},pair(X,Y).
:- highway(H,X,Y), not 1{node(N,X,Y)}.

:-  2{pickingStation(P,X,Y)}, pair(X,Y).
:- pickingStation(H,X,Y), not 1{node(N,X,Y)}.

:-  2{robot(R,X,Y,T):pair(X,Y)}, T=0..m.
:- robot(R,X,Y,T), not 1{node(N,X,Y)}, T=0..m.

% for any x,y - there can be only one shelf
:-  2{shelf(S,X,Y,T):pair(X,Y)},T=0..m.
:- shelf(H,X,Y,T), not 1{node(N,X,Y)},T=0..m.

%for any R, there can be only one move at T
1{move(R,DX,DY,T):DX=-1..1, DY=-1..1, |DX+DY|=1}1 :- robot(R,X,Y,T), T=0..m-1.

%for any O,P there can be only one delivery at T
1{deliver(R,O,I,UD,T):UD=0..US}1 :- robot(R,X,Y,T), order(O,I,UO,T),product(I,S,US,T), T=0..m-1.

%for any R there can be only one pickUp at T
1{pickUp(R,T)}1 :- robot(R,X,Y,T), T=0..m-1.

%for any R there can be only one putDown at T
1{putDown(R,T)}1 :- robot(R,X,Y,T), T=0..m-1.


% Product: the number 'u' of units is unique for each product 'i' and shelf 's', i.e., there is not more than one fact referring to the same product and shelf.
:- product(I,S,U,T), product(I,S,U1,T), U!=U1, T=1..m.

% Order+Product: where the number 'u' of units is unique for each order 'o' and product 'i', i.e., there is not more than one fact referring to the same order and product.
:- order(O,I,U,T), order(O,I,U1,T), U!=U1, T=1..m.
% also check of for same order there can two lines with same product

% Order+PickingStation: There is exactly one fact of this kind per order 'o' occurring in facts of the previous form, and a fact specifying the cell of picking station 'p' exists as well.
:- not 1{order(O,P)}1, order(O,I,U,T), T=1..m.
:- not 1{pickingStation(P,X,Y)}, order(O,P).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% effect and preconditions of action
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%Move - robot moves
%Move - if robot is Carry(R,S,T,t/f), shelf in in same location, shelf also moves
%Move - if robot is under shelf, it can't move to location with shelf
%Move - two robots can't switch over
%PickUp - robot and shelf location is same at T
%PickUp - robot is not having a shelf already


% move R to new location
robot(R,X+DX,Y+DY,T+1) :- move(R,DX,DY,T),robot(R,X,Y,T),node(N,X+DX,Y+DY), T=0..m.


%If R and S at same location and pickUp implies carry is true
carry(R,S,T+1,t) :- robot(R,X,Y,T),shelf(S,X,Y,T),carry(R,S,T,f),pickUp(R,T).

%shelf also moves if R is carrying S while move
shelf(S,X+DX,Y+DY,T+1) :- move(R,DX,DY,T),robot(R,X,Y,T),carry(R,S,T,t),shelf(S,X,Y,T), T=1..m-1.

%can't move to a shelf location with robot already carrying a shelf
:- move(R,DX,DY,T), shelf(S,X+DX,Y+DY,T), carry(R,S1,T,t), pair(X,Y).

%robots can't cross each other
:- move(R1,DX1,DY1,T), move(R2,DX2,DY2,T), robot(R1,X1,Y1,T), robot(R2,X2,Y2,T), X1+DX1=X2, Y1+DY1=Y2, X2+DX2 = X1, Y2+DY2=Y1.


% Deliver - At time step 't', the robot labeled 'r' delivers a positive integer 'u' many units of product 'i', included
% in order 'o'. The cell hosting 'r' at time step 't'-1 must be the cell of the picking station of order 'o'. Moreover,
% robot 'r' must carry some shelf on which at least 'u' many units of product 'i' are stored at time step 't'-1, and at
% least 'u' many units of product 'i' must be included in 'o' and yet be undelivered. In fact, the quantity of product
% 'i' stored on the shelf carried by 'r' and the number of units of 'i' included in order 'o' are both reduced by 'u'
% at time step 't', and neither of the resulting quantities may be negative.
order(O,I,UO-UD,T+1) :- deliver(R,O,I,UD,T), pickingStation(P,X,Y), order(O,P), order(O,I,UO,T), robot(R,X,Y,T), carry(R,S,T,t), shelf(S,X,Y,T), product(I,S,US,T), UD<=UO, UD<=US, T=1..m-1.
product(I,S,US-UD,T) :- deliver(R,O,I,UD,T), pickingStation(P,X,Y), order(O,P), order(O,I,UO,T), robot(R,X,Y,T), carry(R,S,T,t), shelf(S,X,Y,T), product(I,S,US,T), UD<=UO, UD<=US, T=1..m-1.


%PutDown - robot and shelf are at same location
%PutDown - shelf can't be put down on a highway
%Carry(R,S,T,t/f) - become false
carry(R,S,T+1,f) :- robot(R,X,Y,T),shelf(S,X,Y,T),carry(R,S,T,t),putDown(R,T),T=1..m-1.


%Concurrent actions are
% No PutDown and Move together
% No Deliver and Move together
% No PickUp and Move together
% No PutDown and Deliver together

:- putDown(R,T), move(R,DX,DY,T), T=1..m.
:- pickUp(R,T), move(R,DX,DY,T), T=1..m.
:- deliver(R,O,I,UD,T), move(R,DX,DY,T), T=1..m.
:- pickUp(R,T), deliver(R,O,I,UD,T), T=1..m.
:- putDown(R,T), deliver(R,O,I,UD,T), T=1..m.


%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% domain independent axioms
%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%% flaunts are initially exogenous
% robots, shelves, order(O,I,U), Carry, (is produt a fluent?)
%these i guess are from input - we covered them already
% uniqueness and existence of value constraints

:- not 1{robot(R,X,Y,T)}1,  robot(R,X,Y,T),  T=1..m.
:- not 1{shelf(S,X,Y,T)}1, shelf(S,X,Y,T), T=1..m.
:- not 1{product(I,S,U,T)}1, product(I,S,U,T),shelf(S,X,Y,T), T=1..m.
:- not 1{order(O,I,U,T)}1, product(I,S,U,T), order(O,P), T=1..m.




%% actions are exogenous
% move, PutDown, PickUp, Deliver
{move(R,DX,DY,T)} :- robot(R,X,Y,T), T=0..m-1, DX=-1..1, DY=-1..1, |DX+DY|=1.
{pickUp(R,T)} :- robot(R,X,Y,T), T=0..m-1.
{putDown(R,T)} :- robot(R,X,Y,T), T=0..m-1.
{deliver(R,O,I,UD,T)} :- robot(R,X,Y,T), order(O,I,UO,T),product(I,S,US,T), T=0..m-1,UD=0..US.

%% commonsense law of inertia
% carry, robots, shelf, order(O,I,U)
{robot(R,X,Y,T+1)} :- robot(R,X,Y,T), T<m.
{shelf(S,X,Y,T+1)} :- shelf(S,X,Y,T), T<m.
{product(I,S,U,T+1)} :- product(I,S,U,T), T<m.
{order(O,I,U,T+1)} :- order(O,I,U,T), T<m.



#show move/4.
#show robot/4.
