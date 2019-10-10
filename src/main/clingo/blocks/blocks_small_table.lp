%%%%%%%%%%%%%%%%%%%

% File: blocks_small_table.lp: Blocks World 

%%%%%%%%%%%%%%%%%%%

% max on table are limited by num of grippers

:- not {on(B,table,T)} onTable, T = 0..m-1.
