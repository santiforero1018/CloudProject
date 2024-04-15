package edu.eci.CLSC.project.cloudProject.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eci.CLSC.project.cloudProject.models.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
    
    public Optional<Provider> findByName(String name);
    public boolean existsByNit(String nit);
    public Optional<Provider> findByNit(String nit);
}
