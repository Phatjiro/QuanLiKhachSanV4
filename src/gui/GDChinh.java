package gui;

import component.CustomConfirmDialog;
import component.PanelItemPhong;
import connectDB.KetNoiCSDL;
import custom.MyScrollBar;
import dao.KhachHangDAO;
import entity.KhachHang;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import other.BienMacDinh;

/**
 *
 * @author vanphatdev
 */
public class GDChinh extends javax.swing.JFrame implements MouseListener, KeyListener {

	private boolean isThuGonMenu = false;
	private int manHinhDangChon = 1;

	// {Sơ đồ phòng, Đặt phòng, Trả phòng, Dịch vụ, Nhân viên, Khách hàng, Hoá đơn}
	private LinkedList<JPanel> lstPanel;
	private LinkedList<JPanel> lstPanelMenu;
	private LinkedList<JLabel> lstLabel;
	private LinkedList<JButton> lstButton;
	private DefaultTableModel tableModelNV;

	public GDChinh() {

		// khởi tạo kết nối đến CSDL
		try {
			KetNoiCSDL.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		icon();
		this.setTitle("Quản lí khách sạn - VinaHotel");
		initComponents();

		customJPanelVaJLableKhiDuocChon(pSoDoPhong, lblSoDoPhong);

		// Tạo list panel nội dung
		lstPanel = new LinkedList<>();
		lstPanel.add(pNDSoDoPhong);
		lstPanel.add(pNDQLDatPhong);
		lstPanel.add(pNDQLTraPhong);
		lstPanel.add(pNDQLDichVu);
		lstPanel.add(pNDQLNhanVien);
		lstPanel.add(pNDQLKhachHang);
		lstPanel.add(pNDQLHoaDon);

		// Tạo list label menu
		lstLabel = new LinkedList<>();
		lstLabel.add(lblSoDoPhong);
		lstLabel.add(lblQLDatPhong);
		lstLabel.add(lblQLTraPhong);
		lstLabel.add(lblQLDichVu);
		lstLabel.add(lblQLNhanVien);
		lstLabel.add(lblQLKhachHang);
		lstLabel.add(lblQLHoaDon);

		// Tạo list panel menu
		lstPanelMenu = new LinkedList<>();
		lstPanelMenu.add(pSoDoPhong);
		lstPanelMenu.add(pQLDatPhong);
		lstPanelMenu.add(pQLTraPhong);
		lstPanelMenu.add(pQLDichVu);
		lstPanelMenu.add(pQLNhanVien);
		lstPanelMenu.add(pQLKhachHang);
		lstPanelMenu.add(pQLHoaDon);

		// Chọn panel sơ đồ phòng khi vừa khởi tạo
		setVisibleLstPanel(lstPanel, new int[] { 1, 0, 0, 0, 0, 0, 0 });

		// Đăng kí lắng nghe
		lblSoDoPhong.addMouseListener(this);
		lblQLDatPhong.addMouseListener(this);
		lblQLTraPhong.addMouseListener(this);
		lblQLDichVu.addMouseListener(this);
		lblQLNhanVien.addMouseListener(this);
		lblQLKhachHang.addMouseListener(this);
		lblQLHoaDon.addMouseListener(this);

		// Custom JScrollpane
		jScrollPane1.setVerticalScrollBar(new MyScrollBar());

		// Chỉnh tốc độ lăn thanh cuộn
		jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);

		// Button group cho radio button
		btnGroupLoaiPhong.add(rbtnLoaiPhong1);
		btnGroupLoaiPhong.add(rbtnLoaiPhong2);
		btnGroupLoaiPhong.add(rbtnLoaiPhong3);
		btnGroupLoaiPhong.add(rbtnLoaiPhong4);
		btnGroupLoaiPhong.add(rbtnLoaiPhong5);

		btnGroupTrangThai.add(rbtnTrangThaiPhong1);
		btnGroupTrangThai.add(rbtnTrangThaiPhong2);
		btnGroupTrangThai.add(rbtnTrangThaiPhong3);
		btnGroupTrangThai.add(rbtnTrangThaiPhong4);
		btnGroupTrangThai.add(rbtnTrangThaiPhong5);
	}

