:- module(tictactoe, [move/2,min_to_move/1,max_to_move/1,utility/2,drawPos/2,winPos/2,retornaListaJogadas/3,nextPlayer/2]).

% move(+Pos, -NextPos)
% True if there is a legal (according to rules) move from Pos to NextPos.
move([X1, play, Board], [X2, win, NextBoard]) :-
    nextPlayer(X1, X2),
    move_aux(X1, Board, NextBoard),
    winPos(X1, NextBoard), !.	
	
move([X1, play, Board], [X2, draw, NextBoard]) :-
    nextPlayer(X1, X2),
    move_aux(X1, Board, NextBoard),
    drawPos(X1, NextBoard), !.

move([X1, play, Board], [X2, play, NextBoard]) :-
	nextPlayer(X1, X2),
    move_aux(X1, Board, NextBoard).
	
% nextPlayer(X1, X2)
% True if X2 is the next player to play after X1.
nextPlayer(o, x).
nextPlayer(x, o).

% move_aux(+Player, +Board, -NextBoard)
% True if NextBoard is Board whith an empty case replaced by Player mark.
move_aux(P, [0|Bs], [P|Bs]).

move_aux(P, [B|Bs], [B|B2s]) :-
    move_aux(P, Bs, B2s).

% min_to_move(+Pos)
% True if the next player to play is the MIN player.
min_to_move([o, _, _]).

% max_to_move(+Pos)
% True if the next player to play is the MAX player.
max_to_move([x, _, _]).
	
% utility(+Pos, -Val) :-
% True if Val the the result of the evaluation function at Pos.
% We will only evaluate for final position.
% So we will only have MAX win, MIN win or draw.
% We will use  4 when MAX win
%             -4 when MIN win
%              0 otherwise.

utility([o, win, _], 4) :- !. % Previous player (MAX) has win.
utility([x, win, _], -4) :- !. % Previous player (MIN) has win.    
utility([_, draw, _], 0) :- !.

utility([o, play, Board], Utilidade) :-
		% writeln('calculando utility para o Player o...'),
		% writeln(Board),
		delta1(o, Board, U1),
		% writeln('delta1: '),
		% writeln(U1),
		delta4(o, Board, U2),
		% writeln('delta4: '),
		% writeln(U2),
		delta5(o, Board, U3),
		% writeln('delta5: '),
		% writeln(U3),
		delta3(o, Board, U4),
		% writeln('delta3: '),
		% writeln(U4),
		delta13(Board, U5),
		% writeln('delta13: '),
		% writeln(U5),
		delta17(o, Board, U6),
		% writeln('delta17: '),
		% writeln(U6),
		delta19(o, Board, U7),
		% writeln('delta19: '),
		% writeln(U7),
		delta20(o, Board, U8),
		% writeln('delta20: '),
		% writeln(U8),
		delta21(Board, U9),
		% writeln('delta21: '),
		% writeln(U9),
		retornaUtilidade(o, [U1, U2, U3, U4, U5, U6, U7, U8, U9], Utilidade).
		% writeln('Utilidade p/ O = '),
		% writeln(Utilidade).

utility([x, play, Board], Utilidade) :-
		writeln('calculando utility para o Player x...'),
		% writeln(Player),
		writeln(Board),
		delta1(x, Board, U1),
		% writeln('delta1: '),
		% writeln(U1),
		delta4(x, Board, U2),
		% writeln('delta4: '),
		% writeln(U2),
		delta5(x, Board, U3),
		% writeln('delta5: '),
		% writeln(U3),
		delta3(x, Board, U4),
		% writeln('delta3: '),
		% writeln(U4),
		delta13(Board, U5),
		% writeln('delta13: '),
		% writeln(U5),
		delta17(x, Board, U6),
		% writeln('delta17: '),
		% writeln(U6),
		delta19(x, Board, U7),
		% writeln('delta19: '),
		% writeln(U7),
		delta20(x, Board, U8),
		% writeln('delta20: '),
		% writeln(U8),
		delta21(Board, U9),
		% writeln('delta21: '),
		% writeln(U9),
		retornaUtilidade(x, [U1, U2, U3, U4, U5, U6, U7, U8, U9], Utilidade).
		% writeln('Utilidade p/ X = '),
		% writeln(Utilidade).
				
