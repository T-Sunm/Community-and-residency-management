package viewTamtru;

public class nhankhautamtru {
	private String HoTen;
	private String GioiTinh;
	private String Birth;
	private String CCCD;
	private String sdt;
	private String DiaChiTamT;
	private String NgheNghiep;
	private String HoTenchuho;
	private String quanhechuho;
	private String cccdchuho;
	private String ngaydangky;
	private String ngayketthuc;
	private String ten;
	public nhankhautamtru(String hoTen,String ten, String birth, String gioiTinh,String cCCD,String sdt,String diaChiTamT,String quanHuyen,
			String ngheNghiep,String hoTenchuho, String quanhechuho, String cccdchuho,
			String ngaydangky, String ngayketthuc) {
		HoTen = hoTen;
		GioiTinh = gioiTinh;
		Birth = birth;
		CCCD = cCCD;
		this.sdt = sdt;
		DiaChiTamT = diaChiTamT;
		NgheNghiep = ngheNghiep;
		HoTenchuho = hoTenchuho;
		this.quanhechuho = quanhechuho;
		this.cccdchuho = cccdchuho;
		this.ngaydangky = ngaydangky;
		this.ngayketthuc = ngayketthuc;
		QuanHuyen = quanHuyen;
		this.setTen(ten);
	}
	public nhankhautamtru(String hoTen,String ten,String birth, String gioiTinh, String cCCD, String sdt,
			String diaChiTamT, String ngheNghiep, String hoTenchuho, String quanhechuho, String cccdchuho,
			String ngaydangky, String ngayketthuc) {
		HoTen = hoTen;
		GioiTinh = gioiTinh;
		Birth = birth;
		CCCD = cCCD;
		this.sdt = sdt;
		DiaChiTamT = diaChiTamT;
		NgheNghiep = ngheNghiep;
		HoTenchuho = hoTenchuho;
		this.quanhechuho = quanhechuho;
		this.cccdchuho = cccdchuho;
		this.ngaydangky = ngaydangky;
		this.ngayketthuc = ngayketthuc;
		this.ten = ten;
	}
	
	private String QuanHuyen;
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
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiaChiTamT() {
		return DiaChiTamT;
	}
	public void setDiaChiTamT(String diaChiTamT) {
		DiaChiTamT = diaChiTamT;
	}
	public String getNgheNghiep() {
		return NgheNghiep;
	}
	public void setNgheNghiep(String ngheNghiep) {
		NgheNghiep = ngheNghiep;
	}
	public String getHoTenchuho() {
		return HoTenchuho;
	}
	public void setHoTenchuho(String hoTenchuho) {
		HoTenchuho = hoTenchuho;
	}
	public String getQuanhechuho() {
		return quanhechuho;
	}
	public void setQuanhechuho(String quanhechuho) {
		this.quanhechuho = quanhechuho;
	}
	public String getCccdchuho() {
		return cccdchuho;
	}
	public void setCccdchuho(String cccdchuho) {
		this.cccdchuho = cccdchuho;
	}
	public String getNgaydangky() {
		return ngaydangky;
	}
	public void setNgaydangky(String ngaydangky) {
		this.ngaydangky = ngaydangky;
	}
	public String getNgayketthuc() {
		return ngayketthuc;
	}
	public void setNgayketthuc(String ngayketthuc) {
		this.ngayketthuc = ngayketthuc;
	}
	public String getQuanHuyen() {
		return QuanHuyen;
	}
	public void setQuanHuyen(String quanHuyen) {
		QuanHuyen = quanHuyen;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	
}
