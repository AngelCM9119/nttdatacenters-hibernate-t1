package com.nttdata.hibernate.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nttdata.hibernate.common.CommonDaoImpl;
import com.nttdata.hibernate.daoi.ClienteDaoI;
import com.nttdata.hibernate.persistence.Client;

public class ClienteDaoImpl extends CommonDaoImpl<Client> implements ClienteDaoI
{

	public ClienteDaoImpl(Session session)
	{
		super(session);
	}

	// Métodos propios de la tabla clientes
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getByFullname(String name, String lastname1, String lastname2)
	{
		Transaction transaction = checkTransaction();
		String w1 = "name = '"+name+"'";
		String w2 = "lastname1 = '"+lastname1+"'";
		String w3 = "lastname2 = '"+lastname2+"'";
		List<Client> res = session.createQuery("FROM "+entityClass.getName()+" WHERE "+w1+" AND "+w2+" AND "+w3).list();
		closeTransaction(transaction);
				
		return res;
	}	

}
