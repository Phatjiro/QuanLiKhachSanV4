package entity;

import java.time.LocalDate;

/**
 *
 * @author nguye
 */
public class HoaDon {
    private int maHD;
    private LocalDate thoiGianLapHoaDon;
    private NhanVien tenNVLapHD;
    private KhachHang tenKH;
    private ChiTietHoaDon chiTietHoaDon;
    private double tienKhachDua;
    private double tienChuaThue;
    private double thueGiaTriGiaTang;

    public HoaDon() {
    }

    public HoaDon(int maHD, LocalDate thoiGianLapHoaDon, NhanVien tenNVLapHD, KhachHang tenKH, ChiTietHoaDon chiTietHoaDon, double tienKhachDua, double tienChuaThue, double thueGiaTriGiaTang) {
        this.maHD = maHD;
        this.thoiGianLapHoaDon = thoiGianLapHoaDon;
        this.tenNVLapHD = tenNVLapHD;
        this.tenKH = tenKH;
        this.chiTietHoaDon = chiTietHoaDon;
        this.tienKhachDua = tienKhachDua;
        this.tienChuaThue = tienChuaThue;
        this.thueGiaTriGiaTang = thueGiaTriGiaTang;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public LocalDate getThoiGianLapHoaDon() {
        return thoiGianLapHoaDon;
    }

    public void setThoiGianLapHoaDon(LocalDate thoiGianLapHoaDon) {
        this.thoiGianLapHoaDon = thoiGianLapHoaDon;
    }

    public NhanVien getTenNVLapHD() {
        return tenNVLapHD;
    }

    public void setTenNVLapHD(NhanVien tenNVLapHD) {
        this.tenNVLapHD = tenNVLapHD;
    }

    public KhachHang getTenKH() {
        return tenKH;
    }

    public void setTenKH(KhachHang tenKH) {
        this.tenKH = tenKH;
    }

    public ChiTietHoaDon getChiTietHoaDon() {
        return chiTietHoaDon;
    }

    public void setChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        this.chiTietHoaDon = chiTietHoaDon;
    }

    public double getTienKhachDua() {
        return tienKhachDua;
    }

    public void setTienKhachDua(double tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public double getTienChuaThue() {
        return tienChuaThue;
    }

    public void setTienChuaThue(double tienChuaThue) {
        this.tienChuaThue = tienChuaThue;
    }

    public double getThueGiaTriGiaTang() {
        return thueGiaTriGiaTang;
    }

    public void setThueGiaTriGiaTang(double thueGiaTriGiaTang) {
        this.thueGiaTriGiaTang = thueGiaTriGiaTang;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "maHD=" + maHD + ", thoiGianLapHoaDon=" + thoiGianLapHoaDon + ", tenNVLapHD=" + tenNVLapHD + ", tenKH=" + tenKH + ", chiTietHoaDon=" + chiTietHoaDon + ", tienKhachDua=" + tienKhachDua + ", tienChuaThue=" + tienChuaThue + ", thueGiaTriGiaTang=" + thueGiaTriGiaTang + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.maHD;
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
