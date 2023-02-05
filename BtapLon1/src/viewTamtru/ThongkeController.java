package viewTamtru;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class ThongkeController extends JFrame {
	private ThongKeNamSinhDAO thongkeNamsinh = new ThongKeNamSinhDAO();
	private ThongkeGioiTinhDAO thongkeGioitinh = new ThongkeGioiTinhDAO();

	public void setDatetoChart1(JPanel jpnItem) {
		List<NamSinhtamtruBean> listIten = thongkeNamsinh.getListByNamSinh();
		if (listIten != null) {
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (NamSinhtamtruBean nhankhauBean : listIten) {
				dataset.addValue(nhankhauBean.getSoLuongHocVien(), "Học viên", nhankhauBean.getNam());
			}
			JFreeChart chart = ChartFactory.createBarChart("Thống kê độ tuổi", "Năm sinh", "Số lượng", dataset);
			ChartPanel cPn = new ChartPanel(chart);
			JScrollPane chartScrollPane = new JScrollPane(cPn);
			chartScrollPane.setPreferredSize(new Dimension(790, 270));
			
			jpnItem.removeAll();
			jpnItem.add(chartScrollPane);
			jpnItem.validate();
			jpnItem.repaint();

		}
	}
	public void setDatetoChart2(JPanel jpnItem) {
		List<GioiTinhtamtruBean> listIten = thongkeGioitinh.getListByGioiTinh();
		if (listIten != null) {
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (GioiTinhtamtruBean gioiTinhBean : listIten) {
				dataset.addValue(gioiTinhBean.getSogioitinh(),"Giới tính",gioiTinhBean.getGioiTinh());
			} 
			JFreeChart chart = ChartFactory.createBarChart("Thống kê giới tính", "Giới tính", "Số lượng", dataset);
			ChartPanel cPn = new ChartPanel(chart);
			cPn.setPreferredSize(new Dimension(790, 260));

			jpnItem.removeAll();
			jpnItem.add(cPn);
			jpnItem.validate();
			jpnItem.repaint();

		}
	}
	public void setThongKeSoLuong(JPanel jpnItem) {
		List<QuanBean> listIten = ThongKeQuan.getListByQuan();
		if (listIten != null) {
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (QuanBean quanBean : listIten) {
				dataset.addValue(quanBean.getSoluong(),"Quận",quanBean.getQuan());
			} 
			JFreeChart chart = ChartFactory.createBarChart("Thống kê số lượng người trong Quận", "Quận", "Số lượng", dataset);
			ChartPanel cPn = new ChartPanel(chart);
			cPn.setPreferredSize(new Dimension(790, 260));

			jpnItem.removeAll();
			jpnItem.add(cPn);
			jpnItem.validate();
			jpnItem.repaint();

		}
	}
	public void ThongkeControllerr() {
		this.init();
	}
	private void init() {
		JPanel jpTkAge = new JPanel();
		JPanel jpTkGioitinh = new JPanel();
		JPanel jpTKSoLuong = new JPanel();
		ThongkeController th = new ThongkeController();
		this.setLayout(new GridLayout(3, 1));
		this.add(jpTKSoLuong);
		this.add(jpTkAge);
		this.add(jpTkGioitinh);
		this.setTitle("Biểu dồ");
		this.setSize(800, 820);
		this.setLocationRelativeTo(null);
		th.setThongKeSoLuong(jpTKSoLuong);
		th.setDatetoChart1(jpTkAge);
		th.setDatetoChart2(jpTkGioitinh);
		this.setResizable(false);
		this.setVisible(true);
	}
}
