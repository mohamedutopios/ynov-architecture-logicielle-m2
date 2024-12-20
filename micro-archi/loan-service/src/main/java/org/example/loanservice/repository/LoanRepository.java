package org.example.loanservice.repository;

import org.example.loansservice.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByAccountId(Long customerId);
    void deleteLoanByAccountId(Long id);

}
