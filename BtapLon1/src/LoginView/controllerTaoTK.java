package LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controllerTaoTK implements ActionListener {
	public viewTaotk vTTK;
	public controllerTaoTK(viewTaotk vTTK ) {
		this.vTTK = vTTK;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String srcTaoTk = e.getActionCommand();
		if(srcTaoTk.equals("Làm mới")) {
			vTTK.xoaForm();
		}else if(srcTaoTk.equals("Đăng ký")) {
			vTTK.Dangky();
		}else if(srcTaoTk.equals("Quay lại")) {
			vTTK.chuyenhuongcuasoDangnhap();
		}
	}
	
}
