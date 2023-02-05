package viewTamtru;

public class NamSinhtamtruBean {
	private String nam;
	private int soLuongHocVien;
	
	public String getNam() {
		return nam;
	}
	public void setNam(String nam) {
		this.nam = nam;
	}
	public int getSoLuongHocVien() {
		return soLuongHocVien;
	}
	public void setSoLuongHocVien(int soLuongHocVien) {
		this.soLuongHocVien = soLuongHocVien;
	}
	public NamSinhtamtruBean(String nam, int soLuongHocVien) {
		this.nam = nam;
		this.soLuongHocVien = soLuongHocVien;
	}
	public NamSinhtamtruBean() {
	}
}
