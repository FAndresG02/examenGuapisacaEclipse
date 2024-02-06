package ec.edu.ups.ppw.examenGuapisaca.business;

import java.util.List;

import ec.edu.ups.ppw.examenGuapisaca.Operadora;
import ec.edu.ups.ppw.examenGuapisaca.dao.OperadoraDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionOperadoras {
	
	@Inject
	private OperadoraDAO daoOperadora;
	
	public void guardarOperadora(Operadora operadora) {
		Operadora ope = daoOperadora.read(operadora.getCodigo());
		if(ope != null) {
			daoOperadora.update(operadora);
		} else {
			daoOperadora.insert(operadora); 
		}
	}
	
	public void actualizarOperadora(Operadora operadora) throws Exception {
		Operadora ope = daoOperadora.read(operadora.getCodigo());
		if (ope != null){
			daoOperadora.update(operadora);
		}else {
			throw new Exception("Operadora no existe");
		}
	}
	
	public Operadora getOperadoraPorId(int codigo) throws Exception {
		if(codigo < 0) 
			throw new Exception("Id Incorrecto");
		return daoOperadora.getOperadoraPorId(codigo);
	}
	
	public void borrarProductos(int codigo) {
		daoOperadora.remove(codigo); 
	}
	
	public List<Operadora> getOperadoras() {
		return daoOperadora.getAll();
	}
	

}
