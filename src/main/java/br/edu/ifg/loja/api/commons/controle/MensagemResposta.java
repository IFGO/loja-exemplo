package br.edu.ifg.loja.api.commons.controle;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Representa uma mensagem de resposta para um end-point qualquer
 * @author otaviocx
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MensagemResposta {

    private Integer codigo;
    private String mensagem;
    private Object dados;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Object getDados() {
        return dados;
    }

    public void setDados(Object dados) {
        this.dados = dados;
    }
}
