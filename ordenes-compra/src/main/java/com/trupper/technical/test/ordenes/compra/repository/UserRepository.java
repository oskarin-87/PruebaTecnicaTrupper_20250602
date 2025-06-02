package com.trupper.technical.test.ordenes.compra.repository;


import com.trupper.technical.test.ordenes.compra.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}
