package other;

import gui.PanelQLDatPhong;
import gui.PanelQLDichVu;
import gui.PanelQLHoaDon;
import gui.PanelQLKhachHang;
import gui.PanelQLNhanVien;
import gui.PanelQLTraPhong;
import gui.PanelSoDoPhong;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author vanphatdev
 */
public class ChuyenManHinh implements BienMacDinh{
    private JPanel pChinh;
    private String danhMucDangChon = "";
    
    private List<DanhMucBean> listDanhMucBean = null;
    
    public ChuyenManHinh(JPanel pChinh) {
        this.pChinh = pChinh;
    }
    
    public void setManHinhNoiDung(JPanel pDanhMucDangChon, JLabel lblDanhMucDangChon) {
        danhMucDangChon = "SoDoPhong";
        pDanhMucDangChon.setBackground(mauDanhMucDangChon);
        lblDanhMucDangChon.setBackground(mauDanhMucDangChon);
        lblDanhMucDangChon.setForeground(mauTrang);
        
        // Load lại giao diện
        pChinh.removeAll();
        pChinh.setLayout(new BorderLayout());
        pChinh.add(new PanelSoDoPhong());
        pChinh.validate();
        pChinh.repaint();
    }
    
    public void setSuKienClickDanhMuc(List<DanhMucBean> listDanhMucBean) {
        this.listDanhMucBean = listDanhMucBean;
        for (DanhMucBean item : listDanhMucBean) {
            item.getLbl().addMouseListener(new customSuKienMouseListener(item.getLoaiDanhMuc(), item.getPanel(), item.getLbl()));
        }
    }
    
    public class customSuKienMouseListener implements MouseListener{
        // pNoiDung dùng để set lại panel nội dung ở bên phải
        private JPanel pNoiDung;
        
        // 3 thành phần tạo nên danh mục trong panel menu
        private String loaiDanhMuc;
        private JPanel panel;
        private JLabel lbl;

        public customSuKienMouseListener(String loaiDanhMuc, JPanel panel, JLabel lbl) {
            this.loaiDanhMuc = loaiDanhMuc;
            this.panel = panel;
            this.lbl = lbl;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            danhMucDangChon = loaiDanhMuc;
            switch (loaiDanhMuc) {
                case "SoDoPhong":
                    pNoiDung = new PanelSoDoPhong();
                    break;
                case "QLDatPhong":
                    pNoiDung = new PanelQLDatPhong();
                    break;
                case "QLTraPhong":
                    pNoiDung = new PanelQLTraPhong();
                    break;
                case "QLDichVu":
                    pNoiDung = new PanelQLDichVu();
                    break;
                case "QLNhanVien":
                    pNoiDung = new PanelQLNhanVien();
                    break;
                case "QLKhachHang":
                    pNoiDung = new PanelQLKhachHang();
                    break;
                case "QLHoaDon":
                    pNoiDung = new PanelQLHoaDon();
                    break;
                default:
                    break;
            }
            
            pChinh.removeAll();
            pChinh.setLayout(new BorderLayout());
            pChinh.add(pNoiDung);
            pChinh.validate();
            pChinh.repaint();
            thayDoiBackgroundKhiClick(loaiDanhMuc);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // set hiệu ứng khi được để chuột vào
            panel.setBackground(mauDanhMucDangChon);
            lbl.setBackground(mauDanhMucDangChon);
            lbl.setForeground(mauTrang);
            lbl.setBorder(null);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // set hiệu ứng khi lia chuột ra chỗ khác khi đã lia chuột vào trước đó
            if (!danhMucDangChon.equalsIgnoreCase(loaiDanhMuc)) {
                panel.setBackground(mauNenMenu);
                lbl.setBackground(mauNenMenu);
                lbl.setForeground(mauDen);
                lbl.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, mauBorderBottomMenu));
            }
        }
        
        public void thayDoiBackgroundKhiClick(String loaiDangChon) {
            for (DanhMucBean item : listDanhMucBean) {
                if (item.getLoaiDanhMuc().equalsIgnoreCase(loaiDangChon)) {
                    item.getPanel().setBackground(mauDanhMucDangChon);
                    item.getLbl().setBackground(mauDanhMucDangChon);
                    item.getLbl().setForeground(mauTrang);
                    item.getLbl().setBorder(null);
                }
                else {
                    item.getPanel().setBackground(mauNenMenu);
                    item.getLbl().setBackground(mauNenMenu);
                    item.getLbl().setForeground(mauDen);
                    item.getLbl().setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, mauBorderBottomMenu));
                }
            }
        }
    }
}
