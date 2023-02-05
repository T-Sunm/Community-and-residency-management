package LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controllerLogin implements ActionListener {
	private viewLogin vLogin;
	
	public controllerLogin(viewLogin v ) {
		this.vLogin = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String srcLogin = e.getActionCommand();
		if(srcLogin.equals("Đăng nhập")) {
			vLogin.dangnhap();
		} else if(srcLogin.equals("Chưa có tài khoản")) {
			vLogin.Taotk();
		}else if(srcLogin.equals("Làm mới")) {
			vLogin.lammoi();
		}else if(srcLogin.equals("Quên mật khẩu")) {
			vLogin.chuyenhuongcuasoQuenmk();
		}
	}
	
}