retornaUtilidade(o, Lista, Utilidade) :- min_list(Lista, Utilidade), !.
retornaUtilidade(x, Lista, Utilidade) :- max_list(Lista, Utilidade), !.	
		
avaliaUtilidade( CX, 0, Utilidade ) :- CX > 0, Utilidade is CX.
avaliaUtilidade( 0, CO, Utilidade ) :- CO > 0, Utilidade is -CO.
avaliaUtilidade( CX, CO, 0 ) :- CX >= 0, CO >= 0.

count(_, [], 0) :- !. /* base case */

count(X, [X|T], N) :- /* if X is in the head */
    count(X, T, N2), 
    N is N2 + 1.     
	
count(X, [Y|T], N) :- 
    X \= Y,          /* if X is not in the head */
    count(X, T, N).  /* just count the rest */		

calculaUtilidade( Jogada, Utilidade ) :-
	count( x, Jogada, CX ),
    count( o, Jogada, CO ),
    avaliaUtilidade( CX, CO, Utilidade ).
			
delta1(P, [X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20,
	  X21, X22, X23, X24, X25, X26, X27, X28, X29, X30, X31, X32, X33, X34, X35, X36, X37, X38,
	  X39, X40, X41, X42, X43, X44, X45, X46, X47, X48, X49, X50, X51, X52, X53, X54, X55, X56,
	  X57, X58, X59, X60, X61, X62, X63, X64], Utilidade) :-

	  calculaUtilidade( [X1, X2, X3, X4], U1 ),
	  calculaUtilidade( [X5, X6, X7, X8], U2 ),
	  calculaUtilidade( [X9, X10, X11, X12], U3 ),
	  calculaUtilidade( [X13, X14, X15, X16], U4 ),
	  calculaUtilidade( [X17, X18, X19, X20], U5 ),
	  calculaUtilidade( [X21, X22, X23, X24], U6 ),
	  calculaUtilidade( [X25, X26, X27, X28], U7 ),
	  calculaUtilidade( [X29, X30, X31, X32], U8 ),
	  calculaUtilidade( [X33, X34, X35, X36], U9 ),
	  calculaUtilidade( [X37, X38, X39, X40], U10 ),
	  calculaUtilidade( [X41, X42, X43, X44], U11 ),
	  calculaUtilidade( [X45, X46, X47, X48], U12 ),
	  calculaUtilidade( [X49, X50, X51, X52], U13 ),
	  calculaUtilidade( [X53, X54, X55, X56], U14 ),
	  calculaUtilidade( [X57, X58, X59, X60], U15 ),
	  calculaUtilidade( [X61, X62, X63, X64], U16 ),
	  retornaUtilidade(P, [U1, U2, U3, U4, U5, U6, U7, U8, U9, U10, U11, U12, U13, U14, U15, U16], Utilidade).
	  
delta4(P, [X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20,
	  X21, X22, X23, X24, X25, X26, X27, X28, X29, X30, X31, X32, X33, X34, X35, X36, X37, X38,
	  X39, X40, X41, X42, X43, X44, X45, X46, X47, X48, X49, X50, X51, X52, X53, X54, X55, X56,
	  X57, X58, X59, X60, X61, X62, X63, X64], Utilidade) :-
	
	calculaUtilidade( [X1, X5, X9, X13], U1 ),
	calculaUtilidade( [X2, X6, X10, X14], U2 ),
	calculaUtilidade( [X3, X7, X11, X15], U3 ),
	calculaUtilidade( [X4, X8, X12, X16], U4 ),
	calculaUtilidade( [X17, X21, X25, X29], U5 ),
	calculaUtilidade( [X18, X22, X26, X30], U6 ),
	calculaUtilidade( [X19, X23, X27, X31], U7 ),
	calculaUtilidade( [X20, X24, X28, X32], U8 ),
	calculaUtilidade( [X33, X37, X41, X45], U9 ),
	calculaUtilidade( [X34, X38, X42, X46], U10 ),
	calculaUtilidade( [X35, X39, X43, X47], U11 ),
	calculaUtilidade( [X36, X40, X44, X48], U12 ),
	calculaUtilidade( [X49, X53, X57, X61], U13 ),
	calculaUtilidade( [X50, X54, X58, X62], U14 ),
	calculaUtilidade( [X51, X55, X59, X63], U15 ),
	calculaUtilidade( [X52, X56, X60, X64], U16 ),
	retornaUtilidade(P, [U1, U2, U3, U4, U5, U6, U7, U8, U9, U10, U11, U12, U13, U14, U15, U16], Utilidade).
	
