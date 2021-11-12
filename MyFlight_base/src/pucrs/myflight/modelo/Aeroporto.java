package pucrs.myflight.modelo;

public class Aeroporto {

	private static int totalAeroportos = 0;
	private String codigo;
	private String nome;
	private Geo loc;
	private String pais;

	public Aeroporto(String codigo, String nome, Geo loc, String pais) {
		totalAeroportos++;
		this.codigo = codigo;
		this.nome = nome;
		this.loc = loc;
		this.pais = pais;
	}

	public static int getTotalAeroportos() {
		return totalAeroportos;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public Geo getLocal() {
		return loc;
	}

	public String getPais() {
		return pais;
	}
}