package edu.eci.CLSC.project.cloudProject.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;

import edu.eci.CLSC.project.cloudProject.Exception.MessageErros;
import edu.eci.CLSC.project.cloudProject.Exception.UserException;
import edu.eci.CLSC.project.cloudProject.models.User;
import edu.eci.CLSC.project.cloudProject.repositories.UserRepository;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(String username) throws UserException {
        return this.userRepository.findByUsername(username).orElseThrow(() -> new UserException(MessageErros.NOT_FOUND_USER.getMessageError()));
    }

    public void addUser(User user){
        user.setPassword(hashPwd(user.getPassword()));
        this.userRepository.save(user);
    }



    public String hashPwd(String chain){
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(chain.getBytes());
            return Base64.getEncoder().encodeToString(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("problems hashing");
        }

        return null;
       
    }
}
