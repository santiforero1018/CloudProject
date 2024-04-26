package edu.eci.CLSC.project.cloudProject.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;
    @Column(unique = true)
    private String email;
    private  String password;

    public User(){

    }

    public User(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }


    

    
}
