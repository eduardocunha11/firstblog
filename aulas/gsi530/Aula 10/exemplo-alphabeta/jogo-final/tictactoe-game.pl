:- use_module(tictactoe).
:- use_module(alphabeta).

% bestMove(+Pos, -NextPos)
% Compute the best Next Position from Position Pos
% with alpha-beta algorithm.
bestMove(Pos, NextPos) :- 
	firstMove(Pos), 
	generateRandomMove(Pos, NextPos, Jogada), 
	gravaJogadaNoArquivo(o, Jogada), !.

bestMove(Pos, NextPos) :-
	alphabeta(2, Pos, -32767, 32767, NextPos, _),
	gravaJogada(Pos, NextPos), !.
	
gravaJogada([Player, _, Board], [_, _, BestSuccBoard]) :-
	retornaJogadaMaquina(Board, BestSuccBoard, Player, Jogada), nl,
	write('JogadaMaquina ==> '),
	writeln(Jogada), nl,
	gravaJogadaNoArquivo(Player, Jogada), !.
	
firstMove([Player, _, Board]) :- 
	not(member(Player, Board)). 	
	
generateRandomMove([Player, play, Board], [NextPlayer, play, NextBoard], JogadaMaquina) :-
	nextPlayer(Player, NextPlayer),
	
	% Retorna a primeira jogada que o humano fez
	% O resultado sera uma lista com um elemento
	retornaListaJogadas(Board, NextPlayer, Lista1),
	recuperaValor(Lista1, JogadaHumano),
	write('Primeira Jogada Humano ==> '),
	writeln(JogadaHumano),
	random(1, 64, JogadaMaquina), nl,
	JogadaHumano =\= JogadaMaquina,
	write('Primeira Jogada Maquina (Random) ==> '),
	write(JogadaMaquina), nl,
	set1(JogadaMaquina, Player, Board, NextBoard), nl.
		
% We represent a game position by a list [Player, State, Board],
% where Player is the next player to play,
% State is equal to 'play' if not final posit., 'win' if win or 'draw' if draw
% and Board is the actual board of the game.
%
% The board is represented by a list of 64 elements
% 
% An empty case is represented by '0'.
%
% We choose x to be the MAX player and o the MIN player.
%
%
% TODO :
% - Add the number of empty cases in Board to test draw faster.
% - Try to not test all lines/cols/diags for winning or draw after a move,
%   but only the modified ones.
%

% play
% Start the game.
play :-
    nl,
    write('********************'), nl,
	  write('* Prolog TicTacToe *'), nl,
	  write('********************'), nl, nl,
	  write('Rem : x starts the game'), nl,
	  playAskColor.
	
	
	
% playAskColor
% Ask the color for the human player and start the game with it.
playAskColor :-
	  nl, write('Color for human player ? (x or o)'), nl,
	  read(Player), nl,
	  (
	    Player \= o, Player \= x, !,     % If not x or o -> not a valid color
	    write('Error : not a valid color !'), nl,
	    playAskColor                     % Ask again
	    ;
	    EmptyBoard = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
					  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
				      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
					  0, 0, 0, 0],
	    show(EmptyBoard), nl,
	
	    % Start the game with color and emptyBoard
	    play([x, play, EmptyBoard], Player)
	  ).



% play(+Position, +HumanPlayer)
% If next player to play in position is equal to HumanPlayer -> Human must play
% Ask to human what to do.
play([Player, play, Board], Player) :- !,
    nl, write('Next move ?'), nl,
    read(Pos), nl,                                  % Ask human where to play
    (
      humanMove([Player, play, Board], [NextPlayer, State, NextBoard], Pos), !,
      show(NextBoard),
      (
        State = win, !,                             % If Player win -> stop
        nl, write('End of game : '),
        write(Player), write(' win !'), nl, nl
        ;
        State = draw, !,                            % If draw -> stop
        nl, write('End of game : '),
        write(' draw !'), nl, nl
        ;
        play([NextPlayer, play, NextBoard], Player) % Else -> continue the game
      )
      ;
      write('-> Bad Move !'), nl,                % If humanMove fail -> bad move
      play([Player, play, Board], Player)        % Ask again
    ).



% play(+Position, +HumanPlayer)
% If it is not human who must play -> Computer must play
% Compute the best move for computer with minimax or alpha-beta.
play([Player, play, Board], HumanPlayer) :-
    nl, write('Computer play : '), nl, nl,
    % Compute the best move
    bestMove([Player, play, Board], [NextPlayer, State, BestSuccBoard]),
	show(BestSuccBoard),
    (
      State = win, !,                                 % If Player win -> stop
      nl, write('End of game : '),
      write(Player), write(' win !'), nl, nl
      ;
      State = draw, !,                                % If draw -> stop
      nl, write('End of game : '), write(' draw !'), nl, nl
      ;
      % Else -> continue the game
      play([NextPlayer, play, BestSuccBoard], HumanPlayer)
    ).

