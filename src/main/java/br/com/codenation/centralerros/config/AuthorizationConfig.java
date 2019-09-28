package br.com.codenation.centralerros.config;

import br.com.codenation.centralerros.entity.User;
import br.com.codenation.centralerros.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableAuthorizationServer
public class AuthorizationConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        if (userService.findAll().isEmpty()) {
            saveUser(auth);
        }
        //auth.userDetailsService(userService::findUserByCode);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(HttpMethod.GET, "/", "/webjars/**", "/*.html", "/favicon.ico", "/**/*.html",
                        "/v2/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/**",
                        "/webjars/**", "/**/*.css", "/**/*.js", "/gerarLog");
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    @SuppressWarnings("unchecked")
    public FilterRegistrationBean corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);

        return bean;
    }

    private void saveUser(AuthenticationManagerBuilder auth) throws Exception {
        for (int i = 0; i <= 4; i++) {
            User usuario = new User();
            usuario.setPassword("User" + i);
            usuario.setEmail("User" + i + "@gmail.com");
            usuario.setName("Administrador" + i);
            usuario.setCode("User" + i);
            usuario.setId((long) i);
            userService.saveConfig(usuario);//temporário esse aqui é para a autenticação e o save normal está sendo usado nos testes e enpoints
            auth.userDetailsService(userService::findUserByCode);
        }
    }
}
