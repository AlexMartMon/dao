package com.tsystems.tu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tsystems.tu.dominio.Tarea;
import com.tsystems.tu.exceptions.DaoException;

/**
 * Clase DAO para la entidad Tarea.
 * 
 * @author krequena
 *
 */
public class TareaDao implements IDao<Tarea> {
	
	private static final Logger LOG = LogManager.getLogger();

	private static final String QUERY_OBTENER_TODOS = "SELECT t FROM Tarea t";

	EntityManager em = null;
	
	/**
	 * Constructor del DAO.
	 */
	public TareaDao() {
		this.em = Persistence.createEntityManagerFactory("dao").createEntityManager();
	}

	@Override
	public Tarea obtenerPorId(long id) throws DaoException {
		LOG.info("TareaDAO.obtenerPorId. Id: {}.", id);
		try {
			return em.find(Tarea.class, id);
		} catch (Exception exception) {
			throw new DaoException(exception);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tarea> obtenerTodos() throws DaoException {
		LOG.info("TareaDAO.obtenerTodos.");
		try {
			return em.createQuery(QUERY_OBTENER_TODOS).getResultList();
		} catch (Exception exception) {
			throw new DaoException(exception);
		}
	}

	@Override
	public void insertar(Tarea instancia) throws DaoException {
		LOG.info("TareaDAO.insertar. {}", instancia);
		try {
			em.persist(instancia);
		} catch (Exception exception) {
			throw new DaoException(exception);
		}
	}

	@Override
	public void modificar(Tarea instancia) throws DaoException {
		LOG.info("TareaDAO.modificar. {}.", instancia);
		try {
			em.merge(instancia);
		} catch (Exception exception) {
			throw new DaoException(exception);
		}
	}

	@Override
	public void eliminar(long id) throws DaoException {
		LOG.info("TareaDAO.eliminar. Id: {}.", id);
		try {
			Tarea instancia = this.obtenerPorId(id);
			em.remove(instancia);
		} catch (Exception exception) {
			throw new DaoException(exception);
		}
	}

}
