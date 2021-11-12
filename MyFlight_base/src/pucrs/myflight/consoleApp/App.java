package pucrs.myflight.consoleApp;

import pucrs.myflight.modelo.*;
import pucrs.myflight.modelo.Voo.Status;
import java.time.LocalDateTime;
import java.time.Duration;

public class App {

	public static void main(String[] args) {

		System.out.println("\nMyFlight project...\n");

		System.out.println("\nEXERCÍCIO 1\n");

		GerenciadorAeronaves gnave1 = GerenciadorAeronaves.getInstance();
		GerenciadorAeroportos gporto1 = GerenciadorAeroportos.getInstance();
		GerenciadorCias gcia1 = GerenciadorCias.getInstance();
		GerenciadorRotas grota1 = GerenciadorRotas.getInstance();
		GerenciadorVoos gvoo1 = new GerenciadorVoos();

		gnave1.carregaDados("equipment.dat");
		gporto1.carregaDados("airports.dat");
		gcia1.carregaDados("airlines.dat");
		grota1.carregarDados("routes.dat", gcia1, gporto1, gnave1);

		System.out.println("-> Teste dos métodos da classe GerenciadorAeronaves:");
		Aeronave nave1 = new Aeronave("100", "Fokker 100", 100);
		Aeronave nave2 = new Aeronave("141", "British Aerospace BAe 146-100", 100);
		Aeronave nave3 = new Aeronave("142", "British Aerospace BAe 146-200", 112);
		gnave1.adicionar(nave1);
		gnave1.adicionar(nave2);
		gnave1.adicionar(nave3);
		System.out.println("- Buscar aeronave pelo código '142': " + gnave1.buscarPorCodigo("142").getDescricao());
		System.out.println("- Buscar aeronave pelo código 'não existe': " + gnave1.buscarPorCodigo("não existe"));
		System.out.println();

		System.out.println("-> Teste dos métodos da classe Aeronave:");
		System.out.println("- Total de aeronaves: " + Aeronave.getTotalAeronaves());
		System.out.println("- Código da aeronave 'nave1': " + nave1.getCodigo());
		System.out.println("- Descrição da aeronave 'nave2': " + nave2.getDescricao());
		System.out.println("- Capacidade da aeronave 'nave1': " + nave1.getCapacidade());
		System.out.println();

		System.out.println("-> Teste dos métodos da classe GerenciadorAeroportos:");
		Geo geo1 = new Geo(-29.9939, -51.1711);
		Geo geo2 = new Geo(-23.4356, -46.4731);
		Geo geo3 = new Geo(-20.6500, -40.4917);
		Geo geo4 = new Geo(48.9694, 2.4414);
		Aeroporto porto1 = new Aeroporto("POA", "Salgado Filho Airport", geo1, "BR");
		Aeroporto porto2 = new Aeroporto("GRU", "Guarulhos Airport", geo2, "BR");
		Aeroporto porto3 = new Aeroporto("GUZ", "Guarapari Airport", geo3, "BR");
		Aeroporto porto4 = new Aeroporto("LBG", "Paris-Le Bourget Airport", geo4, "FR");
		gporto1.adicionar(porto1);
		gporto1.adicionar(porto2);
		gporto1.adicionar(porto3);
		gporto1.adicionar(porto4);
		System.out.println("- Buscar aeroporto pelo código 'GRU': " + gporto1.buscarPorCodigo("GRU").getNome());
		System.out.println("- Buscar aeronave pelo código 'não existe': " + gporto1.buscarPorCodigo("não existe"));
		System.out.println();

		System.out.println("-> Teste dos métodos da classe Aeroporto:");
		System.out.println("- Total de aeroportos: " + Aeroporto.getTotalAeroportos());
		System.out.println("- Código do aeroporto 'POA': " + porto1.getCodigo());
		System.out.println("- Nome do aeroporto 'GRU': " + porto2.getNome());
		System.out.println("- Coordenadas do aeroporto 'POA': " + porto1.getLocal().getLatitude() + "; "
				+ porto1.getLocal().getLongitude());
		System.out.println("- Pais do aeroporto 'POA': " + porto1.getPais());
		System.out.println();

		System.out.println("-> Teste dos métodos da classe GerenciadorCias:");
		CiaAerea cia1 = new CiaAerea("3J", "Jubba Airways Ltd");
		CiaAerea cia2 = new CiaAerea("3K", "Jetstar Asia");
		gcia1.adicionar(cia1);
		gcia1.adicionar(cia2);
		System.out.println("- Buscar companhia pelo código '3J': " + gcia1.buscarCodigo("3J").getNome());
		System.out.println("- Buscar companhia pelo código 'não existe': " + gcia1.buscarCodigo("não existe"));
		System.out.println("- Buscar companhia pelo nome 'Jetstar Asia': " + gcia1.buscarNome("Jetstar Asia"));
		System.out.println("- Buscar companhia pelo nome 'não existe': " + gcia1.buscarNome("não existe"));
		System.out.println();

		System.out.println("-> Teste dos métodos da classe CiaAerea:");
		System.out.println("- Total de companhias: " + CiaAerea.getTotalCias());
		System.out.println("- Código da companhia 'Jetstar Asia: " + cia2.getCodigo());
		System.out.println("- Nome da companhia '3J': " + cia1.getNome());
		System.out.println();

		System.out.println("-> Teste dos métodos da classe GerenciadorRotas:");
		Rota rota1 = new Rota(cia1, porto1, porto2, nave1);
		Rota rota2 = new Rota(cia1, porto2, porto1, nave1);
		Rota rota3 = new Rota(cia1, porto2, porto4, nave1);
		grota1.adicionar(rota1);
		grota1.adicionar(rota2);
		grota1.adicionar(rota3);
		System.out.println("- Buscar origem pela rota 'rota2': " + grota1.buscarPorOrigem(rota2));
		System.out.println();

		System.out.println("-> Teste dos métodos da classe Rota:");
		System.out.println("- Total de rotas: " + Rota.getTotalRotas());
		System.out.println("- Companhia da rota 'rota1': " + rota1.getCia().getNome());
		System.out.println("- Destino da rota 'rota2': " + rota2.getDestino().getNome());
		System.out.println("- Origem da rota 'rota2': " + rota2.getOrigem().getNome());
		System.out.println("- Aeronave da rota 'rota1': " + rota1.getAeronave().getDescricao());
		System.out.println();

		System.out.println("-> Teste dos métodos da classe GerenciadorVoos:");
		LocalDateTime ldt1 = LocalDateTime.of(2021, 8, 07, 18, 0);
		LocalDateTime ldt2 = LocalDateTime.of(2021, 12, 10, 17, 30);
		Duration d1 = Duration.ofMinutes(120);
		Duration d2 = Duration.ofMinutes(240);
		VooDireto v1 = new VooDireto(rota1, null, ldt1, d1, Status.CONFIRMADO);
		VooDireto v2 = new VooDireto(rota2, null, ldt2, d1, Status.CONFIRMADO);
		VooEscalas v3 = new VooEscalas(rota1, rota3, ldt2, d2, Status.CONFIRMADO);
		gvoo1.adicionar(v1);
		gvoo1.adicionar(v2);
		gvoo1.adicionar(v3);
		System.out.println("- Listar todos os voos: " + gvoo1.listarTodos());
		System.out.println("- Buscar voo pela data 10/12/2021: " + gvoo1.buscarPorData(ldt2));
		System.out.println("- Buscar voo pela data 07/08/2021: " + gvoo1.buscarPorData(ldt1));
		System.out.println();

		System.out.println("-> Teste dos métodos da classe VooDireto:");
		System.out.println("- Rota do voo 'v1': " + v1.getRota().getOrigem().getNome() + " até "
				+ v1.getRota().getDestino().getNome());
		System.out.println("- Duração do voo 'v1': "
				+ v1.getDuracao(v1.getRota().getOrigem().getLocal(), v1.getRota().getDestino().getLocal())
				+ " minutos");
		System.out.println();

		System.out.println("\nEXERCÍCIO 2\n");
		System.out.println("Realizar commits");
		System.out.println();

		System.out.println("\nEXERCÍCIO 3\n");

		System.out.println("-> Teste da fórmula para encontrar a distância:");
		System.out.println("- Distância entre POA e GRU: " + Geo.distancia(geo1, geo2) + " km");
		System.out.println("- Distância entre POA e os demais: " + Geo.distanciaTodos(gporto1.getArrayList(), porto1));
		System.out.println();

		System.out.println("\nEXERCÍCIO 4\n");

		System.out.println("-> Teste dos métodos da classe VooEscalas:");
		System.out.println("- Rota do voo 'v3': " + v3.getRota().getOrigem().getNome() + " com escala em "
				+ v3.getRota().getDestino().getNome() + " com destino final em "
				+ v3.getRotaFinal().getDestino().getNome());
		System.out.println("- Duração do voo 'v3': "
				+ v3.getDuracao(v3.getRota().getOrigem().getLocal(), v3.getRota().getDestino().getLocal())
				+ " minutos");
		System.out.println();

		System.out.println("\nEXERCÍCIO 5\n");

		System.out.println("- Duração do voo de POA até GRU: " + v1.getDuracao(geo1, geo2) + " minutos");
		System.out.println();

		System.out.println("\nARQUIVOS\n");

		System.out.println("-> Métodos de listar todos mostrando os arquivos: ");
		System.out.println("(O método que lista as rotas esta comentado pois existem mais de 72.000 rotas)");
		System.out.println("- Listar todas as aeronaves: " + gnave1.listarTodas());
		System.out.println("- Listar todos as aeroportos: " + gporto1.listarTodos());
		System.out.println("- Listar todas as companhias: " + gcia1.listarTodas());
		// System.out.println("- Listar todas as rotas: " + grota1.listarTodas());
	}
}