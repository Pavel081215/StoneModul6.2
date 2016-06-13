package dao;

import entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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
            logger.error("Exception" +  e);
        }
        logger.info("Connection finish");
        return result;
    }

    private Employee createEmployee(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setSurname(resultSet.getString("surname"));
        employee.setBirthDay(resultSet.getString("birthDay"));
        employee.setName(resultSet.getString("name"));
        employee.setPhone(resultSet.getLong("phone"));
        employee.setPosition(resultSet.getString("position"));
        employee.setSalary(resultSet.getInt("salary"));
        return employee;
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
