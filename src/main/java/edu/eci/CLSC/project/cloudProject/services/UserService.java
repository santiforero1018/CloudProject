package edu.eci.CLSC.project.cloudProject.services;

import edu.eci.CLSC.project.cloudProject.Exception.UserException;
import edu.eci.CLSC.project.cloudProject.models.User;

public interface UserService {

    public User getUser(String username) throws UserException;

    public void addUser(User user);

}
