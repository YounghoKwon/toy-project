package com.xxx.noticeproject.repository;


import com.xxx.noticeproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByLoginId(String loginId);
}
