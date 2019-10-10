%%sort and object declaration
boolean(t;f).
object(box;banana;monkey).
location(l1;l2;l3).

%% state constraints
loc(banana,L,T) :- hasBanana(t,T),loc(monkey,L,T).
loc(monkey,L,T) :- onBox(t,T), loc(box,L,T).

%% effect and preconditions

% walk
loc(monkey,L,T+1) :- walk(L,T).
:- walk(L,T), loc(monkey,L,T).
:- walk(L,T), onBox(t,T).

%pushBox
loc(monkey,L,T+1) :- pushBox(L,T).
loc(box,L,T+1) :- pushBox(L,T).
:- pushBox(L,T), loc(monkey,L,T).
:- pushBox(L,T), onBox(t,T).
:- pushBox(L,T), loc(monkey,L1,T), loc(box,L2,T), L1!=L2.

%climbOn
onBox(t,T+1) :- climbOn(T).
:- onBox(t,T),climbOn(T).
:- climbOn(T),loc(monkey,L1,T), loc(box,L2,T), L1!=L2.

%climbOff
onBox(f,T+1) :- climbOff(T).
:- onBox(f,T),climbOff(T).

%graspBanana
hasBanana(t,T+1) :- graspBanana(T).
:- graspBanana(T),hasBanana(t,T).
:- onBox(f,T),graspBanana(T).
:- graspBanana(T),loc(monkey,L1,T), loc(banana,L2,T), L1!=L2.

% disallow concurrent actions
:- pushBox(L,T),walk(L,T).
:- climbOn(T),walk(L,T).
:- pushBox(L,T),climbOn(T).
:- climbOff(T),graspBanana(T).

%:- pushBox(L,T),climbOff(T).
%:- climbOff(T),walk(L,T).

%% domain independent actions

% fluent are initially exogenous
1{hasBanana(BB,0):boolean(BB)}1.
1{onBox(BB,0):boolean(BB)}1.
1{loc(B,LL,0):location(LL)}1 :- object(B).

% uniqueness and existence of fluent values
:- not 1{loc(B,LL,T)}1, object(B), T=1..m.
:- not 1{onBox(B,T):boolean(B)}1, T=1..m.
:- not 1{hasBanana(B,T):boolean(B)}1, T=1..m.

% actions are exogenous
{walk(L,T)} :- location(L), T=0..m-1.
{pushBox(L,T)} :- location(L), T=0..m-1.
{climbOff(T)} :-  T=0..m-1.
{climbOn(T)} :- T=0..m-1.
{graspBanana(T)} :- T=0..m-1.

% commonsense law of inertia
{hasBanana(B,T+1)} :- hasBanana(B,T), T=0..m-1.
{onBox(B,T+1)} :- onBox(B,T), T=0..m-1.
{loc(B,L,T+1)} :- loc(B,L,T), T=0..m-1.

%#show loc/3.
%#show hasBanana/2.
%#show onBox/2.
#show walk/2.
#show pushBox/2.
#show climbOn/1.
#show climbOff/1.
#show graspBanana/1.
