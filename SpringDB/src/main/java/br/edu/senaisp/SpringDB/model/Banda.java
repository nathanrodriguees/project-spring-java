package br.edu.senaisp.SpringDB.model;

public class Banda {
	
	private Integer id;
	private String nome;
	private int anoLançamento;
	
	
	
	public Banda(Integer id, String nome, int anoLançamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.anoLançamento = anoLançamento;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAnoLançamento() {
		return anoLançamento;
	}
	public void setAnoLançamento(int anoLançamento) {
		this.anoLançamento = anoLançamento;
	}
	
	

}
