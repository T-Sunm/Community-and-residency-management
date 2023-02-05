package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.viewchoose;

public class chooseController implements ActionListener {
	public viewchoose v;
	public chooseController(viewchoose v) {
		this.v = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Đăng ký thường trú")) {
			this.v.chuyenhuongcuasothuongtru();
		}else if(src.equals("Đăng ký tạm trú")) {
			this.v.chuyenhuongcuasotamtru();
		}
		
	}

}
