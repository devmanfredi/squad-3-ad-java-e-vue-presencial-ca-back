package br.com.codenation.centralerros.config;

import br.com.codenation.centralerros.entity.Users;
import br.com.codenation.centralerros.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
@AllArgsConstructor
public class AuthorizationServerConfig extends WebSecurityConfigurerAdapter {

    private UserService userService;

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        Users usuario = new Users();
        usuario.setPassword("12345");
        usuario.setEmail("paulo.vieira@gmail.com");
        usuario.setName("Paulo GUstavo");
        usuario.setCode("pgvieira");

        if (userService.findAll().isEmpty())
            userService.save(usuario);


        auth.userDetailsService(code ->
            userService.findUserByCode(code)
        );
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.GET,
                "/",
                "/webjars/**",
                "/*.html",
                "/favicon.ico",
                "/**/*.html",
                "/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/**",
                "/swagger-ui.html",
                "/webjars/**",
                "/**/*.css",
                "/**/*.js"
        );
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

}
