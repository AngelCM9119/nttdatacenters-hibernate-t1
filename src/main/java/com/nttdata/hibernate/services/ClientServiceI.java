package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.Client;

public interface ClientServiceI
{
	/**
	 * Inserta un nuevo cliente
	 * @param client El cliente a insertar
	 */
	public void insertClient(final Client client);
	
	/**
	 * Actualiza un cliente existente
	 * @param client El cliente a actualizar
	 */
	public void updateClient(final Client client);
	
	/**
	 * Elimina un cliente existente
	 * @param client El cliente a eliminar
	 */
	public void deleteClient(final Client client);
	
	/**
	 * Devuelve todos los clientes
	 * @return Una lista con todos los clientes
	 */
	public List<Client> getAllClients();
	
	/**
	 * Devuelve el cliente buscado
	 * @param id El ID del cliente que se quiere buscar
	 * @return Devuelve el cliente si existe. En caso contrario, devuelve null
	 */
	public Client getClientById(final Long id);
	
	/**
	 * Consulta todos los clientes por nombre y apellidos
	 * @param name Nombre del cliente
	 * @param lastname1 Primer apellido
	 * @param lastname2 Segundo apellido
	 * @return Una lista con los clientes obtenidos en la consulta
	 */
	public List<Client> getClientByFullname(final String name, String lastname1, String lastname2);
}
