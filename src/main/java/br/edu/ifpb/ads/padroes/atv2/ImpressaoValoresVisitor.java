package br.edu.ifpb.ads.padroes.atv2;

import java.util.ArrayList;
import java.util.List;

public class ImpressaoValoresVisitor implements ItemVisitor {

    private final List<String> linhas = new ArrayList<>();

    @Override
    public void visitar(ProdutoFisico produtoFisico) {
        imprimirValor(produtoFisico);
    }

    @Override
    public void visitar(Servico servico) {
        imprimirValor(servico);
    }

    public List<String> getLinhas() {
        return List.copyOf(linhas);
    }

    private void imprimirValor(ItemTributavel item) {
        String linha = String.format("%s - valor: %.2f", item.getDescricao(), item.getValor());
        linhas.add(linha);
        System.out.println(linha);
    }
}
