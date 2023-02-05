package LoginView;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import view.viewMain;
import view.viewchoose;


public class viewLogin extends JFrame {
	private JLabel TentkLB;
	private JLabel MkLB;
	private JTextField TentkTF;
	private JTextField MkTF;
	private JButton jblOGIN;
	private JButton jbLammoi;
	private JLabel TieudeLB;
	private JButton jbDangky;
	private JButton jbQuenMk;

	public viewLogin() {
		this.init();
	}

	private void init() {
		ActionListener ls = new controllerLogin(this);
		
		this.setTitle("Quản lý Nhân Khẩu");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(400, 200);
		this.setTitle("Đăng nhập");
        Font font = new Font("NewellsHand", Font.PLAIN,30);
		
		TieudeLB = new JLabel("Đăng nhập");
		TieudeLB.setFont(font);
		TentkLB = new JLabel("Tên tài khoản");
		MkLB = new JLabel("Mật khẩu");
		
		TentkTF = new JTextField(20);
		MkTF = new JTextField(20);
		
		jblOGIN = new JButton("Đăng nhập");
		jblOGIN.addActionListener(ls);
		jbLammoi = new JButton("Làm mới");
		jbLammoi.addActionListener(ls);
		jbDangky = new JButton("Chưa có tài khoản");
		jbDangky.addActionListener(ls);
		jbQuenMk = new JButton("Quên mật khẩu");
		jbQuenMk.addActionListener(ls);
		
		SpringLayout layout = new SpringLayout();
		JPanel panel = new JPanel();
	    panel.setSize(300, 300);
	    panel.setLayout(layout);
	    
	    panel.add(TieudeLB);
	    panel.add(TentkLB);
	    panel.add(MkLB);
	    
	    panel.add(TentkTF);
	    panel.add(MkTF);
	    
	    panel.add(jblOGIN);
	    panel.add(jbLammoi);
	    panel.add(jbDangky);
	    panel.add(jbQuenMk);
	    
	    layout.putConstraint(SpringLayout.WEST, TieudeLB, 130, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, TieudeLB, 0, SpringLayout.NORTH, panel);
	    layout.putConstraint(SpringLayout.WEST, TentkLB, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, TentkLB, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, MkLB, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, MkLB, 65, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, TentkTF, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, TentkTF, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, MkTF, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, MkTF, 65, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, jbDangky, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jbDangky, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, jblOGIN, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jblOGIN, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, jbLammoi, 244, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jbLammoi, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, jbQuenMk, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jbQuenMk, 130, SpringLayout.NORTH, panel);
        
	    this.setLocationRelativeTo(null);
		this.add(panel);
		this.setVisible(true); 
	}

	public void dangnhap() {
		try {
			Connection connection = null;
	        PreparedStatement statement = null;
	        ResultSet rs = null;
	        
	        try {
	            //lay tat ca danh sach sinh vien
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dangnhap", "root", "");
	            
	            //query
	            String sql = "select*from acount where username=? and pass=?";
	            
	            // cho phép chỉ định tham số đầu vào khi chạy
	            PreparedStatement ps = connection.prepareCall(sql);
	            
	            ps.setString(1, TentkTF.getText());//nhận tham số khi người dùng nhập vào
	            ps.setString(2,MkTF.getText());
	            rs = ps.executeQuery();//trả về đối tượng khi thực thi câu lệnh 
	            
	            if(TentkTF.getText().equals("") || MkTF.getText().equals("")) {
	            	JOptionPane.showMessageDialog(this,"Chưa nhập thông tin");
	            } else if(rs.next()) {//khi có dữ liệu
	            	viewchoose vc = new viewchoose();
	            	vc.setVisible(true);
	            	this.dispose();
	            	JOptionPane.showMessageDialog(this,"Đăng nhập thành công");
	            	sendEmail(TentkTF.getText());
	            }else {
	            	JOptionPane.showMessageDialog(this,"Đăng nhập thất bại");
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

	public void Taotk() {
		viewTaotk v = new viewTaotk();
    	v.setVisible(true);
    	this.dispose();
		
	}

	public void lammoi() {
		TentkTF.setText("");
		MkTF.setText("");
		
	}
	public void sendEmail(String username) {
		Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dangnhap", "root", "");
            
            //query
            String sql = "select gmail from acount where username like ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            
            final String usernamee = "minhtq.22ds@vku.udn.vn";
    		final String password = "minh11200";

    		Properties prop = new Properties();
    		prop.put("mail.smtp.host", "smtp.gmail.com");
    		prop.put("mail.smtp.port", "587");
    		prop.put("mail.smtp.auth", "true");
    		prop.put("mail.smtp.starttls.enable", "true"); // TLS

    		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
    			protected PasswordAuthentication getPasswordAuthentication() {
    				return new PasswordAuthentication(usernamee, password);
    			}
    		});

    		try {

    			Message message = new MimeMessage(session);
    			
    			message.setFrom(new InternetAddress("minhtq.22ds@vku.udn.vn"));
    			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(resultSet.getString(1)));
    			message.setSubject("He sờ lô hơ sờ ly ly");
    			message.setText("Dear "+TentkTF.getText() + "\n chúc mừng bạn đã đăng nhập thành công"
    					+ "\n\n Please do not spam my email!");

    			Transport.send(message);

    			System.out.println("Done");

    		} catch (MessagingException e) {
    			e.printStackTrace();
    		}
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

	public void chuyenhuongcuasoQuenmk() {
		quenMkview v = new quenMkview();
		v.setVisible(true);
		this.dispose();
	}
}
