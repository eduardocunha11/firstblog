:- use_module(minimax).
:- use_module(tictactoe).

% bestMove(+Pos, -NextPos)
% Compute the best Next Position from Position Pos
% with minimax or alpha-beta algorithm.
bestMove(Pos, NextPos) :-
    minimax(Pos, NextPos, _).


% play
% Start the game.
play :-
    nl,
    write('===================='), nl,
	  write('= Prolog TicTacToe ='), nl,
	  write('===================='), nl, nl,
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
	    EmptyBoard = [0, 0, 0, 0, 0, 0, 0, 0, 0],
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



% nextPlayer(X1, X2)
% True if X2 is the next player to play after X1.
nextPlayer(o, x).
nextPlayer(x, o).

% When human play
humanMove([X1, play, Board], [X2, State, NextBoard], Pos) :-
    nextPlayer(X1, X2),
    set1(Pos, X1, Board, NextBoard),
    (
      winPos(X1, NextBoard), !, State = win ;
      drawPos(X1,NextBoard), !, State = draw ;
      State = play
    ).



% set1(+Elem, +Pos, +List, -ResList).
% Set Elem at Position Pos in List => Result in ResList.
% Rem : counting starts at 1.
set1(1, E, [X|Ls], [E|Ls]) :- !, X = 0.

set1(P, E, [X|Ls], [X|L2s]) :-
    number(P),
    P1 is P - 1,
    set1(P1, E, Ls, L2s).


% show(+Board)
% Show the board to current output.
show([X1, X2, X3, X4, X5, X6, X7, X8, X9]) :-
    write('   '), show2(X1),
    write(' | '), show2(X2),
    write(' | '), show2(X3), nl,
    write('  -----------'), nl,
    write('   '), show2(X4),
    write(' | '), show2(X5),
    write(' | '), show2(X6), nl,
    write('  -----------'), nl,
    write('   '), show2(X7),
    write(' | '), show2(X8),
    write(' | '), show2(X9), nl.



% show2(+Term)
% Write the term to current outupt
% Replace 0 by ' '.
show2(X) :-
    X = 0, !,
    write(' ').

show2(X) :-
    write(X).