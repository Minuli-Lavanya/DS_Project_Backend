package com.hotel.ds_backend.service.impl;

import com.hotel.ds_backend.exception.ResourceNotFoundException;
import com.hotel.ds_backend.model.Employee;
import com.hotel.ds_backend.repository.EmplyeeRepository;
import com.hotel.ds_backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmplyeeRepository emplyeeRepository;

    public EmployeeServiceImpl(EmplyeeRepository emplyeeRepository) {
        this.emplyeeRepository = emplyeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee){
        return emplyeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return emplyeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
//        Optional<Employee> employee = emplyeeRepository.findById(id);
//        if(employee.isPresent()){
//            return employee.get();
//        }else {
//            throw new ResourceNotFoundException("Employee", "Id", id);
//        }
//    }

        return emplyeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {

        Employee existingEmployee = emplyeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","Id", id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        emplyeeRepository.save(existingEmployee);

        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        emplyeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id", id));
        emplyeeRepository.deleteById(id);
    }
}
