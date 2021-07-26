package com.xxx.noticeproject.restController;

import com.sun.istack.NotNull;
import com.xxx.noticeproject.dto.DepartmentDto;
import com.xxx.noticeproject.entity.Department;
import com.xxx.noticeproject.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping(value = "/")
    public ResponseEntity<Page<DepartmentDto.Department>> list(@PageableDefault(size=20, sort="title",direction = Sort.Direction.ASC) Pageable pageable, @RequestParam(value = "search_text") String searchText){
        return new ResponseEntity<>(departmentService.getDepartMentList(searchText,pageable), HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Department> saveNotice(@Valid @RequestBody Department department){
        return new ResponseEntity<>(departmentService.modifyDepartMent(department), HttpStatus.OK);
    }

    @PatchMapping(value = "/")
    public ResponseEntity<Department> modifyNotice(@Valid @RequestBody Department department){
        return new ResponseEntity<>(departmentService.modifyDepartMent(department), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Department> deleteNotice(@NotNull @PathVariable Long id){
        departmentService.deleteDepartment(id);
        return new ResponseEntity("", HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartmentDto.Department> getNotice(@NotNull @PathVariable Long id){
        return new ResponseEntity(departmentService.getDepartment(id), HttpStatus.OK);
    }

}
