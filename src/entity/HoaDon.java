package entity;

import java.time.LocalDateTime;

/**
 *
 * @author vanphatdev
 */
public class HoaDon {
    private int maHD;
    private LocalDateTime thoiGianLapHD;
    private double tienKhachDua;
    private NhanVien nhanVien;
    private KhachHang khachHang;

    public HoaDon() {
    }

    public HoaDon(int maHD) {
        this.maHD = maHD;
    }

    public HoaDon(int maHD, LocalDateTime thoiGianLapHD, double tienKhachDua, NhanVien nhanVien, KhachHang khachHang) {
        this.maHD = maHD;
        this.thoiGianLapHD = thoiGianLapHD;
        this.tienKhachDua = tienKhachDua;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public LocalDateTime getThoiGianLapHD() {
        return thoiGianLapHD;
    }

    public void setThoiGianLapHD(LocalDateTime thoiGianLapHD) {
        this.thoiGianLapHD = thoiGianLapHD;
    }

    public double getTienKhachDua() {
        return tienKhachDua;
    }

    public void setTienKhachDua(double tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "maHD=" + maHD + ", thoiGianLapHD=" + thoiGianLapHD + ", tienKhachDua=" + tienKhachDua + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.maHD;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HoaDon other = (HoaDon) obj;
        if (this.maHD != other.maHD) {
            return false;
        }
        return true;
    }
}
