package com.api.ekologictur;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.ekologictur.model.Destino;
import com.api.ekologictur.model.Pacote;


@SpringBootApplication
public class EkologicturApplication implements CommandLineRunner{
	
	/*private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public PedalShoppingApplication(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}*/

	public static void main(String[] args) {
		SpringApplication.run(EkologicturApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
/*
		Scanner sc = new Scanner(System.in);
		System.out.println("=== Ekologic Tur | MENU ===");
		System.out.println("1-Criar um Pacote | 2-Mostrar Pacotes | 3-Mostrar Destinos | 4-Encerrar");
		int opcao = 0;

		while (opcao != 4) {
			System.out.print("Escolha a opção: ");
			opcao = Integer.parseInt(sc.nextLine());
			switch (opcao) {
			case 1:		
				// Cria Pacote
				System.out.println("CRIAR PACOTE:");
				
				System.out.print("Nome do pacote: ");
				String nomePacote = sc.nextLine();
				
				System.out.print("Época do pacote (temporada): ");
				String epoca = sc.nextLine();
				
				System.out.print("Preço do pacote: ");
				double precoPacote = Double.parseDouble(sc.nextLine());
				
				System.out.print("Período do pacote (dias): ");
				int periodoPacote = Integer.parseInt(sc.nextLine());
				
				Pacote pacote = new Pacote(null, nomePacote, epoca, precoPacote, periodoPacote);

				// Cria Destino
				System.out.println("INSERIR DESTINO:");
				
				System.out.println("Nome do Destino: ");
				String nomeDestino = sc.nextLine();
				
				System.out.println("Localidade: ");
				String localidade = sc.nextLine();
				
				System.out.println("Tipo de Destino (Nacional ou internaional): ");
				String tipoDestino = sc.nextLine();
						
				Destino destino = new Destino(null, nomeDestino, localidade, tipoDestino, pacote);
				
				
				
				categoria.getProducts().addAll(Arrays.asList(produto));
				categoryRepository.save(categoria);
				productRepository.save(produto);

				break;
			case 2:
				System.out.println("MOSTRAR PACOTES:");
				System.out.println("Defina o valor limite: ");
				int valorLimite = Integer.parseInt(sc.nextLine());
				Pageable precoMenorQueValorOrdenadoPorPrecoCrescente = PageRequest.of(0, 30,
						Sort.by(Sort.Direction.ASC, "price"));
				Page<Product> products = productRepository.findAllByPriceLessThan(valorLimite,
						precoMenorQueValorOrdenadoPorPrecoCrescente);
				System.out.println(products);
				System.out.println("Página atual: " + products.getNumber());
				System.out.println("Total de elementos: " + products.getTotalElements());
				products.forEach(product -> System.out.println(product.toString()));
				break;
			case 3:
				System.out.println("MOSTRAR DESTINOS:");
				System.out.println("Todos produtos: \n" + productRepository.findAll().toString());
				break;
			}

		}*/

		
	}

}
