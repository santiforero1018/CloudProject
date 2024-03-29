package edu.eci.CLSC.project.cloudProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eci.CLSC.project.cloudProject.models.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
    
}
