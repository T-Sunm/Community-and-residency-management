package viewTamtru;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import view.viewchoose;


public class viewTamTru extends JFrame {
	private JLabel TenLB;
	private JLabel BirthLB;
	private JLabel CCCDLB;
	private JLabel GioiTinhLB;
	private JLabel DiaChiLB;
	private JLabel NghenghiepLB;
	private JLabel CCCDLB1;
	public JTextField HoKhauTF;
	public JTextField TenTF;
	public JTextField BirthTF;
	public JTextField CCCDTF;
	public JTextField NgheNgiepTF;
	public JTextField DiaChiTA;
	private JButton jbLammoi;
	private JButton jbEdit;
	private JButton jbDelete;
	private JButton jbComplete;
	private JButton jbSortSoHoKhau;
	private JButton jbSortName;
	public ButtonGroup group;
	private JScrollPane jScrollPanePeopleTable;
	private JTable PeopleTable;
	JTextField NgayketthucTF1;
	JTextField CCCDTF1;
	public JRadioButton jrNam;
	public JRadioButton jrNu;
	static List<nhankhautamtru> nhankhauList = new ArrayList<>();
	// định nghĩa các cột của bảng quanlyNhanKhau
	private String[] columnNames = new String[] {"Họ Và Tên đệm","Tên","Ngày,tháng,năm sinh ", "Giới Tính",
			"CMND/CCCD","Số điện thoại", "Địa Chỉ tạm trú", "Nghề nghiệp","Họ và tên chủ hộ","Quan hệ với chủ hộ","CCCD chủ hộ","Ngày đăng ký","Ngày kết thúc"};
	private String[] Quanhuyen = new String[] { "Hải Châu", "Cẩm Lệ", "Thanh Khê", "Liên Chiểu", "Ngũ Hành Sơn",
			"Sơn Trà", "Hòa Vang", "Hoàng Sa" };
	// định nghĩa dữ liệu mặc định của bẳng quanLynhanKhau là rỗng
	private Object data = new Object[][] {};
	private JButton jbNotSearch;
	private JButton jbSearchsohokhau;
	private JButton jbSearchcccd;
	private JButton jbchose;
	private JButton jbChuyenhuongThongke;
	private JLabel QuanLB;
	private JComboBox cbQuan;
	private JLabel SdtLB;
	private JTextField SDTTF;
	private JLabel hotenchuho;
	private JLabel quanhevoichuho;
	private JLabel cccdchuho;
	private JLabel ngaydangkylb;
	private JLabel ngayketthuclb;
	private JTextField hotenchuhoTF;
	private JTextField quanhevoichuhoTF;
	private JTextField cccdchuhoTF;
	private JTextField ngaydangkyTF;
	private JTextField ngayketthucTF;
	private JLabel NgayKTLB1;
	private JButton jbquaylai;
	private static DefaultTableModel tableModel;

	public viewTamTru() {
		this.init();
		tableModel = (DefaultTableModel) PeopleTable.getModel();
		showNhankhau();
	}

