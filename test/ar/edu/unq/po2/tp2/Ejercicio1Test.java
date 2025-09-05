package ar.edu.unq.po2.tp2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate; 

import ar.edu.unq.po2.tp2.*;

public class Ejercicio1Test {
	
	private Empresa empresa; 
	private EmpleadoPermanente juan;
	private EmpleadoTemporario carlos;
	
	@BeforeEach
	public void setup() {
		empresa = new Empresa("Arcor", 12345);
		juan = new EmpleadoPermanente("Juan Perez", "San Juan 1228", true, LocalDate.of(1985, 5, 17), 950000.5, 2, 15);
		carlos = new EmpleadoTemporario("Carlos Sanchez", "Olavarria 72", false , LocalDate.of(1978, 9, 4), 870000.5, LocalDate.of(2012, 6, 8), 10);
		
		empresa.agregarEmpleado(carlos);
		empresa.agregarEmpleado(juan);
	}
	
	@Test
	public void testConstructorPermanente() {
		assertEquals("Juan Perez", juan.getNombre());
		assertEquals("San Juan 1228", juan.getDireccion());
		assertEquals(true, juan.getEstadoCivil());
		assertEquals(LocalDate.of(1985, 5, 17), juan.getFechaNac());
		assertEquals(950000.5, juan.getSueldoBasico());
		assertEquals(2, juan.getCantHijos());
		assertEquals(15, juan.getAntiguedad());
		
		assertEquals("Carlos Sanchez", carlos.getNombre());
		assertEquals("Olavarria 72", carlos.getDireccion());
		assertEquals(false, carlos.getEstadoCivil());
		assertEquals(LocalDate.of(1978, 9, 4), carlos.getFechaNac());
		assertEquals(870000.5, carlos.getSueldoBasico());
		assertEquals(LocalDate.of(2012, 6, 8), carlos.getfechaFin());
		assertEquals(10, carlos.getCantHorasExtra());
	}
	
}