package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmpleadoTemporario extends Empleado {
	
	private LocalDate fechaFin;
	private int cantHorasExtra;
	
	private static final int valorHoraExtra = 40 ;
	private static final double retencionObraSocial = 0.1;
	private static final int retencionAntiguedad = 25;
	private static final double retencionJubilacion = 0.1;
	private static final int retencionJubilacionHoraExtra = 5;
	
	public EmpleadoTemporario(String nombre, String direccion, boolean estadoCivil, LocalDate fechaNac, double sueldoBasico, LocalDate fechaFin, int cantHorasExtra) {
		super(nombre, direccion, estadoCivil, fechaNac, sueldoBasico);
		this.fechaFin = fechaFin;
		this.cantHorasExtra = cantHorasExtra;
	}
	
	public LocalDate getfechaFin() {
		return fechaFin;
	}
	
	public int getCantHorasExtra() {
		return cantHorasExtra;
	}

	public void setCantHorasExtra(int cantHorasExtra) {
		this.cantHorasExtra = cantHorasExtra;
	}
	
	public int pagoHorasExtra() {
		return this.getCantHorasExtra() * valorHoraExtra;
	}
	
	@Override
	public double sueldoBruto() {
		return this.getSueldoBasico() + this.pagoHorasExtra() ;
	}
	
	public int validacionPagoPorEdad() {
		if (this.edad() > 50) {
			return retencionAntiguedad;
		}
		else {
			return 0;
		}
	}
	
	public double aporteObraSocial() {
		return this.sueldoBruto() * retencionObraSocial + this.validacionPagoPorEdad();
	}
	
	public double aporteJubilatorio() {
		return this.sueldoBruto() * retencionJubilacion + this.getCantHorasExtra() * retencionJubilacionHoraExtra;
	}

	@Override
	public double retenciones() {
		return  this.aporteObraSocial() + this.aporteJubilatorio();
	}

	@Override
	public ArrayList<Concepto> calcularConceptos() {
		ArrayList<Concepto> conceptosARetornar = new ArrayList<Concepto>(); 

		conceptosARetornar.add(new Concepto("Sueldo Basico", this.getSueldoBasico()));
		conceptosARetornar.add(new Concepto("Horas extra", this.pagoHorasExtra()));
		conceptosARetornar.add(new Concepto("Aporte obra social", this.aporteObraSocial()));
		conceptosARetornar.add(new Concepto("Aporte jubilatorio", this.aporteJubilatorio()));
		
		return conceptosARetornar;
	}
}