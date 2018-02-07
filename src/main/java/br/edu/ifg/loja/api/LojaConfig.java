package br.edu.ifg.loja.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Configuracoes adicionais do Spring Boot para o projeto da Loja
 * @author otaviocx
 */
@Configuration
public class LojaConfig extends WebMvcConfigurerAdapter {

    @Autowired
    AuthInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor);
    }
}