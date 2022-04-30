package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.KetNoiCSDL;
import entity.KhachHang;

public class KhachHangDAO {

	public ArrayList<KhachHang> getTableKhachHang() {
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		KetNoiCSDL.getInstance();

		// Step 1: get a connection to database
		Connection con = KetNoiCSDL.getConnection();
		try {
			// Step 2: create a statement object
			Statement statement = con.createStatement();

			// Step 3: Execute a SQL statement
			String sql = "SELECT * FROM KhachHang";
			ResultSet rs = statement.executeQuery(sql);

			// Step 4: Process the SQL Query results
			while (rs.next()) {
				int maKH = rs.getInt("maKH");
				String hoTen = rs.getString("hoTen");
				String soDT = rs.getString("soDT");
				String soCMND = rs.getString("soCMND");
				String diaChi = rs.getString("diaChi");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				boolean loaiKH = rs.getBoolean("loaiKH");
				KhachHang kh = new KhachHang(maKH, hoTen, soDT, soCMND, diaChi, gioiTinh, loaiKH);
				dsKhachHang.add(kh);
			}
		} catch (Exception e) {
			System.err.println("Connection failed");
			e.printStackTrace();
		}

		return dsKhachHang;
	}

	public boolean addKhachHang(KhachHang kh) {
		KetNoiCSDL.getInstance();

		Connection con = KetNoiCSDL.getConnection();
		PreparedStatement stmt = null;
		String sql = "INSERT INTO KhachHang VALUES (?, ?, ?, ?, ?, ?, ?)";
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, kh.getMaKH());
			stmt.setString(2, kh.getHoTenKH());
			stmt.setString(3, kh.getSoDT());
			stmt.setString(4, kh.getSoCMND());
			stmt.setString(5, kh.getDiaChi());
			stmt.setBoolean(6, kh.isGioiTinh());
			stmt.setBoolean(7, kh.isLoaiKH());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	public ArrayList<KhachHang> getKhachHangTheoLoaiGioiTinh(boolean gioiTinh) {
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		KetNoiCSDL.getInstance();

		// Step 1: get a connection to database
		Connection con = KetNoiCSDL.getConnection();

		// Step 2: create a prepareStatement object
		PreparedStatement statement = null;

		String sql = "SELECT * FROM KhachHang WHERE gioiTinh = ?";
		try {
			statement = con.prepareStatement(sql);
			statement.setBoolean(1, gioiTinh);

			// Step 3: Execute a SQL statement
			ResultSet rs = statement.executeQuery();

			// Step 4: Process the SQL Query results
			while (rs.next()) {
				int maKH = rs.getInt("maKH");
				String hoTen = rs.getString("hoTen");
				String soDT = rs.getString("soDT");
				String soCMND = rs.getString("soCMND");
				String diaChi = rs.getString("diaChi");
				boolean gioitinh = rs.getBoolean("gioiTinh");
				boolean loaiKhachHang = rs.getBoolean("loaiKH");
				KhachHang kh = new KhachHang(maKH, hoTen, soDT, soCMND, diaChi, gioitinh, loaiKhachHang);
				dsKhachHang.add(kh);
			}
		} catch (Exception e) {
			System.err.println("Connection failed");
			e.printStackTrace();
		}

		return dsKhachHang;
	}
	
	public ArrayList<KhachHang> getKhachHangTheoLoaiKH(boolean loaiKH) {
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		KetNoiCSDL.getInstance();

		// Step 1: get a connection to database
		Connection con = KetNoiCSDL.getConnection();

		// Step 2: create a prepareStatement object
		PreparedStatement statement = null;

		String sql = "SELECT * FROM KhachHang WHERE loaiKH = ?";
		try {
			statement = con.prepareStatement(sql);
			statement.setBoolean(1, loaiKH);

			// Step 3: Execute a SQL statement
			ResultSet rs = statement.executeQuery();

			// Step 4: Process the SQL Query results
			while (rs.next()) {
				int maKH = rs.getInt("maKH");
				String hoTen = rs.getString("hoTen");
				String soDT = rs.getString("soDT");
				String soCMND = rs.getString("soCMND");
				String diaChi = rs.getString("diaChi");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				boolean loaiKhachHang = rs.getBoolean("loaiKH");
				KhachHang kh = new KhachHang(maKH, hoTen, soDT, soCMND, diaChi, gioiTinh, loaiKhachHang);
				dsKhachHang.add(kh);
			}
		} catch (Exception e) {
			System.err.println("Connection failed");
			e.printStackTrace();
		}

		return dsKhachHang;
	}

	public KhachHang getKhachHangTheoMaKhachHang(int maKhachHang) {
		KhachHang kh = null;
		KetNoiCSDL.getInstance();

		// Step 1: get a connection to database
		Connection con = KetNoiCSDL.getConnection();

		// Step 2: create a prepareStatement object
		PreparedStatement statement = null;

		String sql = "SELECT * FROM KhachHang WHERE maKH = ?";
		try {
			statement = con.prepareStatement(sql);
			statement.setInt(1, maKhachHang);

			// Step 3: Execute a SQL statement
			ResultSet rs = statement.executeQuery();

			// Step 4: Process the SQL Query results
			if (rs.next()) {				
				int maKH = rs.getInt("maKH");
				String hoTen = rs.getString("hoTen");
				String soDT = rs.getString("soDT");
				String soCMND = rs.getString("soCMND");
				String diaChi = rs.getString("diaChi");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				boolean loaiKH = rs.getBoolean("loaiKH");
				kh = new KhachHang(maKH, hoTen, soDT, soCMND, diaChi, gioiTinh, loaiKH);
			}
		} catch (Exception e) {
			System.err.println("Connection failed");
			e.printStackTrace();
		}
		
		return kh;
	}
	
	public int createMaKH_moi() {
		int maKH = 0;
		KetNoiCSDL.getInstance();

		// Step 1: get a connection to database
		Connection con = KetNoiCSDL.getConnection();
		
		try {
			// Step 2: create a statement object
			Statement statement = con.createStatement();
			String sql = "SELECT TOP 1 * FROM KhachHang ORDER BY maKH DESC";
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				maKH = rs.getInt("maKH") + 1;
			}
		} catch (Exception e) {
			System.err.println("Connection failed");
			e.printStackTrace();
		}
		return maKH;
	}
	
	public boolean updateThongTinKH(KhachHang kh) {
		KetNoiCSDL.getInstance();
		Connection con = KetNoiCSDL.getConnection();
		
		PreparedStatement stmt = null;
		int n = 0;
		
		String sql = "UPDATE KhachHang SET hoTen = ?, soDT = ?, soCMND = ?, diaChi = ?, gioiTinh = ?, loaiKH = ? WHERE maKH = ?";
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, kh.getHoTenKH());
			stmt.setString(2, kh.getSoDT());
			stmt.setString(3, kh.getSoCMND());
			stmt.setString(4, kh.getDiaChi());
			stmt.setBoolean(5, kh.isGioiTinh());
			stmt.setBoolean(6, kh.isLoaiKH());
			stmt.setInt(7, kh.getMaKH());
			
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
}
