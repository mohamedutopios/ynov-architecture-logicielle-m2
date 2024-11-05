package org.example.o.solution;

import org.example.o.solution.User;

public class GageLoanHandler implements LoanHandler {

   private Validator validator;

    public GageLoanHandler(Validator validator) {
        this.validator = validator;
    }

    @Override
    public void approveLoan(User user) {

        if(validator.isValid(user)) {

        }

    }
}
