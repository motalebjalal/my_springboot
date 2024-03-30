package com.jalal.employee_portal.service;

import com.jalal.employee_portal.domain.EmployeeDto;
import com.jalal.employee_portal.entity.Employee;
import com.jalal.employee_portal.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public EmployeeDto getEmployee(long id) {
        Optional<Employee> employeeOptional = employeeRepo.findById(id);
        Employee employee = employeeOptional.get();
        if (employee == null) {
            throw new RuntimeException("Data Is Not Found");
        }
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(employee.getName());
        employeeDto.setDepartment(employee.getDepartment());
        employeeDto.setPhoneNumber(employee.getPhoneNumber());
        return employeeDto;
    }

    @Override
    public void updateEmployee(EmployeeDto employeeDto, long id) {
        Optional <Employee> employeeUpdate = employeeRepo.findById(id);
        Employee employee = employeeUpdate.get();

        employee.setName(employeeDto.getName());
        employee.setDepartment(employeeDto.getDepartment());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepo.deleteById(id);
    }
}
