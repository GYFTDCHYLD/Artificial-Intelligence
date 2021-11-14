%Rules
high_fever(TempF) :- TempF>102.1.
convert_temperature(Celcius,Fahrenheit):- Fahrenheit is Celcius*(9/5)+32.

high_pressure(Systolic,Diastolic) :- Systolic>90.0;Diastolic>60.0.
low_pressure(Systolic,Diastolic) :- Systolic<90.0;Diastolic<60.0.

possibly_has(Sym,TempF,Syst,Dias,Var) :- symptom(Sym),associated(Sym,Var),high_fever(TempF),high_pressure(Syst,Dias).
risk_having(Sym,TempF,Syst,Dias) :- symptom(Sym),not(high_fever(TempF));low_pressure(Syst,Dias).

%mu_cases(Patient,Varient):- patient(Patient),
% symptom(S),has_symptom(Patient,S),associated(S,Varient).

%delta_cases(Patient):-Patient=(patient(P), symptom(S),has_symptom(P,S),(associated(S,delta),not(associated(S,mu)))).

% regular_cases(Patient):- Patient=(patient(P),
% symptom(S),has_symptom(P,S),(associated(S,regular),not(associated(S,mu)),not(associated(S,delta)))).
%

%cases(Patient, Varient):-
%    %(Varient == 'mu')->
%    symptom(S),has_symptom(Patient,S),associated(S,Varient);
%    (Varient == 'delta')->
%    symptom(S),has_symptom(Patient,S),associated(S,Varient),not(associated(S,mu));
%    (Varient == 'regular')->
%    symptom(S),has_symptom(Patient,S),associated(S,Varient),
%                                   not(associated(S,mu);associated(S,delta)).

% severity(Severity):-
% distinct(has_symptom(P,Symptom),condition(Severity,Symptom)),write(P),fail.
%

cases(Patient, Varient):- has_strand(Patient,Varient).

severity(Patient,Stat):- status(Patient,Stat).


%severity(Severity):-  condition(Patient,severe).


%Facts
parish("Kingston & St Andrew").
parish("St Thomas").
parish("Portland").
parish("St Cathrine").
parish("St Mary").
parish("St Ann").
parish("Manchester").
parish("Clarendon").
parish("Hanover").
parish("Westmoreland").
parish("St James").
parish("Trelawny").
parish("St Elizabeth").

ethnicity("Black").
ethnicity("White").
ethnicity("Hispanic").
ethnicity("Aisian").
ethnicity("Caucasian").

gender("Male").
gender("Female").

varient(regular).
varient(delta).
varient(mu).

severity(mild).
severity(severe).

condition(severe,fainting).
condition(mild,dizziness).
condition(severe,dificulty_breathing).
condition(mild,chest_pain).
condition(severe,sore_throat).
condition(mild,rash_on_skin).
condition(severe,blurred_vision).

symptom(dizziness).
symptom(fainting).
symptom(blurred_vision).
symptom(sore_throat).
symptom(chest_pain).
symptom(rash_on_skin).
symptom(dificulty_breathing).

associated(dizzinesss,regular).
associated(fainting,regular).
associated(blurred_vision,mu).
associated(sore_throat,delta).
associated(chest_pain,delta).
associated(rash_on_skin,mu).
associated(dificulty_breathing,mu).



patient("Gavin Lie").
age("Gavin Lie",25).
sex("Gavin Lie","Male").
adderess("Gavin Lie","St Cathrine").
temperature("Gavin Lie",104.0).
has_symptom("Gavin_Lie",rash_on_skin).
has_symptom("Gavin_Lie",blurred_vision).
sytolic("Gavin Lie",100).
diastolic("Gavin Lie",50).
has_strand("Gavin Lie",mu).
status("Gavin Lie",severe).



patient("tash tmp").
age("tash tmp",22).
sex("tash tmp","Female").
adderess("tash tmp","St Mary").
temperature("tash tmp",103.82).
has_symptom("tash_tmp",fainting).
sytolic("tash tmp",100).
diastolic("tash tmp",56).
has_strand("tash tmp",regular).
status("Gavin Lie",severe).


patient("Like Mike").
age("Like Mike",22).
sex("Like Mike","Male").
adderess("Like Mike","St Cathrine").
temperature("Like Mike",102.2).
has_symptom("Like_Mike",dizziness).
has_symptom("Like_Mike",rash_on_skin).
sytolic("Like Mike",97).
diastolic("Like Mike",65).
has_strand("Like Mike",mu).
status("Gavin Lie",mild).


patient("jane sky").
age("jane sky",65).
sex("jane sky","Female").
adderess("jane sky","St James").
temperature("jane sky",104.0).
has_symptom("jane_sky",sore_throat).
has_symptom("jane_sky",chest_pain).
sytolic("jane sky",97).
diastolic("jane sky",66).
has_strand("jane sky",delta).
status("Gavin Lie",severe).


patient("Chad francis").
age("Chad francis",31).
sex("Chad francis","Male").
adderess("Chad francis","St Ann").
temperature("Chad francis",102.2).
has_symptom("Chad_francis",dizziness).
has_symptom("Chad_francis",chest_pain).
has_symptom("Chad_francis",rash_on_skin).
sytolic("Chad francis",91).
diastolic("Chad francis",55).
has_strand("Chad francis",mu).
status("Chad francis",mild).

patient("monicka hector").
age("monicka hector",27).
sex("monicka hector","Female").
adderess("monicka hector","Westmoreland").
temperature("monicka hector",102.2).
has_symptom("monicka_hector",dificulty_breathing).
has_symptom("monicka_hector",rash_on_skin).
has_symptom("monicka_hector",blurred_vision).
sytolic("monicka hector",92).
diastolic("monicka hector",11).
has_strand("monicka hector",mu).
status("monicka hector",severe).
