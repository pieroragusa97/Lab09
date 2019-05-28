package it.polito.tdp.borders.model;

public class Country {
	private String nomeAbb;
	private int codice;
	private String nomeCompleto;
	
	public Country(String nomeAbb, int codice, String nomeCompleto) {
		super();
		this.nomeAbb = nomeAbb;
		this.codice = codice;
		this.nomeCompleto = nomeCompleto;
	}

	public String getNomeAbb() {
		return nomeAbb;
	}

	public void setNomeAbb(String nomeAbb) {
		this.nomeAbb = nomeAbb;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codice;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (codice != other.codice)
			return false;
		return true;
	}
	
	

}
