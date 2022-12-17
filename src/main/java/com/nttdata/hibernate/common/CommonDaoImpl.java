package com.nttdata.hibernate.common;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Session;

import com.nttdata.hibernate.persistence.AbstractEntity;

/**
 * 
 * 
 * @author Angel
 * @param <T>
 */
public abstract class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T>
{
	/** Sesión de conexión a la base de datos */
	protected Session session;
	
	/** Tipo de la clase de la entidad */
	protected Class<T> entityClass;
	
	
	/**
	 * Constructor de la clase
	 * @param session Sesión de conexión a la base de datos
	 */
	@SuppressWarnings("unchecked")
	public CommonDaoImpl(Session session)
	{
		this.session = session;
		setEntityClass((Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);		
	}
	
	@Override
	public Transaction checkTransaction()
	{
		Transaction transaction = this.session.getTransaction();
		
		if (!transaction.isActive()) {
			transaction.begin();
		}
		
		return transaction;
	}
	
	@Override
	public void closeTransaction(Transaction transaction)
	{
		session.flush();
		transaction.commit();
	}
	
	@Override
	public void insert(T entity)
	{
		Transaction transaction = checkTransaction();
		session.save(entity); // inserta la tupla
		closeTransaction(transaction);		
	}
	
	@Override
	public void update(T entity)
	{
		Transaction transaction = checkTransaction();
		session.update(entity); // actualiza la tupla
		closeTransaction(transaction);
	}
	
	@Override
	public void delete(T entity)
	{
		Transaction transaction = checkTransaction();
		session.delete(entity); // elimina la tupla
		closeTransaction(transaction);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll()
	{
		Transaction transaction = checkTransaction();
		List<T> res = session.createQuery("FROM "+entityClass.getName()).list();
		closeTransaction(transaction);
		
		return res;
	}
	
	@Override
	public T getById(Long id)
	{
		Transaction transaction = checkTransaction();
		T res = session.get(entityClass, id);
		closeTransaction(transaction);
		
		return res;
	}

	/**
	 * Devuelve el tipo de la clase de la entidad
	 * @return El tipo de la clase de la entidad
	 */
	public Class<T> getEntityClass()
	{
		return entityClass;
	}

	/**
	 * Establece el tipo de la clase de la entidad
	 * @param entityClass El tipo de la clase de la entidad
	 */
	public void setEntityClass(Class<T> entityClass)
	{
		this.entityClass = entityClass;
	}
	
	

}
