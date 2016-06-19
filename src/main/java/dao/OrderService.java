package dao;

import entity.Employee;
import entity.OrderName;

import java.util.List;


public interface OrderService  {
    public List<OrderName> getAllOrders ();
}
