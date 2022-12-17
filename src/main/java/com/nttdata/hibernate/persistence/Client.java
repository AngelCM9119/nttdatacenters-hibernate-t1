package com.nttdata.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * Clase que representa a la tabla Clientes en la base de datos
 * @author Ángel
 *
 */
@Entity
@Table(name="clientes")
public class Client extends AbstractEntity implements Serializable
{
	/** Serial version ID */
	private static final long serialVersionUID = 1L;
	
	/** Identificador del cliente */
	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/** Nombre del cliente */
	@Column(name="nombre")
	private String name;
	
	/** Primer apellido del cliente */
	@Column(name="apellido1")
	private String lastname1;
	
	/** Segundo apellido del cliente */
	@Column(name="apellido2")
	private String lastname2;
	
	/** DNI del cliente */
	@Column(name="dni", length = 9, unique = true, nullable = false)
	private String dni;

	@Override
	public long getSerialId()
	{
		return this.id;
	}

	@Override
	public void setSerialId(long id)
	{
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public Long getId()
	{
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the lastname1
	 */
	public String getLastname1()
	{
		return lastname1;
	}

	/**
	 * @param lastname1 the lastname1 to set
	 */
	public void setLastname1(String lastname1)
	{
		this.lastname1 = lastname1;
	}

	/**
	 * @return the lastname2
	 */
	public String getLastname2()
	{
		return lastname2;
	}

	/**
	 * @param lastname2 the lastname2 to set
	 */
	public void setLastname2(String lastname2)
	{
		this.lastname2 = lastname2;
	}

	/**
	 * @return the dni
	 */
	public String getDni()
	{
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni)
	{
		this.dni = dni;
	}

	@Override
	public String toString()
	{
		return "Client [id=" + id + ", nombre=" + name + ", apellido1=" + lastname1 + ", apellido2=" + lastname2 + ", dni=" + dni + "]";
	}
	
	
	
}
