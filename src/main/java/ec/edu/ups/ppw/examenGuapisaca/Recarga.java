package ec.edu.ups.ppw.examenGuapisaca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Recarga {
	@Id
	@GeneratedValue
	private int codigo;
	
	private String numero;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="codigoOperadora")
	private Operadora operadora;
	
	private double total;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="codigoOperadora")
	private List<DetalleRecarga> detalles;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Operadora getOperadora() {
		return operadora;
	}

	public void setOperadora(Operadora operadora) {
		this.operadora = operadora;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<DetalleRecarga> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleRecarga> detalles) {
		this.detalles = detalles;
	}
	
	public void addRecarga(DetalleRecarga detalle) {
		if(detalles == null)
			detalles = new ArrayList<DetalleRecarga>();
		detalles.add(detalle);
	}

	@Override
	public String toString() {
		return "Recarga [codigo=" + codigo + ", numero=" + numero + ", operadora=" + operadora + ", total=" + total
				+ ", detalles=" + detalles + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
