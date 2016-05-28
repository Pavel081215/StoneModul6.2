package dao;

import entity.Employee;

import java.util.List;

/**
 * Created by Pavel on 28.05.2016.
 */
public interface EmployeeService {

    public void addEmplyee(Employee contact);

    public List<Employee> listEmplyee();

    public void removeEmplyee(Integer id);

    public Employee findEmplyee(Integer id);
}
