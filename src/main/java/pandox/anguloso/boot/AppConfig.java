package pandox.anguloso.boot;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pandox.anguloso.boot.util.BasePropertyConfigurer;
import pandox.anguloso.boot.util.NameGenerator;

import java.util.HashMap;

/**
 * Classe de configuração Spring MVC 3
 */
@Configuration
@PropertySource("classpath:config.properties")
@ComponentScan(nameGenerator = NameGenerator.class, basePackages = "pandox", excludeFilters = @Filter(Configuration.class))
//@EnableTransactionManagement
//@EnableJpaRepositories("pandox.anguloso.repo")
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {

    private static Logger log = Logger.getLogger(AppConfig.class);

    private static HashMap<String, Object> velocityProperties = new HashMap<String, Object>();

    @Bean
    public static final BasePropertyConfigurer propertyConfigurer() {

        BasePropertyConfigurer config = new BasePropertyConfigurer();
        config.setIgnoreResourceNotFound(false);
        Resource location = new ClassPathResource("config.properties");
        config.setLocation(location);
        return config;
    }

//    @Bean
//    public DriverManagerDataSource dataSource() {
//        log.info("Configurando [dataSource]...");
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName("com.mysql.jdbc.Driver");
//
////        ds.setUrl("jdbc:mysql://mydbinstance.cpaisbs3w0fy.sa-east-1.rds.amazonaws.com:3306/china");
////        ds.setUsername("pandox");
////        ds.setPassword("pandox123");
//
//        ds.setUrl("jdbc:mysql://localhost/egito");
//        ds.setUsername("root");
//        ds.setPassword("");
//        log.info("Datasource configurado: " + ds.toString());
//        return ds;
//    }
//
//    @Bean
//    public JpaTransactionManager transactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//        return transactionManager;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        log.info("Configurando [entityManagerFactory]...");
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//
//        entityManagerFactoryBean.setDataSource(dataSource());
//        entityManagerFactoryBean.setPackagesToScan("pandox.china");
//        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
//
//        Properties hibernateProperties = new Properties();
//        boolean bootable = false;
//        if (bootable) {
//            hibernateProperties.put("hbm2ddl.auto", "create");
//            hibernateProperties.put("hibernate.hbm2ddl.auto", "create");
//        } else {
//            hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
//        }
//
//        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//        hibernateProperties.put("hibernate.format_sql", "false");
//        hibernateProperties.put("hibernate.show_sql", "false");
//
//        entityManagerFactoryBean.setJpaProperties(hibernateProperties);
//
//        log.info(entityManagerFactoryBean);
//        return entityManagerFactoryBean;
//    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }


    @Bean(name = "resourceBundleMessageSource")
    public static final ReloadableResourceBundleMessageSource resourceBundleMessageSource() {
        ReloadableResourceBundleMessageSource resourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("classpath:Messages");
        resourceBundleMessageSource.setDefaultEncoding("utf-8");
        return resourceBundleMessageSource;
    }

    @Bean
    public static final ReloadableResourceBundleMessageSource config() {
        ReloadableResourceBundleMessageSource resourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("classpath:config");
        resourceBundleMessageSource.setDefaultEncoding("utf-8");
        return resourceBundleMessageSource;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/WEB-INF/pages/");
    }

}
