package com.tsystems.tu.dao;

import java.util.List;

import com.tsystems.tu.exceptions.DaoException;

/**
 * Interfaz de DAO genérico.
 * 
 * @author krequena
 *
 */
public interface IDao<K> {
	/**
	 * Método que obtiene una instancia de una entidad a partir de su id.
	 * 
	 * @param id Identificador de la entidad.
	 * @return Instancia.
	 * @throws DaoException Excepción.
	 */
	K obtenerPorId(long id) throws DaoException;

	/**
	 * Método que obtiene todas las instancias de una entidad.
	 * 
	 * @return Lista de instancias.
	 * @throws DaoException Excepción.
	 */
	List<K> obtenerTodos() throws DaoException;

	/**
	 * Método que inserta una instancia de una entidad.
	 * 
	 * @param instancia Instancia a insertar.
	 * @throws DaoException Excepción.
	 */
	void insertar(K instancia) throws DaoException;

	/**
	 * Método que modifica una instancia de una entidad.
	 * 
	 * @param instancia Instancia a modificar.
	 * @throws DaoException Excepción.
	 */
	void modificar(K instancia) throws DaoException;

	/**
	 * Método que elimina una instancia de una entidad.
	 * 
	 * @param id Identificador de la entidad.
	 * @throws DaoException Excepción.
	 */
	void eliminar(long id) throws DaoException;

}
