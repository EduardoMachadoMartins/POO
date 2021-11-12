package pucrs.myflight.modelo;

import java.time.LocalDateTime;

public abstract class Voo {

	public enum Status {
		CONFIRMADO, ATRASADO, CANCELADO
	};

	private LocalDateTime datahora;
	private Status status;

	public Voo(LocalDateTime datahora, Status status) {
		this.datahora = datahora;
		this.status = Status.CONFIRMADO; // default é confirmado
	}

	public abstract Rota getRota();

	public abstract double getDuracao(Geo local1, Geo local2);

	public LocalDateTime getDatahora() {
		return datahora;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status novo) {
		this.status = novo;
	}

	public Object getRotaFinal() {
		return null;
	}
}