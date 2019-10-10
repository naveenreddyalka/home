{in(I,1..k)}=1 :- I=1..n.

:- in(J,S), in(K,S), in(J+K,S), J!=K.

#show in/2.
