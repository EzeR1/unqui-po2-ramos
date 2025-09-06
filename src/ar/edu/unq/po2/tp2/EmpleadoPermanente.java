package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmpleadoPermanente extends Empleado {
	
	private int cantHijos;
	private int antiguedad;
	
	private static final int asignacionHijo = 150 ;
	private static final int asignacionConyuge = 100;
	private static final int valorAñoAntiguedad = 50;
	private static final double retencionObraSocial = 0.1;
	private static final int retencionHijo = 20;
	private static final double retencionJubilacion = 0.15;
	
	
	public EmpleadoPermanente(String nombre, String direccion, boolean estadoCivil, LocalDate fechaNac, double sueldoBasico, int cantHijos, int antiguedad) {
		super(nombre, direccion, estadoCivil, fechaNac, sueldoBasico);
		this.cantHijos = cantHijos;
		this.antiguedad = antiguedad;
	}
	
	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	public int getCantHijos() {
		return cantHijos;
	}

	public void setCantHijos(int cantHijos) {
		this.cantHijos = cantHijos;
	}
	
	public int validacionConyuge( ) {
		if (this.getEstadoCivil()) {
			return asignacionConyuge;
		}
		else {
			return 0;
		}
	}

	public int salarioFamiliar() {
		return ( cantHijos * asignacionHijo ) + this.validacionConyuge();
	}
	
	public int salarioAntiguedad() {
		return this.getAntiguedad() * valorAñoAntiguedad;
	}
	
	@Override
	public double sueldoBruto() {
		return this.getSueldoBasico() + this.salarioFamiliar() + this.salarioAntiguedad();
	}
	
	public double aporteObraSocial() {
		return ( this.sueldoBruto() * retencionObraSocial ) +  (this.getCantHijos() * retencionHijo );
	}
	
	public double aporteJubilatorio() {
		return this.sueldoBruto() * retencionJubilacion;
	}
	
	@Override
	public double retenciones() {
		return this.aporteJubilatorio() + this.aporteObraSocial();
	}
	
	@Override
	public ArrayList<Concepto> calcularConceptos() {
		ArrayList<Concepto> conceptosARetornar = new ArrayList<>(); 

		conceptosARetornar.add(new Concepto("Sueldo Basico", this.getSueldoBasico()));
		conceptosARetornar.add(new Concepto("Salario familiar", this.salarioFamiliar()));
		conceptosARetornar.add(new Concepto("Salario antiguedad", this.salarioAntiguedad()));
		conceptosARetornar.add(new Concepto("Aporte obra social", this.aporteObraSocial()));
		conceptosARetornar.add(new Concepto("Aporte jubilatorio", this.aporteJubilatorio()));
		
		
		return conceptosARetornar;
	}
	
}