package com.javatechie.reactive.repository;




// import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.javatechie.reactive.entity.User;


@Repository
public interface UserRepository extends ReactiveMongoRepository<User,String> {
    // Flux<ProductDto> findByPriceBetween(Range<Double> priceRange);
}
