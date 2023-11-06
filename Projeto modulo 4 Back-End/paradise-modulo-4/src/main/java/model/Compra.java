package model;

public class Compra {
	private int id_compra;
	private Cliente cliente;
	private Destino destino;

	public Compra(int id_compra, Cliente cliente, Destino destino) {
		this.id_compra = id_compra;
		this.cliente = cliente;
		this.destino = destino;
	}

	
	
	public Compra(Cliente cliente, Destino destino) {
		this.cliente = cliente;
		this.destino = destino;
	}



	public Compra() {

	}

	public int getId_compra() {
		return id_compra;
	}

	public void setId_compra(int id_compra) {
		this.id_compra = id_compra;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}



	@Override
	public String toString() {
		return "Compra [id_compra=" + id_compra + ", " + cliente + ", " + destino + "]";
	}

}
