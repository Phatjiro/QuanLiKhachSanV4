package entity;

import java.time.LocalDate;

/**
 *
 * @author nguye
 */
public class ChiTietHoaDon {
    private int soLuongDichVu;
    private double donGiaPhong;
    private double donGiaDichVu;
    private Phong phong;
    private HoaDon hoaDon;
    private DichVu dichVu;
    private LocalDate ngayNhanPhong;
    private LocalDate ngayDatPhong;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int soLuongDichVu, double donGiaPhong, double donGiaDichVu, Phong phong, HoaDon hoaDon, DichVu dichVu, LocalDate ngayNhanPhong, LocalDate ngayDatPhong) {
        this.soLuongDichVu = soLuongDichVu;
        this.donGiaPhong = donGiaPhong;
        this.donGiaDichVu = donGiaDichVu;
        this.phong = phong;
        this.hoaDon = hoaDon;
        this.dichVu = dichVu;
        this.ngayNhanPhong = ngayNhanPhong;
        this.ngayDatPhong = ngayDatPhong;
    }

    public int getSoLuongDichVu() {
        return soLuongDichVu;
    }

    public void setSoLuongDichVu(int soLuongDichVu) {
        this.soLuongDichVu = soLuongDichVu;
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

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public DichVu getDichVu() {
        return dichVu;
    }

    public void setDichVu(DichVu dichVu) {
        this.dichVu = dichVu;
    }

    public LocalDate getNgayNhanPhong() {
        return ngayNhanPhong;
    }

    public void setNgayNhanPhong(LocalDate ngayNhanPhong) {
        this.ngayNhanPhong = ngayNhanPhong;
    }

    public LocalDate getNgayDatPhong() {
        return ngayDatPhong;
    }

    public void setNgayDatPhong(LocalDate ngayDatPhong) {
        this.ngayDatPhong = ngayDatPhong;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" + "soLuongDichVu=" + soLuongDichVu + ", donGiaPhong=" + donGiaPhong + ", donGiaDichVu=" + donGiaDichVu + ", phong=" + phong + ", hoaDon=" + hoaDon + ", dichVu=" + dichVu + ", ngayNhanPhong=" + ngayNhanPhong + ", ngayDatPhong=" + ngayDatPhong + '}';
    }

}
