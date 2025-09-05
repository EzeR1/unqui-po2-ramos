package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.ArrayList;

public class ReciboDeHaberes {
	
	private String nombreEmpleado;
	private String direccionEmpleado;
	private LocalDate fechaEmision;
	private double sueldoBruto;
	private double sueldoNeto;
	private ArrayList<Concepto> conceptos;
	
	public ReciboDeHaberes(Empleado empleado) {
		this.nombreEmpleado = empleado.getNombre();
		this.direccionEmpleado = empleado.getDireccion();
		this.fechaEmision = LocalDate.now();
		this.sueldoBruto = empleado.sueldoBruto();
		this.sueldoNeto = empleado.sueldoNeto();
		this.conceptos = new ArrayList<Concepto>();
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public String getDireccionEmpleado() {
		return direccionEmpleado;
	}

	public LocalDate getFechaEmision() {
		return fechaEmision;
	}

	public double getSueldoBruto() {
		return sueldoBruto;
	}

	public double getSueldoNeto() {
		return sueldoNeto;
	}

	public ArrayList<Concepto> getConceptos() {
		return conceptos;
	}
	
	public void imprimirRecibo() {
		System.out.println("----------------------------------");
		System.out.println("Recibo de Haberes");
        System.out.println("Empleado: " + this.getNombreEmpleado());
        System.out.println("Direccion: " + this.getDireccionEmpleado());
        System.out.println("Fecha: " + this.getFechaEmision());
        System.out.println("Sueldo Bruto: " + this.getSueldoBruto());
        System.out.println("Sueldo Neto: " + this.getSueldoNeto());
        System.out.println("Conceptos:");
        for (Concepto concepto : conceptos) {
            System.out.println(" - " + concepto.getDescripcion() + ": $" + concepto.getMonto());
        }
        System.out.println("----------------------------------");
	}
}
