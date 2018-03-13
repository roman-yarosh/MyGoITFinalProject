package ua.goit.finall.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().withUser("roman").password("1").roles("USER");
        auth.inMemoryAuthentication().withUser("kostya").password("1").roles("USER");
        auth.inMemoryAuthentication().withUser("nastya").password("1").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

	@Override
    protected void configure(HttpSecurity http) throws Exception {
/* work but simple
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
*/
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/login", "/logout").permitAll()
                .antMatchers( "/employeeInfo").hasAnyRole("USER","ADMIN").anyRequest().authenticated()
                .antMatchers( "/admin**").hasAnyRole("USER","ADMIN").anyRequest().authenticated()

                .antMatchers( "/api/employees**").hasRole("ADMIN").anyRequest().authenticated()
                .antMatchers( "/api/departments**").hasRole("ADMIN").anyRequest().authenticated()
                .antMatchers( "/api/events**").hasRole("ADMIN").anyRequest().authenticated()
                .antMatchers( "/api/eventTypes**").hasRole("ADMIN").anyRequest().authenticated()
                .antMatchers( "/api/positions**").hasRole("ADMIN").anyRequest().authenticated()
                .antMatchers( "/api/salaries**").hasRole("ADMIN").anyRequest().authenticated()
                .antMatchers( "/api/statuses**").hasRole("ADMIN").anyRequest().authenticated()
                .antMatchers( "/api/users**").hasRole("ADMIN").anyRequest().authenticated()
                .antMatchers( "/api/roles**").hasRole("ADMIN").anyRequest().authenticated()

        // Config for Login Form
        .and().formLogin()//
                // Submit URL of login page.
                //.loginProcessingUrl("/j_spring_security_check") // Submit URL
                //.loginPage("/login")//when custom login form will be ready
                //.defaultSuccessUrl("/welcome")//
                //.failureUrl("/login?error=true")//
                //.usernameParameter("username")//
                //.passwordParameter("password")
                // Config for Logout Page
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
    }
}

/*
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private DataSource dataSource;

	@Value("${spring.queries.users-query}")
	private String usersQuery;

	@Value("${spring.queries.roles-query}")
	private String rolesQuery;

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.
			jdbcAuthentication()
				.usersByUsernameQuery(usersQuery)
				.authoritiesByUsernameQuery(rolesQuery)
				.dataSource(dataSource)
				.passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.
			authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/registration").permitAll()
				.antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
				.authenticated().and().csrf().disable().formLogin()
				.loginPage("/login").failureUrl("/login?error=true")
				.defaultSuccessUrl("/admin/home")
				.usernameParameter("email")
				.passwordParameter("password")
				.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/").and().exceptionHandling()
				.accessDeniedPage("/access-denied");
	}

	@Override
	public void configure(WebSecurity mvc) throws Exception {
	    mvc
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

}
 */
