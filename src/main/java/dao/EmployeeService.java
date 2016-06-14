package dao;

import entity.Employee;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Pavel on 28.05.2016.
 */
public interface EmployeeService {

    public List<Employee> getAll();

    public void addEmployee(Employee employee);

    public Employee getEmployee(String name);
    public void deleteEmployee(String name);

  /*  public List<Employee> listEmplyee();

    public void removeEmplyee(Integer id);

    public Employee findEmplyee(Integer id);*/
}
