package utils.sql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBaseInterface {

	private String password = "682mex71";
	private String user = "root";
	private String adresse = "10.12.159.157:3306/";

	/**
	 * Interface de la base de donnée, une seule instance de la classe suffit !
	 * @param adresse
	 * @param user
	 * @param password
	 */
	public DataBaseInterface(){

	}

	public void writeRequest(String request){
		String url = this.adresse; 
		String dbName = "nephaliste";					
		String driver = "com.mysql.jdbc.Driver";	
		String userName = this.user;					
		String password = this.password;			
		try {
			Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://"+url+dbName, userName, password);
			Statement st = conn.createStatement();
			st.executeUpdate(request);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> readRequest(String request){
		String url = this.adresse;
		String dbName = "nephaliste";
		String driver = "com.mysql.jdbc.Driver";
		String userName = this.user;
		String password = this.password;

		try {
			Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://"+url+dbName, userName, password);
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery(request);
			ArrayList<String> result = new ArrayList<String>();
			while (res.next()) {
				String msg = res.getString(1);
				result.add(msg.toLowerCase());
			}
			conn.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
