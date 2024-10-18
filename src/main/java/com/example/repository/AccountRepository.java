package com.example.repository;

import org.springframework.stereotype.Repository;
import com.example.entity.Account;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
    public Optional<Account> findByUsername(String username);
    public Optional<Account> findByUsernameAndPassword(String username, String password);
}
