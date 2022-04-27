package entity;

import java.util.Objects;

/**
 *
 * @author nguye
 */
public class Phong {
	private String maPhong;
	private boolean trangThai;
	private LoaiPhong loaiPhong;
	private double gia;
	private double dienTich;
	private int soGiuong;
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public double getDienTich() {
		return dienTich;
	}
	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}
	public int getSoGiuong() {
		return soGiuong;
	}
	public void setSoGiuong(int soGiuong) {
		this.soGiuong = soGiuong;
	}
	public Phong(String maPhong, boolean trangThai, LoaiPhong loaiPhong, double gia, double dienTich, int soGiuong) {
		super();
		this.maPhong = maPhong;
		this.trangThai = trangThai;
		this.loaiPhong = loaiPhong;
		this.gia = gia;
		this.dienTich = dienTich;
		this.soGiuong = soGiuong;
	}
	public Phong(String maPhong) {
		super();
		this.maPhong = maPhong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Phong))
			return false;
		Phong other = (Phong) obj;
		return Objects.equals(maPhong, other.maPhong);
	}
	
	
}
