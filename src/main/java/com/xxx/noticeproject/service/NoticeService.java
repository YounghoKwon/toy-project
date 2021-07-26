package com.xxx.noticeproject.service;

import com.xxx.noticeproject.dto.DepartmentDto;
import com.xxx.noticeproject.entity.Department;
import com.xxx.noticeproject.mapper.DepartmentMapper;
import com.xxx.noticeproject.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public Page<DepartmentDto.Department> getDepartMentList(String searchText, Pageable pageable) {

        return departmentRepository.getSearchDepartmentList(pageable, searchText).map(departmentMapper::toDto);
    }

    public DepartmentDto.Department getDepartment(Long id) {
        return departmentRepository.findById(id)
                .map(departmentMapper::toDto)
                .orElseThrow(NoSuchElementException::new);
    }

    public void deleteDepartment(Department department){
        departmentRepository.delete(department);
    }

    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }

    public Department modifyDepartMent(Department department){
        return departmentRepository.save(department);
    }



}
