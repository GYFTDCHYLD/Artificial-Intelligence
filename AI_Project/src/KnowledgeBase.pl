%Shericka Jones
%1700464



/*
 *
 *
QUESTION 1(Arithmetic)
The tax payable on incomes paid to employees of a certain company is as outlined below:
Taxable Income Tax Payable
From $1 - $5,461.99 NIL
From $5,462.00 - $18,893.99 10% of income
From $18,894.00 - $39,499.99 15% of income
From $39,500.00 - $55,899.99 20% of income
$55,900.00 and over 25% of income
Married employees get a tax refund of $50, while unmarried employees receive $60. Tax refund contributes to a
person’s disposable income.
Write a prolog predicate taxable/0 that will accept the user’s name, tax revenue number and income. Calculate
the tax payable on their income and display their name, tax revenue number, income, tax refund, tax payable
and disposable income. (Disposable Income =
Sample run:
?- taxable.
Enter name: ‘John Brown’.
Enter Tax Revenue Number: ‘346-028-125’.
Enter income: 35656.44.
Are you married y/n ?: y.
*/

cls :- write('\e[H\e[2J').

%MAIN FUNCTION CALL HERE TO RUN PROGRAMMMM!!!
taxable:-
          write('Please


           nl,write('Are you married (Select y for yes or n for no?'),nl,read(MaritalStatus),
           ((MaritalStatus == y; MaritalStatus == 'Y') -> Refund is 50; Refund is 60),

          DisposableIncome is TaxableIncome - (TaxPayable + Refund),



      do_output(Name,TaxRevenueNumber,TaxableIncome, TaxPayable,Refund,DisposableIncome).


% cond then if the income is greater than or equal to 1 or then tax is 0
calculate_tax_payable(TaxableIncome,TaxPayable):-

                              TaxableIncome >= 1,    TaxableIncome < 5461.99  -> TaxPayable is 0;
                              TaxableIncome >= 5462.00, TaxableIncome < 18893.99  -> TaxPayable is  TaxableIncome * 0.10;
                              TaxableIncome >= 18894.00, TaxableIncome < 39499.99  -> TaxPayable is  TaxableIncome * 0.15;
                              TaxableIncome >= 39500.00,TaxableIncome < 55899.99  -> TaxPayable is  TaxableIncome * 0.20;
                              TaxableIncome >= 55900.00 -> TaxPayable is  TaxableIncome * 0.25.

do_output(Name,TaxRevenueNumber,TaxableIncome, TaxPayable,Refund,Disposable):-
     write('***********Income Calculation**********'),

      nl,write('Name:  '),write(Name),
      nl,write('Tax Revenue Number: '),write(TaxRevenueNumber),
      nl,write('Income: '),write(TaxableIncome),
      nl,write('Tax Refund: '),write(Refund),
      nl,write('Tax Payable: '),write(TaxPayable),
      nl,write('Disposable Income '),write(Disposable),
      nl,write('Do you want to run again? selecy y or Y for yes or n for no : '),nl,read(MaritalStatus),nl,
      ((MaritalStatus == y;MaritalStatus  == 'Y') ->taxable; write('Thank you Goodbye')),fail.





/*
 * Problem Solving
Formalize the following problem by implementing the necessary Prolog facts and rules.
Vehicles may be purchased from various car dealers. Zeus and Staub are reasonable car dealers, Mercury is
expensive. Zeus’s origin is in USA, Mercury is in Norway and Staub is in Japan. Zeus ships to Norway, Japan
and USA. Mercury ships to Japan and Germany only and Staub ships to Germany and USA. Staub and Zeus
sells Mazda and Toyota, Mercury sells Hyundai.
Lisa wants to buy a reasonable Mazda or a Toyota from a dealer that does not originate in Japan and will ship
the goods to Germany or USA. Tanya wants to buy a reasonable Mazda or a Toyota from a dealer who will ship
to Germany. Thomas wants a Hyundai from a dealer that will ship to Germany but doesn’t care about the cost.

Write a knowledge-base in PROLOG which encodes the above knowledge in as general a form as possible, and
a predicate, which, when executed, generates a sequence of statements of the form:
<buyer> can purchase <car> from <dealer>
All possibilitiehould be generated.
*

%Facts Extracted from paragraph

%Dealers
reasonable_dealer(zeus).
reasonable_dealer(staub).

expensive_dealer(mercury).

%Orgin
origin(zeus,usa).
origin(mercury,norway).
origin(staub,japan).

ships(zeus,norway).
ships(zeus,japan).
ships(zeus,usa).
ships(mercury,japan).
ships(mercury,germany).
ships(staub,germany).
ships(staub,usa).
sells(staub,mazda).
sells(zeus,mazda).
sells(staub,toyota).
sells(zeus,toyota).
sells(mercury,hyundai).

%rules Extracted from paragraph

/*Lisa wants to buy a reasonable Mazda or a Toyota from a dealer that does not originate in Japan and will ship
the goods t
