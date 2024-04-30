package edu.eci.CLSC.project.cloudProject.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eci.CLSC.project.cloudProject.models.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
    public Optional<Bank> findByName(String name);

    public boolean existsByName(String name);
}
