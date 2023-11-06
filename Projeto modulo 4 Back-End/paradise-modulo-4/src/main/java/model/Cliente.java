package model;

public class Cliente {
	private String nome;
	private String celular;
	private int Id_Cliente;

	public Cliente() {
	}

	public Cliente(int id_Cliente, String nome, String celular) {
		Id_Cliente = id_Cliente;
		this.nome = nome;
		this.celular = celular;
	}

	public Cliente(String nome, String celular) {
		this.nome = nome;
		this.celular = celular;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public int getId_Cliente() {
		return Id_Cliente;
	}

	public void setId_Cliente(int id_Cliente) {
		Id_Cliente = id_Cliente;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", celular=" + celular + ", Id_Cliente=" + Id_Cliente + "]";
	}
	
	
}
