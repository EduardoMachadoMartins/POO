package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class VooEscalas extends Voo{
	
	private Rota rotafinal;
	
	public VooEscalas(Rota rota, Rota rotaFinal, LocalDateTime datahora, Duration duracao) {
        super(rota, datahora, duracao);
		this.rotafinal = rotaFinal;
	}
	
	public Rota getRotaFinal() {
		return rotafinal;
	}

    @Override
    public String toString() {
       return super.toString() + " -> " + rotafinal;
    }
}
