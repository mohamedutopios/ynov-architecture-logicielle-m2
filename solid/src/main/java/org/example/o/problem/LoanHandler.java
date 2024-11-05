package org.example.o.problem;

public class LoanHandler {
    
    private PersonalLoanValidator personalLoanValidator;
    private GageLoanValidator gageLoanValidator;

    public void approvePersonalLoan(User user){
        if(personalLoanValidator.isValidUserForPersonalLoan(user)){

        }
    }

    public void approveGageLoan(User user){
        if(gageLoanValidator.isValidUserGage(user)){

        }
    }


}
