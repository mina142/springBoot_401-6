package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String username);
    User findByEmail(String Email);
    Long countByEmail(String Email);
    Long countByUserName(String username);

}
