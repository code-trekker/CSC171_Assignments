dwarf(smelly).
dwarf(stumpy).
dwarf(sleepy).
dwarf(happy).
dwarf(bashful).
dwarf(sneezy).
dwarf(grumpy).
dwarf(doc).
dwarf(dopey).
dwarf(droopy).


behind(sleepy, stumpy).
behind(sleepy, smelly).
behind(sleepy, happy).
behind(bashful, smelly).
behind(bashful, droopy).
behind(bashful, sleepy).
behind(dopey, sneezy).
behind(dopey, doc).
behind(dopey, sleepy).
behind(smelly, doc).
behind(stumpy,sneezy).
behind(stumpy,doc).

behind(X, Y) :- inFrontOf(Y, X).

inFrontOf(happy, smelly).
inFrontOf(happy, sleepy).
inFrontOf(happy, bashful).
inFrontOf(sneezy, dopey).
inFrontOf(smelly, grumpy).
inFrontOf(smelly, stumpy).
inFrontOf(smelly, sneezy).
inFrontOf(dopey, droopy).
inFrontOf(sleepy, grumpy).
inFrontOf(sleepy, bashful).
inFrontOf(stumpy, dopey).
inFrontOf(grumpy, dopey).
inFrontOf(doc, droopy).
inFrontOf(doc, happy).



start(_) :- 
	order([bashful, droopy, dopey, doc, happy, sneezy, smelly, sleepy, stumpy], [grumpy]).

order([d|x], O) :- write("order is: "), write(O), nl.

order([d|OT], [F|x]) :- 
	(front(d, F) -> order(OT, [d, F]) ; order([OT], [F, d])).

order([d|OT], [F|R]) :-
	(front(d, F) -> order(OT, [d, F|R]) ; order([d|OT], [F, R])).