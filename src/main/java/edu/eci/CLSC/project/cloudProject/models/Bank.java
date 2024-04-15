package edu.eci.CLSC.project.cloudProject.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

/**
 * Class that represents a bank
 * 
 * @author Santiago Forero Yate
 * @author Wilson Rafael Morales
 * @author Cesar Manuel Vasquez
 */
@Entity(name = "banks")
@Data
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    
    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts;

    public  Bank() {}

    public Bank(Long id, String name, List<Account> accounts) {
        this.id = id;
        this.name = name;
        this.accounts = accounts;
    }

    
}
