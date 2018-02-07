package br.edu.ifg.loja.api;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interceptador para verificar se o usuário está logado
 * @author otaviocx
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {

    Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception ex)
            throws Exception {
        // nenhuma ação a ser realizada
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView model)
            throws Exception {
        // nenhuma ação a ser realizada
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String pathInfo = request.getRequestURI();
        boolean auth = pathInfo != null && pathInfo.indexOf("/login") == 0;

        String httpMethod = request.getMethod();

        if (!auth && !httpMethod.equals("OPTIONS")) {
            doValidation(request, response);
        }

        return true;
    }

    private void doValidation(HttpServletRequest request, HttpServletResponse response) {

    }

}
