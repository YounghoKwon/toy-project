package com.xxx.noticeproject.service;

import com.xxx.noticeproject.dto.DepartmentDto;
import com.xxx.noticeproject.entity.Department;
import com.xxx.noticeproject.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public Page<DepartmentDto.Department> getDepartmentList(String searchText, Pageable pageable) {

        return departmentRepository.getSearchDepartmentListUsingJPAQueryFactory(pageable, searchText);
    }

    public DepartmentDto.Department getDepartment(Long id) {
//        return departmentRepository.findById(id)
//                .map(departmentMapper::toDto)
//                .orElseThrow(NoSuchElementException::new);
        return null;
    }

    public void deleteDepartment(Department department){
        departmentRepository.delete(department);
    }

    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }

    public Department modifyDepartment(Department department){
        return departmentRepository.save(department);
    }



}
