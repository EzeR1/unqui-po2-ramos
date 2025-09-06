package ar.edu.unq.po2.tp2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate; 

// import ar.edu.unq.po2.tp2.*;

public class Ejercicio1y2Test {
	
	private Empresa arcor; 
	private EmpleadoPermanente juan;
	private EmpleadoTemporario carlos;
	private EmpleadoContratado nicolas;
	
	@BeforeEach
	public void setup() {
		arcor = new Empresa("Arcor", 12345);
		juan = new EmpleadoPermanente("Juan Perez", "San Juan 1228", true, LocalDate.of(1985, 5, 17), 2500.5, 2, 15);
		carlos = new EmpleadoTemporario("Carlos Sanchez", "Olavarria 72", false , LocalDate.of(1978, 9, 4), 1800.5, LocalDate.of(2012, 6, 8), 10);
		nicolas = new EmpleadoContratado("Nicolas Fernandez", "Manuel Belgrano 732", false, LocalDate.of(2002,3,14), 900, 147, "Transferencia bancaria"  );
		
		arcor.agregarEmpleado(carlos);
		arcor.agregarEmpleado(juan);
		arcor.agregarEmpleado(nicolas);
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
		
		assertEquals("Nicolas Fernandez", nicolas.getNombre());
		assertEquals("Manuel Belgrano 732", nicolas.getDireccion());
		assertEquals(false, nicolas.getEstadoCivil());
		assertEquals(LocalDate.of(2002,3,14), nicolas.getFechaNac());
		assertEquals(900, nicolas.getSueldoBasico());
		assertEquals(147, nicolas.getNumeroDeContrato());
		assertEquals("Transferencia bancaria", nicolas.getMedioDePago());
	}
	
	@Test 
	public void testSueldosBrutosEmpleados() {
		assertEquals(3650.5, juan.sueldoBruto());
		assertEquals(2200.5, carlos.sueldoBruto());	
		assertEquals(900, nicolas.sueldoBruto());	
	}

	@Test 
	public void testRetencionesEmpleados() {
		assertEquals(952.625, juan.retenciones());
		assertEquals(490.1, carlos.retenciones());
		assertEquals(50, nicolas.retenciones());
	}
	
	@Test 
	public void testSueldosNetos() {
		assertEquals(2697.875, juan.sueldoNeto());
		assertEquals(1710.4, carlos.sueldoNeto());
		assertEquals(850, nicolas.sueldoNeto());
	}
	
	
	@Test 
	public void testTotalSueldosBrutosRetencionesYNetos() {
		assertEquals(6751,arcor.totalSueldosBrutos() );
		assertEquals(1492.725,arcor.totalRetenciones() );
		assertEquals(5258.275,arcor.totalSueldosNetos() );
	}
	
	@Test
	public void testLiqudacionSueldos() {
		arcor.liquidarSueldos();
		assertEquals(3, arcor.getEmpleados().size());
		assertEquals(3,arcor.getRecibos().size());
		assertEquals("Juan Perez", arcor.getRecibos().get(1).getNombreEmpleado());
		assertEquals(1710.4, arcor.getRecibos().get(0).getSueldoNeto());
		assertEquals("Manuel Belgrano 732", arcor.getRecibos().get(2).getDireccionEmpleado());
		
	}
	
	
	
}










