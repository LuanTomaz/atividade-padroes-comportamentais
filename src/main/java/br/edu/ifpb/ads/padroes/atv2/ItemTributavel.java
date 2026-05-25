package br.edu.ifpb.ads.padroes.atv2;

public interface ItemTributavel {

    String getDescricao();

    double getValor();

    void aceitar(ItemVisitor visitor);
}
