package com.ripple.infrasvc.dal.repository;


import com.ripple.infrasvc.dal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByName(String name);

    User findByName(String name);

    void deleteByName(String name);

}
