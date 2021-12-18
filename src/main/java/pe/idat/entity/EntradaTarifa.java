package pe.idat.entity;

public class EntradaTarifa {

	private Entrada entrada;
	private Tarifa tarifa;
	
	private Integer cantidad;
	
	
	public EntradaTarifa() {
	}


	public EntradaTarifa(Entrada entrada, Tarifa tarifa, Integer cantidad) {
		this.entrada = entrada;
		this.tarifa = tarifa;
		this.cantidad = cantidad;
	}


	public Entrada getEntrada() {
		return entrada;
	}


	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}


	public Tarifa getTarifa() {
		return tarifa;
	}


	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
