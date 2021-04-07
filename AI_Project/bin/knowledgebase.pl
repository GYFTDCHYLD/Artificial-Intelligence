symtom(fainting).
symtom(fever).

disease(covid19).

sign(covid19, fainting).
sign(covid19, fever).

is_a_symtom(X):- symtom(X); sign(covid-19, X); disease(covid-19).


