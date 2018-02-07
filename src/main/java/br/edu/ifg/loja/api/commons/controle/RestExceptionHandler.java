package br.edu.ifg.loja.api.commons.controle;

import br.edu.ifg.loja.api.commons.exceptions.NaoEncontradoException;
import br.edu.ifg.loja.api.commons.exceptions.ParametrosInvalidosException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private Map<Class<? extends RuntimeException>, HttpStatus> statusMap;

    public RestExceptionHandler() {
        this.statusMap = new HashMap<>();
        this.statusMap.put(NaoEncontradoException.class, HttpStatus.NOT_FOUND);
        this.statusMap.put(ParametrosInvalidosException.class, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ RuntimeException.class })
    protected ResponseEntity<MensagemResposta> handleRuntime(Exception ex, WebRequest request) {
        HttpStatus status = statusMap.getOrDefault(ex.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);

        MensagemResposta resposta = new MensagemResposta();
        resposta.setCodigo(status.value());
        resposta.setMensagem(ex.getMessage());
        return ResponseEntity.status(status).body(resposta);
    }
}