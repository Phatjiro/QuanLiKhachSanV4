package main;

import gui.GDChinh;
import java.sql.SQLException;

/**
 *
 * @author vanphatdev
 */
public class Main {

    public static GDChinh gdChinh;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        System.out.println("Cay cú tạo nên khác biệt!");
        gdChinh = new GDChinh();
        gdChinh.setVisible(true);
    }
    
}
