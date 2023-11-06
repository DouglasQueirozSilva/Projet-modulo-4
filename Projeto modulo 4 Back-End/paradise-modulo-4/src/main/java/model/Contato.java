package model;

public class Contato {
	private String nome_completo;
	private String mensagem;
	private String telefone;
	private String email;
	private int id_contato;
	private Cliente cliente;

	public Contato(int id_contato,Cliente cliente, String nome_completo, String mensagem, String telefone, String email
			) {
		this.id_contato = id_contato;
		this.nome_completo = nome_completo;
		this.mensagem = mensagem;
		this.telefone = telefone;
		this.email = email;
		this.cliente = cliente;
	}

	public Contato(Cliente cliente, String nome_completo, String mensagem, String telefone, String email) {
		this.nome_completo = nome_completo;
		this.mensagem = mensagem;
		this.telefone = telefone;
		this.email = email;
		this.cliente = cliente;
	}

	public Contato() {

	}

	public int getId_contato() {
		return id_contato;
	}

	public void setId_contato(int id_contato) {
		this.id_contato = id_contato;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNome_completo() {
		return nome_completo;
	}

	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contato [nome_completo=" + nome_completo + ", mensagem=" + mensagem + ", telefone=" + telefone
				+ ", email=" + email + ", id_contato=" + id_contato + ", cliente=" + cliente + "]";
	}

}
