package ec.edu.ups.ppw.examenGuapisaca.business;

import java.util.List;

import ec.edu.ups.ppw.examenGuapisaca.Operadora;
import ec.edu.ups.ppw.examenGuapisaca.dao.OperadoraDAO;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {
	@Inject
	private OperadoraDAO daoOperadora;
	@PostConstruct
	public void init(){
		Operadora operadora = new Operadora();
		
		operadora.setCodigo(1);
		operadora.setNombre("Claro");
		
		daoOperadora.insert(operadora);
		
		operadora = new Operadora();
		operadora.setCodigo(2);
		operadora.setNombre("Movistar");
		
		daoOperadora.insert(operadora);
		
		operadora = new Operadora();
		operadora.setCodigo(3);
		operadora.setNombre("Tuenti");
		
		daoOperadora.insert(operadora);
		
		System.out.println("\n------------- Facturas2");
		List<Operadora> list2 = daoOperadora.getAll();
		for (Operadora fac: list2) {
			System.out.println(fac);
		}
		
	}
}
