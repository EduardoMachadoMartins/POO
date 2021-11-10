package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorCias {

	private ArrayList<CiaAerea> empresas;
	
	public GerenciadorCias() {
		empresas = new ArrayList<>();
	}

	public void adicionar (CiaAerea cia) {
		empresas.add(cia);
	}

	public ArrayList<CiaAerea> listarTodas() {
	
		return empresas;
		
	}

	public CiaAerea buscarCodigo(String cod) {

		for (int i = 0; i < empresas.size(); i++) {
			if(empresas.get(i).getCodigo().equals(cod)) {
				return empresas.get(i);
			}
		}
		return null;
	}

	public CiaAerea buscarNome(String cod) {
		
		for(int i = 0; i < empresas.size(); i++) {
			if(empresas.get(i).getNome().equals(cod)) {
				return empresas.get(i);
			}
		}
		return null;
	}

}