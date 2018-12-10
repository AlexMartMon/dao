package com.tsystems.tu.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tsystems.tu.dao.TareaDao;
import com.tsystems.tu.exceptions.DaoException;

public class TareaTest {

	// Instancia del DAO a testear.
	private TareaDao tareaDao = null;

	// Datos de Test.
	private static final long ID_TAREA = 1L;
	private static final String NOMBRE_TAREA_ORIGINAL = "Nombre de la tarea";
	private static final String DESCRIPCION_TAREA_ORIGINAL = "Descripción de la tarea";
	private static final String NOMBRE_TAREA_NUEVO = "Nombre de la tarea";
	private static final String DESCRIPCION_TAREA_NUEVO = "Descripción de la tarea";

	@Before
	public void inicializacion( ) {
		tareaDao = new TareaDao();
	}

	@After
	public void destruccion() {
		tareaDao = null;
	}

	@Test
	public void testIntegrado() throws DaoException {
		
		// Crear una instancia de tarea.
		Tarea tarea = new Tarea(ID_TAREA, NOMBRE_TAREA_ORIGINAL, DESCRIPCION_TAREA_ORIGINAL);

		// Inserción.
		tareaDao.insertar(tarea);
		
		// Obtención.
		Tarea tarea2 = tareaDao.obtenerPorId(ID_TAREA);
		assertEquals(ID_TAREA, tarea2.getId());
		assertEquals(NOMBRE_TAREA_ORIGINAL, tarea2.getNombre());
		assertEquals(DESCRIPCION_TAREA_ORIGINAL, tarea2.getDescripcion());
		
		// Actualización.
		tarea2.setNombre(NOMBRE_TAREA_NUEVO);
		tarea2.setDescripcion(DESCRIPCION_TAREA_NUEVO);
		tareaDao.modificar(tarea2);
		
		Tarea tarea3 = tareaDao.obtenerPorId(ID_TAREA);
		assertEquals(ID_TAREA, tarea3.getId());
		assertEquals(NOMBRE_TAREA_NUEVO, tarea3.getNombre());
		assertEquals(DESCRIPCION_TAREA_NUEVO, tarea3.getDescripcion());
		
		// Borrado.
		tareaDao.eliminar(ID_TAREA);
	}
}
