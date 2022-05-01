package entity;

import java.time.LocalDateTime;

/**
 *
 * @author nguye
 */
public class ChiTietHoaDon {
    private int soLuongDV;
    private double donGiaPhong;
    private double donGiaDichVu;
    private LocalDateTime ngayDatPhong;
    private LocalDateTime ngayNhanPhong;
    private Phong phong;
    private DichVu dichVu;
    private HoaDon hoaDon;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int soLuongDV, double donGiaPhong, double donGiaDichVu, LocalDateTime ngayDatPhong, LocalDateTime ngayNhanPhong, Phong phong, DichVu dichVu, HoaDon hoaDon) {
        this.soLuongDV = soLuongDV;
        this.donGiaPhong = donGiaPhong;
        this.donGiaDichVu = donGiaDichVu;
        this.ngayDatPhong = ngayDatPhong;
        this.ngayNhanPhong = ngayNhanPhong;
        this.phong = phong;
        this.dichVu = dichVu;
        this.hoaDon = hoaDon;
    }

    public int getSoLuongDV() {
        return soLuongDV;
    }

    public void setSoLuongDV(int soLuongDV) {
        this.soLuongDV = soLuongDV;
    }

    public double getDonGiaPhong() {
        return donGiaPhong;
    }

    public void setDonGiaPhong(double donGiaPhong) {
        this.donGiaPhong = donGiaPhong;
    }

    public double getDonGiaDichVu() {
        return donGiaDichVu;
    }

    public void setDonGiaDichVu(double donGiaDichVu) {
        this.donGiaDichVu = donGiaDichVu;
    }

    public LocalDateTime getNgayDatPhong() {
        return ngayDatPhong;
    }

    public void setNgayDatPhong(LocalDateTime ngayDatPhong) {
        this.ngayDatPhong = ngayDatPhong;
    }

    public LocalDateTime getNgayNhanPhong() {
        return ngayNhanPhong;
    }

    public void setNgayNhanPhong(LocalDateTime ngayNhanPhong) {
        this.ngayNhanPhong = ngayNhanPhong;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public DichVu getDichVu() {
        return dichVu;
    }

    public void setDichVu(DichVu dichVu) {
        this.dichVu = dichVu;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" + "soLuongDV=" + soLuongDV + ", donGiaPhong=" + donGiaPhong + ", donGiaDichVu=" + donGiaDichVu + ", ngayDatPhong=" + ngayDatPhong + ", ngayNhanPhong=" + ngayNhanPhong + ", phong=" + phong + ", dichVu=" + dichVu + ", hoaDon=" + hoaDon + '}';
    }
}
