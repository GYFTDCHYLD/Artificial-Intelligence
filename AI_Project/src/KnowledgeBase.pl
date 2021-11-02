%Rules
high_fever(TempF) :- TempF>215.6.

high_pressure(Systolic,Diastolic) :- Systolic>90.0;Diastolic>60.0.
low_pressure(Systolic,Diastolic) :- Systolic<90.0;Diastolic<60.0.

possibly_has(Sym,TempF,Syst,Dias,Var) :- symptom(Sym),associated(Sym,Var),high_fever(TempF),high_pressure(Syst,Dias).

risk_having(Sym,TempF,Syst,Dias) :- symptom(Sym),high_fever(TempF);low_pressure(Syst,Dias).

convert_temperature(Celcius,Fahrenheit):- Fahrenheit is Celcius*(9/5)+32.

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

symptom(dizziness).
symptom(fainting).
symptom(blurred_vision).

associated(dizzinesss,regular).
associated(fainting,regular).
associated(blurred_vision,regular).

