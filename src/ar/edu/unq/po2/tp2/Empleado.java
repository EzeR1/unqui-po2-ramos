package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public abstract class Empleado {

	private String nombre;
	private String direccion;
	private boolean estadoCivil; // para el contexto del ejercicio, solo importa si es o no casado.
	private LocalDate fechaNac;
	private Float sueldoBasico; 
	
	public Empleado(String nombre, String direccion, boolean estadoCivil, LocalDate fechaNac, Float sueldoBasico) {
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

	public Float getSueldoBasico() {
		return sueldoBasico;
	}
	public void setSueldoBasico(Float sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}
	
	public int edad() {
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(this.getFechaNac(),hoy);
		int edad = periodo.getYears();
		return edad;
	}
	
	public abstract Float sueldoBruto();
	
	public abstract Float retenciones();
	
	public Float sueldoNeto() {
		return this.sueldoBruto() - this.retenciones();
	}
	
	public abstract ArrayList <Concepto> calcularConceptos();
	
}