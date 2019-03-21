hoof(tony).
hoof(shikuo).
hoof(ellen).

hoof(X) :- 
    skier(X) ; climber(X) ; skier(X), climber(X).

likes(tony, snow).
likes(tony, rain).

likes(tony, Y) :- 
    dislikes(ellen, Y).

dislikes(ellen, Y) :- 
    likes(tony, Y).

skier(X) :- 
    likes(X, snow).

climber(X) :- 
    dislikes(X, rain).


climber_q([H|T]) :- ( climber(H) -> skier_q([H|T]), nl ; climber_q(T) ).

skier_q([H|T]) :- ( skier(H) -> climber_q(T) ; write(H), nl ).

start(_) :-
	climber_q([shikuo, tony, ellen]).