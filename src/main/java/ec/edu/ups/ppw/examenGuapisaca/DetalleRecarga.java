package ec.edu.ups.ppw.examenGuapisaca;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class DetalleRecarga {
	@Id
	@GeneratedValue
	private int codigo;
	private int cantidad;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "DetalleRecarga [codigo=" + codigo + ", cantidad=" + cantidad + "]";
	}
	
	
}
