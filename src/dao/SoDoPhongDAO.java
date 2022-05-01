package dao;

import java.sql.Connection;
import connectDB.KetNoiCSDL;
import entity.LoaiPhong;
import entity.Phong;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vanphatdev
 */
public class SoDoPhongDAO {
    public ArrayList<Phong> getAllSoDoPhong() throws SQLException {
        ArrayList<Phong> soDoPhong = new ArrayList<>();
        KetNoiCSDL.getInstance();
        KetNoiCSDL knCSDL = new KetNoiCSDL();
        knCSDL.connect();

        Connection con = knCSDL.getConnection();

        try {
            
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Phong";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                String maPhong = rs.getString(1);
                double giaPhong = rs.getDouble(2);
                double dienTich = rs.getDouble(3);
                int soGiuong = rs.getInt(4);
                String trangThaiPhong = rs.getString(5);
                LoaiPhong loaiPhong = new LoaiPhong(rs.getString(6));
                Phong phong = new Phong(maPhong, giaPhong, dienTich, soGiuong, trangThaiPhong, loaiPhong);
                soDoPhong.add(phong);
            }
            
        } catch (Exception e) {
            System.err.println("getAllSoDoPhong failed - pls check in SoDoPhongDAO");
            e.printStackTrace();
        }
        
        return soDoPhong;
    }
}
