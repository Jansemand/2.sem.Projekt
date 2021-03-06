package domain;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Jannik
 */
public class Order {

    private int orderNo;
    private int state;
    private Customer customer;
    private ArrayList<Item> itemlist = new ArrayList<Item>();
    private Date depositumDate;
    private Date orderDate;
    private int depositumPrice;

    public Order(ArrayList<Item> itemlist, Customer customer, Date orderDate) {
        this.itemlist = itemlist;
        state = 0;
        this.customer = customer;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 3);
        Date date = (Date) calendar.getTime();
        depositumDate = date;
        this.orderDate = orderDate;
    }

    public Order(int orderNo, ArrayList<Item> itemlist, Date depositumDate, Date orderDate, Customer customer, int state) {

        this.orderNo = orderNo;
        this.itemlist = itemlist;
        this.state = state;
        this.orderDate = orderDate;
        this.depositumDate = depositumDate;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int ordreNo) {
        this.orderNo = ordreNo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public ArrayList<Item> getItemlist() {
        return itemlist;
    }

    public String getItemlistString() {
        String res = "\nVarer:\n";
        for (int i = 0; i < itemlist.size(); i++) {
            res += itemlist.get(i).getItemName() + ", " + itemlist.get(i).getItemAmount() + "\n";
        }
        return res;
    }

    public Date getDepositumDate() {
        return depositumDate;
    }

    public Date getorderDate() {
        return orderDate;
    }

    public void setorderDate(Date date) {
        orderDate = date;
    }

    public String getDepositumDateToString() {
        String res = "";

        java.sql.Date sqlDate = new java.sql.Date(depositumDate.getTime());
        res = new SimpleDateFormat("y M d").format(sqlDate);
        return res;
    }

    public String getOrderDateToString() {
        String res = "";

        java.sql.Date sqlDate = new java.sql.Date(orderDate.getTime());
        res = new SimpleDateFormat("y M d").format(sqlDate);
        return res;
    }

    public int getDepositumPrice() {
        depositumPrice = 0;
        for (int i = 0; i < itemlist.size(); i++) {
            if (itemlist.get(i).getItemAmount() > 1) {
                depositumPrice += itemlist.get(i).getPrice() * itemlist.get(i).getItemAmount();
            } else {
                depositumPrice += itemlist.get(i).getPrice();
            }
        }
        return depositumPrice/2;
    }

    @Override
    public String toString() {
        return "Ordre nummer " + orderNo + ", state " + state;
    }
}
