package LoginView;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import view.viewMain;

public class quenMkview extends JFrame {
	private JLabel TieudeLB;
	private JLabel TentkLB;
	private JLabel XacnhanMkLB;
	private JLabel GmailLb;
	private JLabel MkLB;
	private JTextField TentkTF;
	private JTextField gmailTF;
	private JTextField MkTF;
	private JTextField XacnhanMkTF;
	private JButton jblOGIN;
	private JButton jbXacnhan;
	private AbstractButton jbLammoi;

	public quenMkview() {
		this.init();
	}

	private void init() {
		this.setSize(450,230);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font font = new Font("NewellsHand", Font.PLAIN,30);
		
		ActionListener ls = new controllerQuenMk(this);
		
		TieudeLB = new JLabel("Thay đổi mật khẩu");
		TieudeLB.setFont(font);
		TentkLB = new JLabel("Tên tài khoản");
		GmailLb = new JLabel("Gmail");
		MkLB = new JLabel("Mật khẩu mới");
		XacnhanMkLB = new JLabel("Xác nhận mật khẩu");
		
		TentkTF = new JTextField(20);
		gmailTF = new JTextField(25);
		MkTF = new JTextField(20);
		XacnhanMkTF = new JTextField(20);
		
		jblOGIN = new JButton("Quay lại");
		jblOGIN.addActionListener(ls);
		jbXacnhan = new JButton("Xác nhận");
		jbXacnhan.addActionListener(ls);
		
		SpringLayout layout = new SpringLayout();
		JPanel panel = new JPanel();
	    panel.setSize(300, 300);
	    panel.setLayout(layout);
	    
	    panel.add(TieudeLB);
	    panel.add(TentkLB);
	    panel.add(GmailLb);
	    panel.add(MkLB);
	    panel.add(XacnhanMkLB);
	    
	    panel.add(TentkTF);
	    panel.add(gmailTF);
	    panel.add(MkTF);
	    panel.add(XacnhanMkTF);
	    
	    panel.add(jblOGIN);
	    panel.add(jbXacnhan);
	    
	    layout.putConstraint(SpringLayout.WEST, TieudeLB, 130, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, TieudeLB, 0, SpringLayout.NORTH, panel);
	    layout.putConstraint(SpringLayout.WEST, TentkLB, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, TentkLB, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, GmailLb, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, GmailLb, 65, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, MkLB, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, MkLB, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, XacnhanMkLB, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, XacnhanMkLB, 115, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, TentkTF, 120, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, TentkTF, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, gmailTF, 120, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, gmailTF, 65, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, MkTF, 120, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, MkTF, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, XacnhanMkTF, 120, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, XacnhanMkTF, 115, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, jblOGIN, 120, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jblOGIN, 150, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, jbXacnhan, 210, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jbXacnhan, 150, SpringLayout.NORTH, panel);
        
        this.add(panel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
		
	}
	public void thaydoimk() {
		try {
			Connection connection = null;
	        PreparedStatement statement = null;
	        ResultSet rs = null;
	        
	        try {
	            //lay tat ca danh sach sinh vien
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dangnhap", "root", "");
	            
	            //query
	            String sql1 = "select*from acount where username=? and gmail=?";
	            
	            // cho phép chỉ định tham số đầu vào khi chạy
	            PreparedStatement ps = connection.prepareCall(sql1);
	            
	            ps.setString(1, TentkTF.getText());//nhận tham số khi người dùng nhập vào
	            ps.setString(2, gmailTF.getText());
	            rs = ps.executeQuery();//trả về đối tượng khi thực thi câu lệnh 
	            
	            if(TentkTF.getText().equals("") || MkTF.getText().equals("") || XacnhanMkTF.getText().equals("")) {
	            	JOptionPane.showMessageDialog(this,"Chưa nhập thông tin");
	            }else if(!MkTF.getText().equals(XacnhanMkTF.getText())) {
	            	JOptionPane.showMessageDialog(this,"Xác nhận mật khẩu không đúng");
	            }else if(rs.next()) {//khi có dữ liệu
	            	update(MkTF.getText(), TentkTF.getText());
	            	JOptionPane.showMessageDialog(this,"Thay đổi mật khẩu thành công");
	            }else {
	            	JOptionPane.showMessageDialog(this,"Thay đổi mật khẩu thất bại");
	            }
	            
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        } finally {
	            if(statement != null) {
	                try {
	                    statement.close();
	                } catch (SQLException ex) {
	                	ex.printStackTrace();
	                }
	            }
	            
	            if (connection != null) {
	                try {
	                    connection.close();
	                } catch (SQLException ex) {
	                	ex.printStackTrace();
	                }
	            }
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void update(String mk , String tk) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dangnhap", "root", "");
            
            //query
            String sql = "update acount set pass = ?  where username = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1 , mk);
            statement.setString(2, tk );
            statement.execute();
        } catch (SQLException ex) {
        	ex.printStackTrace();
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                	ex.printStackTrace();
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                	ex.printStackTrace();
                }
            }
        }
        //ket thuc.
    }

	public void quaylaicuasoDangnhap() {
		viewLogin vlg = new viewLogin();
		vlg.setVisible(true);
		this.dispose();
	}
}
