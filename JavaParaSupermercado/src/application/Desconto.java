package application;

import java.time.LocalDateTime;


public class Desconto{

	private LocalDateTime data;

	public Desconto(LocalDateTime data) {
		this.data = data;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
}