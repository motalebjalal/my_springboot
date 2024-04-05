package com.jalal.employee_portal.controller;

import com.jalal.employee_portal.domain.EmployeeDto;
import com.jalal.employee_portal.entity.Employee;
import com.jalal.employee_portal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public void createEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
    }

    @GetMapping("/retrieve")
    public List<EmployeeDto> getAllEmployee(){
       return employeeService.fatchAllEmployee();
    }

    @GetMapping("/retrieve/{id}")
    public EmployeeDto getEmployee(@PathVariable long id){
        System.out.println(id);
        return employeeService.getEmployee(id);
    }

    @PutMapping("/update/{id}")
    public EmployeeDto updateEmployee(@RequestBody  EmployeeDto employeeDto , @PathVariable long id) {
        employeeService.updateEmployee(employeeDto,id);
        return employeeDto;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable long id){
    employeeService.deleteEmployee(id);
    }


}

