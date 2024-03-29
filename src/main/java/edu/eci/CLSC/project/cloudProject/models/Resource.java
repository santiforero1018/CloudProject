package edu.eci.CLSC.project.cloudProject.models;

import org.hibernate.annotations.DialectOverride.GeneratedColumns;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "resources")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; 
    private Long inventoryId;
    
    public Resource(){}

    public Resource(Long id, String name, Long inventoryId) {
        this.id = id;
        this.name = name;
        this.inventoryId = inventoryId;
    }

    
}
