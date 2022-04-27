package entity;

import java.util.Objects;

/**
 *
 * @author nguye
 */
public class KhachHang {
    private int maKH;
    private String hoTenKH;
    private String soDT;
    private String soCMND;
    private String diaChi;
    private boolean gioiTinh;
    private boolean loaiKH;
    public int getMaKH() {
            return maKH;
    }
    public void setMaKH(int maKH) {
            this.maKH = maKH;
    }
    public String getHoTenKH() {
            return hoTenKH;
    }
    public void setHoTenKH(String hoTenKH) {
            this.hoTenKH = hoTenKH;
    }
    public String getSoDT() {
            return soDT;
    }
    public void setSoDT(String soDT) {
            this.soDT = soDT;
    }
    public String getSoCMND() {
            return soCMND;
    }
    public void setSoCMND(String soCMND) {
            this.soCMND = soCMND;
    }
    public String getDiaChi() {
            return diaChi;
    }
    public void setDiaChi(String diaChi) {
            this.diaChi = diaChi;
    }
    public boolean isGioiTinh() {
            return gioiTinh;
    }
    public void setGioiTinh(boolean gioiTinh) {
            this.gioiTinh = gioiTinh;
    }
    public boolean isLoaiKH() {
            return loaiKH;
    }
    public void setLoaiKH(boolean loaiKH) {
            this.loaiKH = loaiKH;
    }
    public KhachHang(int maKH, String hoTenKH, String soDT, String soCMND, String diaChi, boolean gioiTinh,
                    boolean loaiKH) {
            super();
            this.maKH = maKH;
            this.hoTenKH = hoTenKH;
            this.soDT = soDT;
            this.soCMND = soCMND;
            this.diaChi = diaChi;
            this.gioiTinh = gioiTinh;
            this.loaiKH = loaiKH;
    }
    public KhachHang() {
            super();
    }
    public KhachHang(int maKH) {
            super();
            this.maKH = maKH;
    }
    @Override
    public int hashCode() {
            return Objects.hash(maKH);
    }
    @Override
    public boolean equals(Object obj) {
            if (this == obj)
                    return true;
            if (!(obj instanceof KhachHang))
                    return false;
            KhachHang other = (KhachHang) obj;
            return maKH == other.maKH;
    }
}
