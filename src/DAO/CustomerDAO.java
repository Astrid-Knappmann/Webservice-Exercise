
package DAO;

import java.sql.Connection;

/**
 *
 * @author Patrick
 */
public class CustomerDAO {
    
    private Connection dbConn;

    public CustomerDAO(Connection dbConn) {
        this.dbConn = dbConn;
    }
    
    

}
