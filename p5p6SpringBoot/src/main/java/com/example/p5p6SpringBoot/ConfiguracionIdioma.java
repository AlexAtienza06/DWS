package com.example.p5p6SpringBoot;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class ConfiguracionIdioma implements WebMvcConfigurer {
    /**
     * Configuramos el español como idioma inicial de la página.
     * Si el usuario cambia de idioma, se guardará su elección en la sesión.
     **/
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver resolver = new SessionLocaleResolver();
        resolver.setDefaultLocale(new Locale("es"));
        return resolver;
    }

    /**
     * Indicamos dónde están los archivos con las traducciones.
     * Spring utilizará messages.properties para español y messages_en.properties para inglés.
     **/
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource mensajes = new ResourceBundleMessageSource();
        mensajes.setBasename("messages");
        mensajes.setDefaultEncoding("UTF-8");
        return mensajes;
    }

    // Permitimos cambiar el idioma mediante el parámetro lang, pudiendo usar ?lang=es o ?lang=en.
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        return interceptor;
    }

    // Registramos el interceptor para que Spring detecte los cambios de idioma.
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}