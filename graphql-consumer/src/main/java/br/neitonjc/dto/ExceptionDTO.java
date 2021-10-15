package br.neitonjc.dto;

public class ExceptionDTO {
	
	public int cod;
	public String dsErro;
	
	public ExceptionDTO(int cod, String dsErro) {
		super();
		this.cod = cod;
		this.dsErro = dsErro;
	}

}