retornaJogadaMaquina(Board, NewBoard, Player, Jogada) :-
    retornaListaJogadas(Board, Player, Lista1),
	retornaListaJogadas(NewBoard, Player, Lista2),
	subtract(Lista2, Lista1, Lista3),
	recuperaValor(Lista3, Jogada).
	
recuperaValor([X], X).	
	
% When human play
humanMove([X1, play, Board], [X2, State, NextBoard], Pos) :-
    nextPlayer(X1, X2),
    set1(Pos, X1, Board, NextBoard),
    (
      winPos(X1, NextBoard), !, State = win ;
      drawPos(X1, NextBoard), !, State = draw ;
      State = play
    ),
	gravaJogadaNoArquivo(X1, Pos).
	
% set1(+Pos, +Elem, +List, -ResList).
% Set Elem at Position Pos in List => Result in ResList.
% Rem : counting starts at 1.
set1(1, E, [X|Ls], [E|Ls]) :- !, X = 0.

set1(P, E, [X|Ls], [X|L2s]) :-
    number(P),
    P1 is P - 1,
    set1(P1, E, Ls, L2s).
	
% show(+Board)
% Show the board to current output.
show([X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20,
	  X21, X22, X23, X24, X25, X26, X27, X28, X29, X30, X31, X32, X33, X34, X35, X36, X37, X38,
	  X39, X40, X41, X42, X43, X44, X45, X46, X47, X48, X49, X50, X51, X52, X53, X54, X55, X56,
	  X57, X58, X59, X60, X61, X62, X63, X64]) :- 
	
    write('   '), show2(X1),
    write(' | '), show2(X2),
    write(' | '), show2(X3), 
	write(' | '), show2(X4),
	write('     '), show2(X17),
	write(' | '), show2(X18),
	write(' | '), show2(X19),
	write(' | '), show2(X20),
	write('     '), show2(X33),
	write(' | '), show2(X34),
	write(' | '), show2(X35),
	write(' | '), show2(X36),
	write('     '), show2(X49),
	write(' | '), show2(X50),
	write(' | '), show2(X51),
	write(' | '), show2(X52), nl,
    write('  ---------------   ---------------   ---------------   ---------------  '), nl,
    write('   '), show2(X5),
    write(' | '), show2(X6),
    write(' | '), show2(X7), 
	write(' | '), show2(X8),
	write('     '), show2(X21),
	write(' | '), show2(X22),
	write(' | '), show2(X23),
	write(' | '), show2(X24),
	write('     '), show2(X37),
	write(' | '), show2(X38),
	write(' | '), show2(X39),
	write(' | '), show2(X40),
	write('     '), show2(X53),
	write(' | '), show2(X54),
	write(' | '), show2(X55),
	write(' | '), show2(X56), nl,
	write('  ---------------   ---------------   ---------------   ---------------  '), nl,
	write('   '), show2(X9),
    write(' | '), show2(X10),
    write(' | '), show2(X11), 
	write(' | '), show2(X12),
	write('     '), show2(X25),
	write(' | '), show2(X26),
	write(' | '), show2(X27),
	write(' | '), show2(X28),
	write('     '), show2(X41),
	write(' | '), show2(X42),
	write(' | '), show2(X43),
	write(' | '), show2(X44),
	write('     '), show2(X57),
	write(' | '), show2(X58),
	write(' | '), show2(X59),
	write(' | '), show2(X60), nl,
	write('  ---------------   ---------------   ---------------   ---------------  '), nl,
	write('   '), show2(X13),
    write(' | '), show2(X14),
    write(' | '), show2(X15), 
	write(' | '), show2(X16),
	write('     '), show2(X29),
	write(' | '), show2(X30),
	write(' | '), show2(X31),
	write(' | '), show2(X32),
	write('     '), show2(X45),
	write(' | '), show2(X46),
	write(' | '), show2(X47),
	write(' | '), show2(X48),
	write('     '), show2(X61),
	write(' | '), show2(X62),
	write(' | '), show2(X63),
	write(' | '), show2(X64), nl.
		
% show2(+Term)
% Write the term to current outupt
% Replace 0 by ' '.
show2(X) :-
    X = 0, !,
    write(' ').

show2(X) :-
    write(X).

gravaJogadaNoArquivo(Jogador, Posicao):-  open('C:\\Users\\EduardoCunha\\Desktop\\jogo-final\\game.txt', update, ASaida),
										  Offset is Posicao-1,
										  seek(ASaida, Offset, bof, Offset),
										  converte_caractere(Jogador, Jogador1),
										  write(ASaida, Jogador1),
										  close(ASaida).
										  
converte_caractere(x, 'X').
converte_caractere(o, 'O').			