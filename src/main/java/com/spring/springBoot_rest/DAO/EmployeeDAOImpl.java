package com.spring.springBoot_rest.DAO;


import com.spring.springBoot_rest.entity.Employee;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        Session session = entityManager.unwrap(Session.class);
        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList();
        return allEmployees;
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
         Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id){
     Session session = entityManager.unwrap(Session.class);
    Employee employee = session.get(Employee.class, id);
    return employee;
    }
    
     @Override
     @Transactional
    public void deleteEmployee(int id) {
          Session session = entityManager.unwrap(Session.class);
         Query <Employee> query = session.createQuery("delete from Employee where id=:employeeId");
         query.setParameter("employeeId", id);
         query.executeUpdate();
       }
}
