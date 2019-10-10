d(1..3).
b(a;b;c).
{f(X,Y):b(Y)}=1 :- d(X).
X1=X :- f(X,Y), f(X1,Y).
#show f/2.
