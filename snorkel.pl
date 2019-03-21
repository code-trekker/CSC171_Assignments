beat(A, B) :- position(A) < position(B).


beat(garry, barry).
beat(larry, barry).

beat(X, Y) :- (X \= garry -> red(X), blue(Y); blue(Y)).

red(X) :- write(X), write(" wears red."), nl.
blue(X) :- write(X), write(" wears blue."), nl.
green(X) :- place(X, 2), number(X, 3), write(X), write(" wears green."), nl.

yellow(barry).
yellow(X) :- beat(larry, X), write(X), write(" wears yellow."), nl.

place(harry, 4).
place(X, Y) :- write(X), write("'s place is "), write(Y), nl, number(X, Y).

number(X,Y) :- write(X), write("'s number is "), write(Y), nl.
number(X, 2) :- place(X, 1).

start(_) :- write("the order is: "), query([gary, barry, larry, harry]).

% query([A,B|C]) :- ().


    