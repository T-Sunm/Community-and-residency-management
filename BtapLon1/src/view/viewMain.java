package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
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
import javax.swing.JTextArea;
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

import ThongkeDemo.ThongkeController;
import controller.QLNKcontroller;
import model.NhanKhau;
import model.nhankhauModify;

public class viewMain extends JFrame {
	private JLabel HoKhauLB;
	private JLabel TenLB;
	private JLabel BirthLB;
	private JLabel CCCDLB;
	private JLabel GioiTinhLB;
	private JLabel DiaChiLB;
	private JLabel NghenghiepLB;
	private JLabel DanTocLB;
	private JLabel HoKhauLB1;
	private JLabel CCCDLB1;
	public JTextField HoKhauTF;
	public JTextField TenTF;
	public JTextField BirthTF;
	public JTextField CCCDTF;
	public JTextField NgheNgiepTF;
	public JTextField DanTocTF;
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
	public JTextField HoKhauTF1;
	public JTextField CCCDTF1;
	public NhanKhau nhankhau;
	public JRadioButton jrNam;
	public JRadioButton jrNu;
	static List<NhanKhau> nhankhauList = new ArrayList<>();
	// ?????nh ngh??a c??c c???t c???a b???ng quanlyNhanKhau
	private String[] columnNames = new String[] { "S??? H??? Kh???u", "H??? V?? T??n ?????m","T??n", "Gi???i T??nh", "Ng??y,th??ng,n??m sinh ",
			"CMND/CCCD", "?????a Ch??? th?????ng tr??", "Ngh??? nghi???p", "D??n T???c" };
	private String[] Quanhuyen = new String[] { "H???i Ch??u", "C???m L???", "Thanh Kh??", "Li??n Chi???u", "Ng?? H??nh S??n",
			"S??n Tr??", "H??a Vang", "Ho??ng Sa" };
	// ?????nh ngh??a d??? li???u m???c ?????nh c???a b???ng quanLynhanKhau l?? r???ng
	private Object data = new Object[][] {};
	private JButton jbNotSearch;
	private JButton jbSearchsohokhau;
	private JButton jbSearchcccd;
	private JButton jbchose;
	private JButton jbChuyenhuongThongke;
	private JLabel QuanLB;
	private JComboBox cbQuan;
	private JButton jbquaylai;
	private static DefaultTableModel tableModel;

	public viewMain() {
		this.init();
		tableModel = (DefaultTableModel) PeopleTable.getModel();
		showNhankhau();
	}

