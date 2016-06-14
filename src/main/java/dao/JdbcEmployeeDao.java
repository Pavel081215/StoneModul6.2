package dao;

import entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;
import java.util.ArrayList;
import java.sql.Date;


@Repository
public class JdbcEmployeeDao implements EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(JdbcEmployeeDao.class);

    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public List<Employee> getAll() {
        List<Employee> result = new ArrayList<>();
        logger.info("Connection start");
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            logger.info("метод getAll");
            ResultSet resultSet = statement.executeQuery("SELECT  * FROM employee");
            while (resultSet.next()) {
                Employee employee = createEmployee(resultSet);
                result.add(employee);

            }
        } catch (SQLException e) {
            logger.error("Exception" + e);
        }
        logger.info("Connection finish");
        return result;
    }

    private Employee createEmployee(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setSurname(resultSet.getString("surname"));
        employee.setBirthDay(resultSet.getDate("birthDay"));
        employee.setName(resultSet.getString("name"));
        employee.setPhone(resultSet.getLong("phone"));
        employee.setPosition(resultSet.getString("position"));
        employee.setSalary(resultSet.getInt("salary"));
        return employee;
    }

    public void addEmployee(Employee employee) {
        int id = employee.getId();
        String surname = employee.getSurname();
        String name = employee.getName();
        Date birthDay = employee.getBirthDay();
        long phone = employee.getPhone();
        String position = employee.getPosition();
        long salary = employee.getSalary();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO employee VALUES (?,?,?,?,?,?,?);")) {
            stmt.setInt(1, id);
            stmt.setString(2, surname);
            stmt.setString(3, name);
            stmt.setDate(4, birthDay);
            stmt.setLong(5, phone);
            stmt.setString(6, position);
            stmt.setLong(7, salary);

            int rs = stmt.executeUpdate();
            if (rs > 0)
                System.out.println("Inserted Successfully");
            else
                System.out.println("Insert Unsuccessful");
        } catch (SQLException e) {
            logger.error("Exception", e);
            throw new RuntimeException(e);
        }
    }

    public Employee getEmployee(String name) {
        Employee employee = new Employee();
        logger.info("Connection start");
        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM employee WHERE name  = ? ;")) {
            stmt.setString(1, name);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                employee = createEmployee(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        logger.info("Connection finish");
        return employee;
    }

    public void deleteEmployee(String name) {

        logger.info("Connection start");
        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement("DELETE  FROM employee WHERE name  = ?;")) {
            stmt.setString(1, name);
            int rs = stmt.executeUpdate();
            if (rs > 0)
                System.out.println("Inserted Successfully");
            else
                System.out.println("Insert Unsuccessful");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        logger.info("Connection finish");


    }



























    /*
    private static final Logger logger = LoggerFactory.getLogger(JdbcEmployeeDao.class);

    @Autowired
    private DataSource dataSource;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addEmplyee(Employee employee) {

        Integer id = employee.getId();
        String surname = employee.getSurname();
        String name = employee.getName();
        String birthDay = employee.getBirthDay();
        long phone = employee.getPhone();
        String position = employee.getPosition();
        long salary = employee.getSalary();
        try (Connection connection = dataSource.getConnection();
             Statement stmt = connection.createStatement()) {
            String sql = "INSERT INTO employee (id,surname,name,birthDay,phone,position,salary) VALUES ('" + id + "', '" + surname + " ','" + name + "','"
                    + birthDay + "', '" +phone + "', '" + position + "', '" + salary;
            int rs = stmt.executeUpdate(sql);
            if (rs > 0)
                System.out.println("Inserted Successfully");
            else
                System.out.println("Insert Unsuccessful");
        } catch (SQLException e) {
            logger.error("Exception" + e);
            throw new RuntimeException(e);
        }
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Employee> listEmplyee() {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void removeEmplyee(Integer id) {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Employee findEmplyee(Integer id) {
        return null;
    }


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    */
}

