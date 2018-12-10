package com.tsystems.tu.exceptions;

/**
 * Excepción genérica de la capa DAO.
 * @author krequena
 *
 */
public class DaoException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 */
	public DaoException(Exception exception) {
		super(exception.getMessage(), exception);
	}

}
