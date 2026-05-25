package br.edu.ifpb.ads.padroes.atv1;

public class ServicoNotificacao {

    public void enviarNotificacao(CanalNotificacao canal, String mensagem) {
        canal.enviar(mensagem);
    }

    public CanalNotificacao criarCanal(String canal) {
        return switch (canal.toLowerCase()) {
            case "email" -> new CanalEmail();
            case "sms" -> new CanalSms();
            case "push" -> new CanalPush();
            default -> throw new IllegalArgumentException("Canal de notificacao desconhecido: " + canal);
        };
    }
}
