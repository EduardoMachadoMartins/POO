package pucrs.myflight.consoleApp;

import pucrs.myflight.modelo.Aeronave;
import pucrs.myflight.modelo.Aeroporto;
import pucrs.myflight.modelo.CiaAerea;
import pucrs.myflight.modelo.Geo;
import pucrs.myflight.modelo.Gerenciador;
import pucrs.myflight.modelo.GerenciadorAeronaves;
import pucrs.myflight.modelo.GerenciadorAeroportos;
import pucrs.myflight.modelo.GerenciadorCias;
import pucrs.myflight.modelo.GerenciadorRotas;
import pucrs.myflight.modelo.GerenciadorVoos;
import pucrs.myflight.modelo.Rota;
import pucrs.myflight.modelo.Voo;
import pucrs.myflight.modelo.VooEscalas;
import java.time.LocalDateTime;
import java.time.Duration;
import java.util.*;

public class App {

	public static void main(String[] args) {

		System.out.println("\nMyFlight project...\n");

		System.out.println("\nEXERCÍCIO 1\n");
		
		Gerenciador g1 = new Gerenciador();
		GerenciadorAeronaves gnave1 = new GerenciadorAeronaves();
		GerenciadorAeroportos gporto1 = new GerenciadorAeroportos();
		GerenciadorCias gcia1 = new GerenciadorCias();
		GerenciadorRotas grota1 = new GerenciadorRotas();
		GerenciadorVoos gvoo1 = new GerenciadorVoos();

		System.out.println("-> Teste dos métodos da calsse GerenciadorAeronaves:");
		Aeronave a1 = new Aeronave("0001", "IJKL");
		Aeronave a2 = new Aeronave("0002", "MNOP");
		Aeronave a3 = new Aeronave("0003", "QRST");
		gnave1.adicionar(a1);
		gnave1.adicionar(a2);
		gnave1.adicionar(a3);
		System.out.println("- Listar todas as aeronaves: " + gnave1.listarTodas());
		System.out.println("- Buscar aeronave pelo código '0001': " + gnave1.buscarPorCodigo("0001"));
		System.out.println("- Buscar aeronave pelo código 'não existe': " + gnave1.buscarPorCodigo("não existe"));
		System.out.println();

		System.out.println("-> Teste dos métodos da calsse Aeronave:");
		System.out.println("- Total de aeronaves: " + Aeronave.getTotalAeronaves());
		System.out.println("- Código da aeronave 'a1': " + a1.getCodigo());
		System.out.println("- Descrição da aeronave 'a2': " + a2.getDescricao());
		System.out.println();

		System.out.println("-> Teste dos métodos da calsse GerenciadorAeroportos:");
		Geo AAAA = new Geo(-29.9939, -51.1711);
		Geo BBBB = new Geo (-23.4356, -46.4731);
		Aeroporto POA = new Aeroporto("AAAA", "Salgado Filho", AAAA);
		Aeroporto GRU = new Aeroporto("BBBB", "Guarulhos", BBBB);
		gporto1.adicionar(POA);
		gporto1.adicionar(GRU);
		System.out.println("- Listar todos as aeroportos: " + gporto1.listarTodos());
		System.out.println("- Buscar aeroporto pelo código 'BBBB': " + gporto1.buscarPorCodigo("BBBB"));
		System.out.println("- Buscar aeronave pelo código 'não existe': " + gporto1.buscarPorCodigo("não existe"));
		System.out.println();

		System.out.println("-> Teste dos métodos da calsse Aeroporto:");
		System.out.println("- Total de aeroportos: " + Aeroporto.getTotalAeroportos());
		System.out.println("- Código do aeroporto 'POA': " + POA.getCodigo());
		System.out.println("- Nome do aeroporto 'GRU': " + GRU.getNome());
		System.out.println("- Coordenadas do aeroporto 'POA': " + POA.getLocal());
		System.out.println();

		System.out.println("-> Teste dos métodos da calsse GerenciadorCias:");
		CiaAerea azul = new CiaAerea("1000", "ABCD");
		CiaAerea gol = new CiaAerea("1001", "EFGH");
		gcia1.adicionar(azul);
		gcia1.adicionar(gol);
		System.out.println("- Listar todas as companhias: " + gcia1.listarTodas());
		System.out.println("- Buscar companhia pelo código '1001': " + gcia1.buscarCodigo("1001"));
		System.out.println("- Buscar companhia pelo código 'não existe': " + gcia1.buscarCodigo("não existe"));
		System.out.println("- Buscar companhia pelo nome 'gol': " + gcia1.buscarNome("EFGH"));
		System.out.println("- Buscar companhia pelo nome 'não existe': " + gcia1.buscarNome("não existe"));
		System.out.println();

		System.out.println("-> Teste dos métodos da calsse CiaAerea:");
		System.out.println("- Total de companhias: " + CiaAerea.getTotalCias());
		System.out.println("- Código da companhia 'gol: " + gol.getCodigo());
		System.out.println("- Nome da companhia 'azul': " + azul.getNome());
		System.out.println();

		System.out.println("-> Teste dos métodos da calsse GerenciadorRotas:");
		Rota POA_GRU = new Rota(azul, POA, GRU, a1);
		Rota GRU_POA = new Rota(azul, GRU, POA, a1);
		grota1.adicionar(POA_GRU);
		grota1.adicionar(GRU_POA);
		System.out.println("- Listar todas as rotas: " + grota1.listarTodas());
		System.out.println("- Buscar origem pela rota 'POA_GRU': ");
		System.out.println();

		System.out.println("-> Teste dos métodos da calsse Rota:");
		System.out.println("- Total de rotas: " + Rota.getTotalRotas());
		System.out.println("- Companhia da rota 'POA_GRU': " + POA_GRU.getCia());
		System.out.println("- Destino da rota 'GRU_POA': " + GRU_POA.getDestino());
		System.out.println("- Origem da rota 'GRU_POA': " + GRU_POA.getOrigem());
		System.out.println("- Aeronave da rota 'POA_GRU': " + POA_GRU.getAeronave());
		System.out.println();

		System.out.println("-> Teste dos métodos da calsse GerenciadorVoos:");
		//Voo v1 = new Voo(GRU_POA, , );
		//Voo v2 = new Voo(POA_GRU, , );
		//Voo v3 = new VooEscalas(POA_GRU, GRU_POA, , );
		//gvoo1.adicionar(v1);
		//gvoo1.adicionar(v2);
		//gvoo1.adicionar(v3);
		System.out.println("- Listar todas os voos: " + gvoo1.listarTodos());
		System.out.println();
		
		System.out.println("\nEXERCÍCIO 2\n");

		

	}
}