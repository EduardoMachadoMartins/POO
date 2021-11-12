package pucrs.myflight.modelo;

public class Rota {

	private static int totalRotas = 0;
	private CiaAerea cia;
	private Aeroporto origem;
	private Aeroporto destino;
	private Aeronave aeronave;

	public Rota(CiaAerea cia, Aeroporto origem, Aeroporto destino, Aeronave aeronave) {
		totalRotas++;
		this.cia = cia;
		this.origem = origem;
		this.destino = destino;
		this.aeronave = aeronave;
	}

	public static int getTotalRotas() {
		return totalRotas;
	}

	public CiaAerea getCia() {
		return cia;
	}

	public Aeroporto getDestino() {
		return destino;
	}

	public Aeroporto getOrigem() {
		return origem;
	}

	public Aeronave getAeronave() {
		return aeronave;
	}
}
