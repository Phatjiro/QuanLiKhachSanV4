package component;

import dao.DatPhongDAO;
import dao.KhachHangDAO;
import dao.NhanPhongDAO;
import dao.SoDoPhongDAO;
import entity.Phong;
import entity.LoaiPhong;
import gui.GDChinh;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Main;
import other.BienMacDinh;

/**
 *
 * @author vanphatdev
 */
public class PanelItemPhong extends javax.swing.JPanel {

    public Phong phong;
    public String maPhong, loaiPhong, trangThaiPhong;
    /**
     * Creates new form PanelItemPhong
     */
    public PanelItemPhong(Phong phong) {
        initComponents();
        this.phong = phong;
        LoaiPhong loaiPhong = phong.getLoaiPhong();
        this.setPreferredSize(new Dimension(222,100));
        
        lblMaPhong.setText(phong.getMaPhong());
        lblLoaiPhong.setText(loaiPhong.getTenLoaiPhong());
        lblTrangThaiPhong.setText(bienDoiTrangThaiPhong(phong.getTrangThaiPhong()));
    }
    
    public PanelItemPhong(String maPhong, String loaiPhong, String trangThaiPhong) {
        initComponents();
        this.setPreferredSize(new Dimension(222,100));
        
        this.maPhong = maPhong;
        this.loaiPhong = loaiPhong;
        this.trangThaiPhong = trangThaiPhong;
        
        lblMaPhong.setText(maPhong);
        lblLoaiPhong.setText(loaiPhong);
        lblTrangThaiPhong.setText(bienDoiTrangThaiPhong(trangThaiPhong));
    }
    
