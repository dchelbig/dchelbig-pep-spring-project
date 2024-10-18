package com.example.repository;

import org.springframework.stereotype.Repository;
import com.example.entity.Message;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{
    @Query("SELECT acc.accountId FROM Account acc WHERE acc.accountId = :postedBy")
    public Optional<Integer> findByPostedBy(@Param("postedBy") Integer postedBy);

    @Query("FROM Message msg WHERE msg.postedBy = :postedBy")
    public List<Message> findAllByPostedBy(@Param("postedBy") Integer postedBy);
}
