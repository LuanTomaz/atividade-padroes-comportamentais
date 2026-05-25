package br.edu.ifpb.ads.padroes.atv2;

public class ProdutoFisico implements ItemTributavel {

    private final String descricao;
    private final double valor;

    public ProdutoFisico(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public double getValor() {
        return valor;
    }

    @Override
    public void aceitar(ItemVisitor visitor) {
        visitor.visitar(this);
    }
}
