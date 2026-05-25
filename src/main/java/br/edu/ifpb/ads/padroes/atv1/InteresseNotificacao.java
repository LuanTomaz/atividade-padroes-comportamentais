package br.edu.ifpb.ads.padroes.atv1;

import java.util.Objects;

public class InteresseNotificacao {

    private final TipoInteresse tipo;
    private final String valor;
    private final CanalNotificacao canalNotificacao;

    public InteresseNotificacao(TipoInteresse tipo, String valor, CanalNotificacao canalNotificacao) {
        this.tipo = Objects.requireNonNull(tipo, "tipo nao pode ser nulo");
        this.valor = Objects.requireNonNull(valor, "valor nao pode ser nulo");
        this.canalNotificacao = Objects.requireNonNull(canalNotificacao, "canalNotificacao nao pode ser nulo");
    }

    public boolean corresponde(Disco disco) {
        return switch (tipo) {
            case TITULO -> contem(disco.getTitulo(), valor);
            case ARTISTA -> contem(disco.getArtista(), valor);
            case GENERO -> contem(disco.getGenero(), valor);
        };
    }

    public void notificar(Disco disco) {
        canalNotificacao.enviar(mensagemPara(disco));
    }

    private String mensagemPara(Disco disco) {
        return switch (tipo) {
            case TITULO -> "Novo disco adicionado: " + disco.getTitulo();
            case ARTISTA -> "Novo disco do artista: " + disco.getArtista();
            case GENERO -> "Novo disco do genero: " + disco.getGenero();
        };
    }

    private boolean contem(String texto, String valor) {
        return texto != null && texto.toLowerCase().contains(valor.toLowerCase());
    }
}
