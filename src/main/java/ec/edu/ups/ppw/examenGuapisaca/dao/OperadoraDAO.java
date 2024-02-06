package ec.edu.ups.ppw.examenGuapisaca.dao;

import java.util.List;

import ec.edu.ups.ppw.examenGuapisaca.Operadora;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class OperadoraDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Operadora operadora) {
		em.persist(operadora);
	}
	
	public void update(Operadora operadora) {
		em.merge(operadora);
	}
	
	public void remove(int codigo) {
		Operadora operadora = em.find(Operadora.class, codigo);
		em.remove(operadora);
	}
	
	public Operadora read(int codigo) {
		Operadora operadora = em.find(Operadora.class, codigo);
		return operadora;
	}
	
	public List<Operadora> getAll() {
		String jpql = "SELECT o FROM Operadora o";
		Query q = em.createQuery(jpql, Operadora.class);
		return q.getResultList();
	}
	
	
	public Operadora getOperadoraPorId(int codigo) {
		String jpql = "SELECT o FROM Operadora o WHERE o.codigo = :codigo";
		Query q = em.createQuery(jpql, Operadora.class);
		q.setParameter("codigo", codigo);
		List<Operadora> operadora = q.getResultList();
		if(operadora.size()>0)
			return operadora.get(0);
		return null;
	}
}
