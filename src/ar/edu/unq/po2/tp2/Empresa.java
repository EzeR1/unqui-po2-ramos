package ar.edu.unq.po2.tp2;

import java.util.ArrayList;

public class Empresa {
	private String nombre;
	private int cuit;
	private ArrayList<Empleado> empleados;
	private ArrayList<ReciboDeHaberes> recibos; 
	
	public Empresa(String nombre, int cuit) {
		this.nombre = nombre;
		this.cuit = cuit;
		this.empleados = new ArrayList<Empleado>();
		this.recibos = new ArrayList<ReciboDeHaberes>();
	}
	
	public void agregarEmpleado(Empleado empleado) {
		empleados.add(empleado);
	}
	
	public double totalSueldosNetos() {
		double sueldosNetos = 0;
		for (Empleado empleado : empleados) {
			sueldosNetos += empleado.sueldoNeto();
		}
		return sueldosNetos;
	}
	
	public double totalSueldosBrutos() {
		double sueldosBrutos = 0;
				for (Empleado empleado : empleados) {
			sueldosBrutos += empleado.sueldoBruto();
		}
		return sueldosBrutos;
	}
	
	public double totalRetenciones() {
		double retenciones = 0;
		for (Empleado empleado : empleados) {
			retenciones += empleado.retenciones();
		}
		return retenciones;
	}
	
	public void liquidarSueldos() {
		
	}
	
	
}
