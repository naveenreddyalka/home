%%%%%%%%%%%%%%%%%%%

% File: blocks-valid.lp

%%%%%%%%%%%%%%%%%%%

block(1..6).

% block can't be on itself
:- on(B,L1,T),B=L1,T = 0..m.

% this is redundant after the circles check
% block can't be on a block which is on it
:- on(B1,L1,T),on(B2,L2,T),L1=B2,L2=B1,T= 0..m.

% alteast 1 on table
:- not 1{on(B,table,T)},T= 0..m.

%to avoid cases like circles
%Answer: 4851
%on(2,1,0) on(5,2,0) on(6,3,0) on(1,4,0) on(4,5,0) on(3,table,0)

path(B1,B2,T) :-  on(B2,B1,T), T= 0..m.

path(B1,B3,T) :- path(B1,B2,T), on(B3,B2,T), T= 0..m.

:-path(B1,B2,T), B1=B2, block(B1),T= 0..m.


#show on/3.
