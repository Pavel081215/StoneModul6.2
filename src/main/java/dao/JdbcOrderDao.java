package dao;

import entity.Employee;
import entity.OrderName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcOrderDao implements OrderService {
    private static final Logger logger = LoggerFactory.getLogger(JdbcEmployeeDao.class);

    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<OrderName> getAllOrders() {
        List<OrderName> result = new ArrayList<>();
        logger.info("Connection start");
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            logger.info("метод getAll");
            ResultSet resultSet = statement.executeQuery("SELECT  * FROM employee");
            while (resultSet.next()) {
                OrderName orderName = createOrderName(resultSet);
                result.add(orderName);
            }
        } catch (SQLException e) {
            logger.error("Exception" + e);
        }
        logger.info("Connection finish");
        return result;
    }


    private OrderName createOrderName(ResultSet resultSet) throws SQLException {
        OrderName orderName = new OrderName();
        orderName.setId(resultSet.getInt("id"));
        orderName.setWaiter(resultSet.getString("waiter"));
        orderName.setTime(resultSet.getDate("time"));
        orderName.setDish_1(resultSet.getString("dish_1"));
        orderName.setDish_2(resultSet.getString("dish_2"));
        orderName.setDish_2(resultSet.getString("dish_2"));
        orderName.setDish_3(resultSet.getString("dish_3"));
        orderName.setTable_number(resultSet.getInt("table_number"));
        orderName.setOpen_order(resultSet.getBoolean("open_order"));
        return orderName;
    }
}
