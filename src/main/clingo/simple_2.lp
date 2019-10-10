boolean(t;f).

p(t,T+1) :- a(T), T=0..m-1.

1{p(B,0):boolean(B)}1.

{a(T)} :- T=0..m-1.

{p(B,T+1)} :- p(B,T),boolean(B),T=0..m-1.

1{p(B,T):boolean(B)}1:- T=1..m.

#show a/1.
#show p/2.
