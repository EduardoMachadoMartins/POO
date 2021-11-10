package pucrs.myflight.modelo;

import java.util.*;

public class GerenciadorAeroportos {

    private ArrayList<Aeroporto> aeroportos;

    public GerenciadorAeroportos() {
        aeroportos = new ArrayList<>();
    }
    
    public void adicionar (Aeroporto aero) {
        aeroportos.add(aero);
    }

    
    public ArrayList<Aeroporto> listarTodos() {
        return aeroportos;
    }

    public Aeroporto buscarPorCodigo (String cod) {
        for (int i = 0; i < aeroportos.size(); i++) {
			if(aeroportos.get(i).getCodigo().equals(cod)) {
				return aeroportos.get(i);
			}
		}
		return null;
    }
    

}
