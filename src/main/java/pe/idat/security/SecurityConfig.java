package pe.idat.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import pe.idat.service.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserServiceImpl userServiceImpl;



	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userServiceImpl);
	}



	
	//archivos de libre acceso
	String[] resourses = new String[] {
			"/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**","/login.css"
	};
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
	
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers(resourses).permitAll()
			.antMatchers("/","/museo/login").permitAll()
			.antMatchers("/museo/inicio").permitAll()
			.antMatchers("/museo/cargo/listar").access("hasRole('ADMIN')")
			.anyRequest().authenticated()
			.and()
		.formLogin().loginPage("/museo/login")
			.defaultSuccessUrl("/museo/inicio")
			.failureUrl("/login?error=true")
			.usernameParameter("username")
			.passwordParameter("password")
			.and()
		.logout()
			.permitAll()
			.logoutSuccessUrl("/login?logout");
		
		
		
		//autenticacion basica
		http.authorizeRequests().and().
		httpBasic().
		and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


}
