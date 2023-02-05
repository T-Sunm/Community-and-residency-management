package ThongkeDemo;

public class GioiTinhBean {
	private String GioiTinh;
	private int sogioitinh;
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public int getSogioitinh() {
		return sogioitinh;
	}
	public void setSogioitinh(int sogioitinh) {
		this.sogioitinh = sogioitinh;
	}
	public GioiTinhBean() {
		// TODO Auto-generated constructor stub
	}
	public GioiTinhBean(String gioiTinh, int sogioitinh) {
		GioiTinh = gioiTinh;
		this.sogioitinh = sogioitinh;
	}
	
}
