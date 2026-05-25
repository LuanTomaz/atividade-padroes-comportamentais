package br.edu.ifpb.ads.padroes.atv2;

import java.util.ArrayList;
import java.util.List;

public class RelatorioImpostosVisitor implements ItemVisitor {

    private final List<String> linhas = new ArrayList<>();
    private double totalImpostos;

    @Override
    public void visitar(ProdutoFisico produtoFisico) {
        registrar(produtoFisico, calcularImposto(produtoFisico));
    }

    @Override
    public void visitar(Servico servico) {
        registrar(servico, calcularImposto(servico));
    }

    public double getTotalImpostos() {
        return totalImpostos;
    }

    public List<String> getLinhas() {
        return List.copyOf(linhas);
    }

    public void imprimirRelatorio() {
        linhas.forEach(System.out::println);
        System.out.printf("Total de impostos: %.2f%n", totalImpostos);
    }

    private double calcularImposto(ProdutoFisico produtoFisico) {
        return produtoFisico.getValor() * 0.10;
    }

    private double calcularImposto(Servico servico) {
        return servico.getValor() * 0.15;
    }

    private void registrar(ItemTributavel item, double imposto) {
        totalImpostos += imposto;
        linhas.add(String.format("%s - valor: %.2f - imposto: %.2f",
                item.getDescricao(), item.getValor(), imposto));
    }
}
