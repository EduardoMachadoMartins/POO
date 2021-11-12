package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GerenciadorCias {

	private ArrayList<CiaAerea> empresas;
	private static GerenciadorCias gcia2 = null;

	public GerenciadorCias() {
		empresas = new ArrayList<>();
	}

	public static GerenciadorCias getInstance() {
		if (gcia2 == null) {
			gcia2 = new GerenciadorCias();
		}
		return gcia2;
	}

	public boolean carregaDados(String nomeArquivo) {
		Path path = Paths.get(nomeArquivo);
		try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("utf8"))) {
			String line = null;
			line = reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] dados = line.split(";");
				String cod = dados[0];
				String nome = dados[1];
				CiaAerea novo = new CiaAerea(cod, nome);
				adicionar(novo);
			}
		} catch (IOException x) {
			System.err.format("Erro de E/S: %s%n", x);
		}
		return true;
	}

	public void adicionar(CiaAerea cia) {
		empresas.add(cia);
	}

	public String listarTodas() {
		String lista = "\n";
		for (CiaAerea aux : empresas)
			lista += aux.getNome() + ";\n";
		return lista;
	}

	public CiaAerea buscarCodigo(String cod) {

		for (int i = 0; i < empresas.size(); i++) {
			if (empresas.get(i).getCodigo().equals(cod)) {
				return empresas.get(i);
			}
		}
		return null;
	}

	public String buscarNome(String cod) {

		for (int i = 0; i < empresas.size(); i++) {
			if (empresas.get(i).getNome().equals(cod)) {
				return empresas.get(i).getCodigo();
			}
		}
		return null;
	}
}