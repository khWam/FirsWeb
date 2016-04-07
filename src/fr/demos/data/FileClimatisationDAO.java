package fr.demos.data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import fr.demos.web.Climatisation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;



import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import fr.demos.web.Climatisation;

public class FileClimatisationDAO implements ClimatisationDAO {

	@Override
	public void sauve(Climatisation cl, String FileName) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Climatisation> listClim = new ArrayList<>();
		
        listClim = (ArrayList<Climatisation>) this.rechercheTout(FileName);
		listClim.add(cl);


		try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(FileName)));){
			oos.writeObject(listClim);
			oos.flush();
		}catch(IOException e){System.out.println(e.getMessage());}
	}

	@Override
	public List<Climatisation> rechercheTout(String FileName) throws Exception {
		
		ArrayList<Climatisation> listClim = new ArrayList<>();
		
		try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(FileName)))){
			listClim =(ArrayList<Climatisation>) ois.readObject();

		}catch(IOException e){System.out.println(e.getMessage());
		}catch(ClassNotFoundException exp){System.out.println(exp.getMessage());}
		return listClim;
	}
	@Override
	public List<Climatisation> recherche(String critere, String FileName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
