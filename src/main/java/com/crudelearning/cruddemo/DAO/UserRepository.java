package com.crudelearning.cruddemo.DAO;

import com.crudelearning.cruddemo.model.ServiceUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<ServiceUsers,Long> {
}
