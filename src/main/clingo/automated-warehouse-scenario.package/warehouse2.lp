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

object(node,1..n*n;highway,1..n*n;pickingStation,1..n*n;robot,1..n*n;shelf,1..n*n;product,1..n*n;order,1..n*n).
value(at;on;line,pair(X,Y)) :- pair(X,Y).
move(1..n,1,0,1..m-1;1..n,0,1,1..m-1;1..n,-1,0,1..m-1;1..n,0,-1,1..m-1).
boolean(t;f).
node(N,X,Y) :- init(object(node,N),value(at,pair(X,Y))).
highway(H,X,Y) :- init(object(highway,H),value(at,pair(X,Y))), node(N,X,Y).
pickingStation(P,X,Y) :- init(object(pickingStation,P),value(at,pair(X,Y))), node(N,X,Y).
robot(R,X,Y,T) :- init(object(robot,R),value(at,pair(X,Y))), node(N,X,Y), T=1..m.
shelf(S,X,Y,T) :- init(object(shelf,S),value(at,pair(X,Y))), node(N,X,Y), T=1..m.
product(I,S,U) :- init(object(product,I),value(on,pair(S,U))), shelf(S,X,Y).
order(O,I,U) :- init(object(order,O),value(line,pair(I,U))), product(I,S,U).
order(O,P) :- init(object(order,O),value(pickingStation,P)), pickingStation(P,X,Y).

% ???  highway, pickingStation, robot, shelf can only be in a node
% ???  no object can be placed out of the grid
% for order and shelf - quantity can't be negative
%%%%%%%%%%%%%%%%%%%%%%%%%%
% state description
%%%%%%%%%%%%%%%%%%%%%%%%%%
% Node, Highway, PickingStation, Robot, Shelf: same object can't have two locations
:-  2{node(N,X,Y)}, pair(X,Y).

:-  2{robot(R,X,Y)}, pair(X,Y).
:- robot(H,X,Y), not 1{node(N,X,Y)}.

:-  2{shelf(S,X,Y)}, pair(X,Y).
:- shelf(H,X,Y), not 1{node(N,X,Y)}.

% Product: the number 'u' of units is unique for each product 'i' and shelf 's', i.e., there is not more than one fact referring to the same product and shelf.
:- product(I,S,U), product(I,S,U1), U!=U1.

% Order+Product: where the number 'u' of units is unique for each order 'o' and product 'i', i.e., there is not more than one fact referring to the same order and product.
:- order(O,I,U), order(O,I,U1), U!=U1.
% also check of for same order there can two lines with same product

% Order+PickingStation: There is exactly one fact of this kind per order 'o' occurring in facts of the previous form, and a fact specifying the cell of picking station 'p' exists as well.
:- not 1{order(O,P)}1, order(O,I,U).
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
robot(R,X+dx,Y+dy,T+1) :- move(R,dx,dy,T), T=1..m-1.

%If R and S at same location and pickUp implies carry is true
carry(R,S,T+1,t) :- robot(R,X,Y,T),shelf(S,X,Y,T),carry(R,S,T,f),pickUp(R,T).

%shelf also moves if R is carrying S while move
shelf(S,X+dx,Y+dy,T+1) :- move(R,dx,dy,T),robot(R,X,Y,T),carry(R,S,T,t), T=1..m-1.

%can't move to a shelf location with robot already carrying a shelf
:- move(R,dx,dy,T), shelf(S,X+dx,Y+dy,T), carry(R,S1,T,t).

%robots can't cross each other
:- move(R1,dx1,dy1,T), move(R2,dx2,dy2,T), robot(R1,X1,Y1,T), robot(R2,X2,Y2,T), X1+dx1=X2, Y1+dy1=Y2, X2+dx2 = X1, Y2+dy2=Y1.


%Deliver - robot, shelf, PickingStaion location is same at T
%Deliver - The robot needs to have a shelf with min quantity of order O
%Deliver - robot ->  shelf and PickingStaion are of order O
%Deliver - robot ->  shelf be reduced of units by the quantity available to be delivered in the order for product i and then order also be reduced same
%Carry(R,S,T,t/f) - needs to true

%PutDown - robot and shelf are at same location
%PutDown - shelf can't be put down on a highway
%Carry(R,S,T,t/f) - become false

%Concurrent actions are
% No PutDown and Move together
% No Deliver and Move together
% No PickUp and Move together
% No PutDown and Deliver together


%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% domain independent axioms
%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%% fluents are initially exogenous
% robots, shelfs, order(O,I,U), Carry, (is produt a fluent?)

%% actions are exogenous
% move, PutDown, PickUp, Deliver

%% commonsense law of inertia
% carry, robots, shelf, order(O,I,U)


occurs(object(robot,R),move(X,Y),T) :- move(R,X,Y,T).
occurs(object(robot,R),pickup,T) :- pickup(R,T).
occurs(object(robot,R),deliver(O,I,U),T) :- deliver(R,O,I,U,T).

%#show occurs/3.

%Goal
%:- not {order(O,I,U)}, U=0.



%move(1,-1,0,1).
%pickup(2,2).
%deliver(2,1,3,4,4).