    public String bienDoiTrangThaiPhong(String bdTrangThai) {
        if (bdTrangThai.equals("pt")) {
            pMaPhong.setBackground(BienMacDinh.mauPhongTrong);
            pLoaiThaiPhong.setBackground(BienMacDinh.mauPhongTrongNhat);
            lblLoaiPhong.setForeground(BienMacDinh.mauPhongTrong);
            lblTrangThaiPhong.setForeground(BienMacDinh.mauPhongTrong);
            return "Trống";
        }
        
        if (bdTrangThai.equals("pcn")) {
            pMaPhong.setBackground(BienMacDinh.mauPhongCoNguoi);
            pLoaiThaiPhong.setBackground(BienMacDinh.mauPhongCoNguoiNhat);
            lblLoaiPhong.setForeground(BienMacDinh.mauPhongCoNguoi);
            lblTrangThaiPhong.setForeground(BienMacDinh.mauPhongCoNguoi);
            return "Có người";
        }
        
        if (bdTrangThai.equals("pdt")) {
            pMaPhong.setBackground(BienMacDinh.mauPhongDatTruoc);
            pLoaiThaiPhong.setBackground(BienMacDinh.mauPhongDatTruocNhat);
            lblLoaiPhong.setForeground(BienMacDinh.mauPhongDatTruoc);
            lblTrangThaiPhong.setForeground(BienMacDinh.mauPhongDatTruoc);
            return "Đặt trước";
        }
        
        if (bdTrangThai.equals("pds")) {
            pMaPhong.setBackground(BienMacDinh.mauPhongDangSua);
            pLoaiThaiPhong.setBackground(BienMacDinh.mauPhongDangSuaNhat);
            lblLoaiPhong.setForeground(BienMacDinh.mauPhongDangSua);
            lblTrangThaiPhong.setForeground(BienMacDinh.mauPhongDangSua);
            return "Đang sửa";
        }
        
        return bdTrangThai = "Ngoại lệ!";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pMenuPhongTrong = new javax.swing.JPopupMenu();
        ptDatPhong = new javax.swing.JMenuItem();
        ptSuaChua = new javax.swing.JMenuItem();
        pMenuPhongDatTruoc = new javax.swing.JPopupMenu();
        pdtNhanPhong = new javax.swing.JMenuItem();
        pdtHuyDat = new javax.swing.JMenuItem();
        pdtXemTTNguoiDat = new javax.swing.JMenuItem();
        pMenuPhongCoNguoi = new javax.swing.JPopupMenu();
        pcnDatDV = new javax.swing.JMenuItem();
        pcnTraPhong = new javax.swing.JMenuItem();
        pcnTTNguoiThue = new javax.swing.JMenuItem();
        pMenuPhongSuaChua = new javax.swing.JPopupMenu();
        pdsSuaXong = new javax.swing.JMenuItem();
        pMaPhong = new javax.swing.JPanel();
        lblMaPhong = new javax.swing.JLabel();
        pLoaiThaiPhong = new javax.swing.JPanel();
        lblLoaiPhong = new javax.swing.JLabel();
        lblTrangThaiPhong = new javax.swing.JLabel();

        pMenuPhongTrong.setBackground(new java.awt.Color(255, 255, 255));

        ptDatPhong.setBackground(new java.awt.Color(255, 255, 255));
        ptDatPhong.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        ptDatPhong.setText("Đặt phòng");
        ptDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptDatPhongActionPerformed(evt);
            }
        });
        pMenuPhongTrong.add(ptDatPhong);

        ptSuaChua.setBackground(new java.awt.Color(255, 255, 255));
        ptSuaChua.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        ptSuaChua.setText("Sửa chữa");
        ptSuaChua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptSuaChuaActionPerformed(evt);
            }
        });
        pMenuPhongTrong.add(ptSuaChua);

        pMenuPhongDatTruoc.setBackground(new java.awt.Color(255, 255, 255));

        pdtNhanPhong.setBackground(new java.awt.Color(255, 255, 255));
        pdtNhanPhong.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        pdtNhanPhong.setText("Nhận phòng");
        pdtNhanPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdtNhanPhongActionPerformed(evt);
            }
        });
        pMenuPhongDatTruoc.add(pdtNhanPhong);

        pdtHuyDat.setBackground(new java.awt.Color(255, 255, 255));
        pdtHuyDat.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        pdtHuyDat.setText("Huỷ đặt");
        pdtHuyDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdtHuyDatActionPerformed(evt);
            }
        });
        pMenuPhongDatTruoc.add(pdtHuyDat);

        pdtXemTTNguoiDat.setBackground(new java.awt.Color(255, 255, 255));
        pdtXemTTNguoiDat.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        pdtXemTTNguoiDat.setText("Xem thông tin người đặt");
        pdtXemTTNguoiDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdtXemTTNguoiDatActionPerformed(evt);
            }
        });
        pMenuPhongDatTruoc.add(pdtXemTTNguoiDat);

        pMenuPhongCoNguoi.setBackground(new java.awt.Color(255, 255, 255));

        pcnDatDV.setBackground(new java.awt.Color(255, 255, 255));
        pcnDatDV.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        pcnDatDV.setText("Đặt dịch vụ");
        pcnDatDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcnDatDVActionPerformed(evt);
            }
        });
        pMenuPhongCoNguoi.add(pcnDatDV);

        pcnTraPhong.setBackground(new java.awt.Color(255, 255, 255));
        pcnTraPhong.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        pcnTraPhong.setText("Trả phòng");
        pcnTraPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcnTraPhongActionPerformed(evt);
            }
        });
        pMenuPhongCoNguoi.add(pcnTraPhong);

        pcnTTNguoiThue.setBackground(new java.awt.Color(255, 255, 255));
        pcnTTNguoiThue.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        pcnTTNguoiThue.setText("Xem thông tin người thuê");
        pcnTTNguoiThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcnTTNguoiThueActionPerformed(evt);
            }
        });
        pMenuPhongCoNguoi.add(pcnTTNguoiThue);

        pMenuPhongSuaChua.setBackground(new java.awt.Color(255, 255, 255));

        pdsSuaXong.setBackground(new java.awt.Color(255, 255, 255));
        pdsSuaXong.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        pdsSuaXong.setText("Sửa xong");
        pdsSuaXong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdsSuaXongActionPerformed(evt);
            }
        });
        pMenuPhongSuaChua.add(pdsSuaXong);

        setBackground(new java.awt.Color(228, 230, 233));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        pMaPhong.setBackground(new java.awt.Color(4, 135, 217));

        lblMaPhong.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lblMaPhong.setForeground(new java.awt.Color(255, 255, 255));
        lblMaPhong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaPhong.setText("P001");

        javax.swing.GroupLayout pMaPhongLayout = new javax.swing.GroupLayout(pMaPhong);
        pMaPhong.setLayout(pMaPhongLayout);
        pMaPhongLayout.setHorizontalGroup(
            pMaPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pMaPhongLayout.setVerticalGroup(
            pMaPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMaPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        lblLoaiPhong.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lblLoaiPhong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoaiPhong.setText("LoaiPhong");

        lblTrangThaiPhong.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lblTrangThaiPhong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTrangThaiPhong.setText("TrinhTrang");

        javax.swing.GroupLayout pLoaiThaiPhongLayout = new javax.swing.GroupLayout(pLoaiThaiPhong);
        pLoaiThaiPhong.setLayout(pLoaiThaiPhongLayout);
        pLoaiThaiPhongLayout.setHorizontalGroup(
            pLoaiThaiPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLoaiPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblTrangThaiPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
        );
        pLoaiThaiPhongLayout.setVerticalGroup(
            pLoaiThaiPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLoaiThaiPhongLayout.createSequentialGroup()
                .addComponent(lblLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThaiPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pLoaiThaiPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(pMaPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pLoaiThaiPhong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            if (trangThaiPhong.equals("pt")) {
                pMenuPhongTrong.show(this, evt.getX(), evt.getY());
            }
            
            if (trangThaiPhong.equals("pdt")) {
                pMenuPhongDatTruoc.show(this, evt.getX(), evt.getY());
            }
            
            if (trangThaiPhong.equals("pcn")) {
                pMenuPhongCoNguoi.show(this, evt.getX(), evt.getY());
            }
            
            if (trangThaiPhong.equals("pds")) {
                pMenuPhongSuaChua.show(this, evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_formMouseClicked
    // Sửa xong
    private void pdsSuaXongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdsSuaXongActionPerformed
        try {
            new SoDoPhongDAO().updateTrangThaiPhong("pt", maPhong);
            Main.gdChinh.refreshSoDoPhong();
            Main.gdChinh.loadSoDoPhong(Main.gdChinh.getSoDoPhong());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_pdsSuaXongActionPerformed
    // Sửa chữa
    private void ptSuaChuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptSuaChuaActionPerformed
        try {
            new SoDoPhongDAO().updateTrangThaiPhong("pds", maPhong);
            Main.gdChinh.refreshSoDoPhong();
            Main.gdChinh.loadSoDoPhong(Main.gdChinh.getSoDoPhong());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ptSuaChuaActionPerformed

    private void pdtHuyDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdtHuyDatActionPerformed
        try {
            new DatPhongDAO().xoaDatPhong(maPhong);
            new SoDoPhongDAO().updateTrangThaiPhong(Phong.PHONG_TRONG, maPhong);
            Main.gdChinh.refreshSoDoPhong();
            Main.gdChinh.loadSoDoPhong(Main.gdChinh.getSoDoPhong());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_pdtHuyDatActionPerformed

    private void ptDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptDatPhongActionPerformed
        Main.gdChinh.chuyenManHinh(2);
        Main.gdChinh.setTextTTDatPhong(maPhong, loaiPhong);
    }//GEN-LAST:event_ptDatPhongActionPerformed

    private void pdtNhanPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdtNhanPhongActionPerformed
        try {
            int maKHDatPhong = new DatPhongDAO().nguoiDatPhong(maPhong);
            
            LocalDateTime ngayNhanPhong = LocalDateTime.now();
            String ngayNhanFormat = Main.gdChinh.getDate(ngayNhanPhong.toString());
            new NhanPhongDAO().themNhanPhong(ngayNhanFormat, maPhong, maKHDatPhong);
            new DatPhongDAO().xoaDatPhong(maPhong);
            new SoDoPhongDAO().updateTrangThaiPhong(Phong.PHONG_CO_NGUOI, maPhong);
            Main.gdChinh.refreshSoDoPhong();
            Main.gdChinh.loadSoDoPhong(Main.gdChinh.getSoDoPhong());
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_pdtNhanPhongActionPerformed

    private void pdtXemTTNguoiDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdtXemTTNguoiDatActionPerformed
        Main.gdChinh.chuyenManHinh(6);
        try {
            int maKHDatPhong = new DatPhongDAO().nguoiDatPhong(maPhong);
            Main.gdChinh.selectedTheoMaKH(maKHDatPhong);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_pdtXemTTNguoiDatActionPerformed

    private void pcnTTNguoiThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcnTTNguoiThueActionPerformed
        Main.gdChinh.chuyenManHinh(6);
        try {
            int maKHNhanPhong = new NhanPhongDAO().nguoiNhanPhong(maPhong);
            Main.gdChinh.selectedTheoMaKH(maKHNhanPhong);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_pcnTTNguoiThueActionPerformed

    private void pcnTraPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcnTraPhongActionPerformed
        try {
            int maKhach = new NhanPhongDAO().nguoiNhanPhong(maPhong);
            new NhanPhongDAO().xoaNhanPhong(maPhong);
            new KhachHangDAO().xoaKhachHang(maKhach);
            new SoDoPhongDAO().updateTrangThaiPhong(Phong.PHONG_TRONG, maPhong);
            Main.gdChinh.refreshSoDoPhong();
            Main.gdChinh.loadSoDoPhong(Main.gdChinh.getSoDoPhong());
            Main.gdChinh.loadDSKhachHangLenUI(new KhachHangDAO().getAllKhachHang());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_pcnTraPhongActionPerformed

    private void pcnDatDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcnDatDVActionPerformed
        Main.gdChinh.chuyenManHinh(4);
        try {
            int maKhachHang = new NhanPhongDAO().nguoiNhanPhong(maPhong);
            String hoTenKH = new KhachHangDAO().getHoTenByMaKH(maKhachHang);
            
            Main.gdChinh.setTextDatDichVu(maKhachHang, hoTenKH, maPhong);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_pcnDatDVActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblLoaiPhong;
    private javax.swing.JLabel lblMaPhong;
    private javax.swing.JLabel lblTrangThaiPhong;
    private javax.swing.JPanel pLoaiThaiPhong;
    private javax.swing.JPanel pMaPhong;
    private javax.swing.JPopupMenu pMenuPhongCoNguoi;
    private javax.swing.JPopupMenu pMenuPhongDatTruoc;
    private javax.swing.JPopupMenu pMenuPhongSuaChua;
    private javax.swing.JPopupMenu pMenuPhongTrong;
    private javax.swing.JMenuItem pcnDatDV;
    private javax.swing.JMenuItem pcnTTNguoiThue;
    private javax.swing.JMenuItem pcnTraPhong;
    private javax.swing.JMenuItem pdsSuaXong;
    private javax.swing.JMenuItem pdtHuyDat;
    private javax.swing.JMenuItem pdtNhanPhong;
    private javax.swing.JMenuItem pdtXemTTNguoiDat;
    private javax.swing.JMenuItem ptDatPhong;
    private javax.swing.JMenuItem ptSuaChua;
    // End of variables declaration//GEN-END:variables
}
