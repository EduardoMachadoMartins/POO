package pucrs.myflight.modelo;

public class Aeronave {

	private static int totalAeronaves = 0;
	private String codigo;
	private String descricao;

	
	public Aeronave(String codigo, String descricao) {
		totalAeronaves++;
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static int getTotalAeronaves() {
		return totalAeronaves;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
