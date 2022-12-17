package com.nttdata.hibernate.daoi;

import java.util.List;

import com.nttdata.hibernate.common.CommonDaoI;
import com.nttdata.hibernate.persistence.Client;

public interface ClienteDaoI extends CommonDaoI<Client>
{
	/**
	 * Consulta todos los clientes por nombre y apellidos
	 * @param name Nombre del cliente
	 * @param lastname1 Primer apellido
	 * @param lastname2 Segundo apellido
	 * @return Una lista con los clientes obtenidos en la consulta
	 */
	public List<Client> getByFullname(final String name, String lastname1, String lastname2);
}
