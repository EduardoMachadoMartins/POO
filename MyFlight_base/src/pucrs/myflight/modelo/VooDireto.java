package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class VooDireto extends Voo {

    private Rota rotafinal;
    private Rota rota;
    private Duration duracao;

    public VooDireto(Rota rota, Rota rotafinal, LocalDateTime datahora, Duration duracao, Status status) {
        super(datahora, status);
        this.duracao = duracao;
        this.rota = rota;
        this.rotafinal = null;
    }

    public Rota getRota() {
        return rota;
    }

    public Rota getRotaFinal() {
        return rotafinal;
    }

    @Override
    public double getDuracao(Geo local1, Geo local2) {
        // Cálculo da duração do Voo: Distância em Km / Velocidade Média
        final int velocidadeJato = 805;
        double duracaoHoras = ((Geo.distancia(local1, local2)) / velocidadeJato) + 0.5;
        double duracaoMinutos = duracaoHoras * 60;

        return duracaoMinutos;
    }

    @Override
    public String toString() {
        return "" + getStatus() + getDatahora() + getRota();
    }
}