like(1,2; 3,4).

dislike(2,3; 1,3).

{at(G,1..n)}=1 :- G=1..n.
X1=X2 :- at(X1,Y), at(X2,Y).
:- at(X1,Y), at(X2,Y), X1!=X2.

adj(X1,X2) :- at(X1,K), at(X2,L), |K-L|=1.
adj(X1,X2) :- at(X1,1), at(X2,n).
adj(X1,X2) :- at(X1,n), at(X2,1).

:- dislike(X,Y), adj(X,Y).

:- like(X,Y), not adj(X,Y).

#show at/2.
