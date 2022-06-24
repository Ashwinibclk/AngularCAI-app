package com.example.postgresql.controller;

import com.example.postgresql.model.user ;
import com.example.postgresql.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.net.URI;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class userController {

    private final UserRepository UserRepository;

    public userController(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }
    
   @GetMapping("/get")
    public ResponseEntity getAllUsers() {
        return ResponseEntity.ok(this.UserRepository.findAll());
    }

  
        
    @PostMapping("/add")
    public user createUser(@RequestBody user usera)  
    {  
    user savedUser=this.UserRepository.save(usera); 
    return savedUser;   
    }  


    @PutMapping("/update/{id}")
 public user replaceuUser(@RequestBody user newEmployee, @PathVariable Long id) {
    
    return this.UserRepository.findById(id)
      .map(usera -> {
    usera.setName(newEmployee.getName());
    usera.setrole(newEmployee.getrole());
    usera.setemail(newEmployee.getemail());
    
        return this.UserRepository.save(usera);
      })
      .orElseGet(() -> {
        newEmployee.setId(id);
        return this.UserRepository.save(newEmployee);
      });
  }

  @DeleteMapping("/delete/{id}")
  void deleteUser(@PathVariable Long id) {
    this.UserRepository.deleteById(id);
  }

  @GetMapping("/{id}")
  Optional<user> one(@PathVariable Long id) {
    
    return this.UserRepository.findById(id);
      
  }

  

  @DeleteMapping("/delete")
  public void deleteAll() {

		for (user element : this.UserRepository.findAll()) {
			this.UserRepository.delete(element);
		}
	}

  
  
}

