package com.xxx.noticeproject.repository.customized;


import com.xxx.noticeproject.dto.DepartmentDto;
import com.xxx.noticeproject.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartmentCustomRepository {

    Page<Department> getSearchDepartmentList(Pageable pageable, String searchText);
    Page<DepartmentDto.Department> getSearchDepartmentListUsingJPAQueryFactory(Pageable pageable, String searchText);
}
