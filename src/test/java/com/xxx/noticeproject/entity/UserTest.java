package com.xxx.noticeproject.entity;

import com.xxx.noticeproject.dto.UserDto;
import com.xxx.noticeproject.mapper.DepartmentMapper;
import com.xxx.noticeproject.mapper.UserMapper;
import com.xxx.noticeproject.repository.DepartmentRepository;
import com.xxx.noticeproject.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    DepartmentRepository departmentRepository;

    @Test
    @DisplayName("사용자 생성 성공 테스트")
    public void userCreateSuccessTest(){

        Department department = new Department("abc", "abc");
        departmentRepository.save(department);
        User user = new User("testAdmin", "admin", "12345678", department);
        userRepository.save(user);

        User admin = userRepository.findByLoginId("testAdmin");
//        UserDto.User user1 = userMapper.toDto(admin);
//        System.out.println(user1);
////        User user2 = userMapper.toEntity(user1);
////        System.out.println(user2);
//
//
//        User user2 = UserMapper.INSTANCE.toEntity( user1 );
//        System.out.println(user2);

        User user3 = new User();

        //        assertEquals(admin.getLoginId(),"admin");
    }
//
//
//    @Test
//    @DisplayName("사용자 실패 테스트 ")
//    public void userCreateFailTest(){
//        User user = new User("a", "b", "c");
//        ConstraintViolationException exception = assertThrows(ConstraintViolationException.class, () -> userRepository.save(user));
//        String message = exception.getMessage();
//        System.out.println(message);
//    }
}
