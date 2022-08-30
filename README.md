# CustomerAccountTracker
This project works on:

a)Creating a new account for the customer(one account per customer)
b) It may contain account types such as savings(individual/joint), current, etc.
c) We can edit customer details.
d)We can fetch customer details including account details.
e)Customer can transfer funds to another account if the fund exists.

Basic walk through

a) Created a Maven project
b) Created seperate folders for Bean, Dao files, Service files and Controller files
c) Each folder has different class for Account, Customer And Transaction.
d) AccountBean has all the account details such as AccountNumber, AccountType, Name and BalanceAmount.
e) CustomerBean has all the customer details such as AccountNumber, Name, Gender, Email, contact, adhaarnumber, AccountType
f) TransactionBean has all transaction details like BenificiaryName, BenificiaryAccountNumber, Amount,BalanceAmount
