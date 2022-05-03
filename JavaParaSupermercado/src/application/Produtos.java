package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Produtos {
	
	private String nome;
	private double preco;
	private Desconto desconto;
	
	public Produtos(String nome, double preco, Desconto desconto) {
		this.nome = nome;
		this.preco = preco;
		this.setDesconto(desconto);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Desconto getDesconto() {
		return desconto;
	}

	public void setDesconto(Desconto desconto) {
		this.desconto = desconto;
	}
	
	public void fazerDesconto() {
		String dateDesconto = "01/01/0001 20:00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime dateTimeDesconto = LocalDateTime.parse(dateDesconto, formatter);
		
		int num = desconto.getData().getDayOfWeek().getValue();
		if(dateTimeDesconto.getHour() <= desconto.getData().getHour() || num == 6 || num == 7) {
			System.out.println("");
			if(num == 6) {
				System.out.println("Vai ter desconto de 10% por hoje ser Sábado!");
			}
			else if(num == 7) {
				System.out.println("Vai ter desconto de 10% por hoje ser Domingo!");
			}
			else {
				System.out.println("Vai ter desconto de 10% por passar das 20h!");
			}
			double discount = this.preco;
			this.preco -= discount * 0.10;
		}
		else
			System.out.println("Não vai ter desconto!");
		
	}
}
