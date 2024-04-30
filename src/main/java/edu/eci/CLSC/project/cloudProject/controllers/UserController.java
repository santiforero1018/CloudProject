package edu.eci.CLSC.project.cloudProject.controllers;

import edu.eci.CLSC.project.cloudProject.models.LoginDto;
import edu.eci.CLSC.project.cloudProject.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.eci.CLSC.project.cloudProject.Exception.UserException;
import edu.eci.CLSC.project.cloudProject.services.UserService;


@CrossOrigin(origins = {"http://localhost:3000", "https://red-sand-074a8980f.5.azurestaticapps.net"})

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> authUser(@RequestBody LoginDto userDto){
        try {
            if(this.userService.validateUser(userDto.getEmail(), userDto.getPassword())){
                return ResponseEntity.ok(new Response(userDto.getEmail(), true));
            }else{
                return ResponseEntity.status(401).body(new Response(userDto.getEmail(), false));
            }
        } catch (UserException e) {
            return ResponseEntity.status(404).body(new Response(userDto.getEmail(), false));
        }
    }
    
}
