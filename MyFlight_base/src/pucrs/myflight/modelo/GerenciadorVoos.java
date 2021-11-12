package pucrs.myflight.modelo;

import java.time.LocalDateTime;
import java.util.*;

public class GerenciadorVoos {

    private ArrayList<Voo> voos;

    public GerenciadorVoos() {
        voos = new ArrayList<>();
    }

    public void adicionar(Voo voo) {
        voos.add(voo);
    }

    public String listarTodos() {
        String lista = "";
        int i = 0;
        for (Voo aux : voos) {
            if (voos.get(i).getRotaFinal() != null) {
                lista += "\n" + aux.getRota().getOrigem().getNome() + " faz escala em "
                        + aux.getRota().getDestino().getNome() + " com destino final em "
                        + ((Rota) aux.getRotaFinal()).getDestino().getNome() + ";";
            } else {
                lista += "\n" + aux.getRota().getOrigem().getNome() + " com destino final em "
                        + aux.getRota().getDestino().getNome() + ";";
            }
            i++;
        }
        return lista;
    }

    public String buscarPorData(LocalDateTime datahora) {
        int i = 0;
        for (Voo voo : voos) {
            if (voo.getDatahora().equals(datahora))
                if (voos.get(i).getRotaFinal() != null) {
                    return "" + voo.getRota().getOrigem().getNome() + " faz escala em "
                            + voo.getRota().getDestino().getNome() + " com destino final em "
                            + ((Rota) voo.getRotaFinal()).getDestino().getNome() + ";";
                } else {
                    return "" + voo.getRota().getOrigem().getNome() + " com destino final em "
                            + voo.getRota().getDestino().getNome() + ";";
                }
            i++;
        }
        return null;
    }
}
