package com.jalal.employee_portal.service;

import com.jalal.employee_portal.domain.EmployeeDto;
import com.jalal.employee_portal.entity.Employee;

public interface EmployeeService {

   public void saveEmployee(Employee employee);
   EmployeeDto getEmployee(long id);

   void updateEmployee(EmployeeDto employeeDto, long id);

   void deleteEmployee(long id);

}
