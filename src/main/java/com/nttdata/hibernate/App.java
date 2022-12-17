package com.nttdata.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nttdata.hibernate.persistence.Client;
import com.nttdata.hibernate.services.ClientServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args)
    {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
    	Session session = factory.openSession();
    	
    	ClientServiceImpl clientService = new ClientServiceImpl(session);
    	
    	Client c1 = new Client();
    	c1.setName("Angel");
    	c1.setLastname1("Calle");
    	c1.setLastname2("Martin");
    	c1.setDni("12345678B");
    	
    	Client c2 = new Client();
    	c2.setName("Manuel");
    	c2.setLastname1("Gutierrez");
    	c2.setLastname2("Carmona");
    	c2.setDni("98765432C");
    	
    	clientService.insertClient(c1);
    	clientService.insertClient(c2);
    	
    	System.out.println("cliente: "+clientService.getClientById(2L));
    	System.out.println("clientes: "+clientService.getAllClients());
    	System.out.println("cliente: "+clientService.getClientByFullname("Manuel", "Gutierrez", "Carmona"));
    	
    	session.close();    	
    }
}
