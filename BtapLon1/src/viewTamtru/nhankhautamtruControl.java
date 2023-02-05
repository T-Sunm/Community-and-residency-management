package viewTamtru;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class nhankhautamtruControl implements ActionListener {
	public viewTamTru v;
	public nhankhautamtruControl(viewTamTru v) {
		this.v = v;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		//sử lý sự kiện button
		if(src.equals("Làm mới")) {
			this.v.xoaForm();
		}else if(src.equals("Lưu")) {
			this.v.Save();
		}else if(src.equals("Chỉnh sửa")) {
			this.v.update();
		}else if(src.equals("Xóa")) {
			this.v.thuchienXoa();
		}else if(src.equals("Hủy tìm kiếm")) {
			this.v.showNhankhau();
			this.v.NgayketthucTF1.setText("");
			this.v.CCCDTF1.setText("");
		}else if(src.equals("Tìm kiếm")) {
			this.v.timkiemngayketthuc();
		}else if(src.equals("Tìm kiếm.")) {
			this.v.timkiemtheoccd();
		}else if(src.equals("Lấy")) {
			this.v.hienThiThongTinNhanKhau();
		}else if(src.equals("About me")) {
			this.v.hienthiAbout();
		}else if(src.equals("Exit")) {
			this.v.thoatkhoichuongtrinh();
		}else if(src.equals("Sắp xếp theo Tên")) {
			this.v.thuchienSapxeptheoten();
		}
		else if(src.equals("Thống kê")) {
			this.v.thuchienchuyenhuongThongke();
		}else if(src.equals("Quay lại")) {
			this.v.thuchienchuyenhuongcuasochon();
		}
		
	}

}
