package pucrs.myflight.modelo;

public class Gerenciador {
    
    private GerenciadorAeronaves gerenciadorAeronaves = new GerenciadorAeronaves();
    private GerenciadorAeroportos gerenciadorAeroportos = new GerenciadorAeroportos();
    private GerenciadorCias gerenciadorCias = new GerenciadorCias();
    private GerenciadorRotas gerenciadorRotas = new GerenciadorRotas();
    private GerenciadorVoos gerenciadorVoos = new GerenciadorVoos();

    public void AdicionaAeronave(Aeronave aeronave) {
        gerenciadorAeronaves.adicionar(aeronave);
    }

    public void AdicionaAeroportos(Aeroporto aeroporto) {
        gerenciadorAeroportos.adicionar(aeroporto);
    }

    public void AdicionaCias(CiaAerea cias) {
        gerenciadorCias.adicionar(cias);
    }

    public void AdicionaRotas(Rota rotas) {
        gerenciadorRotas.adicionar(rotas);
    }

    public void AdicionaVoos(Voo voos) {
        gerenciadorVoos.adicionar(voos);
    }

    public boolean VerificaCodigoAeronave(String codigo) {
        Aeronave a = null;
        a = gerenciadorAeronaves.buscarPorCodigo(codigo);
        if (a != null) {
            return true;
        }
        return false;
    }

    public void listarTodos(String s) {
        if (s.equals("Aeronave")) {
            gerenciadorAeronaves.listarTodas();
        }
        if (s.equals("CiaAerea")) {
            gerenciadorCias.listarTodas();
        }
    }
}