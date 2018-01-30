package br.edu.ifg.loja.commons.exceptions;

/**
 * Exceção que ocorre quando um elemento não é encontrado
 * @author otaviocx
 */
public class NaoEncontradoException extends RuntimeException {

    public NaoEncontradoException() {
        super("Elemento não encontrado", null);
    }

    public NaoEncontradoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}