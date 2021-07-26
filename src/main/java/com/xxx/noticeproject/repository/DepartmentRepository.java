package com.xxx.noticeproject.repository;

import com.xxx.noticeproject.entity.Department;
import com.xxx.noticeproject.repository.customized.DepartmentCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface DepartmentRepository extends JpaRepository<Department,Long>, DepartmentCustomRepository, QuerydslPredicateExecutor<Department> {


}
