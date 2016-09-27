package com.springapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.oxm.Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.PathExtensionContentNegotiationStrategy;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.springframework.web.servlet.view.xml.MarshallingView;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: akol
 * Date: 7/1/13
 * Time: 4:29 PM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.springapp"})
@Import(value = {BeanConfig.class, JpaConfig.class, HazelCastConfig.class})
public class WebConfig extends WebMvcConfigurerAdapter implements ServletContextAware {

    @Autowired
    private Marshaller marshaller;

    private ServletContext servletContext;


    @Bean
    public ViewResolver contentNegotiationViewResolver() {
        ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
        viewResolver.setOrder(1);
        viewResolver.setContentNegotiationManager(getSupportedMediaTypes());
        viewResolver.setDefaultViews(getDefaultViews());
        List<ViewResolver> viewResolvers = new ArrayList<ViewResolver>();
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        viewResolvers.add(tilesViewResolver);
        viewResolver.setViewResolvers(viewResolvers);
        return viewResolver;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("/WEB-INF/views/views.xml");
        return tilesConfigurer;
    }

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver(servletContext);
        //resolver.setMaxUploadSize(MAX_FILE_UPLOAD_SIZE);
        //resolver.setMaxInMemorySize(MAX_FILE_UPLOAD_IN_MEMORY);
        return resolver;
    }

    private List<View> getDefaultViews() {
        List<View> defaultViewResolver = new ArrayList<View>();
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        defaultViewResolver.add(view);
        MarshallingView marshallingView = new MarshallingView(marshaller);
        defaultViewResolver.add(marshallingView);
        return defaultViewResolver;
    }

    private ContentNegotiationManager getSupportedMediaTypes() {
        Map<String, MediaType> mediaTypes = new HashMap<String, MediaType>();
        mediaTypes.put("html", MediaType.TEXT_HTML);
        mediaTypes.put("xml", MediaType.APPLICATION_XML);
        mediaTypes.put("json", MediaType.APPLICATION_JSON);
        PathExtensionContentNegotiationStrategy strategy = new PathExtensionContentNegotiationStrategy(mediaTypes);
        ContentNegotiationManager manager = new ContentNegotiationManager(strategy);
        return manager;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/static/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/static/css/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }


}
