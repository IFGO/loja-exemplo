package br.edu.ifg.loja.api.commons.exceptions;

/**
 * Exceção que ocorre quando algum parametro de requisição está inválido ou é
 * obrigatório e não foi informado
 * @author otaviocx
 */
public class ParametrosInvalidosException extends RuntimeException {

    public ParametrosInvalidosException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
