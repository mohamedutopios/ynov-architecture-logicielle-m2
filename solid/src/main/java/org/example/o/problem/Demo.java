package org.example.o.problem;

public class Demo {

    public static void main(String[] args) {
        LoanHandler loanHandler = new LoanHandler();

        User user = new User();

        loanHandler.approveGageLoan(user);
        loanHandler.approvePersonalLoan(user);

    }
}