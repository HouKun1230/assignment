package com.uxpsystems.assignment.repo;

import com.uxpsystems.assignment.dao.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {


}
