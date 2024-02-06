package ec.edu.ups.ppw.examenGuapisaca;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Operadora" )
public class Operadora {
	@Id
	private int codigo;
	private String nombre;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Operadora [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
	
}
