package com.Exam.UserName.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Exam.UserName.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

}
