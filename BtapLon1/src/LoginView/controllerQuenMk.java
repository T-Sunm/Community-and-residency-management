package LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controllerQuenMk implements ActionListener {
	private quenMkview qmkv;
	public controllerQuenMk(quenMkview v) {
		this.qmkv = v;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Xác nhận")) {
			qmkv.thaydoimk();
		}else if(src.equals("Quay lại")) {
			qmkv.quaylaicuasoDangnhap();
		}
	}
	
}
