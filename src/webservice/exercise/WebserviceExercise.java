
package webservice.exercise;

import DAO.CustomerDAO;
import java.sql.Connection;
import util.DBUtil;

/**
 *
 * @author Patrick
 */
public class WebserviceExercise {
    
    private CustomerDAO customerDAO;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WebserviceExercise we = new WebserviceExercise();
    
    }

    public WebserviceExercise() {
        Connection dbConn = DBUtil.getInstance();
        customerDAO = new CustomerDAO(dbConn);
        System.out.println(customerDAO.getCustomer("ALFKI").toString());
    }
    
    

}
