package com.xxx.noticeproject.entity;

import com.xxx.noticeproject.dto.DepartmentDto;
import com.xxx.noticeproject.repository.DepartmentRepository;
import com.xxx.noticeproject.repository.UserRepository;
import com.xxx.noticeproject.service.DepartmentService;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.*;
import java.lang.reflect.Member;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DepartmentTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    DepartmentService departmentService;

    @Test
    @DisplayName("부서 생성 테스트")
    void department_create_test(){
        Department department = new Department("AAA","AAA");
        departmentRepository.save(department);
        final Department findDepartment = departmentRepository.findByName("AAA");
        assertEquals(department, findDepartment);
    }

    @Test
    @DisplayName("부서 검색 테스트")
    void department_search_test(){
        Department department = new Department("AAA","AAA");
        departmentRepository.save(department);
        PageRequest page = PageRequest.of(0,5);
        Page<DepartmentDto.Department> findDepartmentList = departmentRepository.getSearchDepartmentListUsingJPAQueryFactory(page, "AAA");
        for (DepartmentDto.Department department1 : findDepartmentList) {
            System.out.println(department1);
        }

        assertEquals(findDepartmentList.getTotalElements(), 1);
    }

    @Test
    @DisplayName("부서 등록 실패 테스트")
    void department_fail_test(){
        Department department = new Department("a","a");
        departmentRepository.save(department);
        // 실제 entityManager가 save 에서 쿼리를 실행시키기지 않고 flush를 해줘야 쿼리가 실행되어 Exception을 표시해 준다.
        assertThrows( ConstraintViolationException.class,()-> departmentRepository.flush() );
    }

    @Test
    @DisplayName("부서 등록 실패 테스트2")
    void department_fail_test2(){

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Department department = new Department(null,"a");

        Set<ConstraintViolation<Department>> violations = validator.validate(department);
        departmentRepository.save(department);
        for (ConstraintViolation<Department> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.PropertyPath = " + violation.getPropertyPath());
            System.out.println("violation.message = " + violation.getMessage());
        }

    }

}



