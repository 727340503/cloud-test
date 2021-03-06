package com.cherrypicks.tcc.cms.api.config;

import java.text.SimpleDateFormat;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cherrypicks.tcc.cms.api.filter.CorsFilter;
import com.cherrypicks.tcc.cms.api.filter.RestfulFilter;
import com.cherrypicks.tcc.util.DateUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("deprecation")
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.cherrypicks.tcc.cms.api.controller", "com.cherrypicks.tcc.cms.service","com.cherrypicks.tcc.cms.dao", 
								"com.cherrypicks.tcc.cms.util", "com.cherrypicks.tcc.cms.api.util"})
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

	@Bean
    public FilterRegistrationBean characterEncodingFilter(@Value("${character.encoding}") final String characterEncoding) {
        final CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding(characterEncoding);
        characterEncodingFilter.setForceEncoding(true);

        final FilterRegistrationBean reg = new FilterRegistrationBean();
        reg.setFilter(characterEncodingFilter);
        reg.addUrlPatterns("/*");
        return reg;
    }

	@Bean
    public FilterRegistrationBean corsFilter(@Value("*") final String allowedOrigins, @Value("false") final String allowCredentials) {
        return new FilterRegistrationBean(new CorsFilter(allowedOrigins, allowCredentials));
    }

	@Bean
    public FilterRegistrationBean restfulFilter() {
        final FilterRegistrationBean reg = new FilterRegistrationBean();
        reg.setFilter(new RestfulFilter());
        reg.addUrlPatterns("/*");
        return reg;
    }

    // Default JSON Date Format
    @Bean
    public ObjectMapper jsonMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat(DateUtil.DATETIME_PATTERN_DEFAULT));

        return objectMapper;
    }

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(final ConfigurableEmbeddedServletContainer container) {
                final ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/pageNotFound");
                final ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error");
                container.addErrorPages(error404Page, error500Page);
            }
        };
    }

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        final CommonsRequestLoggingFilter crlf = new CommonsRequestLoggingFilter();
        crlf.setIncludeClientInfo(true);
        crlf.setIncludeQueryString(true);
        crlf.setIncludePayload(true);
        return crlf;
    }

    @Bean
    MultipartConfigElement multipartConfigElement(@Value("${multipart.maxFileSize}") final String multipartMaxFileSize,
            @Value("${multipart.maxRequestSize}") final String multipartMaxRequesteSize) {
        final MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(multipartMaxFileSize);
        factory.setMaxRequestSize(multipartMaxRequesteSize);
        return factory.createMultipartConfig();
    }

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        
    }

}
