{bishops(R,1..n)} :- R=1..n.
:- bishops(R1,C1), bishops(R2,C2), R1!=R2, |R1-R2|==|C1-C2|.
#maximize{1,X,N: bishops(X,N)}.
