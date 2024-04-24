package edu.eci.CLSC.project.cloudProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.CLSC.project.cloudProject.Exception.UserException;
import edu.eci.CLSC.project.cloudProject.services.UserService;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> authUser(@RequestBody LoginDto userDto){
        try {
            if(this.userService.validateUser(userDto.getUserName(), userDto.getPassword())){
                return ResponseEntity.ok().build();
            }else{
                return ResponseEntity.status(401).build();
            }
        } catch (UserException e) {
            return ResponseEntity.status(404).build();
        }
    }
    
}