delta5(P, [X1, _, _, _, _, X6, _, _, _, _, X11, _, _, _, _, X16, X17, _, _, _,
	  _, X22, _, _, _, _, X27, _, _, _, _, X32, X33, _, _, _, _, X38,
	  _, _, _, _, X43, _, _, _, _, X48, X49, _, _, _, _, X54, _, _,
	  _, _, X59, _, _, _, _, X64], Utilidade) :-
	  
	  calculaUtilidade( [X1, X6, X11, X16], U1 ),
	  calculaUtilidade( [X17, X22, X27, X32], U2 ),
	  calculaUtilidade( [X33, X38, X43, X48], U3 ),
	  calculaUtilidade( [X49, X54, X59, X64], U4 ),
	  retornaUtilidade(P, [U1, U2, U3, U4], Utilidade).
	  
delta3(P, [_, _, _, X4, _, _, X7, _, _, X10, _, _, X13, _, _, _, _, _, _, X20,
	  _, _, X23, _, _, X26, _, _, X29, _, _, _, _, _, _, X36, _, _,
	  X39, _, _, X42, _, _, X45, _, _, _, _, _, _, X52, _, _, X55, _,
	  _, X58, _, _, X61, _, _, _], Utilidade) :-
	
	  calculaUtilidade( [X4, X7, X10, X13], U1 ),
	  calculaUtilidade( [X20, X23, X26, X29], U2 ),
	  calculaUtilidade( [X36, X39, X42, X45], U3 ),
	  calculaUtilidade( [X52, X55, X58, X61], U4 ),
	  retornaUtilidade(P, [U1, U2, U3, U4], Utilidade).
	  
delta17(P, [X1, _, _, _, X5, _, _, _, X9, _, _, _, X13, _, _, _, _, X18, _, _,
	  _, X22, _, _, _, X26, _, _, _, X30, _, _, _, _, X35, _, _, _,
	  X39, _, _, _, X43, _, _, _, X47, _, _, _, _, X52, _, _, _, X56,
	  _, _, _, X60, _, _, _, X64], Utilidade) :-
	  
	  calculaUtilidade( [X1, X18, X35, X52], U1 ),
	  calculaUtilidade( [X5, X22, X39, X56], U2 ),
	  calculaUtilidade( [X9, X26, X43, X60], U3 ),
	  calculaUtilidade( [X13, X30, X47, X64], U4 ),
	  retornaUtilidade(P, [U1, U2, U3, U4], Utilidade).
	  
delta19(_, [_, _, _, X4, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _,
	  _, _, X23, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _,
	  _, _, _, X42, _, _, _, _, _, _, _, _, _, _, _, _, _, _,
	  _, _, _, _, X61, _, _, _], Utilidade) :-
	  
	  calculaUtilidade( [X4, X23, X42, X61], Utilidade ).
	  
delta20(P, [X1, X2, X3, X4, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _,
	  X21, X22, X23, X24, _, _, _, _, _, _, _, _, _, _, _, _, _, _,
	  _, _, X41, X42, X43, X44, _, _, _, _, _, _, _, _, _, _, _, _,
	  _, _, _, _, X61, X62, X63, X64], Utilidade) :-
	  
	  calculaUtilidade( [X1, X21, X41, X61], U1 ),
	  calculaUtilidade( [X2, X22, X42, X62], U2 ),
	  calculaUtilidade( [X3, X23, X43, X63], U3 ),
	  calculaUtilidade( [X4, X24, X44, X64], U4 ),
	  retornaUtilidade(P, [U1, U2, U3, U4], Utilidade).
	  
delta21([X1, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _,
	  _, X22, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _,
	  _, _, _, _, X43, _, _, _, _, _, _, _, _, _, _, _, _, _,
	  _, _, _, _, _, _, _, X64], Utilidade) :-
	  
	  calculaUtilidade( [X1, X22, X43, X64], Utilidade ).
	  
