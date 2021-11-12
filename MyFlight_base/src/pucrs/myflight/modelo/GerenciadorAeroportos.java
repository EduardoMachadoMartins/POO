package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class GerenciadorAeroportos {

    private ArrayList<Aeroporto> aeroportos;
    private static GerenciadorAeroportos gporto2 = null;

    public GerenciadorAeroportos() {
        aeroportos = new ArrayList<>();
    }

    public static GerenciadorAeroportos getInstance() {
        if (gporto2 == null) {
            gporto2 = new GerenciadorAeroportos();
        }
        return gporto2;
    }

    public boolean carregaDados(String nomeArquivo) {
        Path path = Paths.get(nomeArquivo);
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("utf8"))) {
            String line = null;
            line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(";");
                String cod = dados[0];
                double lat = Double.parseDouble(dados[1]);
                double lon = Double.parseDouble(dados[2]);
                Geo geo = new Geo(lat, lon);
                String nome = dados[3];
                String pais = dados[4];
                Aeroporto novo = new Aeroporto(cod, nome, geo, pais);
                adicionar(novo);
            }
        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
        return true;
    }

    public void adicionar(Aeroporto aero) {
        aeroportos.add(aero);
    }

    public String listarTodos() {
        String lista = "\n";
        for (Aeroporto aux : aeroportos)
            lista += aux.getNome() + ";\n";
        return lista;
    }

    public Aeroporto buscarPorCodigo(String cod) {
        for (int i = 0; i < aeroportos.size(); i++) {
            if (aeroportos.get(i).getCodigo().equals(cod)) {
                return aeroportos.get(i);
            }
        }
        return null;
    }

    public ArrayList<Aeroporto> getArrayList() {
        return aeroportos;
    }
}
