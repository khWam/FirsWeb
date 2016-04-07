package fr.demos.data;

import java.util.List;

import fr.demos.web.Climatisation;

//DAO: Data Access Object
public interface ClimatisationDAO {
	
	void sauve (Climatisation cl, String FileName) throws Exception;
	List<Climatisation> rechercheTout(String FileName) throws Exception;
	List<Climatisation> recherche (String critere, String Filename) throws Exception;
	
}
