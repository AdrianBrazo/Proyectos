import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDatos {
	public static final String url="192.168.0.225:3306/";
	
	private String cadenaConex;
	private ResultSet rs;
	private Connection cn;
	private int NumTotReg;
	
	public BaseDatos() {
		cadenaConex="jdbc:mysql://"+url+"Alumnado";
		try {
			cn=DriverManager.getConnection(cadenaConex, "almi", "Almi123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getNumTotReg() {
		return NumTotReg;
	}
	public void setNumTotReg(int numTotReg) {
		NumTotReg = numTotReg;
	}
	public ResultSet obtenerAlumnado() {
		String strSent;
		PreparedStatement sent;
		
		strSent="SELECT * FROM Alumnado";
		try {
			sent=cn.prepareStatement(strSent, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=sent.executeQuery();
			//Guardar el numero total de registros
			if(rs.last()) {
				NumTotReg=rs.getRow();
			}else {
				NumTotReg=0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}
	
	public int actualizar(int clave, String nombre, String apellidos, int edad, String direccion, int numero, String cp) {
		PreparedStatement sent;
		String strSent;
		strSent="UPDATE socios SET nombre=?, direccion=?, telefono=?";
		try {
			sent=cn.prepareStatement(strSent);
			sent.setString(1, nombre);
			sent.setString(2, apellidos);
			sent.setInt(3, edad);
			sent.setString(4, direccion);
			sent.setInt(5, numero);
			sent.setString(6, cp);
			sent.setInt(7, clave);
			sent.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		//strSent="UPDATE socios SET nombre='"+nombre+"', direccion='"+direccion+"`', telefono='"+telefono;
		
	}
	
	public int Alta(String nombre, String apellidos, int edad, String direccion, int numero, String cp) {
		String strSent;
		PreparedStatement sentencia;
		strSent="INSERT INTO socio VALUES (NULL,?,?,?,?,?,?)";
		try {
			sentencia=cn.prepareStatement(strSent, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			sentencia.setString(1, nombre);
			sentencia.setString(2, apellidos);
			sentencia.setInt(3, edad);
			sentencia.setString(4, direccion);
			sentencia.setInt(5, numero);
			sentencia.setString(6, cp);
			return sentencia.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
}
