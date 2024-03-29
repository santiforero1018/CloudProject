package edu.eci.CLSC.project.cloudProject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


/**
 * Class that represents a provider
 * 
 * @author Santiago Forero Yate
 * @author Wilson Rafael Morales
 * @author Cesar Manuel Vasquez
 */
@Entity(name = "providers")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String direction;
    private String phone;

    
    public Provider() {
    }


    public Provider(Long id, String name, String direction, String phone) {
        this.id = id;
        this.name = name;
        this.direction = direction;
        this.phone = phone;
    }

    

}
