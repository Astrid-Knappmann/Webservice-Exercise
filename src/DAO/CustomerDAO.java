
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;

/**
 *
 * @author Patrick
 */
public class CustomerDAO {
    
    private Connection dbConn;

    public CustomerDAO(Connection dbConn) {
        this.dbConn = dbConn;
    }
    
    public void createCustomer(Customer customer){
        try {
            Statement st = dbConn.createStatement();
            st.execute("INSERT INTO customers (CustomerID, CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax) VALUES ('" + customer.getId() + "', '" + customer.getCompanyName() + "', '" + customer.getContactName() + "', '" + customer.getContactTitle() + "', '" + customer.getAddress() + "', '" + customer.getCity() + "', '" + customer.getRegion() + "', '" + customer.getPostalCode() + "', '" + customer.getCountry() + "', '" + customer.getPhone() + "', '" + customer.getFax() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Customer getCustomer(String id){
        try {
            Statement st = dbConn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM customers WHERE CustomerID='" + id + "'");
            rs.next();
            return new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void updateCustomer(Customer customer){
        try {
            Statement st = dbConn.createStatement();
            st.execute("UPDATE customers SET CompanyName='" + customer.getCompanyName() + "', ContactName='" + customer.getContactName() + "', ContactTitle='" + customer.getContactTitle() + "', Address='" + customer.getAddress() + "', City='" + customer.getCity() + "', Region='" + customer.getRegion() + "', PostalCode='" + customer.getPostalCode() + "', Country='" + customer.getCountry() + "', Phone='" + customer.getPhone() + "', Fax='" + customer.getFax() + "' WHERE CustomerID='" + customer.getId() + "';");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteCustomer(Customer customer){
        try {
            Statement st = dbConn.createStatement();
            st.execute("DELETE FROM customers WHERE CustomerID='" + customer.getId() + "';");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

}
