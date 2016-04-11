package fr.demos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import fr.demos.web.Climatisation;

public class SQLClimatisationDAO implements ClimatisationDAO{

	private DataSource ds=null;
	private String sqlBaseName="";

	public SQLClimatisationDAO(String sqlBaseName) throws Exception {
		// il faut utiliser ça comme sqlBaseName "jdbc/appliclim"
		super();
		Context context = new InitialContext();
		this.sqlBaseName = sqlBaseName;
		this.ds = (DataSource) context.lookup(this.sqlBaseName);
	}

	@Override
	public void sauve(Climatisation cl) throws Exception {
		// On demande une connexion au pool
		Connection cx = ds.getConnection();
		//On va pouvoir preparer notre requette SQL
		PreparedStatement psmt = cx.prepareStatement("insert into climatisation values (?,?,?,?,?)");

		psmt.setDouble(1, cl.getTemperature());
		psmt.setDouble(2, cl.getPression());
		psmt.setInt(3, cl.getHumidite());
		psmt.setString(4, cl.getNomAppareil());
		psmt.setLong(5, cl.getDatation());
		psmt.executeUpdate();

		//on rend la connexion
		cx.close();
	}

	@Override
	public List<Climatisation> rechercheTout() throws Exception {
		Connection cx =ds.getConnection();
		PreparedStatement psmt = cx.prepareStatement("select * from climatisation");
		ResultSet rs = psmt.executeQuery();
		ArrayList<Climatisation> listClim = new ArrayList<>();
		while(rs.next()){
			Double maTemperature = rs.getDouble(1);
			Double maPression = rs.getDouble(2);		
			int maHumidite =rs.getInt(3);
			String nomAppareil =rs.getString(4);
			long maDate = rs.getLong(5);

			Climatisation clim = new Climatisation(maTemperature,maPression,maHumidite,nomAppareil,maDate);
			listClim.add(clim);

		}
		return listClim;
	}

	@Override
	public List<Climatisation> recherche(String critere) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nombre(String criter) {
		int nb =0;
		try{
			List<Climatisation> listClim = this.rechercheTout();
			nb=listClim.size();
		}catch(Exception e){}

		return nb;
	}

}
