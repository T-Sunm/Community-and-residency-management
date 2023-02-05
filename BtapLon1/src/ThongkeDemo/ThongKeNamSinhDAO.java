package ThongkeDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ThongKeNamSinhDAO {


	public List<NamsinhBean> getListByNamSinh() {
		
        Connection connection = null;
        PreparedStatement statement = null;
        List<NamsinhBean> list = new ArrayList<>();
        try {
        	
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnk", "root", "");
            
            //query
            String sql = "SELECT YEAR(birth) AS YEAR,COUNT(*) AS so_luong FROM nhankhauu GROUP BY YEAR";
            statement = connection.prepareCall(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                NamsinhBean nkB = new NamsinhBean();
                nkB.setNam(resultSet.getString("YEAR"));
                nkB.setSoLuongHocVien((resultSet.getInt("so_luong")));
                list.add(nkB);
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
