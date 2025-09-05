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
	}
	
	public void agregarEmpleado(Empleado empleado) {
		empleados.add(empleado);
	}
	
	public Float totalSueldosNetos() {
		Float contador = 0f;
		
		for (Empleado empleado : empleados) {
			contador += empleado.sueldoNeto();
		}
	}
	
	
	
	
	
}
