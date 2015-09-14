
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order;

/**
 *
 * @author Patrick
 */
public class OrderDAO {
    
    private Connection dbConn;

    public OrderDAO(Connection dbConn) {
        this.dbConn = dbConn;
    }
    
     public Order getOrder(int id){
        try {
            Statement st = dbConn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM orders WHERE OrderID=" + id + ";");
            rs.next();
            return new Order(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDate(5), rs.getDate(6), rs.getInt(7), rs.getBigDecimal(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
