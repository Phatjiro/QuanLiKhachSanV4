package dao;

import connectDB.KetNoiCSDL;
import entity.NhanPhong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author vanphatdev
 */
public class NhanPhongDAO {
    public ArrayList<NhanPhong> getAllNhanPhong() throws SQLException {
        ArrayList<NhanPhong> dsNhanPhong = new ArrayList<NhanPhong>();
        KetNoiCSDL.getInstance();
        KetNoiCSDL knCSDL = new KetNoiCSDL();
        knCSDL.connect();

        Connection con = knCSDL.getConnection();
        
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM NhanPhong";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                LocalDateTime ngayNhanPhong = rs.getTimestamp(1).toLocalDateTime();
                String maPhong = rs.getString(2);
                int maKH = rs.getInt(3);
                
                NhanPhong datPhong = new NhanPhong(ngayNhanPhong, maPhong, maPhong);
                dsNhanPhong.add(datPhong);
            }
            
        } catch (Exception e) {
            System.err.println("Kiểm tra getAllNhanPhong - NhanPhongDAO");
            e.printStackTrace();
        }
        
        return dsNhanPhong;
    }
    
    public void themNhanPhong(String ngayNhanPhong, String maPhong, int maKH) throws SQLException {
        KetNoiCSDL.getInstance();
        KetNoiCSDL knCSDL = new KetNoiCSDL();
        knCSDL.connect();
        Connection con = knCSDL.getConnection();
        
        try {
            String sql = "INSERT INTO NhanPhong VALUES (?, ?, ?)";
            PreparedStatement prepStmt = con.prepareStatement(sql);
            prepStmt.setString(1, ngayNhanPhong);
            prepStmt.setString(2, maPhong);
            prepStmt.setInt(3, maKH);
            prepStmt.executeUpdate();
        } catch (Exception e) {
            System.err.println("themNhanPhong - NhanPhongDAO");
            e.printStackTrace();
        }
    }
}