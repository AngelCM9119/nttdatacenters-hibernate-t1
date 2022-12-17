package com.nttdata.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable
{

	/** Serial version ID */
	private static final long serialVersionUID = 1L;

	/**
	 * Devuelve el serial id
	 * @return Serial id
	 */
	public abstract long getSerialId();
	
	/**
	 * Establece el serial id
	 */
	public abstract void setSerialId(long id);

	
}
