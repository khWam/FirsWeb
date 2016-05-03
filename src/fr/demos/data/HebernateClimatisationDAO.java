package fr.demos.data;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;

import fr.demos.web.Climatisation;

public class HebernateClimatisationDAO implements ClimatisationDAO {

	@PersistenceContext
	private EntityManager em;
	@Resource
	private UserTransaction ut;

	@Override
	public void sauve(Climatisation cl) throws Exception {
		ut.begin();
		em.persist(cl);
		ut.commit();
	}

	@Override
	public List<Climatisation> rechercheTout() throws Exception {
		String query="select cl from Climatisation cl";
		TypedQuery<Climatisation> q= em.createQuery(query, Climatisation.class);
		List<Climatisation> listeClims =q.getResultList();
		return listeClims;
	}

	@Override
	public List<Climatisation> recherche(String critere) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nombre(String criter) {
		// TODO Auto-generated method stub
		return 0;
	}

}
