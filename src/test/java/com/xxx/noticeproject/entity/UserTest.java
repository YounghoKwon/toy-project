package com.xxx.noticeproject.entity;

import com.xxx.noticeproject.repository.DepartmentRepository;
import com.xxx.noticeproject.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
@SpringBootTest
@Transactional
class UserTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DepartmentRepository departmentRepository;

}
