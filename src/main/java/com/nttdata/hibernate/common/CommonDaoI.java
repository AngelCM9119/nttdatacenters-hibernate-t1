package com.nttdata.hibernate.common;

import java.util.List;

import org.hibernate.Transaction;

/**
 * Contiene los métodos para hacer las operaciones CRUD con la base de datos
 * 
 * @author Angel
 * @param <T>
 */
public interface CommonDaoI<T>
{
	/**
	 * Comprueba si hay una transacción activa. En caso de que no la haya, crea una nueva
	 * @param session La sesión abierta en la base de datos
	 * @return La transacción activa
	 */
	public Transaction checkTransaction();
	
	/**
	 * Termina la transaccion
	 * @param transaction La transacción que va a terminar
	 */
	public void closeTransaction(Transaction transaction);
	
	/**
	 * Inserta la tupla en la base de datos
	 * @param entity
	 */
	public void insert(final T entity);
	
	/**
	 * Actualiza la tupla en la base de datos
	 * @param entity
	 */
	public void update(final T entity);
	
	/**
	 * Elimina la tupla en la base de datos
	 * @param entity
	 */
	public void delete(final T entity);
	
	/**
	 * Consulta todas las tuplas de la tabla
	 */
	public List<T> getAll();
	
	/**
	 * Consulta una tupla de la tabla por su id
	 * @param id Identificador por el que se va a consultar el dato
	 */
	public T getById(final Long id);
}
