package com.tsystems.tu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tsystems.tu.dao.TareaDao;
import com.tsystems.tu.dominio.Tarea;
import com.tsystems.tu.exceptions.DaoException;

/**
 * @author krequena
 *
 */
public class Main {
	
	private static final Logger LOG = LogManager.getLogger();

	/**
	 * Entry-point de la aplicación.
	 * @param args Argumentos.
	 * @throws DaoException Excepción de DAO.
	 */
	public static void main(String[] args) throws DaoException {
		// Crear una instancia de tarea.
		Tarea tarea = new Tarea(1L, "Nombre de la tarea", "Descripción de la tarea.");
		
		// Instanciación del DAO.
		TareaDao tareaDao = new TareaDao();

		// Inserción.
		tareaDao.insertar(tarea);
		
		// Obtención.
		Tarea tarea2 = tareaDao.obtenerPorId(1L);
		LOG.info("Tarea obtenida: id {}, nombre {}, descripción {}", tarea2.getId(), tarea2.getNombre(), tarea2.getDescripcion());
		
		// Actualización.
		tarea2.setNombre("Nuevo nombre");
		tarea2.setDescripcion("Nueva descripción");
		tareaDao.modificar(tarea2);
		
		Tarea tarea3 = tareaDao.obtenerPorId(1L);
		LOG.info("Tarea modificada: id {}, nombre {}, descripción {}", tarea3.getId(), tarea3.getNombre(), tarea3.getDescripcion());
		
		// Borrado.
		tareaDao.eliminar(1L);
	}

}
