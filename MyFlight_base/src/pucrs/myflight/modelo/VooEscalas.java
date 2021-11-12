package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VooEscalas extends Voo {

	private ArrayList<Rota> rotas = new ArrayList<>();
	private Rota rotafinal;
	private Rota rota;
	private Duration duracao;

	public VooEscalas(Rota rota, Rota rotaFinal, LocalDateTime datahora, Duration duracao, Status status) {
		super(datahora, status);
		this.rotafinal = rotaFinal;
		this.rota = rota;
		this.duracao = duracao;
	}

	public void adicionaRota(Rota rota) {
		rotas.add(rota);
	}

	@Override
	public double getDuracao(Geo local1, Geo local2) {
		// Cálculo da duração do Voo: Distância em Km / Velocidade Média
		final int velocidadeJato = 805;
		double duracaoHoras = ((Geo.distancia(local1, local2)) / velocidadeJato) + 0.5;
		double duracaoMinutos = duracaoHoras * 60;

		return duracaoMinutos;
	}

	public Rota getRota() {
		return rota;
	}

	public ArrayList<Rota> getRotas() {
		return rotas;
	}

	public Rota getRotaFinal() {
		return rotafinal;
	}

	@Override
	public String toString() {
		return "" + getStatus() + getDatahora() + getRota() + " -> " + getRotaFinal();
	}
}