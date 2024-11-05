package org.example.o.solution;

import org.example.o.solution.User;

public class PersonalLoanHandler implements LoanHandler {

    private Validator validator;

    public PersonalLoanHandler(Validator validator) {
        this.validator = validator;
    }
    @Override
    public void approveLoan(User user) {
    if(validator.isValid(user)) {

    }
    }
}
