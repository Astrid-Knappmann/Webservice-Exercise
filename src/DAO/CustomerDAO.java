
package DAO;

import java.sql.Connection;
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
    
    

}
