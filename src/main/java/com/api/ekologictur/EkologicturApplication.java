package com.api.ekologictur;

import java.util.Arrays;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.api.ekologictur.controller.DestinoController;
import com.api.ekologictur.controller.PacoteController;
import com.api.ekologictur.model.Destino;
import com.api.ekologictur.model.Pacote;

@SpringBootApplication
public class EkologicturApplication implements CommandLineRunner{
	
	private DestinoController destinoController;
	private PacoteController pacoteController;

	public EkologicturApplication(DestinoController destinoController, PacoteController pacoteController) {
		this.destinoController = destinoController;
		this.pacoteController = pacoteController;
	}

	public static void main(String[] args) {
		SpringApplication.run(EkologicturApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

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
				
				Pacote pacote = new Pacote(nomePacote, epoca, precoPacote, periodoPacote);
				Destino destino = new Destino();

				// Cria Destino
				System.out.println("INSERIR DESTINO:");
				
				System.out.println("Nome do Destino: ");
				String nomeDestino = sc.nextLine();
				destino.setNomeDestino(nomeDestino);
				
				System.out.println("Localidade: ");
				String localidade = sc.nextLine();
				destino.setLocalidade(localidade);
				
				System.out.println("Tipo de Destino (Nacional ou internaional): ");
				String tipoDestino = sc.nextLine();
				destino.setTipoDestino(tipoDestino);
				destino.setPacote(pacote);
				
				pacote.getDestinos().addAll(Arrays.asList(destino));
				pacoteController.createPacote(pacote);
				destinoController.createDestino(destino);

				break;
			case 2:
				System.out.println("MOSTRAR PACOTES:");
				/*System.out.println("Informe o nome do pacote: ");
				String nome = sc.nextLine();
				Pageable sortedByName = PageRequest.of(0, 3, Sort.by(Sort.Direction.ASC, "nome"));
				Page<Pacote> pacotes = (Page<Pacote>) pacoteController.findAllPorNomePacote(nome, sortedByName);
				System.out.println(pacotes);
				System.out.println("Página atual: " + pacotes.getNumber());
				System.out.println("Total de elementos: " + pacotes.getTotalElements());
				pacotes.forEach(dest -> System.out.println(pacotes.toString()));*/
				
				System.out.println("Todos produtos: \n" + pacoteController.getPacotes().toString());

				
				break;
			case 3:
				System.out.println("MOSTRAR DESTINOS:");
				System.out.println("Todos produtos: \n" + destinoController.getAllDestinos().toString());
				break;
			}

		}

		
	}

}
