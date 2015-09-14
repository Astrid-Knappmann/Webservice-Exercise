
package webservice.exercise;

import DAO.CustomerDAO;
import DAO.OrderDAO;
import java.sql.Connection;
import model.Customer;
import util.DBUtil;

/**
 *
 * @author Patrick
 */
public class WebserviceExercise {
    
    private CustomerDAO customerDAO;
    private OrderDAO orderDAO;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WebserviceExercise we = new WebserviceExercise();
    
    }

    public WebserviceExercise() {
        Connection dbConn = DBUtil.getInstance();
        customerDAO = new CustomerDAO(dbConn);
        orderDAO = new OrderDAO(dbConn);
        testCustomerDAO();
        testOrderDAO();
    }
    
    public void testCustomerDAO(){
        System.out.println(customerDAO.getCustomer("ALFKI").toString());
        Customer testCustomer = new Customer("AAAAA", "Netto", "Hans", "Chief", "Vej", "Copenhagen", "Zealand", "4600", "Denmark", "34234534", "dsfsdf");
        customerDAO.createCustomer(testCustomer);
        System.out.println(customerDAO.getCustomer("AAAAA"));
        testCustomer.setCompanyName("Fakta");
        customerDAO.updateCustomer(testCustomer);
        System.out.println(customerDAO.getCustomer("AAAAA"));
        customerDAO.deleteCustomer(testCustomer);
    }
    
    public void testOrderDAO(){
        System.out.println(orderDAO.getOrder(10248).toString());
    }
    
    

}
