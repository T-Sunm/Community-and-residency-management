package viewTamtru;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThongKeQuan {
public static List<QuanBean> getListByQuan() {
		
        Connection connection = null;
        PreparedStatement statement = null;
        List<QuanBean> list = new ArrayList<>();
        try {
        	
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnk", "root", "");
            
            //query
            String sql = "SELECT quan,COUNT(*) AS soquan FROM nhankhautamtru GROUP BY quan;";
            statement = connection.prepareCall(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
            	QuanBean QuB = new QuanBean();
            	QuB.setQuan(resultSet.getString("quan"));
            	QuB.setSoluong(resultSet.getInt("soquan"));
                list.add(QuB);
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
