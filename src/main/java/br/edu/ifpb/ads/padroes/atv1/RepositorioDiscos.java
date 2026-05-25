package br.edu.ifpb.ads.padroes.atv1;

import java.util.LinkedList;
import java.util.List;

public class RepositorioDiscos {

    private List<Disco> discos = new LinkedList<>();
    private String canalNotificacao;
    private List<InteresseNotificacao> interesses = new LinkedList<>();
    private ServicoNotificacao servicoNotificacao = new ServicoNotificacao();

    public List<Disco> buscarDiscos(String titulo) {
        return discos.stream().filter(d -> d.getTitulo().toLowerCase()
                .contains(titulo.toLowerCase())).toList();
    }

    public List<Disco> buscarDiscosPorArtista(String artista) {
        return discos.stream().filter(d -> d.getArtista().toLowerCase()
                .contains(artista.toLowerCase())).toList();
    }

    public List<Disco> buscarDiscosPorGenero(String genero) {
        return discos.stream().filter(d -> d.getGenero().toLowerCase()
                .contains(genero.toLowerCase())).toList();
    }

    public List<Disco> buscarDiscosPorAno(int ano) {
        return discos.stream().filter(d -> d.getAnoLancamento() == ano).toList();
    }

    public void addDisco(Disco disco) {
        discos.add(disco);
        notificar(disco);
    }

    public void removeDisco(Disco disco) {
        discos.remove(disco);
    }

    public String getCanalNotificacao() {
        return canalNotificacao;
    }

    public void setCanalNotificacao(String canalNotificacao) {
        this.canalNotificacao = canalNotificacao;
    }

    public void addNotificacaoDisco(String disco) {
        addInteresseTitulo(disco, canalPadrao());
    }

    public void addNotificacaoArtista(String artista) {
        addInteresseArtista(artista, canalPadrao());
    }

    public void addNotificacaoGenero(String genero) {
        addInteresseGenero(genero, canalPadrao());
    }

    public void addInteresseTitulo(String titulo, CanalNotificacao canalNotificacao) {
        interesses.add(new InteresseNotificacao(TipoInteresse.TITULO, titulo, canalNotificacao));
    }

    public void addInteresseArtista(String artista, CanalNotificacao canalNotificacao) {
        interesses.add(new InteresseNotificacao(TipoInteresse.ARTISTA, artista, canalNotificacao));
    }

    public void addInteresseGenero(String genero, CanalNotificacao canalNotificacao) {
        interesses.add(new InteresseNotificacao(TipoInteresse.GENERO, genero, canalNotificacao));
    }

    private void notificar(Disco disco) {
        interesses.stream()
                .filter(interesse -> interesse.corresponde(disco))
                .forEach(interesse -> interesse.notificar(disco));
    }

    private CanalNotificacao canalPadrao() {
        if (canalNotificacao == null) {
            throw new IllegalStateException("Canal de notificacao padrao nao configurado.");
        }
        return servicoNotificacao.criarCanal(canalNotificacao);
    }
}
