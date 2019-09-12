package br.com.codenation.centralerros.config;

import br.com.codenation.centralerros.entity.User;
import br.com.codenation.centralerros.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AuthorizationConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	private UserService userService;

	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		if (userService.findAll().isEmpty())
		{
			User usuario = new User();
			usuario.setPassword("teste");
			usuario.setEmail("teste@gmail.com");
			usuario.setName("Administrador");
			usuario.setCode("admin");
			usuario.setId(1L);

			userService.save(usuario);
		}

		auth.userDetailsService(code -> userService.findUserByCode(code));
	}

	@Override
	public void configure(WebSecurity web) throws Exception
	{
		web.ignoring()
			.antMatchers(HttpMethod.GET, "/", "/webjars/**", "/*.html", "/favicon.ico", "/**/*.html",
				"/v2/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/**",
				"/swagger-ui.html", "/webjars/**", "/**/*.css", "/**/*.js");
	}

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception
	{
		return super.authenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}

}
