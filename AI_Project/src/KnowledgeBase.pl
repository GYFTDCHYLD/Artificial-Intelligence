is_a_symtom(X):- symtom(X); signs(Y, X); disease(Y).

disease(covid19).

symtom(fever).  signs(covid19,fever).
symtom(fainting).  signs(covid19,fainting).
