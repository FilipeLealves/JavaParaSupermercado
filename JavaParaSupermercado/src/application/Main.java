package application;

import java.util.Scanner;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) throws ParseException {
		Scanner input = new Scanner(System.in);
		System.out.println("Supermercado\n");
		
		System.out.print("Nome do produto: ");
		String nome = input.next(); 
		System.out.print("Preço do produto: ");
		double preco = input.nextDouble();
		System.out.print("Dia da semana em (dd/MM/yyyy): ");
		String data = input.next(); 
		System.out.print("Horário da compra em (HH:mm:ss): ");
		String horario = input.next();
		
		String dateNow = data + " " + horario;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(dateNow, formatter);
		
		Desconto desconto = new Desconto(dateTime);
		Produtos produtos = new Produtos(nome, preco, desconto);
		
		produtos.fazerDesconto();
		
		System.out.println("Valor final: " + produtos.getPreco());
	}
}
