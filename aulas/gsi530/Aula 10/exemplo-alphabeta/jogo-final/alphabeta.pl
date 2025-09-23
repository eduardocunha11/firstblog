:- module(alphabeta, [alphabeta/6]).

% Alpha-beta algorithm with depth limit
alphabeta(Depth, Pos, _, _, Pos, Val) :-
	Depth =< 0,
	utility(Pos, Val), !.
	
alphabeta(Depth, Pos, Alpha, Beta, GoodPos, Val) :-
	Depth > 0,
	bagof(NextPos, move(Pos, NextPos), PosList), !,
	OneDeeper is Depth - 1,
	boundedbest(OneDeeper, PosList, Alpha, Beta, GoodPos, Val);
	utility(Pos, Val), !.
	
boundedbest(Depth, [Pos | PosList], Alpha, Beta, GoodPos, GoodVal) :-
	alphabeta(Depth, Pos, Alpha, Beta, _, Val),
	goodenough(Depth, PosList, Alpha, Beta, Pos, Val, GoodPos, GoodVal), !.
	
goodenough(_, [], _, _, Pos, Val, Pos, Val) :- !.   % No other candidate

goodenough(_, _, Alpha, Beta, Pos, Val, Pos, Val) :-
	min_to_move(Pos), Val > Beta, !;    % Maximizer attained upper bound
	max_to_move(Pos), Val < Alpha, !.   % Minimizer attained lower bound
	
goodenough(Depth, PosList, Alpha, Beta, Pos, Val, GoodPos, GoodVal) :-
	newbounds(Alpha, Beta, Pos, Val, NewAlpha, NewBeta),    % Refine bounds
	boundedbest(Depth, PosList, NewAlpha, NewBeta, Pos1, Val1),
	betterof(Pos, Val, Pos1, Val1, GoodPos, GoodVal), !.
	
newbounds(Alpha, Beta, Pos, Val, Val, Beta) :-
	min_to_move(Pos), Val > Alpha, !.   % Maximizer increased lower bound
		
newbounds(Alpha, Beta, Pos, Val, Alpha, Val) :-
	max_to_move(Pos), Val < Beta, !.    % Minimizer decreased upper bound
	
newbounds(Alpha, Beta, _, _, Alpha, Beta) :- !.   % Otherwise bounds unchanged

betterof(Pos, Val, _, Val1, Pos, Val) :-
	min_to_move(Pos), Val >  Val1, !;
	max_to_move(Pos), Val < Val1, !.
	
betterof(_, _, Pos1, Val1, Pos1, Val1) :- !.	% Otherwise Pos1 better
		