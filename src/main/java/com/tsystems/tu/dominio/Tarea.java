package com.tsystems.tu.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entidad Tarea.
 * @author krequena
 *
 */
@Entity
public class Tarea {

	@Id
	@Column(name="id")
	private long id;

	@Column(name="nombre")
	@Size(max=30)
	@NotNull
	private String nombre;

	@Column(name="descripcion")
	@Size(max=200)
	@NotNull
	private String descripcion;

	/**
	 * Constructor de Tarea.
	 * @param id Identificador.
	 * @param nombre Nombre.
	 * @param descripcion Descripción.
	 */
	public Tarea(long id, @Size(max = 30) @NotNull String nombre, @Size(max = 200) @NotNull String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	/**
	 * @return the id
	 */
	public final long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public final String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public final void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the descripcion
	 */
	public final String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public final void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
