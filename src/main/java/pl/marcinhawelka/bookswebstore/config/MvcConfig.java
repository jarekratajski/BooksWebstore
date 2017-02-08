/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import pl.marcinhawelka.bookswebstore.converter.StringIdToBookConverter;
import pl.marcinhawelka.bookswebstore.converter.StringIdToPictureConverter;
import pl.marcinhawelka.bookswebstore.converter.StringIdToPublisherConverter;
import pl.marcinhawelka.bookswebstore.converter.StringIdToTypeConverter;
import pl.marcinhawelka.bookswebstore.converter.StringUsernameToUserConverter;
import pl.marcinhawelka.bookswebstore.service.interfaces.BookService;
import pl.marcinhawelka.bookswebstore.service.interfaces.PictureService;
import pl.marcinhawelka.bookswebstore.service.interfaces.PublisherService;
import pl.marcinhawelka.bookswebstore.service.interfaces.TypeService;
import pl.marcinhawelka.bookswebstore.service.interfaces.UserService;

/**
 *
 * @author Matuidi
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.marcinhawelka.bookswebstore")
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private BookService bookService;
    
    @Autowired
    private TypeService typeService;
    
    @Autowired
    private PictureService pictureService;
    
    @Autowired
    private PublisherService publisherService;
    
    @Autowired
    private UserService userService;
    
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }

    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasename("classpath:messages");
        source.setDefaultEncoding("UTF-8");
        return source;
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }

    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addConverter(new StringIdToBookConverter(bookService));
        registry.addConverter(new StringIdToTypeConverter(typeService));
        registry.addConverter(new StringIdToPictureConverter(pictureService));
        registry.addConverter(new StringIdToPublisherConverter(publisherService));
        registry.addConverter(new StringUsernameToUserConverter(userService));
    }
}
