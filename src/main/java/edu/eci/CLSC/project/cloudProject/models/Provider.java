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
@Data
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String nit;
    private String direction;
    private String phone;
    private String accountId;

    
    public Provider() {
    }


    public Provider(Long id, String name, String nit,String direction, String phone, String accountId) {
        this.id = id;
        this.name = name;
        this.nit = nit;
        this.direction = direction;
        this.phone = phone;
    }

    

}
