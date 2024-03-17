package com.javatechie.reactive.service;

// import com.javatechie.reactive.dto.ProductDto;
// import com.javatechie.reactive.entity.Product;
import com.javatechie.reactive.entity.User;
import com.javatechie.reactive.repository.UserRepository;
// import com.javatechie.reactive.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public Flux<User> getUsers(){
        return repository.findAll();
    }

    public Mono<User> getUser(String id){
        return repository
        .findById(id);
    }



    public Mono<User> saveUser(User UserDetail){
        System.out.println("service method called ...");
        return  repository.save(UserDetail);
                
    }

    public Mono<User> updateUser(User user,String id){
       return repository.findById(id)
              .flatMap(userdetail -> {
                userdetail.setAge(user.getAge());
                userdetail.setName(user.getName());
                userdetail.setPhone(user.getPhone());
                return repository.save(userdetail);

              });
    }

    public Mono<Void> deleteUser(String id){
        return repository.deleteById(id);
    }
}