	public void icon() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/Logo_big.jpg")));
	}

	private void setVisibleLstPanel(LinkedList<JPanel> lstPanel, int[] isOn) {
		int n = lstPanel.size();
		int i = 0;
		for (i = 0; i < n; i++) {
			if (isOn[i] == 1) {
				lstPanel.get(i).setVisible(true);
			} else {
				lstPanel.get(i).setVisible(false);
			}
		}
	}

	public void thuGonMenu() {
		if (isThuGonMenu == false) {
			pMenu.setPreferredSize(new Dimension(76, 740));
			pMenu.revalidate();
			pMenu.repaint();
			isThuGonMenu = true;
		} else {
			pMenu.setPreferredSize(new Dimension(230, 740));
			pMenu.revalidate();
			pMenu.repaint();
			isThuGonMenu = false;
		}
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		btnGroupLoaiPhong = new javax.swing.ButtonGroup();
		btnGroupTrangThai = new javax.swing.ButtonGroup();
		pBackgroundMain = new javax.swing.JPanel();
		pMenu = new javax.swing.JPanel();
		pLogo = new javax.swing.JPanel();
		lblLogo = new javax.swing.JLabel();
		pSoDoPhong = new javax.swing.JPanel();
		lblSoDoPhong = new javax.swing.JLabel();
		pQLDatPhong = new javax.swing.JPanel();
		lblQLDatPhong = new javax.swing.JLabel();
		pQLTraPhong = new javax.swing.JPanel();
		lblQLTraPhong = new javax.swing.JLabel();
		pQLDichVu = new javax.swing.JPanel();
		lblQLDichVu = new javax.swing.JLabel();
		pQLNhanVien = new javax.swing.JPanel();
		lblQLNhanVien = new javax.swing.JLabel();
		pQLKhachHang = new javax.swing.JPanel();
		lblQLKhachHang = new javax.swing.JLabel();
		pQLHoaDon = new javax.swing.JPanel();
		lblQLHoaDon = new javax.swing.JLabel();
		pDangXuat = new javax.swing.JPanel();
		lblDangXuat = new javax.swing.JLabel();
		pNoiDung = new javax.swing.JPanel();
		pNDSoDoPhong = new javax.swing.JPanel();
		jPanel1 = new javax.swing.JPanel();
		btnMenuSoDoPhong = new custom.Button();
		button2 = new custom.Button();
		jLabel2 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		jPanel3 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jPanel4 = new javax.swing.JPanel();
		rbtnLoaiPhong1 = new custom.RadioButtonCustom();
		rbtnLoaiPhong2 = new custom.RadioButtonCustom();
		rbtnLoaiPhong3 = new custom.RadioButtonCustom();
		rbtnLoaiPhong4 = new custom.RadioButtonCustom();
		rbtnLoaiPhong5 = new custom.RadioButtonCustom();
		jPanel5 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jPanel6 = new javax.swing.JPanel();
		rbtnTrangThaiPhong1 = new custom.RadioButtonCustom();
		rbtnTrangThaiPhong2 = new custom.RadioButtonCustom();
		rbtnTrangThaiPhong3 = new custom.RadioButtonCustom();
		rbtnTrangThaiPhong4 = new custom.RadioButtonCustom();
		rbtnTrangThaiPhong5 = new custom.RadioButtonCustom();
		jPanel7 = new javax.swing.JPanel();
		buttonCustom1 = new custom.ButtonCustom();
		jScrollPane1 = new javax.swing.JScrollPane();
		panelMoHinhPhong1 = new component.PanelMoHinhPhong();
		pNDQLDatPhong = new javax.swing.JPanel();
		jPanel16 = new javax.swing.JPanel();
		btnMenuQLDatPhong = new custom.Button();
		button3 = new custom.Button();
		jLabel9 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		pNDQLTraPhong = new javax.swing.JPanel();
		jPanel19 = new javax.swing.JPanel();
		btnMenuQLTraPhong = new custom.Button();
		button4 = new custom.Button();
		jLabel10 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		pNDQLDichVu = new javax.swing.JPanel();
		jPanel8 = new javax.swing.JPanel();
		btnMenuQLDichVu = new custom.Button();
		button5 = new custom.Button();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jPanel9 = new javax.swing.JPanel();
		jPanel10 = new javax.swing.JPanel();
		jLabel5 = new javax.swing.JLabel();
		jPanel11 = new javax.swing.JPanel();
		radioButtonCustom1 = new custom.RadioButtonCustom();
		jPanel12 = new javax.swing.JPanel();
		jLabel6 = new javax.swing.JLabel();
		jPanel13 = new javax.swing.JPanel();
		radioButtonCustom2 = new custom.RadioButtonCustom();
		jPanel14 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jPanel15 = new javax.swing.JPanel();
		pNDQLNhanVien = new javax.swing.JPanel();
		jPanel22 = new javax.swing.JPanel();
		btnMenuQLNhanVien = new custom.Button();
		button11 = new custom.Button();
		jLabel13 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		jPanel17 = new javax.swing.JPanel();
		jPanel23 = new javax.swing.JPanel();
		jLabel16 = new javax.swing.JLabel();
		jPanel24 = new javax.swing.JPanel();
		radioButtonCustom3 = new custom.RadioButtonCustom();
		jPanel25 = new javax.swing.JPanel();
		jLabel17 = new javax.swing.JLabel();
		jPanel26 = new javax.swing.JPanel();
		radioButtonCustom4 = new custom.RadioButtonCustom();
		jPanel18 = new javax.swing.JPanel();
		jScrollPane3 = new javax.swing.JScrollPane();
		pNDQLKhachHang = new javax.swing.JPanel();
		jPanel28 = new javax.swing.JPanel();
		button15 = new custom.Button();
		btnMenuQLKhachHang = new custom.Button();
		jLabel24 = new javax.swing.JLabel();
		jLabel27 = new javax.swing.JLabel();
		jPanel29 = new javax.swing.JPanel();
		jPanel31 = new javax.swing.JPanel();
		jLabel20 = new javax.swing.JLabel();
		jPanel32 = new javax.swing.JPanel();
		radioButtonCustomNamKH = new custom.RadioButtonCustom();
		radioButtonCustomNuKH = new custom.RadioButtonCustom();
		jPanel33 = new javax.swing.JPanel();
		jLabel21 = new javax.swing.JLabel();
		jPanel34 = new javax.swing.JPanel();
		radioButtonCustomThuong = new custom.RadioButtonCustom();
		radioButtonCustomVIP = new custom.RadioButtonCustom();
		jPanel27 = new javax.swing.JPanel();
		jLabel18 = new javax.swing.JLabel();
		myTextFieldMaKH = new custom.MyTextField();
		jPanel30 = new javax.swing.JPanel();
		jLabel15 = new javax.swing.JLabel();
		jScrollPaneTableKH = new javax.swing.JScrollPane();
		jPanel35 = new javax.swing.JPanel();
		jScrollPane6 = new javax.swing.JScrollPane();
		jTableKH = new javax.swing.JTable();
		tableModelNV = new javax.swing.table.DefaultTableModel();
		jPanelDiaChiKH = new javax.swing.JPanel();
		jLabelHoTenKH = new javax.swing.JLabel();
		jLabelSDT_KH = new javax.swing.JLabel();
		jLabelCMND_KH = new javax.swing.JLabel();
		jLabel30 = new javax.swing.JLabel();
		jLabelGioiTinhKH = new javax.swing.JLabel();
		jLabelLoaiKH = new javax.swing.JLabel();
		jTextFieldHoTenKH = new javax.swing.JTextField();
		jTextFieldCMND_KH = new javax.swing.JTextField();
		jTextFieldSDT_KH = new javax.swing.JTextField();
		jTextFieldDiaChiKH = new javax.swing.JTextField();
		jComboBoxGioiTinhKH = new javax.swing.JComboBox<>();
		jComboBoxLoaiKH = new javax.swing.JComboBox<>();
		jPanel21 = new javax.swing.JPanel();
		buttonCustomThemKH = new custom.ButtonCustom();
		buttonCustomSuaKH = new custom.ButtonCustom();
		buttonCustomXoaTrang = new custom.ButtonCustom();
		pNDQLHoaDon = new javax.swing.JPanel();
		jPanel36 = new javax.swing.JPanel();
		btnMenuQLHoaDon = new custom.Button();
		button16 = new custom.Button();
		jLabel25 = new javax.swing.JLabel();
		jLabel26 = new javax.swing.JLabel();
		jPanel37 = new javax.swing.JPanel();
		jPanel40 = new javax.swing.JPanel();
		jLabel22 = new javax.swing.JLabel();
		jPanel41 = new javax.swing.JPanel();
		radioButtonCustom7 = new custom.RadioButtonCustom();
		jPanel42 = new javax.swing.JPanel();
		jLabel23 = new javax.swing.JLabel();
		jPanel43 = new javax.swing.JPanel();
		radioButtonCustom8 = new custom.RadioButtonCustom();
		jPanel38 = new javax.swing.JPanel();
		jScrollPane5 = new javax.swing.JScrollPane();
		jPanel39 = new javax.swing.JPanel();
		listKH = new java.util.ArrayList<KhachHang>();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		pMenu.setBackground(new java.awt.Color(194, 228, 255));
		pMenu.setPreferredSize(new java.awt.Dimension(230, 588));

		pLogo.setBackground(new java.awt.Color(194, 228, 255));

		lblLogo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
		lblLogo.setForeground(new java.awt.Color(204, 0, 51));
		lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo_small.jpg"))); // NOI18N
		lblLogo.setText("VinaHotel");
		lblLogo.setIconTextGap(16);

		javax.swing.GroupLayout pLogoLayout = new javax.swing.GroupLayout(pLogo);
		pLogo.setLayout(pLogoLayout);
		pLogoLayout.setHorizontalGroup(pLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pLogoLayout.createSequentialGroup().addContainerGap().addComponent(lblLogo,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		pLogoLayout.setVerticalGroup(pLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE));

		pSoDoPhong.setBackground(new java.awt.Color(194, 228, 255));

		lblSoDoPhong.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
		lblSoDoPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/houses_32px.png"))); // NOI18N
		lblSoDoPhong.setText("Sơ đồ phòng");
		lblSoDoPhong.setToolTipText("Sơ đồ phòng");
		lblSoDoPhong.setIconTextGap(38);

		javax.swing.GroupLayout pSoDoPhongLayout = new javax.swing.GroupLayout(pSoDoPhong);
		pSoDoPhong.setLayout(pSoDoPhongLayout);
		pSoDoPhongLayout.setHorizontalGroup(pSoDoPhongLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pSoDoPhongLayout.createSequentialGroup().addContainerGap().addComponent(lblSoDoPhong,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		pSoDoPhongLayout
				.setVerticalGroup(pSoDoPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(lblSoDoPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE));

		pQLDatPhong.setBackground(new java.awt.Color(194, 228, 255));

		lblQLDatPhong.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
		lblQLDatPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/room_service_32px.png"))); // NOI18N
		lblQLDatPhong.setText("Quản lí đặt phòng");
		lblQLDatPhong.setToolTipText("Quản lí đặt phòng");
		lblQLDatPhong
				.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 102)));
		lblQLDatPhong.setIconTextGap(38);

		javax.swing.GroupLayout pQLDatPhongLayout = new javax.swing.GroupLayout(pQLDatPhong);
		pQLDatPhong.setLayout(pQLDatPhongLayout);
		pQLDatPhongLayout.setHorizontalGroup(pQLDatPhongLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pQLDatPhongLayout.createSequentialGroup().addContainerGap().addComponent(lblQLDatPhong,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		pQLDatPhongLayout
				.setVerticalGroup(pQLDatPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(lblQLDatPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE));

		pQLTraPhong.setBackground(new java.awt.Color(194, 228, 255));

		lblQLTraPhong.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
		lblQLTraPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/info_32px.png"))); // NOI18N
		lblQLTraPhong.setText("Quản lí trả phòng");
		lblQLTraPhong.setToolTipText("Quản lí trả phòng");
		lblQLTraPhong
				.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 102)));
		lblQLTraPhong.setIconTextGap(38);

		javax.swing.GroupLayout pQLTraPhongLayout = new javax.swing.GroupLayout(pQLTraPhong);
		pQLTraPhong.setLayout(pQLTraPhongLayout);
		pQLTraPhongLayout.setHorizontalGroup(pQLTraPhongLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pQLTraPhongLayout.createSequentialGroup().addContainerGap().addComponent(lblQLTraPhong,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		pQLTraPhongLayout
				.setVerticalGroup(pQLTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(lblQLTraPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE));

		pQLDichVu.setBackground(new java.awt.Color(194, 228, 255));

		lblQLDichVu.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
		lblQLDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/water_service_32px.png"))); // NOI18N
		lblQLDichVu.setText("Quản lí dịch vụ");
		lblQLDichVu.setToolTipText("Quản lí dịch vụ");
		lblQLDichVu
				.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 102)));
		lblQLDichVu.setIconTextGap(38);

		javax.swing.GroupLayout pQLDichVuLayout = new javax.swing.GroupLayout(pQLDichVu);
		pQLDichVu.setLayout(pQLDichVuLayout);
		pQLDichVuLayout.setHorizontalGroup(pQLDichVuLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pQLDichVuLayout.createSequentialGroup().addContainerGap().addComponent(lblQLDichVu,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		pQLDichVuLayout.setVerticalGroup(pQLDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(lblQLDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE));

		pQLNhanVien.setBackground(new java.awt.Color(194, 228, 255));

		lblQLNhanVien.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
		lblQLNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/employee_32px.png"))); // NOI18N
		lblQLNhanVien.setText("Quản lí nhân viên");
		lblQLNhanVien.setToolTipText("Quản lí nhân viên");
		lblQLNhanVien
				.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 102)));
		lblQLNhanVien.setIconTextGap(38);

		javax.swing.GroupLayout pQLNhanVienLayout = new javax.swing.GroupLayout(pQLNhanVien);
		pQLNhanVien.setLayout(pQLNhanVienLayout);
		pQLNhanVienLayout.setHorizontalGroup(pQLNhanVienLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pQLNhanVienLayout.createSequentialGroup().addContainerGap().addComponent(lblQLNhanVien,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		pQLNhanVienLayout
				.setVerticalGroup(pQLNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(lblQLNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE));

		pQLKhachHang.setBackground(new java.awt.Color(194, 228, 255));

		lblQLKhachHang.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
		lblQLKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/customer_32px.png"))); // NOI18N
		lblQLKhachHang.setText("Quản lí khách hàng");
		lblQLKhachHang.setToolTipText("Quản lí khách hàng");
		lblQLKhachHang
				.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 102)));
		lblQLKhachHang.setIconTextGap(38);

		javax.swing.GroupLayout pQLKhachHangLayout = new javax.swing.GroupLayout(pQLKhachHang);
		pQLKhachHang.setLayout(pQLKhachHangLayout);
		pQLKhachHangLayout.setHorizontalGroup(pQLKhachHangLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pQLKhachHangLayout.createSequentialGroup().addContainerGap()
						.addComponent(lblQLKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
						.addContainerGap()));
		pQLKhachHangLayout
				.setVerticalGroup(pQLKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(lblQLKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE));

		pQLHoaDon.setBackground(new java.awt.Color(194, 228, 255));

		lblQLHoaDon.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
		lblQLHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/payment_32px.png"))); // NOI18N
		lblQLHoaDon.setText("Quản lí hoá hơn");
		lblQLHoaDon.setToolTipText("Quản lí hoá hơn");
		lblQLHoaDon
				.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 102)));
		lblQLHoaDon.setIconTextGap(38);

		javax.swing.GroupLayout pQLHoaDonLayout = new javax.swing.GroupLayout(pQLHoaDon);
		pQLHoaDon.setLayout(pQLHoaDonLayout);
		pQLHoaDonLayout.setHorizontalGroup(pQLHoaDonLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pQLHoaDonLayout.createSequentialGroup().addContainerGap().addComponent(lblQLHoaDon,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		pQLHoaDonLayout.setVerticalGroup(pQLHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(lblQLHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE));

		pDangXuat.setBackground(new java.awt.Color(194, 228, 255));

		lblDangXuat.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
		lblDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logout_32px.png"))); // NOI18N
		lblDangXuat.setText("Đăng xuất");
		lblDangXuat.setToolTipText("ALT + F4");
		lblDangXuat.setIconTextGap(38);
		lblDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblDangXuatMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				lblDangXuatMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				lblDangXuatMouseExited(evt);
			}
		});

		javax.swing.GroupLayout pDangXuatLayout = new javax.swing.GroupLayout(pDangXuat);
		pDangXuat.setLayout(pDangXuatLayout);
		pDangXuatLayout.setHorizontalGroup(pDangXuatLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pDangXuatLayout.createSequentialGroup().addContainerGap().addComponent(lblDangXuat,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		pDangXuatLayout.setVerticalGroup(pDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(lblDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE));

		javax.swing.GroupLayout pMenuLayout = new javax.swing.GroupLayout(pMenu);
		pMenu.setLayout(pMenuLayout);
		pMenuLayout.setHorizontalGroup(pMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(pLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(pSoDoPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(pQLDatPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(pQLTraPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(pQLDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(pQLNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(pQLKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(pQLHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(pDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));
		pMenuLayout.setVerticalGroup(pMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pMenuLayout.createSequentialGroup()
						.addComponent(pLogo, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(pSoDoPhong, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(pQLDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(pQLTraPhong, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(pQLDichVu, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(pQLNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(pQLKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(pQLHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(pDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

		pNoiDung.setLayout(new javax.swing.OverlayLayout(pNoiDung));

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

		btnMenuSoDoPhong.setBorder(null);
		btnMenuSoDoPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N
		btnMenuSoDoPhong.setToolTipText("Thu gọn menu");
		btnMenuSoDoPhong.setFocusable(false);
		btnMenuSoDoPhong.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnMenuSoDoPhongMouseClicked(evt);
			}
		});

		button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/profile_32px.png"))); // NOI18N
		button2.setFocusable(false);

		jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		jLabel2.setText("Tên nhân viên");

		jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		jLabel4.setText("Chức vụ");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addComponent(btnMenuSoDoPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(button2,
								javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel2)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10,
												Short.MAX_VALUE)
										.addComponent(jLabel4))
								.addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addComponent(btnMenuSoDoPhong, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));

		jPanel2.setBackground(new java.awt.Color(255, 255, 255));

		jPanel3.setBackground(new java.awt.Color(4, 135, 217));

		jLabel3.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
		jLabel3.setForeground(new java.awt.Color(255, 255, 255));
		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel3.setText("Loại Phòng");

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(jLabel3,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE));

		jPanel4.setBackground(new java.awt.Color(255, 255, 255));

		rbtnLoaiPhong1.setBackground(new java.awt.Color(4, 135, 217));
		rbtnLoaiPhong1.setText("Tất cả");
		rbtnLoaiPhong1.setFocusable(false);
		rbtnLoaiPhong1.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N

		rbtnLoaiPhong2.setBackground(new java.awt.Color(4, 135, 217));
		rbtnLoaiPhong2.setText("Phòng Standard");
		rbtnLoaiPhong2.setFocusable(false);
		rbtnLoaiPhong2.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N

		rbtnLoaiPhong3.setBackground(new java.awt.Color(4, 135, 217));
		rbtnLoaiPhong3.setText("Phòng Superior");
		rbtnLoaiPhong3.setFocusable(false);
		rbtnLoaiPhong3.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N

		rbtnLoaiPhong4.setBackground(new java.awt.Color(4, 135, 217));
		rbtnLoaiPhong4.setText("Phòng Deluxe");
		rbtnLoaiPhong4.setFocusable(false);
		rbtnLoaiPhong4.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N

		rbtnLoaiPhong5.setBackground(new java.awt.Color(4, 135, 217));
		rbtnLoaiPhong5.setText("Phòng Suite");
		rbtnLoaiPhong5.setFocusable(false);
		rbtnLoaiPhong5.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(rbtnLoaiPhong1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rbtnLoaiPhong2, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rbtnLoaiPhong3, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rbtnLoaiPhong4, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rbtnLoaiPhong5, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup()
						.addComponent(rbtnLoaiPhong1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(rbtnLoaiPhong2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(rbtnLoaiPhong3, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(rbtnLoaiPhong4, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(rbtnLoaiPhong5, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 23, Short.MAX_VALUE)));

		jPanel5.setBackground(new java.awt.Color(4, 135, 217));

		jLabel1.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("Trạng thái phòng");

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE));

		jPanel6.setBackground(new java.awt.Color(255, 255, 255));

		rbtnTrangThaiPhong1.setBackground(new java.awt.Color(4, 135, 217));
		rbtnTrangThaiPhong1.setText("Tất cả");
		rbtnTrangThaiPhong1.setToolTipText("");
		rbtnTrangThaiPhong1.setFocusable(false);
		rbtnTrangThaiPhong1.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N

		rbtnTrangThaiPhong2.setBackground(new java.awt.Color(4, 135, 217));
		rbtnTrangThaiPhong2.setText("Phòng trống");
		rbtnTrangThaiPhong2.setFocusable(false);
		rbtnTrangThaiPhong2.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N

		rbtnTrangThaiPhong3.setBackground(new java.awt.Color(4, 135, 217));
		rbtnTrangThaiPhong3.setText("Phòng có người");
		rbtnTrangThaiPhong3.setFocusable(false);
		rbtnTrangThaiPhong3.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N

		rbtnTrangThaiPhong4.setBackground(new java.awt.Color(4, 135, 217));
		rbtnTrangThaiPhong4.setText("Phòng đặt trước");
		rbtnTrangThaiPhong4.setFocusable(false);
		rbtnTrangThaiPhong4.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N

		rbtnTrangThaiPhong5.setBackground(new java.awt.Color(4, 135, 217));
		rbtnTrangThaiPhong5.setText("Phòng đang sửa");
		rbtnTrangThaiPhong5.setFocusable(false);
		rbtnTrangThaiPhong5.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N

		javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(rbtnTrangThaiPhong5, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addComponent(rbtnTrangThaiPhong1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(rbtnTrangThaiPhong2, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(rbtnTrangThaiPhong3, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(rbtnTrangThaiPhong4, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel6Layout.createSequentialGroup()
						.addComponent(rbtnTrangThaiPhong1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(rbtnTrangThaiPhong2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(rbtnTrangThaiPhong3, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(rbtnTrangThaiPhong4, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(rbtnTrangThaiPhong5, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 23, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));

		jPanel7.setBackground(new java.awt.Color(255, 255, 255));

		buttonCustom1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus_24px.png"))); // NOI18N
		buttonCustom1.setText("Thêm phòng");
		buttonCustom1.setFocusable(false);
		buttonCustom1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
		buttonCustom1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				buttonCustom1MouseClicked(evt);
			}
		});

		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
						.addContainerGap(608, Short.MAX_VALUE).addComponent(buttonCustom1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(buttonCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE));

		jScrollPane1.setViewportView(panelMoHinhPhong1);

		javax.swing.GroupLayout pNDSoDoPhongLayout = new javax.swing.GroupLayout(pNDSoDoPhong);
		pNDSoDoPhong.setLayout(pNDSoDoPhongLayout);
		pNDSoDoPhongLayout.setHorizontalGroup(pNDSoDoPhongLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(pNDSoDoPhongLayout.createSequentialGroup()
						.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pNDSoDoPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jScrollPane1))));
		pNDSoDoPhongLayout.setVerticalGroup(pNDSoDoPhongLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pNDSoDoPhongLayout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pNDSoDoPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(pNDSoDoPhongLayout.createSequentialGroup()
										.addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jScrollPane1)))));

		pNoiDung.add(pNDSoDoPhong);

		pNDQLDatPhong.setBackground(new java.awt.Color(204, 204, 255));

		btnMenuQLDatPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N
		btnMenuQLDatPhong.setToolTipText("Thu gọn menu");
		btnMenuQLDatPhong.setFocusable(false);
		btnMenuQLDatPhong.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnMenuQLDatPhongMouseClicked(evt);
			}
		});

		button3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/profile_32px.png"))); // NOI18N
		button3.setFocusable(false);

		jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		jLabel9.setText("Tên nhân viên");

		jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		jLabel11.setText("Chức vụ");

		javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
		jPanel16.setLayout(jPanel16Layout);
		jPanel16Layout.setHorizontalGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel16Layout.createSequentialGroup().addContainerGap()
						.addComponent(btnMenuQLDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 787, Short.MAX_VALUE)
						.addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(button3,
								javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		jPanel16Layout.setVerticalGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel16Layout.createSequentialGroup().addContainerGap()
								.addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(jPanel16Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
												.addComponent(jLabel11))
										.addComponent(button3, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
												jPanel16Layout.createSequentialGroup().addGroup(jPanel16Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel9).addComponent(btnMenuQLDatPhong,
																javax.swing.GroupLayout.PREFERRED_SIZE, 38,
																javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(0, 0, Short.MAX_VALUE)))
								.addContainerGap()));

		javax.swing.GroupLayout pNDQLDatPhongLayout = new javax.swing.GroupLayout(pNDQLDatPhong);
		pNDQLDatPhong.setLayout(pNDQLDatPhongLayout);
		pNDQLDatPhongLayout.setHorizontalGroup(pNDQLDatPhongLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel16,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		pNDQLDatPhongLayout
				.setVerticalGroup(pNDQLDatPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pNDQLDatPhongLayout.createSequentialGroup()
								.addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 680, Short.MAX_VALUE)));

		pNoiDung.add(pNDQLDatPhong);

		pNDQLTraPhong.setBackground(new java.awt.Color(255, 204, 255));

		btnMenuQLTraPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N
		btnMenuQLTraPhong.setToolTipText("Thu gọn menu");
		btnMenuQLTraPhong.setFocusable(false);
		btnMenuQLTraPhong.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnMenuQLTraPhongMouseClicked(evt);
			}
		});

		button4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/profile_32px.png"))); // NOI18N
		button4.setFocusable(false);

		jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		jLabel10.setText("Tên nhân viên");

		jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		jLabel12.setText("Chức vụ");

		javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
		jPanel19.setLayout(jPanel19Layout);
		jPanel19Layout.setHorizontalGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel19Layout.createSequentialGroup().addContainerGap()
						.addComponent(btnMenuQLTraPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 787, Short.MAX_VALUE)
						.addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(button4,
								javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		jPanel19Layout.setVerticalGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel19Layout.createSequentialGroup().addContainerGap()
								.addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(jPanel19Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
												.addComponent(jLabel12))
										.addComponent(button4, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
												jPanel19Layout.createSequentialGroup().addGroup(jPanel19Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel10).addComponent(btnMenuQLTraPhong,
																javax.swing.GroupLayout.PREFERRED_SIZE, 38,
																javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(0, 0, Short.MAX_VALUE)))
								.addContainerGap()));

		javax.swing.GroupLayout pNDQLTraPhongLayout = new javax.swing.GroupLayout(pNDQLTraPhong);
		pNDQLTraPhong.setLayout(pNDQLTraPhongLayout);
		pNDQLTraPhongLayout.setHorizontalGroup(pNDQLTraPhongLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel19,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		pNDQLTraPhongLayout
				.setVerticalGroup(pNDQLTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pNDQLTraPhongLayout.createSequentialGroup()
								.addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 680, Short.MAX_VALUE)));

		pNoiDung.add(pNDQLTraPhong);

		pNDQLDichVu.setBackground(new java.awt.Color(255, 204, 204));

		jPanel8.setBackground(new java.awt.Color(255, 255, 255));

		btnMenuQLDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N
		btnMenuQLDichVu.setToolTipText("Thu gọn menu");
		btnMenuQLDichVu.setFocusable(false);
		btnMenuQLDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnMenuQLDichVuMouseClicked(evt);
			}
		});

		button5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/profile_32px.png"))); // NOI18N

		jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		jLabel7.setText("Tên nhân viên");

		jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		jLabel8.setText("Chức vụ");

		javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
		jPanel8.setLayout(jPanel8Layout);
		jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel8Layout.createSequentialGroup().addContainerGap()
						.addComponent(btnMenuQLDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(button5,
								javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(jPanel8Layout.createSequentialGroup().addComponent(jLabel7)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel8))
								.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnMenuQLDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));

		jPanel10.setBackground(new java.awt.Color(4, 135, 217));

		jLabel5.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
		jLabel5.setForeground(new java.awt.Color(255, 255, 255));
		jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel5.setText("jLabel5");

		javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
		jPanel10.setLayout(jPanel10Layout);
		jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel10Layout.createSequentialGroup().addContainerGap().addComponent(jLabel5,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE));

		jPanel11.setBackground(new java.awt.Color(255, 255, 255));

		radioButtonCustom1.setBackground(new java.awt.Color(4, 135, 217));
		radioButtonCustom1.setText("radioButtonCustom1");
		radioButtonCustom1.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N

		javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
		jPanel11.setLayout(jPanel11Layout);
		jPanel11Layout.setHorizontalGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel11Layout.createSequentialGroup().addContainerGap()
						.addComponent(radioButtonCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel11Layout.setVerticalGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel11Layout.createSequentialGroup()
						.addComponent(radioButtonCustom1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 151, Short.MAX_VALUE)));

		jPanel12.setBackground(new java.awt.Color(4, 135, 217));

		jLabel6.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
		jLabel6.setForeground(new java.awt.Color(255, 255, 255));
		jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel6.setText("jLabel6");

		javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
		jPanel12.setLayout(jPanel12Layout);
		jPanel12Layout.setHorizontalGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel12Layout.createSequentialGroup().addContainerGap().addComponent(jLabel6,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel12Layout.setVerticalGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE));

		jPanel13.setBackground(new java.awt.Color(255, 255, 255));

		radioButtonCustom2.setBackground(new java.awt.Color(4, 135, 217));
		radioButtonCustom2.setText("radioButtonCustom2");
		radioButtonCustom2.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N

		javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
		jPanel13.setLayout(jPanel13Layout);
		jPanel13Layout.setHorizontalGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel13Layout.createSequentialGroup().addContainerGap().addComponent(radioButtonCustom2,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel13Layout.setVerticalGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel13Layout.createSequentialGroup()
						.addComponent(radioButtonCustom2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 151, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
		jPanel9.setLayout(jPanel9Layout);
		jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));
		jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel9Layout.createSequentialGroup()
						.addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));

		jPanel14.setBackground(new java.awt.Color(255, 255, 255));

		javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
		jPanel14.setLayout(jPanel14Layout);
		jPanel14Layout.setHorizontalGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE));
		jPanel14Layout.setVerticalGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 40, Short.MAX_VALUE));

		jPanel15.setBackground(new java.awt.Color(255, 255, 255));

		javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
		jPanel15.setLayout(jPanel15Layout);
		jPanel15Layout.setHorizontalGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 756, Short.MAX_VALUE));
		jPanel15Layout.setVerticalGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 626, Short.MAX_VALUE));

		jScrollPane2.setViewportView(jPanel15);

		javax.swing.GroupLayout pNDQLDichVuLayout = new javax.swing.GroupLayout(pNDQLDichVu);
		pNDQLDichVu.setLayout(pNDQLDichVuLayout);
		pNDQLDichVuLayout.setHorizontalGroup(pNDQLDichVuLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(pNDQLDichVuLayout.createSequentialGroup()
						.addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pNDQLDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jScrollPane2))));
		pNDQLDichVuLayout.setVerticalGroup(pNDQLDichVuLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pNDQLDichVuLayout.createSequentialGroup()
						.addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pNDQLDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(pNDQLDichVuLayout.createSequentialGroup()
										.addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jScrollPane2)))));

		pNoiDung.add(pNDQLDichVu);

		pNDQLNhanVien.setBackground(new java.awt.Color(255, 255, 204));

		jPanel22.setBackground(new java.awt.Color(255, 255, 255));

		btnMenuQLNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N
		btnMenuQLNhanVien.setToolTipText("Thu gọn menu");
		btnMenuQLNhanVien.setFocusable(false);
		btnMenuQLNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnMenuQLNhanVienMouseClicked(evt);
			}
		});

		button11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/profile_32px.png"))); // NOI18N

		jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		jLabel13.setText("Tên nhân viên");

		jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		jLabel14.setText("Chức vụ");

		javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
		jPanel22.setLayout(jPanel22Layout);
		jPanel22Layout.setHorizontalGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel22Layout.createSequentialGroup().addContainerGap()
						.addComponent(btnMenuQLNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(button11,
								javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		jPanel22Layout.setVerticalGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(jPanel22Layout.createSequentialGroup().addComponent(jLabel13)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel14))
								.addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnMenuQLNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));

		jPanel23.setBackground(new java.awt.Color(4, 135, 217));

		jLabel16.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
		jLabel16.setForeground(new java.awt.Color(255, 255, 255));
		jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel16.setText("jLabel16");

		javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
		jPanel23.setLayout(jPanel23Layout);
		jPanel23Layout.setHorizontalGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel23Layout.createSequentialGroup().addContainerGap().addComponent(jLabel16,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel23Layout.setVerticalGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE));

		jPanel24.setBackground(new java.awt.Color(255, 255, 255));

		radioButtonCustom3.setBackground(new java.awt.Color(4, 135, 217));
		radioButtonCustom3.setText("radioButtonCustom3");
		radioButtonCustom3.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N

		javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
		jPanel24.setLayout(jPanel24Layout);
		jPanel24Layout.setHorizontalGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel24Layout.createSequentialGroup().addContainerGap()
						.addComponent(radioButtonCustom3, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel24Layout.setVerticalGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel24Layout.createSequentialGroup()
						.addComponent(radioButtonCustom3, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 151, Short.MAX_VALUE)));

		jPanel25.setBackground(new java.awt.Color(4, 135, 217));

		jLabel17.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
		jLabel17.setForeground(new java.awt.Color(255, 255, 255));
		jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel17.setText("jLabel17");

		javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
		jPanel25.setLayout(jPanel25Layout);
		jPanel25Layout.setHorizontalGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel25Layout.createSequentialGroup().addContainerGap().addComponent(jLabel17,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel25Layout.setVerticalGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE));

		jPanel26.setBackground(new java.awt.Color(255, 255, 255));

		radioButtonCustom4.setBackground(new java.awt.Color(4, 135, 217));
		radioButtonCustom4.setText("radioButtonCustom4");
		radioButtonCustom4.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N

		javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
		jPanel26.setLayout(jPanel26Layout);
		jPanel26Layout.setHorizontalGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel26Layout.createSequentialGroup().addContainerGap().addComponent(radioButtonCustom4,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel26Layout.setVerticalGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel26Layout.createSequentialGroup()
						.addComponent(radioButtonCustom4, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 151, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
		jPanel17.setLayout(jPanel17Layout);
		jPanel17Layout.setHorizontalGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));
		jPanel17Layout.setVerticalGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel17Layout.createSequentialGroup()
						.addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 217, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
		jPanel18.setLayout(jPanel18Layout);
		jPanel18Layout.setHorizontalGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE));
		jPanel18Layout.setVerticalGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 40, Short.MAX_VALUE));

		javax.swing.GroupLayout pNDQLNhanVienLayout = new javax.swing.GroupLayout(pNDQLNhanVien);
		pNDQLNhanVien.setLayout(pNDQLNhanVienLayout);
		pNDQLNhanVienLayout.setHorizontalGroup(pNDQLNhanVienLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pNDQLNhanVienLayout.createSequentialGroup()
						.addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pNDQLNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 758,
										Short.MAX_VALUE)))
				.addComponent(jPanel22, javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		pNDQLNhanVienLayout.setVerticalGroup(pNDQLNhanVienLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pNDQLNhanVienLayout.createSequentialGroup()
						.addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(5, 5, 5)
						.addGroup(pNDQLNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(pNDQLNhanVienLayout.createSequentialGroup()
										.addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jScrollPane3)))));

		pNoiDung.add(pNDQLNhanVien);

		pNDQLKhachHang.setBackground(new java.awt.Color(204, 255, 204));

		jPanel28.setBackground(new java.awt.Color(255, 255, 255));

		button15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/profile_32px.png"))); // NOI18N

		btnMenuQLKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N
		btnMenuQLKhachHang.setToolTipText("Thu gọn menu");
		btnMenuQLKhachHang.setFocusable(false);
		btnMenuQLKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnMenuQLKhachHangMouseClicked(evt);
			}
		});

		jLabel24.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		jLabel24.setText("Tên nhân viên");

		jLabel27.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		jLabel27.setText("Chức vụ");

		javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
		jPanel28.setLayout(jPanel28Layout);
		jPanel28Layout.setHorizontalGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel28Layout.createSequentialGroup().addContainerGap()
						.addComponent(btnMenuQLKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(button15,
								javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		jPanel28Layout.setVerticalGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel28Layout.createSequentialGroup().addContainerGap().addGroup(jPanel28Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addGroup(jPanel28Layout.createSequentialGroup().addComponent(jLabel24)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel27))
						.addComponent(button15, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMenuQLKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
								javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jPanel31.setBackground(new java.awt.Color(4, 135, 217));

		jLabel20.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
		jLabel20.setForeground(new java.awt.Color(255, 255, 255));
		jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel20.setText("Lọc theo giới tính");

		javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
		jPanel31.setLayout(jPanel31Layout);
		jPanel31Layout.setHorizontalGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel31Layout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel31Layout.setVerticalGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE));

		jPanel32.setBackground(new java.awt.Color(255, 255, 255));

		radioButtonCustomNamKH.setBackground(new java.awt.Color(4, 135, 217));
		radioButtonCustomNamKH.setText("Nam");
		radioButtonCustomNamKH.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
		radioButtonCustomNamKH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				radioButtonCustomNamKHActionPerformed(evt);
			}
		});

		radioButtonCustomNuKH.setBackground(new java.awt.Color(4, 135, 217));
		radioButtonCustomNuKH.setText("Nữ");
		radioButtonCustomNuKH.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
		radioButtonCustomNuKH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				radioButtonCustomNuKHActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
		jPanel32.setLayout(jPanel32Layout);
		jPanel32Layout.setHorizontalGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel32Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(radioButtonCustomNamKH, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(radioButtonCustomNuKH, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		jPanel32Layout.setVerticalGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel32Layout.createSequentialGroup()
						.addComponent(radioButtonCustomNamKH, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(radioButtonCustomNuKH, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 120, Short.MAX_VALUE)));

		jPanel33.setBackground(new java.awt.Color(4, 135, 217));

		jLabel21.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
		jLabel21.setForeground(new java.awt.Color(255, 255, 255));
		jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel21.setText("Lọc theo loại KH");

		javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
		jPanel33.setLayout(jPanel33Layout);
		jPanel33Layout.setHorizontalGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel33Layout.createSequentialGroup().addContainerGap().addComponent(jLabel21,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel33Layout.setVerticalGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE));

		jPanel34.setBackground(new java.awt.Color(255, 255, 255));

		radioButtonCustomThuong.setBackground(new java.awt.Color(4, 135, 217));
		radioButtonCustomThuong.setText("Thông Thường");
		radioButtonCustomThuong.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
		radioButtonCustomThuong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				radioButtonCustomThuongActionPerformed(evt);
			}	
		});

		radioButtonCustomVIP.setBackground(new java.awt.Color(4, 135, 217));
		radioButtonCustomVIP.setText("VIP");
		radioButtonCustomVIP.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
		radioButtonCustomVIP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				radioButtonCustomVIPActionPerformed(evt);
			}	
		});

		javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
		jPanel34.setLayout(jPanel34Layout);
		jPanel34Layout.setHorizontalGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel34Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(radioButtonCustomThuong, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(radioButtonCustomVIP, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		jPanel34Layout.setVerticalGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel34Layout.createSequentialGroup()
						.addComponent(radioButtonCustomThuong, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(radioButtonCustomVIP, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 120, Short.MAX_VALUE)));

		jPanel27.setBackground(new java.awt.Color(4, 135, 217));

		jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		jLabel18.setForeground(new java.awt.Color(255, 255, 255));
		jLabel18.setText("Tìm khách hàng theo mã KH:");

		javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
		jPanel27.setLayout(jPanel27Layout);
		jPanel27Layout
				.setHorizontalGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel18).addComponent(myTextFieldMaKH,
												javax.swing.GroupLayout.PREFERRED_SIZE, 182,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(11, 11, 11)));
		jPanel27Layout.setVerticalGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel27Layout.createSequentialGroup().addGap(24, 24, 24).addComponent(jLabel18)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(myTextFieldMaKH, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(16, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
		jPanel29.setLayout(jPanel29Layout);
		jPanel29Layout.setHorizontalGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel29Layout.createSequentialGroup()
								.addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap()));
		jPanel29Layout.setVerticalGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel29Layout.createSequentialGroup()
						.addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));

		jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
		jLabel15.setText("DANH SÁCH KHÁCH HÀNG");

		javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
		jPanel30.setLayout(jPanel30Layout);
		jPanel30Layout.setHorizontalGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel30Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel15).addGap(298, 298, 298)));
		jPanel30Layout.setVerticalGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel30Layout.createSequentialGroup().addContainerGap().addComponent(jLabel15)
						.addContainerGap(18, Short.MAX_VALUE)));

		jScrollPaneTableKH.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		jPanel35.setBackground(new java.awt.Color(255, 255, 255));

		jTableKH.setRowHeight(25);

		listKH = new KhachHangDAO().getTableKhachHang();
		String[] colHeader = { "Mã Khách Hàng", "Họ tên", "SDT", "Số CMND", "Địa Chỉ", "Giới Tính", "Loại Khách Hàng" };
		tableModelNV = new DefaultTableModel(colHeader, 0);
		for (KhachHang kh : listKH) {
			String gioiTinh = "Nam";
			String loaiKH = "Thông Thường";
			if (!kh.isGioiTinh()) {
				gioiTinh = "Nữ";
			}
			if (kh.isLoaiKH()) {
				loaiKH = "VIP";
			}
			tableModelNV.addRow(new Object[] { kh.getMaKH(), kh.getHoTenKH(), kh.getSoDT(), kh.getSoCMND(),
					kh.getDiaChi(), gioiTinh, loaiKH });
		}
		jTableKH.setModel(tableModelNV);

		jScrollPane6.setViewportView(jTableKH);

		javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
		jPanel35.setLayout(jPanel35Layout);
		jPanel35Layout.setHorizontalGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel35Layout.createSequentialGroup().addComponent(jScrollPane6,
						javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 21, Short.MAX_VALUE)));
		jPanel35Layout.setVerticalGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel35Layout.createSequentialGroup().addComponent(jScrollPane6,
						javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 266, Short.MAX_VALUE)));

		jScrollPaneTableKH.setViewportView(jPanel35);

		jLabelHoTenKH.setText("Họ tên:");

		jLabelSDT_KH.setText("Số điện thoại:");

		jLabelCMND_KH.setText("Số CMND:");

		jLabel30.setText("Địa chỉ:");

		jLabelGioiTinhKH.setText("Giới tính:");

		jLabelLoaiKH.setText("Loại khách hàng:");

		jTextFieldCMND_KH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextFieldCMND_KHActionPerformed(evt);
			}
		});

		jComboBoxGioiTinhKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
		jComboBoxGioiTinhKH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBoxGioiTinhKHActionPerformed(evt);
			}
		});

		jComboBoxLoaiKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thông Thường", "VIP" }));

		javax.swing.GroupLayout jPanelDiaChiKHLayout = new javax.swing.GroupLayout(jPanelDiaChiKH);
		jPanelDiaChiKH.setLayout(jPanelDiaChiKHLayout);
		jPanelDiaChiKHLayout
				.setHorizontalGroup(jPanelDiaChiKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanelDiaChiKHLayout.createSequentialGroup().addContainerGap(9, Short.MAX_VALUE)
								.addGroup(jPanelDiaChiKHLayout.createParallelGroup(
										javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDiaChiKHLayout
												.createSequentialGroup().addGroup(jPanelDiaChiKHLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE,
																43, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabelHoTenKH,
																javax.swing.GroupLayout.PREFERRED_SIZE, 43,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabelGioiTinhKH,
																javax.swing.GroupLayout.PREFERRED_SIZE, 58,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(38, 38, 38))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDiaChiKHLayout
												.createSequentialGroup()
												.addComponent(jLabelSDT_KH, javax.swing.GroupLayout.PREFERRED_SIZE, 84,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
								.addGroup(jPanelDiaChiKHLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanelDiaChiKHLayout.createSequentialGroup().addComponent(
												jComboBoxGioiTinhKH, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(
														jLabelLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 99,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(
														jComboBoxLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanelDiaChiKHLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addGroup(jPanelDiaChiKHLayout.createSequentialGroup()
														.addGroup(jPanelDiaChiKHLayout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING,
																		false)
																.addGroup(jPanelDiaChiKHLayout.createSequentialGroup()
																		.addComponent(jTextFieldHoTenKH,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				269,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(18, 18, 18)
																		.addComponent(jLabelCMND_KH,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				60,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(jTextFieldCMND_KH,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				266,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
																.addComponent(jTextFieldSDT_KH))
														.addGap(0, 3, Short.MAX_VALUE))
												.addComponent(jTextFieldDiaChiKH)))
								.addContainerGap(8, Short.MAX_VALUE)));
		jPanelDiaChiKHLayout.setVerticalGroup(jPanelDiaChiKHLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanelDiaChiKHLayout.createSequentialGroup().addGap(22, 22, 22).addGroup(jPanelDiaChiKHLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabelHoTenKH)
						.addComponent(jTextFieldHoTenKH, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jTextFieldCMND_KH, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabelCMND_KH))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanelDiaChiKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jTextFieldSDT_KH, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabelSDT_KH, javax.swing.GroupLayout.Alignment.TRAILING))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
						.addGroup(jPanelDiaChiKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(jPanelDiaChiKHLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jComboBoxGioiTinhKH, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabelLoaiKH).addComponent(jComboBoxLoaiKH,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(jLabelGioiTinhKH))
						.addGap(18, 18, 18)
						.addGroup(jPanelDiaChiKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jTextFieldDiaChiKH, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(31, 31, 31)));

		buttonCustomThemKH.setText("Thêm Khách Hàng");
		buttonCustomThemKH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonCustomThemKHActionPerformed(evt);
			}
		});

		buttonCustomSuaKH.setText("Sửa Thông Tin Khách Hàng");
		buttonCustomSuaKH.setStyle(custom.ButtonCustom.ButtonStyle.DESTRUCTIVE);
		buttonCustomSuaKH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonCustomSuaKHActionPerformed(evt);
			}
		});

		buttonCustomXoaTrang.setText("Xóa trắng");
		buttonCustomXoaTrang.setStyle(custom.ButtonCustom.ButtonStyle.SECONDARY);
		buttonCustomXoaTrang.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonCustomXoaTrangActionPerformed(evt);
			}
		});

		jTableKH.addMouseListener(this);
		myTextFieldMaKH.addKeyListener(this);
		
		javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
		jPanel21.setLayout(jPanel21Layout);
		jPanel21Layout.setHorizontalGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel21Layout.createSequentialGroup().addGap(193, 193, 193)
						.addComponent(buttonCustomThemKH, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(buttonCustomSuaKH, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(buttonCustomXoaTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel21Layout.setVerticalGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
						.addContainerGap(10, Short.MAX_VALUE)
						.addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(buttonCustomThemKH, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(buttonCustomSuaKH, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(buttonCustomXoaTrang, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(14, 14, 14)));

		javax.swing.GroupLayout pNDQLKhachHangLayout = new javax.swing.GroupLayout(pNDQLKhachHang);
		pNDQLKhachHang.setLayout(pNDQLKhachHangLayout);
		pNDQLKhachHangLayout.setHorizontalGroup(pNDQLKhachHangLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(pNDQLKhachHangLayout.createSequentialGroup()
						.addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pNDQLKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										pNDQLKhachHangLayout.createSequentialGroup().addGroup(pNDQLKhachHangLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jPanel21, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jPanelDiaChiKH, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jScrollPaneTableKH,
														javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
												.addContainerGap()))));
		pNDQLKhachHangLayout.setVerticalGroup(pNDQLKhachHangLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pNDQLKhachHangLayout.createSequentialGroup()
						.addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pNDQLKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(pNDQLKhachHangLayout.createSequentialGroup()
										.addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jScrollPaneTableKH, javax.swing.GroupLayout.PREFERRED_SIZE, 397,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jPanelDiaChiKH, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()))));

		pNoiDung.add(pNDQLKhachHang);

		pNDQLHoaDon.setBackground(new java.awt.Color(51, 51, 51));

		jPanel36.setBackground(new java.awt.Color(255, 255, 255));

		btnMenuQLHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N
		btnMenuQLHoaDon.setToolTipText("Thu gọn menu");
		btnMenuQLHoaDon.setFocusable(false);
		btnMenuQLHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnMenuQLHoaDonMouseClicked(evt);
			}
		});

		button16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/profile_32px.png"))); // NOI18N

		jLabel25.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		jLabel25.setText("Tên nhân viên");

		jLabel26.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		jLabel26.setText("Chức vụ");

		javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
		jPanel36.setLayout(jPanel36Layout);
		jPanel36Layout.setHorizontalGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel36Layout.createSequentialGroup().addContainerGap()
						.addComponent(btnMenuQLHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(button16,
								javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		jPanel36Layout.setVerticalGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel36Layout.createSequentialGroup().addContainerGap().addGroup(jPanel36Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addGroup(jPanel36Layout.createSequentialGroup().addComponent(jLabel25)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel26))
						.addComponent(button16, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMenuQLHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
								javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jPanel40.setBackground(new java.awt.Color(4, 135, 217));

		jLabel22.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
		jLabel22.setForeground(new java.awt.Color(255, 255, 255));
		jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel22.setText("jLabel22");

		javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
		jPanel40.setLayout(jPanel40Layout);
		jPanel40Layout.setHorizontalGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel40Layout.createSequentialGroup().addContainerGap().addComponent(jLabel22,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel40Layout.setVerticalGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE));

		jPanel41.setBackground(new java.awt.Color(255, 255, 255));

		radioButtonCustom7.setBackground(new java.awt.Color(4, 135, 217));
		radioButtonCustom7.setText("radioButtonCustom7");
		radioButtonCustom7.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N

		javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
		jPanel41.setLayout(jPanel41Layout);
		jPanel41Layout.setHorizontalGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel41Layout.createSequentialGroup().addContainerGap()
						.addComponent(radioButtonCustom7, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel41Layout.setVerticalGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel41Layout.createSequentialGroup()
						.addComponent(radioButtonCustom7, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 151, Short.MAX_VALUE)));

		jPanel42.setBackground(new java.awt.Color(4, 135, 217));

		jLabel23.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
		jLabel23.setForeground(new java.awt.Color(255, 255, 255));
		jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel23.setText("jLabel23");

		javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
		jPanel42.setLayout(jPanel42Layout);
		jPanel42Layout.setHorizontalGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel42Layout.createSequentialGroup().addContainerGap().addComponent(jLabel23,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel42Layout.setVerticalGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE));

		jPanel43.setBackground(new java.awt.Color(255, 255, 255));

		radioButtonCustom8.setBackground(new java.awt.Color(4, 135, 217));
		radioButtonCustom8.setText("radioButtonCustom8");
		radioButtonCustom8.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N

		javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
		jPanel43.setLayout(jPanel43Layout);
		jPanel43Layout.setHorizontalGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel43Layout.createSequentialGroup().addContainerGap().addComponent(radioButtonCustom8,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel43Layout.setVerticalGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel43Layout.createSequentialGroup()
						.addComponent(radioButtonCustom8, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 151, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
		jPanel37.setLayout(jPanel37Layout);
		jPanel37Layout.setHorizontalGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));
		jPanel37Layout.setVerticalGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel37Layout.createSequentialGroup()
						.addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
		jPanel38.setLayout(jPanel38Layout);
		jPanel38Layout.setHorizontalGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE));
		jPanel38Layout.setVerticalGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 40, Short.MAX_VALUE));

		javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
		jPanel39.setLayout(jPanel39Layout);
		jPanel39Layout.setHorizontalGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 756, Short.MAX_VALUE));
		jPanel39Layout.setVerticalGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 626, Short.MAX_VALUE));

		jScrollPane5.setViewportView(jPanel39);

		javax.swing.GroupLayout pNDQLHoaDonLayout = new javax.swing.GroupLayout(pNDQLHoaDon);
		pNDQLHoaDon.setLayout(pNDQLHoaDonLayout);
		pNDQLHoaDonLayout.setHorizontalGroup(pNDQLHoaDonLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(pNDQLHoaDonLayout.createSequentialGroup()
						.addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pNDQLHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jScrollPane5))));
		pNDQLHoaDonLayout.setVerticalGroup(pNDQLHoaDonLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pNDQLHoaDonLayout.createSequentialGroup()
						.addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pNDQLHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(pNDQLHoaDonLayout.createSequentialGroup()
										.addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jScrollPane5)))));

		pNoiDung.add(pNDQLHoaDon);

		javax.swing.GroupLayout pBackgroundMainLayout = new javax.swing.GroupLayout(pBackgroundMain);
		pBackgroundMain.setLayout(pBackgroundMainLayout);
		pBackgroundMainLayout
				.setHorizontalGroup(pBackgroundMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pBackgroundMainLayout.createSequentialGroup()
								.addComponent(pMenu, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(pNoiDung, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pBackgroundMainLayout.setVerticalGroup(pBackgroundMainLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(pMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE).addComponent(pNoiDung,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(pBackgroundMain,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(pBackgroundMain,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

	private void lblDangXuatMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDangXuatMouseExited
		pDangXuat.setBackground(BienMacDinh.mauNenMenu);
		lblDangXuat.setForeground(BienMacDinh.mauDen);
	}// GEN-LAST:event_lblDangXuatMouseExited

	private void lblDangXuatMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDangXuatMouseEntered
		pDangXuat.setBackground(BienMacDinh.mauDanhMucDangChon);
		lblDangXuat.setForeground(BienMacDinh.mauTrang);
	}// GEN-LAST:event_lblDangXuatMouseEntered

	// Nút thu gọn menu ở panel Sơ đồ phòng
	private void btnMenuSoDoPhongMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnMenuSoDoPhongMouseClicked
		thuGonMenu();
	}// GEN-LAST:event_btnMenuSoDoPhongMouseClicked

	// Nút thu gọn menu ở panel Dịch vụ
	private void btnMenuQLDichVuMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnMenuQLDichVuMouseClicked
		thuGonMenu();
	}// GEN-LAST:event_btnMenuQLDichVuMouseClicked

	// Nút thu gọn menu ở panel Nhân viên
	private void btnMenuQLNhanVienMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnMenuQLNhanVienMouseClicked
		thuGonMenu();
	}// GEN-LAST:event_btnMenuQLNhanVienMouseClicked

	// Nút demo thêm phòng ở panel Sơ đồ phòng
	private void buttonCustom1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_buttonCustom1MouseClicked
		panelMoHinhPhong1.add(new PanelItemPhong());
		panelMoHinhPhong1.revalidate();
		panelMoHinhPhong1.repaint();
	}// GEN-LAST:event_buttonCustom1MouseClicked

	// Nút thu gọn menu ở panel Hoá đơn
	private void btnMenuQLHoaDonMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnMenuQLHoaDonMouseClicked
		thuGonMenu();
	}// GEN-LAST:event_btnMenuQLHoaDonMouseClicked

	// Nút thu gọn menu ở panel Khách hàng
	private void btnMenuQLKhachHangMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnMenuQLKhachHangMouseClicked
		thuGonMenu();
	}// GEN-LAST:event_btnMenuQLKhachHangMouseClicked

	// Nút thu gọn menu ở panel Đặt phòng
	private void btnMenuQLDatPhongMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnMenuQLDatPhongMouseClicked
		thuGonMenu();
	}// GEN-LAST:event_btnMenuQLDatPhongMouseClicked

	// Nút thu gọn menu ở panel Trả phòng
	private void btnMenuQLTraPhongMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnMenuQLTraPhongMouseClicked
		thuGonMenu();
	}// GEN-LAST:event_btnMenuQLTraPhongMouseClicked

	private void lblDangXuatMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDangXuatMouseClicked
		CustomConfirmDialog ccdDangXuat = new CustomConfirmDialog(this);
		ccdDangXuat.showMessage("Cảnh báo đăng xuất?",
				"Đăng xuất sẽ thoát ứng dụng\nKiểm tra cần thận trước khi đăng xuất.");

		if (ccdDangXuat.getMessageType() == CustomConfirmDialog.MessageType.OK) {
			System.exit(0);
		} else {

		}
	}// GEN-LAST:event_lblDangXuatMouseClicked

	private void jComboBoxGioiTinhKHActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxGioiTinhKHActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jComboBoxGioiTinhKHActionPerformed

	private void buttonCustomThemKHActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonCustomThemKHActionPerformed
		// TODO add your handling code here:
		int maKH = new KhachHangDAO().createMaKH_moi();
		String hoTen = jTextFieldHoTenKH.getText();
		String soCMND = jTextFieldCMND_KH.getText();
		String sdt = jTextFieldSDT_KH.getText();
		String diaChi = jTextFieldDiaChiKH.getText();
		boolean gioiTinh = true;
		boolean loaiKH = false;
		if (jComboBoxGioiTinhKH.getSelectedItem().equals("Nữ")) {
			gioiTinh = false;
		}
		if (jComboBoxLoaiKH.getSelectedItem().equals("VIP")) {
			loaiKH = true;
		}
		
		if (!kiemTraDuLieu()) {
			return;
		}
		
		KhachHang kh = new KhachHang(maKH, hoTen, sdt, soCMND, diaChi, gioiTinh, loaiKH);
		listKH.add(kh);
		
		String gioitinh = "Nam";
		String loaiKhachHang = "Thông Thường";
		if (!kh.isGioiTinh()) {
			gioitinh = "Nữ";
		}
		if (kh.isLoaiKH()) {
			loaiKhachHang = "VIP";
		}
		tableModelNV.addRow(new Object[] { kh.getMaKH(), kh.getHoTenKH(), kh.getSoDT(), kh.getSoCMND(),
				kh.getDiaChi(), gioitinh, loaiKhachHang });
		jTableKH.setModel(tableModelNV);
		
		try {
			new KhachHangDAO().addKhachHang(kh);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		JOptionPane.showMessageDialog(this, "Thêm khách hàng '" + hoTen + "' thành công. (mã KH: '" + maKH + "')");
	}// GEN-LAST:event_buttonCustomThemKHActionPerformed

	private void buttonCustomSuaKHActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonCustomSuaKHActionPerformed
		// TODO add your handling code here:
		
		int r = jTableKH.getSelectedRow();
		System.out.println("index of row selected: " + r);
		if (r > -1) {
			if (!kiemTraDuLieu()) {
				return;
			}
			int option = JOptionPane.showConfirmDialog(this, "Nhấn Yes để Xóa, No hủy xóa",
					"Bạn có chắc muốn sửa thông tin của khách hàng này?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (option == JOptionPane.YES_OPTION) {
				int maKH = (int) jTableKH.getModel().getValueAt(r, 0);
				String hoTen = jTextFieldHoTenKH.getText();
				String soCMND = jTextFieldCMND_KH.getText();
				String sdt = jTextFieldSDT_KH.getText();
				String diaChi = jTextFieldDiaChiKH.getText();
				boolean gioiTinh = true;
				boolean loaiKH = false;
				if (jComboBoxGioiTinhKH.getSelectedItem().equals("Nữ")) {
					gioiTinh = false;
				}
				if (jComboBoxLoaiKH.getSelectedItem().equals("VIP")) {
					loaiKH = true;
				}
				
				KhachHang kh = new KhachHang(maKH, hoTen, sdt, soCMND, diaChi, gioiTinh, loaiKH);
				listKH.set(listKH.indexOf(kh), kh);
				new KhachHangDAO().updateThongTinKH(kh);
				
				tableModelNV.setValueAt(hoTen, r, 1);
				tableModelNV.setValueAt(sdt, r, 2);
				tableModelNV.setValueAt(soCMND, r, 3);
				tableModelNV.setValueAt(diaChi, r, 4);
				tableModelNV.setValueAt(jComboBoxGioiTinhKH.getSelectedItem(), r, 5);
				tableModelNV.setValueAt(jComboBoxLoaiKH.getSelectedItem(), r, 6);
				
				jTableKH.setModel(tableModelNV);
			}
		}
	}// GEN-LAST:event_buttonCustomSuaKHActionPerformed

	private void buttonCustomXoaTrangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonCustomXoaTrangActionPerformed
		// TODO add your handling code here:
		jTextFieldHoTenKH.setText("");
		jTextFieldCMND_KH.setText("");
		jTextFieldSDT_KH.setText("");
		jComboBoxGioiTinhKH.setSelectedItem("Nam");
		jComboBoxLoaiKH.setSelectedItem("Thông Thường");
		jTextFieldDiaChiKH.setText("");
	}// GEN-LAST:event_buttonCustomXoaTrangActionPerformed

	private void jTextFieldCMND_KHActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextFieldCMND_KHActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextFieldCMND_KHActionPerformed

	private void radioButtonCustomNamKHActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioButtonCustomNamKHActionPerformed
		// TODO add your handling code here:
		setEnableThemSua();
		
		if (radioButtonCustomNuKH.isSelected()) {
			radioButtonCustomNuKH.setSelected(false);
		}
		if (radioButtonCustomThuong.isSelected()) {
			radioButtonCustomThuong.setSelected(false);
		}
		if (radioButtonCustomVIP.isSelected()) {
			radioButtonCustomVIP.setSelected(false);
		}
		
		if (!radioButtonCustomNamKH.isSelected()) {
			jTableKH.setModel(tableModelNV);
			return;
		}
		
		ArrayList<KhachHang> listKH = new KhachHangDAO().getKhachHangTheoLoaiGioiTinh(true);
		locTable(listKH);
		
	}// GEN-LAST:event_radioButtonCustomNamKHActionPerformed

	private void radioButtonCustomNuKHActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioButtonCustomNuKHActionPerformed
		// TODO add your handling code here:
		setEnableThemSua();
		
		if (radioButtonCustomNamKH.isSelected()) {
			radioButtonCustomNamKH.setSelected(false);
		}
		if (radioButtonCustomThuong.isSelected()) {
			radioButtonCustomThuong.setSelected(false);
		}
		if (radioButtonCustomVIP.isSelected()) {
			radioButtonCustomVIP.setSelected(false);
		}
		
		if (!radioButtonCustomNuKH.isSelected()) {
			jTableKH.setModel(tableModelNV);
			return;
		}
		
		ArrayList<KhachHang> listKH = new KhachHangDAO().getKhachHangTheoLoaiGioiTinh(false);
		locTable(listKH);
	}// GEN-LAST:event_radioButtonCustomNuKHActionPerformed
	
	private void radioButtonCustomThuongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioButtonCustomNuKHActionPerformed
		// TODO add your handling code here:
		setEnableThemSua();
		
		if (radioButtonCustomVIP.isSelected()) {
			radioButtonCustomVIP.setSelected(false);
		}
		if (radioButtonCustomNamKH.isSelected()) {
			radioButtonCustomNamKH.setSelected(false);
		}
		if (radioButtonCustomNuKH.isSelected()) {
			radioButtonCustomNuKH.setSelected(false);
		}
		
		if (!radioButtonCustomThuong.isSelected()) {
			jTableKH.setModel(tableModelNV);
			return;
		}
		
		ArrayList<KhachHang> listKH = new KhachHangDAO().getKhachHangTheoLoaiKH(false);
		locTable(listKH);
	}// GEN-LAST:event_radioButtonCustomNuKHActionPerformed
	
	private void radioButtonCustomVIPActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioButtonCustomNuKHActionPerformed
		// TODO add your handling code here:
		setEnableThemSua();
		
		if (radioButtonCustomThuong.isSelected()) {
			radioButtonCustomThuong.setSelected(false);
		}
		if (radioButtonCustomNamKH.isSelected()) {
			radioButtonCustomNamKH.setSelected(false);
		}
		if (radioButtonCustomNuKH.isSelected()) {
			radioButtonCustomNuKH.setSelected(false);
		}
		
		if (!radioButtonCustomVIP.isSelected()) {
			jTableKH.setModel(tableModelNV);
			return;
		}
		
		ArrayList<KhachHang> listKH = new KhachHangDAO().getKhachHangTheoLoaiKH(true);
		locTable(listKH);
	}// GEN-LAST:event_radioButtonCustomNuKHActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.ButtonGroup btnGroupLoaiPhong;
	private javax.swing.ButtonGroup btnGroupTrangThai;
	private custom.Button btnMenuQLDatPhong;
	private custom.Button btnMenuQLDichVu;
	private custom.Button btnMenuQLHoaDon;
	private custom.Button btnMenuQLKhachHang;
	private custom.Button btnMenuQLNhanVien;
	private custom.Button btnMenuQLTraPhong;
	private custom.Button btnMenuSoDoPhong;
	private custom.Button button11;
	private custom.Button button15;
	private custom.Button button16;
	private custom.Button button2;
	private custom.Button button3;
	private custom.Button button4;
	private custom.Button button5;
	private custom.ButtonCustom buttonCustom1;
	private custom.ButtonCustom buttonCustomThemKH;
	private custom.ButtonCustom buttonCustomSuaKH;
	private custom.ButtonCustom buttonCustomXoaTrang;
	private javax.swing.JComboBox<String> jComboBoxGioiTinhKH;
	private javax.swing.JComboBox<String> jComboBoxLoaiKH;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel20;
	private javax.swing.JLabel jLabel21;
	private javax.swing.JLabel jLabel22;
	private javax.swing.JLabel jLabel23;
	private javax.swing.JLabel jLabel24;
	private javax.swing.JLabel jLabel25;
	private javax.swing.JLabel jLabel26;
	private javax.swing.JLabel jLabel27;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel30;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JLabel jLabelCMND_KH;
	private javax.swing.JLabel jLabelGioiTinhKH;
	private javax.swing.JLabel jLabelHoTenKH;
	private javax.swing.JLabel jLabelLoaiKH;
	private javax.swing.JLabel jLabelSDT_KH;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel10;
	private javax.swing.JPanel jPanel11;
	private javax.swing.JPanel jPanel12;
	private javax.swing.JPanel jPanel13;
	private javax.swing.JPanel jPanel14;
	private javax.swing.JPanel jPanel15;
	private javax.swing.JPanel jPanel16;
	private javax.swing.JPanel jPanel17;
	private javax.swing.JPanel jPanel18;
	private javax.swing.JPanel jPanel19;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel21;
	private javax.swing.JPanel jPanel22;
	private javax.swing.JPanel jPanel23;
	private javax.swing.JPanel jPanel24;
	private javax.swing.JPanel jPanel25;
	private javax.swing.JPanel jPanel26;
	private javax.swing.JPanel jPanel27;
	private javax.swing.JPanel jPanel28;
	private javax.swing.JPanel jPanel29;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel30;
	private javax.swing.JPanel jPanel31;
	private javax.swing.JPanel jPanel32;
	private javax.swing.JPanel jPanel33;
	private javax.swing.JPanel jPanel34;
	private javax.swing.JPanel jPanel35;
	private javax.swing.JPanel jPanel36;
	private javax.swing.JPanel jPanel37;
	private javax.swing.JPanel jPanel38;
	private javax.swing.JPanel jPanel39;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel40;
	private javax.swing.JPanel jPanel41;
	private javax.swing.JPanel jPanel42;
	private javax.swing.JPanel jPanel43;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel8;
	private javax.swing.JPanel jPanel9;
	private javax.swing.JPanel jPanelDiaChiKH;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane5;
	private javax.swing.JScrollPane jScrollPane6;
	private javax.swing.JScrollPane jScrollPaneTableKH;
	private javax.swing.JTable jTableKH;
	private javax.swing.JTextField jTextFieldCMND_KH;
	private javax.swing.JTextField jTextFieldDiaChiKH;
	private javax.swing.JTextField jTextFieldHoTenKH;
	private javax.swing.JTextField jTextFieldSDT_KH;
	private javax.swing.JLabel lblDangXuat;
	private javax.swing.JLabel lblLogo;
	private javax.swing.JLabel lblQLDatPhong;
	private javax.swing.JLabel lblQLDichVu;
	private javax.swing.JLabel lblQLHoaDon;
	private javax.swing.JLabel lblQLKhachHang;
	private javax.swing.JLabel lblQLNhanVien;
	private javax.swing.JLabel lblQLTraPhong;
	private javax.swing.JLabel lblSoDoPhong;
	private custom.MyTextField myTextFieldMaKH;
	private javax.swing.JPanel pBackgroundMain;
	private javax.swing.JPanel pDangXuat;
	private javax.swing.JPanel pLogo;
	private javax.swing.JPanel pMenu;
	private javax.swing.JPanel pNDQLDatPhong;
	private javax.swing.JPanel pNDQLDichVu;
	private javax.swing.JPanel pNDQLHoaDon;
	private javax.swing.JPanel pNDQLKhachHang;
	private javax.swing.JPanel pNDQLNhanVien;
	private javax.swing.JPanel pNDQLTraPhong;
	private javax.swing.JPanel pNDSoDoPhong;
	private javax.swing.JPanel pNoiDung;
	private javax.swing.JPanel pQLDatPhong;
	private javax.swing.JPanel pQLDichVu;
	private javax.swing.JPanel pQLHoaDon;
	private javax.swing.JPanel pQLKhachHang;
	private javax.swing.JPanel pQLNhanVien;
	private javax.swing.JPanel pQLTraPhong;
	private javax.swing.JPanel pSoDoPhong;
	private component.PanelMoHinhPhong panelMoHinhPhong1;
	private custom.RadioButtonCustom radioButtonCustom1;
	private custom.RadioButtonCustom radioButtonCustom2;
	private custom.RadioButtonCustom radioButtonCustom3;
	private custom.RadioButtonCustom radioButtonCustom4;
	private custom.RadioButtonCustom radioButtonCustom7;
	private custom.RadioButtonCustom radioButtonCustom8;
	private custom.RadioButtonCustom radioButtonCustomNamKH;
	private custom.RadioButtonCustom radioButtonCustomNuKH;
	private custom.RadioButtonCustom radioButtonCustomThuong;
	private custom.RadioButtonCustom radioButtonCustomVIP;
	private custom.RadioButtonCustom rbtnLoaiPhong1;
	private custom.RadioButtonCustom rbtnLoaiPhong2;
	private custom.RadioButtonCustom rbtnLoaiPhong3;
	private custom.RadioButtonCustom rbtnLoaiPhong4;
	private custom.RadioButtonCustom rbtnLoaiPhong5;
	private custom.RadioButtonCustom rbtnTrangThaiPhong1;
	private custom.RadioButtonCustom rbtnTrangThaiPhong2;
	private custom.RadioButtonCustom rbtnTrangThaiPhong3;
	private custom.RadioButtonCustom rbtnTrangThaiPhong4;
	private custom.RadioButtonCustom rbtnTrangThaiPhong5;
	private java.util.ArrayList<KhachHang> listKH;
	// End of variables declaration//GEN-END:variables

	public void customJPanelVaJLableKhiDuocChon(JPanel p, JLabel lbl) {
		p.setBackground(BienMacDinh.mauDanhMucDangChon);
		lbl.setForeground(BienMacDinh.mauTrang);
		lbl.setBorder(null);
	}

	public void customJPanelVaJLableKhiKhongDuocChon(JPanel p, JLabel lbl) {
		p.setBackground(BienMacDinh.mauNenMenu);
		lbl.setForeground(BienMacDinh.mauDen);
		lbl.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, BienMacDinh.mauBorderBottomMenu));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();

		if (o.equals(lblSoDoPhong)) {
			// Sơ đồ phòng
			setVisibleLstPanel(lstPanel, new int[] { 1, 0, 0, 0, 0, 0, 0 });
			customMenu(lstPanelMenu, lstLabel, new int[] { 1, 0, 0, 0, 0, 0, 0 });

		} else if (o.equals(lblQLDatPhong)) {
			// Đặt phòng
			setVisibleLstPanel(lstPanel, new int[] { 0, 1, 0, 0, 0, 0, 0 });
			customMenu(lstPanelMenu, lstLabel, new int[] { 0, 1, 0, 0, 0, 0, 0 });

		} else if (o.equals(lblQLTraPhong)) {
			// Trả phòng
			setVisibleLstPanel(lstPanel, new int[] { 0, 0, 1, 0, 0, 0, 0 });
			customMenu(lstPanelMenu, lstLabel, new int[] { 0, 0, 1, 0, 0, 0, 0 });

		} else if (o.equals(lblQLDichVu)) {
			// Dịch vụ
			setVisibleLstPanel(lstPanel, new int[] { 0, 0, 0, 1, 0, 0, 0 });
			customMenu(lstPanelMenu, lstLabel, new int[] { 0, 0, 0, 1, 0, 0, 0 });

		} else if (o.equals(lblQLNhanVien)) {
			// Nhân viên
			setVisibleLstPanel(lstPanel, new int[] { 0, 0, 0, 0, 1, 0, 0 });
			customMenu(lstPanelMenu, lstLabel, new int[] { 0, 0, 0, 0, 1, 0, 0 });

		} else if (o.equals(lblQLKhachHang)) {
			// Khách hàng
			setVisibleLstPanel(lstPanel, new int[] { 0, 0, 0, 0, 0, 1, 0 });
			customMenu(lstPanelMenu, lstLabel, new int[] { 0, 0, 0, 0, 0, 1, 0 });

		} else if (o.equals(lblQLHoaDon)) {
			// Hoá đơn
			setVisibleLstPanel(lstPanel, new int[] { 0, 0, 0, 0, 0, 0, 1 });
			customMenu(lstPanelMenu, lstLabel, new int[] { 0, 0, 0, 0, 0, 0, 1 });
		} else if (o.equals(jTableKH)) {
			int row = jTableKH.getSelectedRow();
			jTextFieldHoTenKH.setText((String) jTableKH.getValueAt(row, 1));
			jTextFieldSDT_KH.setText((String) jTableKH.getValueAt(row, 2));
			jTextFieldCMND_KH.setText((String) jTableKH.getValueAt(row, 3));
			jTextFieldDiaChiKH.setText((String) jTableKH.getValueAt(row, 4));
			jComboBoxGioiTinhKH.setSelectedItem(jTableKH.getValueAt(row, 5));
			jComboBoxLoaiKH.setSelectedItem(jTableKH.getValueAt(row, 6));
		}
	}

	private void customMenu(LinkedList<JPanel> lstPanel, LinkedList<JLabel> lstLabel, int[] tat) {
		int n = lstPanel.size();
		int i = 0;
		for (i = 0; i < n; i++) {
			if (tat[i] == 0) {
				customJPanelVaJLableKhiKhongDuocChon(lstPanel.get(i), lstLabel.get(i));
			} else {
				customJPanelVaJLableKhiDuocChon(lstPanel.get(i), lstLabel.get(i));
				this.manHinhDangChon = i + 1;
			}
		}
	}
	
	private boolean kiemTraDuLieu() {
		String hoTen = jTextFieldHoTenKH.getText();
		String soCMND = jTextFieldCMND_KH.getText();
		String sdt = jTextFieldSDT_KH.getText();
		
		if (hoTen.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Họ tên không được rỗng!");
			jTextFieldHoTenKH.requestFocus();
			return false;
		}
		
		String regexCMND = "^\\d{9,12}$";
		if (soCMND.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Số CMND không được rỗng!");
			jTextFieldCMND_KH.requestFocus();
			return false;
		}
		if (!Pattern.matches(regexCMND, soCMND)) {
			JOptionPane.showMessageDialog(this, "Số CMND từ 9-12 số!");
			jTextFieldCMND_KH.selectAll();
			jTextFieldCMND_KH.requestFocus();
			return false;
		}
		
		String regexSDT = "^(03|05|07|08|09)\\d{8}$";
		if (sdt.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại không được rỗng!");
			jTextFieldSDT_KH.requestFocus();
			return false;
		}
		if (!Pattern.matches(regexSDT, sdt)) {
			JOptionPane.showMessageDialog(this, "Số điện thoại gồm 10 số, bắt đầu 03, 05, 07, 08, 09!");
			jTextFieldSDT_KH.selectAll();
			jTextFieldSDT_KH.requestFocus();
			return false;
		}
		
		return true;
	}

	private void locTable(ArrayList<KhachHang> listKH) {
		String[] colHeader = { "Mã Khách Hàng", "Họ tên", "SDT", "Số CMND", "Địa Chỉ", "Giới Tính", "Loại Khách Hàng" };
		DefaultTableModel newTableModelNV = new DefaultTableModel(colHeader, 0);
		for (KhachHang kh : listKH) {
			String gioiTinh = "Nam";
			String loaiKH = "Thông Thường";
			if (!kh.isGioiTinh()) {
				gioiTinh = "Nữ";
			}
			if (kh.isLoaiKH()) {
				loaiKH = "VIP";
			}
			newTableModelNV.addRow(new Object[] { kh.getMaKH(), kh.getHoTenKH(), kh.getSoDT(), kh.getSoCMND(),
					kh.getDiaChi(), gioiTinh, loaiKH });
		}
		
		jTableKH.setModel(newTableModelNV);
	}
	
	private void setEnableThemSua() {
		buttonCustomThemKH.setEnabled(true);
		buttonCustomSuaKH.setEnabled(true);
		
		if (radioButtonCustomNamKH.isSelected() || radioButtonCustomNuKH.isSelected() || radioButtonCustomThuong.isSelected() || radioButtonCustomVIP.isSelected() || !myTextFieldMaKH.getText().equals("")) {
			buttonCustomThemKH.setEnabled(false);
			buttonCustomSuaKH.setEnabled(false);
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(lblSoDoPhong)) {
			customJPanelVaJLableKhiDuocChon(pSoDoPhong, lblSoDoPhong);
		}
		if (o.equals(lblQLDatPhong)) {
			customJPanelVaJLableKhiDuocChon(pQLDatPhong, lblQLDatPhong);
		}
		if (o.equals(lblQLTraPhong)) {
			customJPanelVaJLableKhiDuocChon(pQLTraPhong, lblQLTraPhong);
		}
		if (o.equals(lblQLDichVu)) {
			customJPanelVaJLableKhiDuocChon(pQLDichVu, lblQLDichVu);
		}
		if (o.equals(lblQLNhanVien)) {
			customJPanelVaJLableKhiDuocChon(pQLNhanVien, lblQLNhanVien);
		}
		if (o.equals(lblQLKhachHang)) {
			customJPanelVaJLableKhiDuocChon(pQLKhachHang, lblQLKhachHang);
		}
		if (o.equals(lblQLHoaDon)) {
			customJPanelVaJLableKhiDuocChon(pQLHoaDon, lblQLHoaDon);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(lblSoDoPhong) && manHinhDangChon != 1) {
			customJPanelVaJLableKhiKhongDuocChon(pSoDoPhong, lblSoDoPhong);
		}
		if (o.equals(lblQLDatPhong) && manHinhDangChon != 2) {
			customJPanelVaJLableKhiKhongDuocChon(pQLDatPhong, lblQLDatPhong);
		}
		if (o.equals(lblQLTraPhong) && manHinhDangChon != 3) {
			customJPanelVaJLableKhiKhongDuocChon(pQLTraPhong, lblQLTraPhong);
		}
		if (o.equals(lblQLDichVu) && manHinhDangChon != 4) {
			customJPanelVaJLableKhiKhongDuocChon(pQLDichVu, lblQLDichVu);
		}
		if (o.equals(lblQLNhanVien) && manHinhDangChon != 5) {
			customJPanelVaJLableKhiKhongDuocChon(pQLNhanVien, lblQLNhanVien);
		}
		if (o.equals(lblQLKhachHang) && manHinhDangChon != 6) {
			customJPanelVaJLableKhiKhongDuocChon(pQLKhachHang, lblQLKhachHang);
		}
		if (o.equals(lblQLHoaDon) && manHinhDangChon != 7) {
			customJPanelVaJLableKhiKhongDuocChon(pQLHoaDon, lblQLHoaDon);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(myTextFieldMaKH)) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				setEnableThemSua();
				
				radioButtonCustomNamKH.setSelected(false);
				radioButtonCustomNuKH.setSelected(false);
				radioButtonCustomThuong.setSelected(false);
				radioButtonCustomVIP.setSelected(false);
				
				String txtNhapMaKH = myTextFieldMaKH.getText();
				if (!txtNhapMaKH.trim().equals("")) {
					int maKH = 0;
					try {
						maKH = Integer.parseInt(txtNhapMaKH);
					} catch (Exception e2) {
						// TODO: handle exception
					} finally {
						KhachHang kh = new KhachHangDAO().getKhachHangTheoMaKhachHang(maKH);
						
						String[] colHeader = { "Mã Khách Hàng", "Họ tên", "SDT", "Số CMND", "Địa Chỉ", "Giới Tính", "Loại Khách Hàng" };
						DefaultTableModel newTableModelNV = new DefaultTableModel(colHeader, 0);
						if (kh != null) {							
							String gioiTinh = "Nam";
							String loaiKH = "Thông Thường";
							if (!kh.isGioiTinh()) {
								gioiTinh = "Nữ";
							}
							if (kh.isLoaiKH()) {
								loaiKH = "VIP";
							}
							
							newTableModelNV.addRow(new Object[] { kh.getMaKH(), kh.getHoTenKH(), kh.getSoDT(), kh.getSoCMND(),
									kh.getDiaChi(), gioiTinh, loaiKH });
						} else {
							JOptionPane.showMessageDialog(this, "Không tìm thấy mã khách hàng: " + txtNhapMaKH);
							myTextFieldMaKH.selectAll();
							myTextFieldMaKH.requestFocus();
//							newTableModelNV.addRow(new Object[] { null, null, null, null,
//									null, null, null });
						}
						jTableKH.setModel(newTableModelNV);
					}
				} else if (txtNhapMaKH.equals("")) {
					jTableKH.setModel(tableModelNV);
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
