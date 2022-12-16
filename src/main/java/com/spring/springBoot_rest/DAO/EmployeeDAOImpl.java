package com.spring.springBoot_rest.DAO;


import com.spring.springBoot_rest.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = entityManager.createQuery("from Employee", Employee.class).getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
      Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());
    }

    @Override
    public Employee getEmployee(int id){
    Employee employee = entityManager.find(Employee.class, id);
    return employee;
    }
    
     @Override
    public void deleteEmployee(int id) {
         Query query = entityManager.createQuery("delete from Employee"+"where id=:employeeId");
         query.setParameter("employeeId", id);
         query.executeUpdate();
       }
}
