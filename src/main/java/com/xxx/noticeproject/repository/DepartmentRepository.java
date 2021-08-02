package com.xxx.noticeproject.repository;

import com.xxx.noticeproject.dto.DepartmentDto;
import com.xxx.noticeproject.entity.Department;
import com.xxx.noticeproject.repository.customized.DepartmentCustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface DepartmentRepository extends JpaRepository<Department,Long>, DepartmentCustomRepository, QuerydslPredicateExecutor<Department> {

    Department findByName(String name);

    Page<Department> getSearchDepartmentList(Pageable pageable, String searchText);

    Page<DepartmentDto.Department> getSearchDepartmentListUsingJPAQueryFactory(Pageable pageable, String searchText);

}