delta13([_, _, _, _, _, _, _, _, _, _, _, _, X13, _, _, _, _, _, _, _,
	  _, _, _, _, _, X26, _, _, _, _, _, _, _, _, _, _, _, _,
	  X39, _, _, _, _, _, _, _, _, _, _, _, _, X52, _, _, _, _,
	  _, _, _, _, _, _, _, _], Utilidade) :-
	  
	  calculaUtilidade( [X13, X26, X39, X52], Utilidade ).
	  
% drawPos(+Player, +Board)
% True if the game is a draw.
drawPos(_, Board) :- 
	\+ member(0, Board).
	
retornaListaJogadas(Board, Player, IndexList) :-
    bagof(Index, indexOf(Board, Player, Index), IndexList).
	
indexOf([Element|_], Element, 1). 
indexOf([_|Tail], Element, Index):-
  indexOf(Tail, Element, Index1), 
  Index is Index1 + 1. 
	
winPos(P, [X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20,
	  X21, X22, X23, X24, X25, X26, X27, X28, X29, X30, X31, X32, X33, X34, X35, X36, X37, X38,
	  X39, X40, X41, X42, X43, X44, X45, X46, X47, X48, X49, X50, X51, X52, X53, X54, X55, X56,
	  X57, X58, X59, X60, X61, X62, X63, X64]) :-
	  
   equal(X1, X2, X3, X4, P) ;   % Delta1 - Linhas
   equal(X5, X6, X7, X8, P) ;
   equal(X9, X10, X11, X12, P) ;
   equal(X13, X14, X15, X16, P) ;
   equal(X17, X18, X19, X20, P) ;
   equal(X21, X22, X23, X24, P) ;
   equal(X25, X26, X27, X28, P) ;
   equal(X29, X30, X31, X32, P) ;
   equal(X33, X34, X35, X36, P) ;
   equal(X37, X38, X39, X40, P) ;
   equal(X41, X42, X43, X44, P) ;
   equal(X45, X46, X47, X48, P) ;
   equal(X49, X50, X51, X52, P) ;
   equal(X53, X54, X55, X56, P) ;
   equal(X57, X58, X59, X60, P) ;
   equal(X61, X62, X63, X64, P) ;
   equal(X1, X5, X9, X13, P) ;  % Delta4 - Colunas
   equal(X2, X6, X10, X14, P) ;
   equal(X3, X7, X11, X15, P) ;
   equal(X4, X8, X12, X16, P) ;
   equal(X17, X21, X25, X29, P) ; 
   equal(X18, X22, X26, X30, P) ;
   equal(X19, X23, X27, X31, P) ;
   equal(X20, X24, X28, X32, P) ;
   equal(X33, X37, X41, X45, P) ;
   equal(X34, X38, X42, X46, P) ;
   equal(X35, X39, X43, X47, P) ;
   equal(X36, X40, X44, X48, P) ;
   equal(X49, X53, X57, X61, P) ;
   equal(X50, X54, X58, X62, P) ;
   equal(X51, X55, X59, X63, P) ;
   equal(X52, X56, X60, X64, P) ;
   equal(X1, X6, X11, X16, P) ; % Delta5 - Diagonais principais
   equal(X17, X22, X27, X32, P) ;
   equal(X33, X38, X43, X48, P) ;
   equal(X49, X54, X59, X64, P) ;
   equal(X4, X7, X10, X13, P) ; % Delta3 - Diagonais invertidas
   equal(X20, X23, X26, X29, P) ;
   equal(X36, X39, X42, X45, P) ;
   equal(X52, X55, X58, X61, P) ;
   equal(X1, X18, X35, X52, P) ; % Delta17 - Linhas distribuidas
   equal(X5, X22, X39, X56, P) ;
   equal(X9, X26, X43, X60, P) ;
   equal(X13, X30, X47, X64, P) ;
   equal(X4, X23, X42, X61, P) ; % Delta19 - Diagonal distribuida
   equal(X1, X21, X41, X61, P) ; % Delta20 - Colunas distribuidas
   equal(X2, X22, X42, X62, P) ;
   equal(X3, X23, X43, X63, P) ;
   equal(X4, X24, X44, X64, P) ;
   equal(X1, X22, X43, X64, P) ; % Delta21 - Diagonal principal distribuida
   equal(X13, X26, X39, X52, P). % Delta13 - Diagonal invertida distribuida
   
   
equal(X, X, X, X, X). 
   