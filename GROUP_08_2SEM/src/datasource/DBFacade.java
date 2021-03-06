package datasource;

import domain.*;
import domain.Package;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Thomas Kragsberger
 */
public class DBFacade
{

    private static DBFacade instance;
    private TheMapper tm;
    private Connection con;

    public DBFacade()
    {
        tm = new TheMapper();
        con = new DBConnector().getConnection();

    }

    public static DBFacade getInstance()
    {
        if (instance == null)
        {
            instance = new DBFacade();
        }
        return instance;
    }

    public Order loadSingleOrder(int ono)
    {
        return tm.getSingleOrder(ono, con);
    }

    public ArrayList<Order> loadAllOrders()
    {
        return tm.getAllOrders(con);
    }

    public ArrayList getCustomer()
    {
        return tm.getCustomer(con);
    }

    public ArrayList getVare()
    {
        return tm.getItems(con);
    }

    public String saveOrder(ArrayList<Order> o) throws SQLException
    {
        return "" + tm.saveOrder(o, con);
    }

    public boolean saveCustomer(ArrayList<Customer> customer)
    {
        return tm.saveCustomer(customer, con);
    }

    public boolean increaseAmount(ArrayList<Item> it)
    {

        return tm.increaseItem(it, con);
    }

    public boolean saveNewItem(ArrayList<Item> it)
    {
        return tm.saveNewItem(it, con);
    }

    public boolean saveEmployee(ArrayList<Employee> employee)
    {
        return tm.saveEmployee(employee, con);
    }

    public boolean deleteItem(int itemNo)
    {
        return tm.deleteItem(itemNo, con);
    }

    public boolean updateOrder(Order o)
    {
        return tm.updateDepositum(o, con);
    }

    public ArrayList<Employee> getAllEmployees()
    {
        return tm.getAllEmployees(con);
    }

    public boolean saveEmployeeWithDate(Employee emp)
    {
        return tm.saveEmployeeWithDate(emp, con);
    }
    public boolean saveItemList(ArrayList<Package> pack){
         return tm.saveItemList(pack, con);
     }
    
        public ArrayList<Package> loadAllPackages()
    {
        return tm.getAllPackages(con);
    }
    public boolean deleteTestEmployees()
    {
        return tm.deleteTestEmployees(con);
    }
    
    public boolean deleteTestOrders()
    {
        return tm.deleteTestOrders(con);
    }
    
    public boolean deleteTestCustomers() throws SQLException
    {
        return tm.deleteTestCustomers(con);
    }
    
    public boolean resetStateOnTestOrder() throws SQLException
    {
        return tm.resetStateOnTestOrder(con);
    }
}
