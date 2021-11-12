package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class GerenciadorAeronaves {

    private ArrayList<Aeronave> aeronaves;
    private static GerenciadorAeronaves gnave2 = null;;

    public GerenciadorAeronaves() {
        aeronaves = new ArrayList<>();
    }

    public static GerenciadorAeronaves getInstance() {
        if (gnave2 == null) {
            gnave2 = new GerenciadorAeronaves();
        }
        return gnave2;
    }

    public boolean carregaDados(String nomeArquivo) {
        Path path = Paths.get(nomeArquivo);
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("utf8"))) {
            String line = null;
            line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(";");
                String cod = dados[0];
                String descricao = dados[1];
                int capacidade = Integer.parseInt(dados[2]);
                Aeronave novo = new Aeronave(cod, descricao, capacidade);
                adicionar(novo);
            }
        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
        return true;
    }

    public void adicionar(Aeronave aviao) {
        aeronaves.add(aviao);
    }

    public String listarTodas() {
        String lista = "\n";
        for (Aeronave aux : aeronaves)
            lista += aux.getDescricao() + ";\n";
        return lista;
    }

    public Aeronave buscarPorCodigo(String cod) {

        for (int i = 0; i < aeronaves.size(); i++) {
            if (aeronaves.get(i).getCodigo().equals(cod)) {
                return aeronaves.get(i);
            }
        }
        return null;
    }
}