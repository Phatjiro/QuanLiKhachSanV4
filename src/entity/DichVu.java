package entity;

/**
 *
 * @author nguye
 */
public class DichVu {
    private int maDV;
    private String tenNV;
    private double donGia;
    private boolean loaiDV;

    public DichVu() {
    }

    public DichVu(int maDV, String tenNV, double donGia, boolean loaiDV) {
        this.maDV = maDV;
        this.tenNV = tenNV;
        this.donGia = donGia;
        this.loaiDV = loaiDV;
    }

    public int getMaNV() {
        return maDV;
    }

    public void setMaNV(int maNV) {
        this.maDV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public boolean isLoaiDV() {
        return loaiDV;
    }

    public void setLoaiDV(boolean loaiDV) {
        this.loaiDV = loaiDV;
    }

    @Override
    public String toString() {
        return "DichVu{" + "maNV=" + maDV + ", tenNV=" + tenNV + ", donGia=" + donGia + ", loaiDV=" + loaiDV + '}';
    }
    
    
}