	private void init() {
		this.setTitle("Qu???n l?? Nh??n Kh???u");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ActionListener ls = new QLNKcontroller(this);

		// kh???i t???o b???ng nhankhau
		jScrollPanePeopleTable = new JScrollPane();
		PeopleTable = new JTable();

		// kh???i t???o menu
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
		// kh???i t???o c??c label
		HoKhauLB = new JLabel("S??? H??? Kh???u");
		TenLB = new JLabel("H??? v?? T??n");
		GioiTinhLB = new JLabel("Gi???i t??nh");
		BirthLB = new JLabel("Ng??y,th??ng,n??m sinh");
		CCCDLB = new JLabel("S??? CMND/CCCD");
		DiaChiLB = new JLabel("?????a ch??? th?????ng tr??");
		QuanLB = new JLabel("Qu???n/Huy???n");
		NghenghiepLB = new JLabel("Ngh??? nghi???p");
		DanTocLB = new JLabel("D??n t???c");
		HoKhauLB1 = new JLabel("S??? H??? Kh???u");
		CCCDLB1 = new JLabel("S??? CMND/CCCD");
		// kh???i t???o c??c tr?????ng nh???p d??? li???u
		HoKhauTF = new JTextField(15);
		TenTF = new JTextField(15);
		cbQuan = new JComboBox(Quanhuyen);
		BirthTF = new JTextField(15);
		BirthTF.setText("yyyy/MM/dd");
		CCCDTF = new JTextField(15);
		DiaChiTA = new JTextField(15);
		NgheNgiepTF = new JTextField(15);
		DanTocTF = new JTextField(15);
		HoKhauTF1 = new JTextField(15);
		CCCDTF1 = new JTextField(15);
		// kh???i t???o c??c n??t
		jbLammoi = new JButton("L??m m???i");
		jbLammoi.addActionListener(ls);
		jbEdit = new JButton("Ch???nh s???a");
		jbEdit.addActionListener(ls);
		jbDelete = new JButton("X??a");
		jbDelete.addActionListener(ls);
		jbComplete = new JButton("L??u");
		jbComplete.addActionListener(ls);
		jbSortSoHoKhau = new JButton("S???p x???p theo S??? h??? kh???u");
		jbSortSoHoKhau.addActionListener(ls);
		jbSortName = new JButton("S???p x???p theo T??n");
		jbSortName.addActionListener(ls);
		jbChuyenhuongThongke = new JButton("Th???ng k??");
		jbChuyenhuongThongke.addActionListener(ls);
		jbSearchsohokhau = new JButton("T??m ki???m");
		jbSearchsohokhau.addActionListener(ls);
		jbSearchcccd = new JButton("T??m ki???m.");
		jbSearchcccd.addActionListener(ls);
		jbNotSearch = new JButton("H???y t??m ki???m");
		jbNotSearch.addActionListener(ls);
		jbchose = new JButton("L???y");
		jbchose.addActionListener(ls);
		jrNam = new JRadioButton("Nam");
		jrNam.setActionCommand("Nam");
		jrNu = new JRadioButton("N???");
		jrNu.setActionCommand("N???");
		group = new ButtonGroup();
		group.add(jrNam);
		group.add(jrNu);
		jbquaylai = new JButton("Quay l???i");
		jbquaylai.addActionListener(ls);
		// c??i ?????t c??c c???t v?? data cho b???ng quanLyNhanKhau
		PeopleTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
		jScrollPanePeopleTable.setViewportView(PeopleTable);
		jScrollPanePeopleTable.setPreferredSize(new Dimension(820, 250));

		// set Layout
		// 1.set Layout cho Jframe
		SpringLayout layout = new SpringLayout();
		JPanel panel = new JPanel();
		panel.setSize(1170, 420);
		panel.setLayout(layout);
		// 2. set Layout cho Table
		JPanel pnpeopleTable = new JPanel();
		Border bor = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titlebor = new TitledBorder(bor, "B???ng Qu???n l?? nh??n kh???u");
		pnpeopleTable.setBorder(titlebor);
		pnpeopleTable.add(jScrollPanePeopleTable);
		// 3.set Layout cho t??m ki???m
		JPanel pnpeoplesearch = new JPanel();
		pnpeoplesearch.setLayout(new BoxLayout(pnpeoplesearch, BoxLayout.X_AXIS));
		Border bor1 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titlebor1 = new TitledBorder(bor1, "T??m ki???m nh??n kh???u");
		pnpeoplesearch.setBorder(titlebor1);
		pnpeoplesearch.add(HoKhauLB1);
		pnpeoplesearch.add(HoKhauTF1);
		pnpeoplesearch.add(jbSearchsohokhau);
		pnpeoplesearch.add(CCCDLB1);
		pnpeoplesearch.add(CCCDTF1);
		pnpeoplesearch.add(jbSearchcccd);
		pnpeoplesearch.add(jbNotSearch);
		// 4. set Layout cho gi???i t??nh
		JPanel pnJrGioiTinh = new JPanel();
		pnJrGioiTinh.setLayout(new BoxLayout(pnJrGioiTinh, BoxLayout.X_AXIS));
		pnJrGioiTinh.add(jrNam);
		pnJrGioiTinh.add(jrNu);

		panel.add(pnpeopleTable);
		panel.add(jbLammoi);
		panel.add(jbEdit);
		panel.add(jbDelete);
		panel.add(jbComplete);
		panel.add(jbSortSoHoKhau);
		panel.add(jbSortName);
		panel.add(jbchose);
		panel.add(pnpeoplesearch);
		panel.add(jbChuyenhuongThongke);
		panel.add(jbquaylai);

		panel.add(HoKhauLB);
		panel.add(TenLB);
		panel.add(GioiTinhLB);
		panel.add(BirthLB);
		panel.add(CCCDLB);
		panel.add(DiaChiLB);
		panel.add(NghenghiepLB);
		panel.add(DanTocLB);
		panel.add(QuanLB);

		panel.add(HoKhauTF);
		panel.add(TenTF);
		panel.add(pnJrGioiTinh);
		panel.add(BirthTF);
		panel.add(CCCDTF);
		panel.add(DiaChiTA);
		panel.add(NgheNgiepTF);
		panel.add(DanTocTF);
		panel.add(cbQuan);

		layout.putConstraint(SpringLayout.WEST, HoKhauLB, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, HoKhauLB, 10, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, TenLB, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, TenLB, 40, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, GioiTinhLB, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, GioiTinhLB, 72, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, BirthLB, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, BirthLB, 100, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, CCCDLB, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, CCCDLB, 130, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, DiaChiLB, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, DiaChiLB, 165, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, QuanLB, 15, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, QuanLB, 190, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, cbQuan, 150, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, cbQuan, 190, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, NghenghiepLB, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, NghenghiepLB, 220, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, DanTocLB, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, DanTocLB, 250, SpringLayout.NORTH, panel);

		layout.putConstraint(SpringLayout.WEST, HoKhauTF, 150, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, HoKhauTF, 10, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, TenTF, 150, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, TenTF, 40, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, pnJrGioiTinh, 150, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, pnJrGioiTinh, 68, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, BirthTF, 150, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, BirthTF, 100, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, CCCDTF, 150, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, CCCDTF, 130, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, DiaChiTA, 150, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, DiaChiTA, 165, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, NgheNgiepTF, 150, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, NgheNgiepTF, 220, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, DanTocTF, 150, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, DanTocTF, 250, SpringLayout.NORTH, panel);

		layout.putConstraint(SpringLayout.WEST, pnpeopleTable, 320, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, pnpeopleTable, 60, SpringLayout.NORTH, panel);

		layout.putConstraint(SpringLayout.WEST, pnpeoplesearch, 320, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, pnpeoplesearch, 5, SpringLayout.NORTH, panel);

		layout.putConstraint(SpringLayout.WEST, jbchose, 0, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jbchose, 340, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jbLammoi, 50, SpringLayout.WEST, jbchose);
		layout.putConstraint(SpringLayout.NORTH, jbLammoi, 340, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jbEdit, 80, SpringLayout.WEST, jbLammoi);
		layout.putConstraint(SpringLayout.NORTH, jbEdit, 340, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jbDelete, 89, SpringLayout.WEST, jbEdit);
		layout.putConstraint(SpringLayout.NORTH, jbDelete, 340, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jbComplete, 55, SpringLayout.WEST, jbDelete);
		layout.putConstraint(SpringLayout.NORTH, jbComplete, 340, SpringLayout.NORTH, panel);

		layout.putConstraint(SpringLayout.WEST, jbSortSoHoKhau, 550, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jbSortSoHoKhau, 350, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jbSortName, 200, SpringLayout.WEST, jbSortSoHoKhau);
		layout.putConstraint(SpringLayout.NORTH, jbSortName, 350, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jbChuyenhuongThongke, 150, SpringLayout.WEST, jbSortName);
		layout.putConstraint(SpringLayout.NORTH, jbChuyenhuongThongke, 350, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jbquaylai, 140, SpringLayout.WEST, jbChuyenhuongThongke);
		layout.putConstraint(SpringLayout.NORTH, jbquaylai, 350, SpringLayout.NORTH, panel);

		this.setResizable(false);
		this.add(panel);
		this.setJMenuBar(jmb);
		this.setSize(1180, 440);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	public void xoaForm() {
		HoKhauTF.setText("");
		TenTF.setText("");
		BirthTF.setText("yyyy/MM/dd");
		CCCDTF.setText("");
		DiaChiTA.setText("");
		NgheNgiepTF.setText("");
		DanTocTF.setText("");
		group.clearSelection();
		cbQuan.setSelectedItem(null);

	}

	public void showNhankhau() {
		nhankhauList = nhankhauModify.findAll();
		// x??a h???t c??c c???t c??n ??? trong
		tableModel.setRowCount(0);

		for (NhanKhau nhankhau : nhankhauList) {
			tableModel.addRow(new Object[] { nhankhau.getSoHoKhau(), nhankhau.getHoTen(),nhankhau.getTen(), nhankhau.getGioiTinh(),
					nhankhau.getBirth(), nhankhau.getCCCD(), nhankhau.getDiaChi(), nhankhau.getNgheNghiep(),
					nhankhau.getDanToc() });
		}
	}

	public void Save() {
		String sohokhau = HoKhauTF.getText();
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
		String dantoc = DanTocTF.getText();

		if (sohokhau.equals("") || hoten.equals("") || gioiTinh.equals("") || ngaysinh.equals("") || cccd.equals("")
				|| diachi.equals("") || nghenghiep.equals("") || dantoc.equals("")) {
			JOptionPane.showMessageDialog(this, "Ch??a nh???p th??ng tin");
		} else {
			NhanKhau nk = new NhanKhau(sohokhau, lastName,firstName, gioiTinh, ngaysinh, cccd, diachi, QuanHuyen, nghenghiep,
					dantoc);
			nhankhauModify.insert(nk);
			showNhankhau();
		}
	}

	public void update() {
		String sohokhau = HoKhauTF.getText();
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
		String dantoc = DanTocTF.getText();
		if (sohokhau.equals("") || hoten.equals("") || gioiTinh.equals("") || ngaysinh.equals("") || cccd.equals("")
				|| diachi.equals("") || nghenghiep.equals("") || dantoc.equals("")) {
			JOptionPane.showMessageDialog(this, "Ch??a nh???p th??ng tin");
		} else {
			NhanKhau nk = new NhanKhau(sohokhau, lastName,firstName ,gioiTinh, ngaysinh, cccd, diachi, QuanHuyen, nghenghiep,
					dantoc);
			nhankhauModify.update(nk);
			showNhankhau();
		}
	}

	public NhanKhau getNhanKhaudangchon() {
		DefaultTableModel model = (DefaultTableModel) PeopleTable.getModel();
		int i_row = PeopleTable.getSelectedRow();
		String SoHoKhau = model.getValueAt(i_row, 0) + "";
		String HoTen = model.getValueAt(i_row, 1) + "";
		String ten = model.getValueAt(i_row, 2) +"";
		String GioiTinh = model.getValueAt(i_row, 3) + "";
		String Birth = model.getValueAt(i_row, 4) + "";
		String CCCD = model.getValueAt(i_row, 5) + "";
		String DiaChi = model.getValueAt(i_row, 6) + "";
		String NgheNghiep = model.getValueAt(i_row, 7) + "";
		String DanToc = model.getValueAt(i_row, 8) + "";
		NhanKhau nk = new NhanKhau(SoHoKhau, HoTen,ten, GioiTinh, Birth, CCCD, DiaChi, NgheNghiep, DanToc);
		return nk;

	}

	public void hienThiThongTinNhanKhau() {
		NhanKhau nk = getNhanKhaudangchon();
		this.HoKhauTF.setText(nk.getSoHoKhau() + "");
		this.TenTF.setText(nk.getHoTen()+""+nk.getTen());
		if (nk.getGioiTinh().equals("Nam")) {
			jrNam.setSelected(true);
		} else {
			jrNu.setSelected(true);
		}
		this.BirthTF.setText(nk.getBirth());
		this.CCCDTF.setText(nk.getCCCD());
		String s = nk.getDiaChi();
		// l???y v??? tr?? c???u d???u ph???y
		int index = s.indexOf(",");
		// l???y string t??? ?????u ?????n v??? tr?? d???u ph???y
		String output = s.substring(0, index);
		this.DiaChiTA.setText(output);
		cbQuan.setSelectedItem(nhankhauModify.getquequan(nk.getCCCD()));
		this.NgheNgiepTF.setText(nk.getNgheNghiep());
		this.DanTocTF.setText(nk.getDanToc());

	}

	public void thuchienXoa() {
		int selectedIndex = PeopleTable.getSelectedRow();
		if (selectedIndex >= 0) {
			NhanKhau nk = nhankhauList.get(selectedIndex);

			int option = JOptionPane.showConfirmDialog(this, "B???n c?? mu???n x??a kh??ng");

			if (option == 0) {
				nhankhauModify.delete(nk.getCCCD());
				showNhankhau();
			}
			// sau khi th???c hi???n xong ta g???i l???i showStudent ????? hi???n th??? danh s??ch sinh vi??n
		}
	}

	public void timkiemsohokhau() {
		String input = HoKhauTF1.getText();
		if (input.length() > 0) {
			nhankhauList = nhankhauModify.findBysohokhau(input);

			tableModel.setRowCount(0);

			for (NhanKhau nhankhau : nhankhauList) {
				tableModel.addRow(new Object[] { nhankhau.getSoHoKhau(), nhankhau.getHoTen(),nhankhau.getTen(), nhankhau.getGioiTinh(),
						nhankhau.getBirth(), nhankhau.getCCCD(), nhankhau.getDiaChi(), nhankhau.getNgheNghiep(),
						nhankhau.getDanToc() });
			}
		}
	}

	public void timkiemtheoccd() {
		String input = CCCDTF1.getText();
		if (input.length() > 0) {
			nhankhauList = nhankhauModify.findBycccd(input);

			tableModel.setRowCount(0);

			for (NhanKhau nhankhau : nhankhauList) {
				tableModel.addRow(new Object[] { nhankhau.getSoHoKhau(), nhankhau.getHoTen(),nhankhau.getTen(), nhankhau.getGioiTinh(),
						nhankhau.getBirth(), nhankhau.getCCCD(), nhankhau.getDiaChi(), nhankhau.getNgheNghiep(),
						nhankhau.getDanToc() });
			}
		}
	}

	public void hienthiAbout() {
		JOptionPane.showMessageDialog(this, "Minh ?????p Trai" + "\nTh?????ng tr?? t???i:22AD");
	}

	public void thoatkhoichuongtrinh() {
		int luachon = JOptionPane.showConfirmDialog(this, "B???n c?? ch???c ch???n Tho??t ?", "Exit", JOptionPane.YES_OPTION);
		if (luachon == JOptionPane.YES_OPTION) {
			System.exit(0);

		}
	}

	public void thuchienSapxeptheoten() {
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(PeopleTable.getModel());
		PeopleTable.setRowSorter(sorter);
		List<RowSorter.SortKey> sortKeys = new ArrayList<>();

		int columnIndexToSort = 2;
		sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));

		sorter.setSortKeys(sortKeys);
		sorter.sort();

	}

	public void thuchienSapxeptheoSohokhau() {
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(PeopleTable.getModel());
		PeopleTable.setRowSorter(sorter);
		List<RowSorter.SortKey> sortKeys = new ArrayList<>();

		int columnIndexToSort = 0;
		sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));

		sorter.setSortKeys(sortKeys);
		sorter.sort();

	}

	public void thuchienchuyenhuongThongke() {
		ThongkeController TKC = new ThongkeController();
		TKC.ThongkeControllerr();
		TKC.setVisible(true);

	}

	public void thuchienchuyenhuongquaylai() {
		viewchoose vc = new viewchoose();
		vc.setVisible(true);
		this.dispose();
		
	}
}