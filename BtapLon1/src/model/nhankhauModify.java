package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class nhankhauModify {
	public static List<NhanKhau> findAll() {
        List<NhanKhau> nhankhauList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnk", "root", "");
            
            //query
            String sql = "select * from nhankhauu";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            //thêm dữ liệu vào table
            while (resultSet.next()) {                
                NhanKhau nk = new NhanKhau(resultSet.getString("sohokhau"), 
                        resultSet.getString("hoten"),resultSet.getString("ten") ,resultSet.getString("gioitinh"),resultSet.getString("birth"),
                        resultSet.getString("cccd"), resultSet.getString("diachi")+","+resultSet.getString("quan"), 
                        resultSet.getString("nghenghiep"),resultSet.getString("dantoc")
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
    
    public static void insert(NhanKhau nk) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnk", "root", "");
            
            //query
            String sql = "insert into nhankhauu(sohokhau, hoten, ten,gioitinh,birth,cccd,diachi,quan,nghenghiep,dantoc) values(?, ?,?, ?, ?,?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, nk.getSoHoKhau());
            statement.setString(2, nk.getHoTen());
            statement.setString(3, nk.getTen());
            statement.setString(4, nk.getGioiTinh());
            statement.setString(5, nk.getBirth());
            statement.setString(6, nk.getCCCD());
            statement.setString(7, nk.getDiaChi());
            statement.setString(8, nk.getQuanHuyen());
            statement.setString(9, nk.getNgheNghiep());
            statement.setString(10, nk.getDanToc());
            
            statement.execute();
        } catch (SQLException ex) {
        	JOptionPane.showMessageDialog(null, "Hãy bấm qua nút chỉnh sửa", "Bấm nhầm nút", JOptionPane.INFORMATION_MESSAGE);
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
    
    public static void update(NhanKhau nk) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnk", "root", "");
            
            //query
            String sql = "update nhankhauu set hoten=?,ten=?,gioitinh=?,birth=?,sohokhau=?,diachi=?,quan=?,nghenghiep=?,dantoc=? where cccd = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(5, nk.getSoHoKhau());
            statement.setString(1, nk.getHoTen());
            statement.setString(2, nk.getTen());
            statement.setString(3, nk.getGioiTinh());
            statement.setString(4, nk.getBirth());
            statement.setString(10, nk.getCCCD());
            statement.setString(6, nk.getDiaChi());
            statement.setString(7, nk.getQuanHuyen());
            statement.setString(8, nk.getNgheNghiep());
            statement.setString(9, nk.getDanToc());
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
    
    public static void delete(String cccd) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnk", "root", "");
            
            //query
            String sql = "delete from nhankhauu where cccd  = ?";
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
    
    public static List<NhanKhau> findBysohokhau(String sohokhau) {
        List<NhanKhau> nhankhauList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnk", "root", "");
            
            //query
            String sql = "select * from nhankhauu where sohokhau like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+sohokhau+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                NhanKhau nk = new NhanKhau(resultSet.getString("sohokhau"), 
                        resultSet.getString("hoten"),resultSet.getString("ten"), resultSet.getString("gioitinh"),resultSet.getString("birth"),
                        resultSet.getString("cccd"), resultSet.getString("diachi")+","+resultSet.getString("quan"), resultSet.getString("nghenghiep"),resultSet.getString("dantoc")
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
    public static List<NhanKhau> findBycccd(String cccd) {
        List<NhanKhau> nhankhauList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnk", "root", "");
            
            //query
            String sql = "select * from nhankhauu where cccd like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+cccd+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                NhanKhau nk = new NhanKhau(resultSet.getString("sohokhau"), 
                        resultSet.getString("hoten"),resultSet.getString("ten"), resultSet.getString("gioitinh"),resultSet.getString("birth"),
                        resultSet.getString("cccd"), resultSet.getString("diachi")+","+resultSet.getString("quan"), resultSet.getString("nghenghiep"),resultSet.getString("dantoc")
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
            String sql = "SELECT quan FROM nhankhauu WHERE cccd = ?";
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
