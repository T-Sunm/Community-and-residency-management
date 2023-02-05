package viewTamtru;

public class QuanBean {
	private String Quan;
	private int soluong;
	public String getQuan() {
		return Quan;
	}
	public void setQuan(String quan) {
		Quan = quan;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public QuanBean(String quan, int soluong) {
		Quan = quan;
		this.soluong = soluong;
	}
	public QuanBean() {
	}
}
