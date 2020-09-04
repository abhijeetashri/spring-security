package com.secure.example.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class AppSecurityConfiguration extends WebSecurityConfigurerAdapter {

	/**
	 * // Uncomment this for security to behave prior to Spring 5. // Refer:
	 * https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#troubleshooting
	 * 
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 *           Exception {
	 *           auth.inMemoryAuthentication().withUser("admin").password("admin").authorities("USER");
	 *           }
	 * 
	 * @Bean public static PasswordEncoder passwordEncoder() { return
	 *       NoOpPasswordEncoder.getInstance(); }
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// authenticate for springdocs endpoint
		http.authorizeRequests().antMatchers("/springdocs/**").authenticated().and().formLogin().and().httpBasic();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode("admin");
		auth.inMemoryAuthentication().withUser("admin").password("{bcrypt}" + encodedPassword).roles("USER");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
