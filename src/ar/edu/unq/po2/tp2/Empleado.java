package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public abstract class Empleado {

	private String nombre;
	private String direccion;
	private boolean estadoCivil; // para el contexto del ejercicio, solo importa si es o no casado. True = casado, False = soltero.
	private LocalDate fechaNac;
	private double sueldoBasico; 
	
	public Empleado(String nombre, String direccion, boolean estadoCivil, LocalDate fechaNac, double sueldoBasico) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaNac = fechaNac;
		this.sueldoBasico = sueldoBasico;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public boolean getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(boolean estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public double getSueldoBasico() {
		return sueldoBasico;
	}
	public void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}
	
	public int edad() {
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(this.getFechaNac(),hoy);
		int edad = periodo.getYears();
		return edad;
	}
	
	public abstract double sueldoBruto();
	
	public abstract double retenciones();
	
	public double sueldoNeto() {
		return this.sueldoBruto() - this.retenciones();
	}
	
	public abstract ArrayList <Concepto> calcularConceptos();
	
}