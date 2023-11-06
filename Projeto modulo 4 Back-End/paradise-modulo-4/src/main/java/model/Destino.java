package model;

public class Destino {
	private int id_destino;
	private float valor;
	private String volta;
	private String ida;

	public Destino(int id_destino, float valor, String ida,String volta) {
		this.id_destino = id_destino;
		this.valor = valor;
		this.ida = ida;
		this.volta = volta;
	}

	public Destino(float valor, String ida, String volta) {
		this.valor = valor;
		this.ida = ida;
		this.volta = volta;
	}

	public Destino() {

	}

	public int getId_destino() {
		return id_destino;
	}

	public void setId_destino(int id_destino) {
		this.id_destino = id_destino;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getVolta() {
		return volta;
	}

	public void setVolta(String volta) {
		this.volta = volta;
	}

	public String getIda() {
		return ida;
	}

	public void setIda(String ida) {
		this.ida = ida;
	}

	@Override
	public String toString() {
		return "Destino [id_destino=" + id_destino + ", valor=" + valor + ", volta=" + volta + ", ida=" + ida + "]";
	}

}
