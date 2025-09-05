package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmpleadoPlantaPermanente extends Empleado {
	
	private int cantHijos;
	private int antiguedad;
	private int asignacionHijo;
	private int asignacionConyuge;
	private int valorAñoAntiguedad;
	private Float retencionObraSocial;
	private int retencionHijo;
	private Float retencionJubilacion;
	
	public int getCantHijos() {
		return cantHijos;
	}

	public void setCantHijos(int cantHijos) {
		this.cantHijos = cantHijos;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public int getAsignacionHijo() {
		return asignacionHijo;
	}

	public int getAsignacionConyuge() {
		return asignacionConyuge;
	}

	public int getValorAñoAntiguedad() {
		return valorAñoAntiguedad;
	}

	public Float getRetencionObraSocial() {
		return retencionObraSocial;
	}

	public int getRetencionHijo() {
		return retencionHijo;
	}

	public Float getRetencionJubilacion() {
		return retencionJubilacion;
	}

	public int salarioFamiliar() {
		return this.getCantHijos() * 150;
	}
	
	/*
	
	public EmpleadoPlantaPermanente(String nombre, String direccion, String estadoCivil, LocalDate fechaNac,
			Float sueldoBasico) {
		super(nombre, direccion, estadoCivil, fechaNac, sueldoBasico);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Float sueldoBruto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float retenciones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Concepto> calcularConceptos() {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
