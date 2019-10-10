d(1..3).
b(a;b;c;d).
{f(X,Y):b(Y)}=1 :- d(X).
X1=X :- f(X,Y), f(X1,Y).
:- {f(X,Y):b(Y)}=0,b(Y).
#show f/2.
