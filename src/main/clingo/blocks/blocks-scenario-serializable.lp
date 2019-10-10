%%%%%%%%%%%%%%%%%%%

% File: blocks-scenario-serializable.lp

%%%%%%%%%%%%%%%%%%%

block(m;l;a;b;c;o;n;d;e;j;k;f;g;h;i).

% initial state

:- not on(m,table,0; l,m,0; a,l,0; b,a,0; c,b,0; o,table,0; n,o,0; d,n,0; e,d,0; j,e,0; k,j,0; f,table,0; g,f,0; h,g,0; i,h,0).

% goal

:- not on(e,j,x; a,e,x; n,a,x; i,d,x; h,i,x; m,h,x; o,m,x; k,g,x; c,k,x; b,c,x; l,b,x).

%can't move to same location or can't move to a moving block
:- move(B1,L1,T), move(B2,L2,T), on(B2,L3,T), L1=L3, T=0..x-1.

#minimize{1,B,L,T:move(B,L,T)}.

#show move/3.
