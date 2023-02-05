package model;


public class NhanKhau {
	private String SoHoKhau;
	private String HoTen;
	private String GioiTinh;
	private String Birth;
	private String CCCD;
	private String DiaChi;
	private String NgheNghiep;
	private String DanToc;
	private String QuanHuyen;
	private String ten;
	
	public NhanKhau(String soHoKhau, String hoTen,String ten, String gioiTinh, String birth, String cCCD, String diaChi,String QuanHuyen,String ngheNghiep, String danToc) {
		SoHoKhau = soHoKhau;
		HoTen = hoTen;
		this.ten = ten;
		GioiTinh = gioiTinh;
		Birth = birth;
		CCCD = cCCD;
		DiaChi = diaChi;
		this.QuanHuyen = QuanHuyen;
		NgheNghiep = ngheNghiep;
		DanToc = danToc;
	}
	public NhanKhau(String soHoKhau, String hoTen,String ten, String gioiTinh, String birth, String cCCD, String diaChi,String ngheNghiep, String danToc) {
		SoHoKhau = soHoKhau;
		HoTen = hoTen;
		this.ten = ten;
		GioiTinh = gioiTinh;
		Birth = birth;
		CCCD = cCCD;
		DiaChi = diaChi;
		NgheNghiep = ngheNghiep;
		DanToc = danToc;
	}
	public NhanKhau() {
	}
	public String getSoHoKhau() {
		return SoHoKhau;
	}
	public String getQuanHuyen() {
		return QuanHuyen;
	}
	public void setQuanHuyen(String quanHuyen) {
		QuanHuyen = quanHuyen;
	}
	public void setSoHoKhau(String soHoKhau) {
		SoHoKhau = soHoKhau;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getBirth() {
		return Birth;
	}
	public void setBirth(String birth) {
		Birth = birth;
	}
	public String getCCCD() {
		return CCCD;
	}
	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getNgheNghiep() {
		return NgheNghiep;
	}
	public void setNgheNghiep(String ngheNghiep) {
		NgheNghiep = ngheNghiep;
	}
	public String getDanToc() {
		return DanToc;
	}
	public void setDanToc(String danToc) {
		DanToc = danToc;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	
}
