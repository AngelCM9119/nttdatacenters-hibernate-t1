package com.nttdata.hibernate.services;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.daoi.ClienteDaoI;
import com.nttdata.hibernate.daoimpl.ClienteDaoImpl;
import com.nttdata.hibernate.persistence.Client;

public class ClientServiceImpl implements ClientServiceI
{
	/** El DAO del cliente */
	private ClienteDaoI dao;

	public ClientServiceImpl(Session session)
	{
		this.dao = new ClienteDaoImpl(session);
	}
	
	@Override
	public void insertClient(final Client client)
	{
		if(client != null && client.getId() == null)
			this.dao.insert(client);
	}

	@Override
	public void updateClient(Client client)
	{
		if(client != null && client.getId() != null)
			this.dao.update(client);
	}

	@Override
	public void deleteClient(Client client)
	{
		if(client != null && client.getId() != null)
			this.dao.delete(client);
	}

	@Override
	public List<Client> getAllClients()
	{
		return this.dao.getAll();
	}

	@Override
	public Client getClientById(final Long id)
	{
		return this.dao.getById(id);
	}

	@Override
	public List<Client> getClientByFullname(String name, String apellido1, String apellido2)
	{
		return this.dao.getByFullname(name, apellido1, apellido2);
	}
	
}
