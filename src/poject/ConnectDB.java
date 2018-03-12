package poject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectDB {
	
public static Connection getConection(){
	Connection connection=null;
	String url="jdbc:mysql://localhost/employ";
	try {
		connection=DriverManager.getConnection(url, "yasser1", "yasser1");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return connection;
}
public static Connection  connection=ConnectDB.getConection();
public static PreparedStatement preparedStatement=null;
public static int statement=0;
public static String sql =null;



public static int saveData(dataEmployee employee){
	
	 sql ="INSERT INTO `employinfo`(`name`, `email`, `password`, `country`) VALUES (?,?,?,?)";
	try {
	    preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1,employee.getName());
		preparedStatement.setString(2,employee.getEmail());
		preparedStatement.setString(3,employee.getPassword());
		preparedStatement.setString(4,employee.getCountry());
		statement=preparedStatement.executeUpdate();
//		connection.close();
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return statement;
	
}
public static int upData(dataEmployee employee){
	
	String sql ="UPDATE `employinfo` SET `name`=?,`email`=?,`password`=?,`country`=? WHERE id=?";
	
	
	
	try {
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1,employee.getName());
		preparedStatement.setString(2,employee.getEmail());
		preparedStatement.setString(3,employee.getPassword());
		preparedStatement.setString(4,employee.getCountry());
		preparedStatement.setInt(5,employee.getId());
		
		
		preparedStatement.executeUpdate();
//		connection.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return statement;
	
}
public static int delete(int id){
	
	 sql =" DELETE FROM `employinfo` WHERE id=?";
	try {
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1,id);
		preparedStatement.executeUpdate();
//	connection.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return statement;
	
}
public static  dataEmployee getEmployeeId(int id){
	
	dataEmployee dataEmployee=new dataEmployee();
	 sql ="SELECT * FROM `employinfo` WHERE id=?";
	 try {
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet= preparedStatement.executeQuery();
		if (resultSet.next()) {
			dataEmployee.setId(resultSet.getInt(1));
			dataEmployee.setName(resultSet.getString(2));
			dataEmployee.setEmail(resultSet.getString(3));
			dataEmployee.setPassword(resultSet.getString(4));
			dataEmployee.setCountry(resultSet.getString(5));
			}
//	connection.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return dataEmployee;
	
}
public static List<dataEmployee> getEmployee(){
	
	List<dataEmployee>list=new ArrayList<dataEmployee>();
	sql ="SELECT * FROM `employinfo`";
	try {
		preparedStatement=connection.prepareStatement(sql);
		ResultSet resultSet= preparedStatement.executeQuery();
		while (resultSet.next()) {
			dataEmployee dataEmployee=new dataEmployee();
			dataEmployee.setId(resultSet.getInt(1));
			dataEmployee.setName(resultSet.getString(2));
			dataEmployee.setEmail(resultSet.getString(3));
			dataEmployee.setPassword(resultSet.getString(4));
			dataEmployee.setCountry(resultSet.getString(5));
			list.add(dataEmployee);
		}
//		connection.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
	
}



}
