package com.crudelearning.cruddemo.repositories;

import com.crudelearning.cruddemo.ServiceUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<ServiceUsers,Long> {
}
