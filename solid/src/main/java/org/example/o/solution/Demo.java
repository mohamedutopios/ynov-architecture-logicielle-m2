package org.example.o.solution;

import org.example.o.solution.User;
import org.example.o.solution.LoanHandler;

public class Demo {


    public static void main(String[] args) {

        LoanHandler loanHandler = new PersonalLoanHandler(new PersonalLoanValidator());

        User user = new User();

        loanHandler.approveLoan(user);

        LoanHandler loanHandler2 = new GageLoanHandler(new GageLoanValidator());

        loanHandler2.approveLoan(user);
    }
}
