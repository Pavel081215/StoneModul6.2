package dao;

import entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


@Repository
public class JdbcEmployeeDao implements EmployeeService {
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
}
