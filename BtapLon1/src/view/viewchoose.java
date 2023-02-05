package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controller.chooseController;
import viewTamtru.viewTamTru;

public class viewchoose extends JFrame {
	public viewchoose() {
		this.init();
	}

	private void init() {
		this.setTitle("Quản lý Nhân Khẩu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ActionListener ls = new chooseController(this);
		
		this.setResizable(false);
		SpringLayout layout = new SpringLayout();
		JPanel panel = new JPanel();
		panel.setSize(300, 300);
		panel.setLayout(layout);
		
		JButton jbchuyenhuongthuongtru = new JButton("Đăng ký thường trú");
		jbchuyenhuongthuongtru.addActionListener(ls);
		JButton jbchuyenhuongtamtru = new JButton("Đăng ký tạm trú");
		jbchuyenhuongtamtru.addActionListener(ls);
		panel.add(jbchuyenhuongthuongtru);
		panel.add(jbchuyenhuongtamtru);
		
		layout.putConstraint(SpringLayout.WEST, jbchuyenhuongthuongtru, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jbchuyenhuongthuongtru, 40, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jbchuyenhuongtamtru, 200, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jbchuyenhuongtamtru, 40, SpringLayout.NORTH, panel);
		
		this.add(panel);
		this.setSize(350, 150);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

	public void chuyenhuongcuasothuongtru() {
		viewMain vM = new viewMain();
		vM.setVisible(true);
		this.dispose();
	}

	public void chuyenhuongcuasotamtru() {
		viewTamTru vTR = new viewTamTru();
		vTR.setVisible(true);
		this.dispose();
	}
}
