package edu.eci.CLSC.project.cloudProject.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eci.CLSC.project.cloudProject.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    public Optional<Account> findByAccountNumber(String accountNumber);
    public void deleteByAccountNumber(String  accountNumber);
}
