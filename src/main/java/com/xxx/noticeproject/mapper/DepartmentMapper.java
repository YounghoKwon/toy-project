package com.xxx.noticeproject.mapper;

import com.xxx.noticeproject.dto.DepartmentDto;
import com.xxx.noticeproject.entity.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper extends GenericMapper<DepartmentDto.Department, Department> {


}
