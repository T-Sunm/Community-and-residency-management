package LoginView;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class viewTaotk extends JFrame {
	private JLabel TentkLB;
	private JLabel MkLB;
	private JTextField TentkTF;
	private JTextField MkTF;
	private JButton jblOGIN;
	private JButton jbLammoi;
	private JLabel TieudeLB;
	private JTextField gmailTF;
	private JLabel GmailLb;
	private JLabel XacnhanMkLB;
	private JTextField XacnhanMkTF;
	private JButton jbDangky;

	public viewTaotk() {
		this.init();
	}

	private void init() {
		ActionListener ls = new controllerTaoTK(this);
		
		this.setSize(450,230);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font font = new Font("NewellsHand", Font.PLAIN,30);
		
		TieudeLB = new JLabel("Đăng ký");
		TieudeLB.setFont(font);
		TentkLB = new JLabel("Tên tài khoản");
		GmailLb = new JLabel("Gmail");
		MkLB = new JLabel("Mật khẩu");
		XacnhanMkLB = new JLabel("Xác nhận mật khẩu");
		
		TentkTF = new JTextField(20);
		gmailTF = new JTextField(25);
		MkTF = new JTextField(20);
		XacnhanMkTF = new JTextField(20);
		
		jblOGIN = new JButton("Quay lại");
		jblOGIN.addActionListener(ls);
		jbDangky = new JButton("Đăng ký");
		jbDangky.addActionListener(ls);
		jbLammoi = new JButton("Làm mới");
		jbLammoi.addActionListener(ls);
		
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
	    panel.add(jbLammoi);
	    panel.add(jbDangky);
	    
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
        layout.putConstraint(SpringLayout.WEST, jbDangky, 230, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jbDangky, 150, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, jbLammoi, 320, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jbLammoi, 150, SpringLayout.NORTH, panel);
        
        this.add(panel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}

	public void xoaForm() {
		TentkTF.setText("");
		gmailTF.setText("");
		MkTF.setText("");
		XacnhanMkTF.setText("");
	}

	public void Dangky() {
		int dk = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng ký không");
		if (dk != JOptionPane.YES_OPTION) {
			return;
		}
		try {
			Connection connection = null;
			PreparedStatement statement = null;

			try {
				// lay tat ca danh sach sinh vien
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dangnhap", "root", "");

				// query
				String sql = "insert into acount(username,gmail,pass) values(?, ?, ?)";
				statement = connection.prepareCall(sql);

				if (TentkTF.getText().equals("") || gmailTF.getText().equals("") || MkTF.getText().equals("")
						|| XacnhanMkTF.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "không để thông tin trống");
				} else if (!MkTF.getText().equals(XacnhanMkTF.getText())) {
					JOptionPane.showMessageDialog(this, "Xác nhận mật khẩu không đúng");
				} else {
					statement.setString(1, TentkTF.getText());
					statement.setString(2, gmailTF.getText());
					statement.setString(3, MkTF.getText());
					int n = statement.executeUpdate();// update dữ liệu lên
					JOptionPane.showMessageDialog(this, "Đăng ký thành công");
					sendEmail();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				if (statement != null) {
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

	public void chuyenhuongcuasoDangnhap() {
		viewLogin l = new viewLogin();
		l.setVisible(true);
		//đóng cửa sổ đăng ký và mở cửa sổ đăng nhập
		this.dispose();
	}
	public void sendEmail() {
		final String username = "minhtq.22ds@vku.udn.vn";
		final String password = "minh11200";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress("minhtq.22ds@vku.udn.vn"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(gmailTF.getText()));
			message.setSubject("He sờ lô hơ sờ ly ly");
			message.setText("Dear "+TentkTF.getText() + "\n chúc mừng bạn đã đăng ký thành công"
					+ "\n\n Please do not spam my email!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}