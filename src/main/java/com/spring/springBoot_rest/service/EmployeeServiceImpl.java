
package com.spring.springBoot_rest.service;
 
import com.spring.springBoot_rest.DAO.EmployeeDAO;
import com.spring.springBoot_rest.entity.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public void saveEmployee(Employee employee) {
      employeeDAO.saveEmployee(employee);  
    }
    @Override
    public Employee getEmployee(int id){
    return employeeDAO.getEmployee(id);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
       }
    
}
