node(1..4).

@log(0.8/0.2) fail(2).

@log(0.5/0.5) fail(3).

@log(0.2/0.8) fail(4).

edge(1,2).

edge(2,4).

edge(1,3).

edge(3,4).

edge(2,3).

connected(X,Y) :- edge(X, Y), not fail(X), not fail(Y)

connected(X,Y) :- connected(X,Z), connected(Z,Y).
