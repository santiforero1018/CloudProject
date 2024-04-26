package edu.eci.CLSC.project.cloudProject.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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

    @OneToOne
    @JoinColumn(name = "account_id")
    @JsonManagedReference
    private Account account;

    
    public Provider() {
    }


    public Provider(Long id, String name, String nit,String direction, String phone, Account account) {
        this.id = id;
        this.name = name;
        this.nit = nit;
        this.direction = direction;
        this.phone = phone;
        this.account = account;
    }

    

}
