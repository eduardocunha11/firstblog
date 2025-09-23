% Bloco 2
concatenar( [], Lista, Lista).
concatenar( [X | Outros], Lista2, [X | Resultado]) :-
	concatenar( Outros, Lista2, Resultado).
	
	