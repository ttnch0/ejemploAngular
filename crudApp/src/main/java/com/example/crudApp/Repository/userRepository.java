package com.example.crudApp.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crudApp.Models.User;

public interface userRepository extends JpaRepository<User, Integer> {
	
	

}
