package cl.springmvcangular.bo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenciaUsuario")
	@SequenceGenerator(name="sequenciaUsuario", sequenceName = "USUARIO_SEQ", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 5, scale = 0)
	private int id;
	
	@Column(name = "NOMBRE", nullable = false, length = 20)
	private String nombre;
	
	@Column(name = "CONTRASENA", nullable = false, length = 20)
	private String contrasena;
	
	
	@Temporal(TemporalType.TIMESTAMP )
	@Column(name = "FECHAINGRESO", nullable = false, length = 20)
	private Date fechaIngreso;

	
	public Usuario(){}
	
	public Usuario(String nombre,String contrasena){
		this.nombre= nombre;
		this.contrasena = contrasena;
		this.fechaIngreso = new java.sql.Timestamp(new Date().getTime()); 
	}
	
	public Usuario(String nombre){
		this.nombre= nombre;
		this.fechaIngreso = new java.sql.Timestamp(new Date().getTime()); 
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	
}
