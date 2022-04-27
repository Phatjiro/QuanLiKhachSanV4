package entity;

import java.util.Objects;

/**
 *
 * @author nguye
 */
public class LoaiPhong {

	private int maLoai;
	private String tenLoai;
	public int getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public LoaiPhong(int maLoai, String tenLoai) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
	}
	public LoaiPhong(int maLoai) {
		super();
		this.maLoai = maLoai;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maLoai);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof LoaiPhong))
			return false;
		LoaiPhong other = (LoaiPhong) obj;
		return maLoai == other.maLoai;
	}
	
}
