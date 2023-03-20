package it.polito.tdp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.libretto.model.Voto;

public class VotoDAO {
	
	// CRUD Create Read Update Delete List Search (CRUL)
	
	public List<Voto> listVoti() {
		
		List<Voto> voti = new ArrayList<Voto>();
		
		try {
			Connection conn = DBConnect.getConnection();
			
			Statement st = conn.createStatement();
			
			String sql = "SELECT corso,punti,data "
					+ "FROM voto";
			
			ResultSet res = st.executeQuery(sql);
			
			while(res.next()) {
				String corso = res.getString("corso");
				int punti = res.getInt("punti");
				LocalDate data = res.getDate("data").toLocalDate();
				
				Voto v = new Voto(corso,punti,data);
				voti.add(v);
			}
			conn.close();
			
			return voti;
		}
		catch (SQLException e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void createVoto(Voto v) {

		String sql = "INSERT INTO `voto` (`corso`, `punti`, `data`) VALUES (?, ?, ?)";

		Connection conn;
		try {
			conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,v.getCorso());
			st.setInt(2, v.getPunti());
			//st.setDate(3, new Date(v.getDataEsame()));
			
			
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/*
	public Voto readVoto(String corso) {
		
	}
	
	public List<Voto> searchVotoPuntiMaggiore(int punti) {
		
	}
*/
}
