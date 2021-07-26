package com.xxx.noticeproject.bootstrap;

import com.xxx.noticeproject.entity.Department;
import com.xxx.noticeproject.entity.User;
import com.xxx.noticeproject.mapper.DepartmentMapper;
import com.xxx.noticeproject.repository.DepartmentRepository;
import com.xxx.noticeproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class BootStrapData implements CommandLineRunner {

    private final UserRepository userRepository;
    private final DepartmentRepository departMentRepository;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("start boot");

        Department department1 = new Department("ABC","ABC");
        Department department2 = new Department("DEC","DEC");
        departMentRepository.save(department1);
        departMentRepository.save(department2);
        User user = new User("admin","admin","12345678",department1);
        userRepository.save(user);


    }
}