	private void init() {
		this.setTitle("Quản lý Nhân Khẩu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ActionListener ls = new nhankhautamtruControl(this);

		// khởi tạo bảng nhankhau
		jScrollPanePeopleTable = new JScrollPane();
		PeopleTable = new JTable();

		// khởi tạo menu
		JMenuBar jmb = new JMenuBar();
		JMenu jmF = new JMenu("File");
		JMenu jmA = new JMenu("About");
		JMenuItem jmtE = new JMenuItem("Exit", KeyEvent.VK_E);
		jmtE.addActionListener(ls);
		JMenuItem jmtABM = new JMenuItem("About me", KeyEvent.VK_A);
		jmtABM.addActionListener(ls);
		jmtE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		jmtABM.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		jmF.add(jmtE);
		jmA.add(jmtABM);
		jmb.add(jmF);
		jmb.add(jmA);
		// khởi tạo các label
		TenLB = new JLabel("Họ và Tên");
		GioiTinhLB = new JLabel("Giới tính");
		BirthLB = new JLabel("Ngày,tháng,năm sinh");
		CCCDLB = new JLabel("Số CMND/CCCD");
		DiaChiLB = new JLabel("Địa chỉ tạm trú");
		QuanLB = new JLabel("Quận/Huyện");
		NghenghiepLB = new JLabel("Nghề nghiệp");
		SdtLB = new JLabel("Số điện thoại");
		hotenchuho = new JLabel("Họ và tên chủ hộ");
		quanhevoichuho = new JLabel("Quan hệ với chủ hộ");
		cccdchuho = new JLabel("CCCD chủ hộ");
		ngaydangkylb = new JLabel("Ngày đăng ký");
		ngayketthuclb = new JLabel("Ngày kết thúc");
		NgayKTLB1 = new JLabel("Ngày kết thúc");
		CCCDLB1 = new JLabel("Số CMND/CCCD");
		// khởi tạo các trường nhập dữ liệu
		TenTF = new JTextField(15);
		cbQuan = new JComboBox(Quanhuyen);
		BirthTF = new JTextField(15);
		BirthTF.setText("yyyy/MM/dd");
		CCCDTF = new JTextField(15);
		DiaChiTA = new JTextField(15);
		NgheNgiepTF = new JTextField(15);
		SDTTF = new JTextField(15);
		hotenchuhoTF = new JTextField(15);
		quanhevoichuhoTF = new JTextField(15);
		cccdchuhoTF =  new JTextField(15);
		ngaydangkyTF = new JTextField(15);
		ngaydangkyTF.setText("yyyy/MM/dd");
		ngayketthucTF = new JTextField(15);
		ngayketthucTF.setText("yyyy/MM/dd");
		NgayketthucTF1 = new JTextField(15);
		NgayketthucTF1.setText("yyyy/MM/dd");
		CCCDTF1 = new JTextField(15);
		// khởi tạo các nút
		jbLammoi = new JButton("Làm mới");
		jbLammoi.addActionListener(ls);
		jbEdit = new JButton("Chỉnh sửa");
		jbEdit.addActionListener(ls);
		jbDelete = new JButton("Xóa");
		jbDelete.addActionListener(ls);
		jbComplete = new JButton("Lưu");
		jbComplete.addActionListener(ls);
		jbSortSoHoKhau = new JButton("Sắp xếp theo Số hộ khẩu");
		jbSortSoHoKhau.addActionListener(ls);
		jbSortName = new JButton("Sắp xếp theo Tên");
		jbSortName.addActionListener(ls);
		jbChuyenhuongThongke = new JButton("Thống kê");
		jbChuyenhuongThongke.addActionListener(ls);
		jbSearchsohokhau = new JButton("Tìm kiếm");
		jbSearchsohokhau.addActionListener(ls);
		jbSearchcccd = new JButton("Tìm kiếm.");
		jbSearchcccd.addActionListener(ls);
		jbNotSearch = new JButton("Hủy tìm kiếm");
		jbNotSearch.addActionListener(ls);
		jbchose = new JButton("Lấy");
		jbchose.addActionListener(ls);
		jrNam = new JRadioButton("Nam");
		jrNam.setActionCommand("Nam");
		jrNu = new JRadioButton("Nữ");
		jrNu.setActionCommand("Nữ");
		group = new ButtonGroup();
		group.add(jrNam);
		group.add(jrNu);
		jbquaylai = new JButton("Quay lại");
		jbquaylai.addActionListener(ls);
		// cài đặt các cột và data cho bảng quanLyNhanKhau
		PeopleTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
		jScrollPanePeopleTable.setViewportView(PeopleTable);
		jScrollPanePeopleTable.setPreferredSize(new Dimension(1020, 250));

		// set Layout
		// 1.set Layout cho Jframe
		SpringLayout layout = new SpringLayout();
		JPanel panel = new JPanel();
		panel.setSize(1370, 520);
		panel.setLayout(layout);
		// 2. set Layout cho Table
		JPanel pnpeopleTable = new JPanel();
		Border bor = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titlebor = new TitledBorder(bor, "Bảng Quản lý nhân khẩu");
		pnpeopleTable.setBorder(titlebor);
		pnpeopleTable.add(jScrollPanePeopleTable);
		// 3.set Layout cho tìm kiếm
		JPanel pnpeoplesearch = new JPanel();
		pnpeoplesearch.setLayout(new BoxLayout(pnpeoplesearch, BoxLayout.X_AXIS));
		Border bor1 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titlebor1 = new TitledBorder(bor1, "Tìm kiếm nhân khẩu");
		pnpeoplesearch.setBorder(titlebor1);
		pnpeoplesearch.add(NgayKTLB1);
		pnpeoplesearch.add(NgayketthucTF1);
		pnpeoplesearch.add(jbSearchsohokhau);
		pnpeoplesearch.add(CCCDLB1);
		pnpeoplesearch.add(CCCDTF1);
		pnpeoplesearch.add(jbSearchcccd);
		pnpeoplesearch.add(jbNotSearch);
		// 4. set Layout cho giới tính
		JPanel pnJrGioiTinh = new JPanel();
		pnJrGioiTinh.setLayout(new BoxLayout(pnJrGioiTinh, BoxLayout.X_AXIS));
		pnJrGioiTinh.add(jrNam);
		pnJrGioiTinh.add(jrNu);

		panel.add(pnpeopleTable);
		panel.add(jbLammoi);
		panel.add(jbEdit);
		panel.add(jbDelete);
		panel.add(jbComplete);
		panel.add(jbSortName);
		panel.add(jbchose);
		panel.add(pnpeoplesearch);
		panel.add(jbChuyenhuongThongke);
		panel.add(jbquaylai);

		panel.add(TenLB);
		panel.add(GioiTinhLB);
		panel.add(BirthLB);
		panel.add(CCCDLB);
		panel.add(DiaChiLB);
		panel.add(NghenghiepLB);
		panel.add(SdtLB);
		panel.add(QuanLB);
		panel.add(hotenchuho);
		panel.add(quanhevoichuho);
		panel.add(cccdchuho);
		panel.add(ngaydangkylb);
		panel.add(ngayketthuclb);

		panel.add(TenTF);
		panel.add(pnJrGioiTinh);
		panel.add(BirthTF);
		panel.add(CCCDTF);
		panel.add(DiaChiTA);
		panel.add(NgheNgiepTF);
		panel.add(SDTTF);
		panel.add(cbQuan);
		panel.add(hotenchuhoTF);
		panel.add(quanhevoichuhoTF);
		panel.add(cccdchuhoTF);
		panel.add(ngaydangkyTF);
		panel.add(ngayketthucTF);

		layout.putConstraint(SpringLayout.WEST, TenLB, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, TenLB, 10, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, GioiTinhLB, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, GioiTinhLB, 42, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, BirthLB, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, BirthLB, 70, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, CCCDLB, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, CCCDLB, 100, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, DiaChiLB, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, DiaChiLB, 135, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, QuanLB, 15, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, QuanLB, 160, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, cbQuan, 150, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, cbQuan, 160, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, NghenghiepLB, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, NghenghiepLB, 190, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, SdtLB, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, SdtLB, 220, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, hotenchuho, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, hotenchuho, 250, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, quanhevoichuho, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, quanhevoichuho, 285, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, cccdchuho, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, cccdchuho, 310, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, ngaydangkylb, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, ngaydangkylb, 340, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, ngayketthuclb, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, ngayketthuclb, 370, SpringLayout.NORTH, panel);
		

		layout.putConstraint(SpringLayout.WEST, TenTF, 150, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, TenTF, 10, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, pnJrGioiTinh, 150, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, pnJrGioiTinh, 38, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, BirthTF, 150, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, BirthTF, 70, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, CCCDTF, 150, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, CCCDTF, 100, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, DiaChiTA, 150, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, DiaChiTA, 135, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, NgheNgiepTF, 150, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, NgheNgiepTF, 190, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, SDTTF, 150, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, SDTTF, 220, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, hotenchuhoTF, 150, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, hotenchuhoTF, 250, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, quanhevoichuhoTF, 150, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, quanhevoichuhoTF, 280, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, cccdchuhoTF, 150, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, cccdchuhoTF, 310, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, ngaydangkyTF, 150, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, ngaydangkyTF, 340, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, ngayketthucTF, 150, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, ngayketthucTF, 370, SpringLayout.NORTH, panel);

		layout.putConstraint(SpringLayout.WEST, pnpeopleTable, 320, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, pnpeopleTable, 60, SpringLayout.NORTH, panel);

		layout.putConstraint(SpringLayout.WEST, pnpeoplesearch, 320, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, pnpeoplesearch, 5, SpringLayout.NORTH, panel);

		layout.putConstraint(SpringLayout.WEST, jbchose, 0, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jbchose, 400, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jbLammoi, 50, SpringLayout.WEST, jbchose);
		layout.putConstraint(SpringLayout.NORTH, jbLammoi, 400, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jbEdit, 80, SpringLayout.WEST, jbLammoi);
		layout.putConstraint(SpringLayout.NORTH, jbEdit, 400, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jbDelete, 89, SpringLayout.WEST, jbEdit);
		layout.putConstraint(SpringLayout.NORTH, jbDelete, 400, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jbComplete, 55, SpringLayout.WEST, jbDelete);
		layout.putConstraint(SpringLayout.NORTH, jbComplete, 400, SpringLayout.NORTH, panel);

		layout.putConstraint(SpringLayout.WEST, jbSortName, 550, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jbSortName, 350, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jbChuyenhuongThongke, 150, SpringLayout.WEST, jbSortName);
		layout.putConstraint(SpringLayout.NORTH, jbChuyenhuongThongke, 350, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jbquaylai, 140, SpringLayout.WEST, jbChuyenhuongThongke);
		layout.putConstraint(SpringLayout.NORTH, jbquaylai, 350, SpringLayout.NORTH, panel);

		this.setResizable(false);
		this.add(panel);
		this.setJMenuBar(jmb);
		this.setSize(1380, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public void xoaForm() {
		TenTF.setText("");
		BirthTF.setText("dd/MM/yyyy");
		CCCDTF.setText("");
		DiaChiTA.setText("");
		NgheNgiepTF.setText("");
		SDTTF.setText("");
		group.clearSelection();
		cbQuan.setSelectedItem(null);
		hotenchuhoTF.setText("");
		quanhevoichuhoTF.setText("");
		cccdchuhoTF.setText("");
		ngaydangkyTF.setText("dd/MM/yyyy");
		ngayketthucTF.setText("dd/MM/yyyy");
		

	}

	public void showNhankhau() {
		nhankhauList = nhankhauTamtruModify.findAll();
		// xóa hết các cột còn ở trong
		tableModel.setRowCount(0);

		for (nhankhautamtru nhankhau : nhankhauList) {
			tableModel.addRow(new Object[] {nhankhau.getHoTen(),nhankhau.getTen(),nhankhau.getBirth(), nhankhau.getGioiTinh(),
					nhankhau.getCCCD(),nhankhau.getSdt(), nhankhau.getDiaChiTamT(), nhankhau.getNgheNghiep(),
					nhankhau.getHoTenchuho(),nhankhau.getQuanhechuho(),nhankhau.getCccdchuho(),nhankhau.getNgaydangky(),nhankhau.getNgayketthuc() });
		}
	}

	public void Save() {
		String hoten = TenTF.getText();
		String[] parts = hoten.split(" ");
	    int lastIndex = parts.length - 1;
		String firstName = parts[lastIndex];
	    String lastName = "";
	    for (int i = 0; i < lastIndex; i++) {
	        lastName += parts[i] + " ";
	    }
		String gioiTinh = group.getSelection().getActionCommand();
		String ngaysinh = BirthTF.getText();
		String cccd = CCCDTF.getText();
		String diachi = DiaChiTA.getText();
		String QuanHuyen = (String) cbQuan.getSelectedItem();
		String nghenghiep = NgheNgiepTF.getText();
		String sdt = SDTTF.getText();
		String hotenchuho = hotenchuhoTF.getText();
		String Quanhechuho = quanhevoichuhoTF.getText();
		String cccdchuho = cccdchuhoTF.getText();
		String ngaydangky = ngaydangkyTF.getText();
		String ngayketthuc = ngayketthucTF.getText();

		if (hoten.equals("") || gioiTinh.equals("") || ngaysinh.equals("") || cccd.equals("")
				|| diachi.equals("") || nghenghiep.equals("") || QuanHuyen.equals("") || sdt.equals("")||hotenchuho.equals("") || Quanhechuho.equals("")
				|| cccdchuho.equals("") || ngaydangky.equals("")||ngayketthuc.equals("")) {
			JOptionPane.showMessageDialog(this, "Chưa nhập thông tin");
		} else {
			nhankhautamtru nk = new nhankhautamtru(lastName,firstName,ngaysinh,gioiTinh,cccd,sdt,diachi,QuanHuyen,nghenghiep,hotenchuho, Quanhechuho, cccdchuho, ngaydangky, ngayketthuc);
			nhankhauTamtruModify.insert(nk);
			showNhankhau();
		}
	}
	public void update() {
		String hoten = TenTF.getText();
		String[] parts = hoten.split(" ");
	    int lastIndex = parts.length - 1;
		String firstName = parts[lastIndex];
	    String lastName = "";
	    for (int i = 0; i < lastIndex; i++) {
	        lastName += parts[i] + " ";
	    }
		String gioiTinh = group.getSelection().getActionCommand();
		String ngaysinh = BirthTF.getText();
		String cccd = CCCDTF.getText();
		String diachi = DiaChiTA.getText();
		String QuanHuyen = (String) cbQuan.getSelectedItem();
		String nghenghiep = NgheNgiepTF.getText();
		String sdt = SDTTF.getText();
		String hotenchuho = hotenchuhoTF.getText();
		String Quanhechuho = quanhevoichuhoTF.getText();
		String cccdchuho = cccdchuhoTF.getText();
		String ngaydangky = ngaydangkyTF.getText();
		String ngayketthuc = ngayketthucTF.getText();
		if (hoten.equals("") || gioiTinh.equals("") || ngaysinh.equals("") || cccd.equals("")
				|| diachi.equals("") || nghenghiep.equals("") || QuanHuyen.equals("") || sdt.equals("")||hotenchuho.equals("") || Quanhechuho.equals("")
				|| cccdchuho.equals("") || ngaydangky.equals("")||ngayketthuc.equals("")) {
			JOptionPane.showMessageDialog(this, "Chưa nhập thông tin");
		} else {
			nhankhautamtru nk = new nhankhautamtru(lastName,firstName,ngaysinh ,gioiTinh, cccd, sdt, diachi, QuanHuyen , nghenghiep, hotenchuho, Quanhechuho, cccdchuho, ngaydangky, ngayketthuc);
			nhankhauTamtruModify.update(nk);
			showNhankhau();
		}
	}
	public nhankhautamtru getNhanKhaudangchon() {
		DefaultTableModel model = (DefaultTableModel) PeopleTable.getModel();
		int i_row = PeopleTable.getSelectedRow();
		String HoTen = model.getValueAt(i_row, 0) + "";
		String ten = model.getValueAt(i_row, 1) + "";
		String GioiTinh = model.getValueAt(i_row, 3) + "";
		String Birth = model.getValueAt(i_row, 2) + "";
		String CCCD = model.getValueAt(i_row, 4) + "";
		String DiaChi = model.getValueAt(i_row, 5) + "";
		String NgheNghiep = model.getValueAt(i_row, 6) + "";
		String sdt = model.getValueAt(i_row, 7) + "";
		String hotenchuho = model.getValueAt(i_row, 8) + "";
		String Quanhechuho = model.getValueAt(i_row, 9) + "";
		String cccdchuho = model.getValueAt(i_row, 10) + "";
		String ngaydangky = model.getValueAt(i_row, 11) + "";
		String ngayketthuc = model.getValueAt(i_row, 12) + "";
		nhankhautamtru nk = new nhankhautamtru(HoTen,ten,Birth ,GioiTinh, CCCD,sdt, DiaChi,NgheNghiep,hotenchuho, Quanhechuho, cccdchuho, ngaydangky, ngayketthuc);
		return nk;

	}

	public void hienThiThongTinNhanKhau() {
		nhankhautamtru nk = getNhanKhaudangchon();
		this.TenTF.setText(nk.getHoTen()+""+nk.getTen());
		if (nk.getGioiTinh().equals("Nam")) {
			jrNam.setSelected(true);
		} else {
			jrNu.setSelected(true);
		}
		this.BirthTF.setText(nk.getBirth());
		this.CCCDTF.setText(nk.getCCCD());
		String s = nk.getDiaChiTamT();
		// lấy vị trí cảu dấu phẩy
		int index = s.indexOf(",");
		// lấy string từ đầu đến vị trí dấu phẩy
		String output = s.substring(0, index);
		this.DiaChiTA.setText(output);
		cbQuan.setSelectedItem(nhankhauTamtruModify.getquequan(nk.getCCCD()));
		this.NgheNgiepTF.setText(nk.getNgheNghiep());
		SDTTF.setText(nk.getSdt());
		hotenchuhoTF.setText(nk.getHoTenchuho());
		quanhevoichuhoTF.setText(nk.getQuanhechuho());
		cccdchuhoTF.setText(nk.getCccdchuho());
		ngaydangkyTF.setText(nk.getNgaydangky());
		ngayketthucTF.setText(nk.getNgayketthuc());

	}

	public void thuchienXoa() {
		int selectedIndex = PeopleTable.getSelectedRow();
		if (selectedIndex >= 0) {
			nhankhautamtru nk = nhankhauList.get(selectedIndex);

			int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không");

			if (option == 0) {
				nhankhauTamtruModify.delete(nk.getCCCD());
				showNhankhau();
			}
			// sau khi thực hiện xong ta gọi lại showStudent để hiển thị danh sách sinh viên
		}
	}

	public void timkiemngayketthuc() {
		String input = NgayketthucTF1.getText();
		if (input.length() > 0) {
			nhankhauList = nhankhauTamtruModify.findByngayketthuc(input);

			tableModel.setRowCount(0);

			for (nhankhautamtru nhankhau : nhankhauList) {
				tableModel.addRow(new Object[] {nhankhau.getHoTen(),nhankhau.getTen(),nhankhau.getBirth(), nhankhau.getGioiTinh(),
						 nhankhau.getCCCD(),nhankhau.getSdt(), nhankhau.getDiaChiTamT(), nhankhau.getNgheNghiep(),
						nhankhau.getHoTenchuho(),nhankhau.getQuanhechuho(),nhankhau.getCccdchuho(),nhankhau.getNgaydangky(),nhankhau.getNgayketthuc() });
			}
		}
	}

	public void timkiemtheoccd() {
		String input = CCCDTF1.getText();
		if (input.length() > 0) {
			nhankhauList = nhankhauTamtruModify.findBycccd(input);

			tableModel.setRowCount(0);

			for (nhankhautamtru nhankhau : nhankhauList) {
				tableModel.addRow(new Object[] {nhankhau.getHoTen(),nhankhau.getTen(),nhankhau.getBirth(), nhankhau.getGioiTinh(),
						 nhankhau.getCCCD(),nhankhau.getSdt(), nhankhau.getDiaChiTamT(), nhankhau.getNgheNghiep(),
						nhankhau.getHoTenchuho(),nhankhau.getQuanhechuho(),nhankhau.getCccdchuho(),nhankhau.getNgaydangky(),nhankhau.getNgayketthuc() });
			}
		}
	}

	public void hienthiAbout() {
		JOptionPane.showMessageDialog(this, "Minh Đẹp Trai" + "\nThường trú tại:22AD");
	}

	public void thoatkhoichuongtrinh() {
		int luachon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn Thoát ?", "Exit", JOptionPane.YES_OPTION);
		if (luachon == JOptionPane.YES_OPTION) {
			System.exit(0);

		}
	}

	public void thuchienSapxeptheoten() {
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(PeopleTable.getModel());
		PeopleTable.setRowSorter(sorter);
		List<RowSorter.SortKey> sortKeys = new ArrayList<>();

		int columnIndexToSort = 1;
		sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));

		sorter.setSortKeys(sortKeys);
		sorter.sort();

	}

	public void thuchienchuyenhuongThongke() {
		ThongkeController TKC = new ThongkeController();
		TKC.ThongkeControllerr();
		TKC.setVisible(true);

	}
	public void thuchienchuyenhuongcuasochon() {
		viewchoose vc = new viewchoose();
		vc.setVisible(true);
		this.dispose();
	}
}
