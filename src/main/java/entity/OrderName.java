package entity;

import java.sql.Date;

/**
 * Created by Pavel on 14.06.2016.
 */
public class OrderName {

    private int id;
    private String waiter;
    private String dish_1;
    private String dish_2;
    private String dish_3;
    private int table_number;
    private Date time;
    private boolean open_order;

    public int getId() {
        return id;
    }

    public String getWaiter() {
        return waiter;
    }

    public String getDish_1() {
        return dish_1;
    }

    public String getDish_2() {
        return dish_2;
    }

    public String getDish_3() {
        return dish_3;
    }

    public int getTable_number() {
        return table_number;
    }

    public Date getTime() {
        return time;
    }

    public boolean isOpen_order() {
        return open_order;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }

    public void setDish_1(String dish_1) {
        this.dish_1 = dish_1;
    }

    public void setDish_2(String dish_2) {
        this.dish_2 = dish_2;
    }

    public void setDish_3(String dish_3) {
        this.dish_3 = dish_3;
    }

    public void setTable_number(int table_number) {
        this.table_number = table_number;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setOpen_order(boolean open_order) {
        this.open_order = open_order;
    }
}
