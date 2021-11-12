package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class GerenciadorRotas {

    private ArrayList<Rota> rotas;
    private static GerenciadorRotas grota2 = null;

    public GerenciadorRotas() {
        rotas = new ArrayList<>();
    }

    public static GerenciadorRotas getInstance() {
        if (grota2 == null) {
            grota2 = new GerenciadorRotas();
        }
        return grota2;
    }

    public boolean carregarDados(String nomeArquivo, GerenciadorCias gcia, GerenciadorAeroportos gaer,
            GerenciadorAeronaves gaev) {
        Path path1 = Paths.get(nomeArquivo);
        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
            String line = null;
            line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(";");
                CiaAerea cia = gcia.buscarCodigo(dados[0]);
                Aeroporto aer1 = gaer.buscarPorCodigo(dados[1]);
                Aeroporto aer2 = gaer.buscarPorCodigo(dados[2]);
                Aeronave aev = gaev.buscarPorCodigo(dados[4]);
                Rota novo = new Rota(cia, aer1, aer2, aev);
                adicionar(novo);
            }
        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
        return true;
    }

    public void adicionar(Rota rota) {
        rotas.add(rota);
    }

    public String listarTodas() {
        String lista = "";
        for (Rota aux : rotas)
            lista += aux.getOrigem().getNome() + " até " + aux.getDestino().getNome() + "; ";
        return lista;
    }

    public String buscarPorOrigem(Rota orig) {
        return orig.getOrigem().getNome();
    }
}
