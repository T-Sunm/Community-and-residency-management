package ThongkeDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThongkeGioiTinhDAO {
public List<GioiTinhBean> getListByGioiTinh() {
		
        Connection connection = null;
        PreparedStatement statement = null;
        List<GioiTinhBean> list = new ArrayList<>();
        try {
        	
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnk", "root", "");
            
            //query
            String sql = "SELECT gioitinh,COUNT(*) AS sogioitinh FROM nhankhauu GROUP BY gioitinh;";
            statement = connection.prepareCall(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
            	GioiTinhBean gtB = new GioiTinhBean();
            	gtB.setGioiTinh(resultSet.getString("gioitinh"));
            	gtB.setSogioitinh(resultSet.getInt("sogioitinh"));
                list.add(gtB);
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
        
        return list;
	}
}
