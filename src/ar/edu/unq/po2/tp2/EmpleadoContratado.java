package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmpleadoContratado extends Empleado {
	
	private int numeroDeContrato;
	private String medioDePago;
	
	private static final int gastosAdministrativosContractuales = 50;

	public EmpleadoContratado(String nombre, String direccion, boolean estadoCivil, LocalDate fechaNac,
			double sueldoBasico, int numeroDeContrato, String medioDePago) {
		super(nombre, direccion, estadoCivil, fechaNac, sueldoBasico);
		this.numeroDeContrato = numeroDeContrato;
		this.medioDePago = medioDePago;
	}

	public String getMedioDePago() {
		return medioDePago;
	}

	public void setMedioDePago(String medioDePago) {
		this.medioDePago = medioDePago;
	}

	public int getNumeroDeContrato() {
		return numeroDeContrato;
	}
	

	@Override
	public double sueldoBruto() {
		return this.getSueldoBasico();
	}

	@Override
	public double retenciones() {
		return gastosAdministrativosContractuales;
	}

	@Override
	public ArrayList<Concepto> calcularConceptos() {
		ArrayList<Concepto> conceptosARetornar = new ArrayList<Concepto>(); 

		conceptosARetornar.add(new Concepto("Sueldo basico", this.sueldoBruto()));
		conceptosARetornar.add(new Concepto("Gastos administrativos contractuales", this.retenciones()));
		
		return conceptosARetornar;
	}

}
