package dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.MBeanUserFone;
import singleconnections.SingleConnectionsJDBC;

public class MBeanUserFoneDAO {
	private Connection connection;	
	
	
	
	public MBeanUserFoneDAO() {
		connection = SingleConnectionsJDBC.getConnection();
	}



	public ArrayList<MBeanUserFone> getListUserFone(Long UIDUser){
		
		ArrayList<MBeanUserFone> listMbeanUserFone= new ArrayList<MBeanUserFone>();
		String sql = " SELECT name, type, number FROM usercursojava u";
		sql += " inner join fonecursojava f on u.id=f.user_id";
		sql += " where u.id="+UIDUser;
		 
		 try {
			PreparedStatement select = connection.prepareStatement(sql);
			ResultSet result = select.executeQuery();
			
			while(result.next()) {
				MBeanUserFone MBeanUserFone  = new MBeanUserFone();
				MBeanUserFone.setType(result.getString("type"));
				MBeanUserFone.setNumber(result.getString("number"));
				MBeanUserFone.setName(result.getString("name"));
				listMbeanUserFone.add(MBeanUserFone);
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 return listMbeanUserFone;
	}

}
