
%%%%%%%%%%%%%%%%%%%
% File: warehouse.lp: Automated Warehouse
%%%%%%%%%%%%%%%%%%%

% sort and object declaration

object(node,1..n*n;highway,1..n*n;pickingStation,1..n*n;robot,1..n*n;shelf,1..n*n;product,1..n*n;order,1..n*n).
objectAction(at;on;pickingStation;line).
pair(1..n,1..n).

%object node;highway;pickingStation;robot;shelf can only have action at with only one X,Y
1{init(object(B,I),value(A,pair(X,Y))):pair(X,Y)}1 :- object(B,I),objectAction(A),B={node;highway;pickingStation;robot;shelf}, A=at.

%object product can only have action on with only shelf ID
1{init(object(B,I),value(A,pair(X,Y))):pair(X,Y)}1 :- object(B,I),objectAction(A),B=product,A=on.

%x -> product id, y -> count(product id =x)
1{init(object(B,I),value(A,pair(X,Y))):object(P,X),objectAction(A),P=product,A=line,Y=1..n} :- object(B,I),B=order.

%every order needs to be delivered to one picking station
1{init(object(B,I),value(P,PI)):object(P,PI),P=pickingStation}1 :- object(B,I),B=order.

% every X,Y is unique to any object id
:- init(object(B1,I1),value(A,pair(X,Y))), init(object(B2,I2),value(A,pair(X,Y))), B1==B2, I1!=I2.


:- not init(object(node,1),value(at,pair(1,1))).
:- not init(object(node,2),value(at,pair(2,1))).
:- not init(object(node,3),value(at,pair(3,1))).
:- not init(object(node,4),value(at,pair(4,1))).
:- not init(object(node,5),value(at,pair(1,2))).
:- not init(object(node,6),value(at,pair(2,2))).
:- not init(object(node,7),value(at,pair(3,2))).
:- not init(object(node,8),value(at,pair(4,2))).
:- not init(object(node,9),value(at,pair(1,3))).
:- not init(object(node,10),value(at,pair(2,3))).
:- not init(object(node,11),value(at,pair(3,3))).
:- not init(object(node,12),value(at,pair(4,3))).
:- not init(object(node,14),value(at,pair(2,4))).
:- not init(object(node,15),value(at,pair(3,4))).
:- not init(object(node,16),value(at,pair(4,4))).

:- not init(object(highway,4),value(at,pair(4,1))).
:- not init(object(highway,8),value(at,pair(4,2))).
:- not init(object(highway,12),value(at,pair(4,3))).
:- not init(object(highway,13),value(at,pair(1,4))).
:- not init(object(highway,14),value(at,pair(2,4))).
:- not init(object(highway,15),value(at,pair(3,4))).
:- not init(object(highway,16),value(at,pair(4,4))).

:- not init(object(pickingStation,1),value(at,pair(1,3))).
:- not init(object(pickingStation,2),value(at,pair(3,1))).

:- not init(object(robot,1),value(at,pair(4,3))).
:- not init(object(robot,2),value(at,pair(2,2))).

:- not init(object(shelf,1),value(at,pair(3,3))).
:- not init(object(shelf,3),value(at,pair(2,3))).
:- not init(object(shelf,4),value(at,pair(2,2))).
:- not init(object(shelf,5),value(at,pair(3,2))).
:- not init(object(shelf,6),value(at,pair(1,2))).

:- not init(object(product,1),value(on,pair(3,1))).
:- not init(object(product,2),value(on,pair(4,1))).
:- not init(object(product,3),value(on,pair(6,4))).
:- not init(object(product,4),value(on,pair(5,1))).
:- not init(object(product,4),value(on,pair(6,1))).



:- not init(object(order,1),value(line,pair(1,1))).
:- not init(object(order,1),value(line,pair(3,4))).
:- not init(object(order,2),value(line,pair(2,1))).
:- not init(object(order,3),value(line,pair(4,1))).


:- not init(object(order,1),value(pickingStation,1)).
:- not init(object(order,2),value(pickingStation,2)).
:- not init(object(order,3),value(pickingStation,2)).
