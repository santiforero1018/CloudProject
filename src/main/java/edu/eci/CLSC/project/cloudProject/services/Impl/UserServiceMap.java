package edu.eci.CLSC.project.cloudProject.services.Impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.CLSC.project.cloudProject.Exception.MessageErros;
import edu.eci.CLSC.project.cloudProject.Exception.UserException;
import edu.eci.CLSC.project.cloudProject.models.User;
import edu.eci.CLSC.project.cloudProject.repositories.UserRepository;
import edu.eci.CLSC.project.cloudProject.services.UserService;

@Service
public class UserServiceMap implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(String email) throws UserException {
        return this.userRepository.findByEmail(email)
                .orElseThrow(() -> new UserException(MessageErros.NOT_FOUND_USER.getMessageError()));
    }

    @Override
    public void addUser(User user) {
        user.setPassword(hashPwd(user.getPassword()));
        this.userRepository.save(user);
    }

    @Override
    public boolean validateUser(String email, String password) throws UserException {
        User user = this.getUser(email);
        return user.getPassword().equals(hashPwd(password));
    }

    public String hashPwd(String chain) {
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
