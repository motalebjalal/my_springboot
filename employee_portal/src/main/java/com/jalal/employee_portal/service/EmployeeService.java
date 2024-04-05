package com.jalal.employee_portal.service;

import com.jalal.employee_portal.domain.EmployeeDto;
import com.jalal.employee_portal.entity.Employee;

import java.util.List;

public interface EmployeeService {

   public void saveEmployee(Employee employee);

  List<EmployeeDto> fatchAllEmployee();
   EmployeeDto getEmployee(long id);

   EmployeeDto updateEmployee(EmployeeDto employeeDto, long id);

   void deleteEmployee(long id);

}

