package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable
{

	/** Serial version ID */
	private static final long serialVersionUID = 1L;
	
	/** Campo de auditoría que guardar quien ha actualizado el dato */
	@Column(name = "update_user", nullable = false)
	private String updatedUser;

	/** Campo de auditoría que guardar que día se ha actualizado el dato */
	@Column(name = "update_date", nullable = false)
	private Date updatedDate;

	/**
	 * Devuelve el serial id
	 * @return Serial id
	 */
	public abstract long getSerialId();
	
	/**
	 * Establece el serial id
	 */
	public abstract void setSerialId(long id);

	/**
	 * @return the updatedUser
	 */
	public String getUpdatedUser()
	{
		return updatedUser;
	}

	/**
	 * @param updatedUser the updatedUser to set
	 */
	public void setUpdatedUser(String updatedUser)
	{
		this.updatedUser = updatedUser;
	}

	/**
	 * @return the updatedDate
	 */
	public Date getUpdatedDate()
	{
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate)
	{
		this.updatedDate = updatedDate;
	}
}
