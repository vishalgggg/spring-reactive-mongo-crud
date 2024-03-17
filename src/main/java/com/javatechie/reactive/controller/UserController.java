package com.javatechie.reactive.controller;


import com.javatechie.reactive.entity.User;
import com.javatechie.reactive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public Flux<User> getUsers(){
        return service.getUsers();
    }

    @GetMapping("/{id}")
    public Mono<User> getUser(@PathVariable String id){
        return service.getUser(id);
    }

    // @GetMapping("/product-range")
    // public Flux<ProductDto> getProductBetweenRange(@RequestParam("min") double min, @RequestParam("max")double max){
    //     return service.getProductInRange(min,max);
    // }

    @PostMapping
    public Mono<User> saveUser(@RequestBody User user){
        System.out.println("controller method called ...");
        return service.saveUser(user);
    }

    @PutMapping("/update/{id}")
    public Mono<User> updateUser(@RequestBody User user,@PathVariable String id){
        return service.updateUser(user, id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id){
        return service.deleteUser(id);
    }



}
