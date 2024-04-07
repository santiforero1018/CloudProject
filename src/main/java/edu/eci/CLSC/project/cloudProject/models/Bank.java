package edu.eci.CLSC.project.cloudProject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    public  Bank() {}

    public Bank(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    
}