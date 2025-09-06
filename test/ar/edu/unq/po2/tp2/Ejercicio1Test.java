package ar.edu.unq.po2.tp2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate; 

import ar.edu.unq.po2.tp2.*;

public class Ejercicio1Test {
	
	private Empresa arcor; 
	private EmpleadoPermanente juan;
	private EmpleadoTemporario carlos;
	
	@BeforeEach
	public void setup() {
		arcor = new Empresa("Arcor", 12345);
		juan = new EmpleadoPermanente("Juan Perez", "San Juan 1228", true, LocalDate.of(1985, 5, 17), 2500.5, 2, 15);
		carlos = new EmpleadoTemporario("Carlos Sanchez", "Olavarria 72", false , LocalDate.of(1978, 9, 4), 1800.5, LocalDate.of(2012, 6, 8), 10);
		
		arcor.agregarEmpleado(carlos);
		arcor.agregarEmpleado(juan);
	}
	
	@Test
	public void testConstructorPermanente() {
		assertEquals("Juan Perez", juan.getNombre());
		assertEquals("San Juan 1228", juan.getDireccion());
		assertEquals(true, juan.getEstadoCivil());
		assertEquals(LocalDate.of(1985, 5, 17), juan.getFechaNac());
		assertEquals(2500.5, juan.getSueldoBasico());
		assertEquals(2, juan.getCantHijos());
		assertEquals(15, juan.getAntiguedad());
		
		assertEquals("Carlos Sanchez", carlos.getNombre());
		assertEquals("Olavarria 72", carlos.getDireccion());
		assertEquals(false, carlos.getEstadoCivil());
		assertEquals(LocalDate.of(1978, 9, 4), carlos.getFechaNac());
		assertEquals(1800.5, carlos.getSueldoBasico());
		assertEquals(LocalDate.of(2012, 6, 8), carlos.getfechaFin());
		assertEquals(10, carlos.getCantHorasExtra());
	}
	
	@Test 
	public void testSueldosBrutosEmpleados() {
		assertEquals(3650.5, juan.sueldoBruto());
		assertEquals(2200.5, carlos.sueldoBruto());	
	}

	@Test 
	public void testRetencionesEmpleados() {
		assertEquals(952.625, juan.retenciones());
		assertEquals(490.1, carlos.retenciones());
	}
	
	@Test 
	public void testSueldosNetos() {
		assertEquals(2697.875, juan.sueldoNeto());
		assertEquals(1710.4, carlos.sueldoNeto());
	}
	
	
	@Test 
	public void testTotalSueldosBrutosRetencionesYNetos() {
		assertEquals(5851,arcor.totalSueldosBrutos() );
		assertEquals(1442.725,arcor.totalRetenciones() );
		assertEquals(4408.275,arcor.totalSueldosNetos() );
	}
	
	@Test
	public void testLiqudacionSueldos() {
		arcor.liquidarSueldos();
		assertEquals(2, arcor.getEmpleados().size());
		assertEquals(2,arcor.getRecibos().size());
		assertEquals("Juan Perez", arcor.getRecibos().get(1).getNombreEmpleado());
		
	}
	
	
	
}










