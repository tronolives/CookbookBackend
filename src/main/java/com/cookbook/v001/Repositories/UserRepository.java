package com.cookbook.v001.Repositories;

import com.cookbook.v001.Entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

}