package viewTamtru;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class nhankhauTamtruModify {
	public static List<nhankhautamtru> findAll() {
        List<nhankhautamtru> nhankhauList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnk", "root", "");
            
            //query
            String sql = "select * from nhankhautamtru";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            //thêm dữ liệu vào table
            while (resultSet.next()) {                
                nhankhautamtru nk = new nhankhautamtru(resultSet.getString("hotennguoidangky"),resultSet.getString("ten"),resultSet.getString("birth"), resultSet.getString("gioitinh"),
                        resultSet.getString("cccd"), resultSet.getString("noitamtru")+","+resultSet.getString("quan"), 
                        resultSet.getString("nghenghiep"),resultSet.getString("sdt"),resultSet.getString("hotenchuho"),resultSet.getString("quanhevoichuho"),
                        resultSet.getString("cccdchuho"),resultSet.getString("ngaydangky"),resultSet.getString("ngayketthuc")
                        );
                nhankhauList.add(nk);
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
        //ket thuc.
        
        return nhankhauList;
    }
    
    public static void insert(nhankhautamtru nk) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnk", "root", "");
            
            //query
            String sql = "insert into nhankhautamtru(hotennguoidangky,ten,Birth,gioitinh,cccd,sdt,noitamtru,quan,nghenghiep,hotenchuho,quanhevoichuho,cccdchuho,ngaydangky,ngayketthuc) values(?,? ,?, ?, ?,?, ?, ?, ?, ?,?,?,?,?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, nk.getHoTen());
            statement.setString(2, nk.getTen());
            statement.setString(4, nk.getGioiTinh());
            statement.setString(3, nk.getBirth());
            statement.setString(5, nk.getCCCD());
            statement.setString(6, nk.getSdt());
            statement.setString(7, nk.getDiaChiTamT());
            statement.setString(8, nk.getQuanHuyen());
            statement.setString(9, nk.getNgheNghiep());
            statement.setString(10, nk.getHoTenchuho());
            statement.setString(11, nk.getQuanhechuho());
            statement.setString(12, nk.getCccdchuho());
            statement.setString(13, nk.getNgaydangky());
            statement.setString(14, nk.getNgayketthuc());
            
            statement.execute();
        } catch (SQLException ex) {
        	JOptionPane.showMessageDialog(null, "Lưu thất bại", "Cảnh cáo", JOptionPane.INFORMATION_MESSAGE);
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
    
    public static void update(nhankhautamtru nk) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnk", "root", "");
            
            //query
            String sql = "update nhankhautamtru set hotennguoidangky=?,ten=?,Birth=?,gioitinh=?,sdt=?,noitamtru=?,quan=?,nghenghiep=?,hotenchuho=?,quanhevoichuho = ?,cccdchuho=?,ngaydangky=?,ngayketthuc=? where cccd = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, nk.getHoTen());
            statement.setString(2, nk.getTen());
            statement.setString(4, nk.getGioiTinh());
            statement.setString(3, nk.getBirth());
            statement.setString(14, nk.getCCCD());
            statement.setString(5, nk.getSdt());
            statement.setString(6, nk.getDiaChiTamT());
            statement.setString(7, nk.getQuanHuyen());
            statement.setString(8, nk.getNgheNghiep());
            statement.setString(9, nk.getHoTenchuho());
            statement.setString(10, nk.getQuanhechuho());
            statement.setString(11, nk.getCccdchuho());
            statement.setString(12, nk.getNgaydangky());
            statement.setString(13, nk.getNgayketthuc());
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
                	JOptionPane.showMessageDialog(null, "Cập nhật thất bại", "Cảnh cáo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        //ket thuc.
    }
    
    public static void delete(String cccd) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnk", "root", "");
            
            //query
            String sql = "delete from nhankhautamtru where cccd  = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, cccd);
            
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
    
    public static List<nhankhautamtru> findByngayketthuc(String ngayketthuc) {
        List<nhankhautamtru> nhankhauList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnk", "root", "");
            
            //query
            String sql = "select * from nhankhautamtru where ngayketthuc = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1,ngayketthuc);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
            	 nhankhautamtru nk = new nhankhautamtru(resultSet.getString("hotennguoidangky"),resultSet.getString("ten") ,resultSet.getString("gioitinh"),resultSet.getString("Birth"),
                         resultSet.getString("cccd"), resultSet.getString("noitamtru")+","+resultSet.getString("quan"), 
                         resultSet.getString("nghenghiep"),resultSet.getString("sdt"),resultSet.getString("hotenchuho"),resultSet.getString("quanhevoichuho"),
                         resultSet.getString("cccdchuho"),resultSet.getString("ngaydangky"),resultSet.getString("ngayketthuc")
                         );
                nhankhauList.add(nk);
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        } finally {
            try {
				if(statement != null) {
				     statement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
        
        return nhankhauList;
    }
    public static List<nhankhautamtru> findBycccd(String cccd) {
        List<nhankhautamtru> nhankhauList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnk", "root", "");
            
            //query
            String sql = "select * from nhankhautamtru where cccd= ?";
            statement = connection.prepareCall(sql);
            statement.setString(1,cccd);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
            	nhankhautamtru nk = new nhankhautamtru(resultSet.getString("hotennguoidangky"),resultSet.getString("ten") ,resultSet.getString("gioitinh"),resultSet.getString("Birth"),
                        resultSet.getString("cccd"), resultSet.getString("noitamtru")+","+resultSet.getString("quan"), 
                        resultSet.getString("nghenghiep"),resultSet.getString("sdt"),resultSet.getString("hotenchuho"),resultSet.getString("quanhevoichuho"),
                        resultSet.getString("cccdchuho"),resultSet.getString("ngaydangky"),resultSet.getString("ngayketthuc")
                        );
                nhankhauList.add(nk);
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        } finally {
            try {
				if(statement != null) {
				     statement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
        
        return nhankhauList;
    }
    public static String getquequan(String cccd) {
        String quequan = "";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnk", "root", "");
            
            //query
            String sql = "SELECT quan FROM nhankhautamtru WHERE cccd = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, cccd);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                String s = resultSet.getString("quan");
                quequan = s;
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        } finally {
            try {
				if(statement != null) {
				     statement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
        
        return quequan;
    }
}
