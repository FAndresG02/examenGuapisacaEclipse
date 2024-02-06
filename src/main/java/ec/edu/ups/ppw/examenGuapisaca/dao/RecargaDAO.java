package ec.edu.ups.ppw.examenGuapisaca.dao;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.ppw.examenGuapisaca.Recarga;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class RecargaDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Recarga recarga) {
		em.persist(recarga);
	}
	
	public void update(Recarga recarga) {
		em.merge(recarga);
	}
	
	public void remove(int codigo) {
		Recarga recarga = em.find(Recarga.class, codigo);
		em.refresh(recarga);
	}
	
	public Recarga read(int codigo) {
		Recarga recarga = em.find(Recarga.class, codigo);
		return recarga;
	}
	
	public List<Recarga> getAll() {
		String jpql = "SELECT r FROM Recarga r";
		Query q = em.createQuery(jpql, Recarga.class);
		return q.getResultList();
	}
	
	
}
