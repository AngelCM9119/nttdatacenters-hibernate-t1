package com.nttdata.hibernate;

import java.util.Date;

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
    	
    	// datos de auditoria
    	String user = "ACM";
    	Date date = new Date();
    	
    	Client c1 = new Client();
    	c1.setName("Angel");
    	c1.setLastname1("Calle");
    	c1.setLastname2("Martin");
    	c1.setDni("12345678B");
    	c1.setUpdatedUser(user);
    	c1.setUpdatedDate(date);
    	
    	Client c2 = new Client();
    	c2.setName("Manuel");
    	c2.setLastname1("Gutierrez");
    	c2.setLastname2("Carmona");
    	c2.setDni("98765432C");
    	c2.setUpdatedUser(user);
    	c2.setUpdatedDate(date);
    	
    	Client c3 = new Client();
    	c3.setName("Maite");
    	c3.setLastname1("Figueroa");
    	c3.setLastname2("Espinosa");
    	c3.setDni("11111111D");
    	c3.setUpdatedUser(user);
    	c3.setUpdatedDate(date);
    	
    	clientService.insertClient(c1);
    	clientService.insertClient(c2);
    	clientService.insertClient(c3);
    	
    	clientService.deleteClient(c2);
    	
    	c1.setDni("99999999X");
    	clientService.updateClient(c1);
    	
    	System.out.println("cliente: "+clientService.getClientById(1L));
    	System.out.println("clientes: "+clientService.getAllClients());
    	System.out.println("cliente: "+clientService.getClientByFullname("Maite", "Figueroa", "Espinosa"));
    	
    	session.close();    	
    }
}
