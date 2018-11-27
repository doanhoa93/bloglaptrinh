package bloglaptrinh.com.config;

import bloglaptrinh.com.service.user.AuthorizedUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration implements WebMvcConfigurer {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService authorizedUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(authorizedUserDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Configuration
    @Order(1)
    public static class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private PersistentTokenRepository persistentTokenRepository;

        @Override
        public void configure(WebSecurity web) throws Exception {
            web
                    .ignoring()
                    .antMatchers("/admin_/resources/**")
                    .antMatchers("/admin_/webjars/**")
                    .antMatchers("/admin_/setup**")
                    .antMatchers("/admin_/signup**");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/admin_/**")
                    .authorizeRequests()
                    .antMatchers("/admin_/**").hasAnyRole("ADMIN", "EDITOR", "AUTHOR")
                    .and()
                    .formLogin()
                    .loginPage("/admin_/login").permitAll()
                    .loginProcessingUrl("/admin_/login")
                    .defaultSuccessUrl("/admin_")
                    .failureUrl("/admin_/login?failed")
                    .and()
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/admin_/logout", "GET"))
                    .logoutSuccessUrl("/admin_/login")
                    .and()
                    .rememberMe()
                    .tokenRepository(persistentTokenRepository)
                    .and()
                    .headers()
                    .frameOptions().disable()
                    .cacheControl().disable()
                    .httpStrictTransportSecurity().disable()
                    .and()
                    .csrf()
                    .disable()
                    .exceptionHandling()
                    .accessDeniedPage("/admin_/login");
        }
    }

    @Configuration
    @Order(2)
    public static class GuestSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private PersistentTokenRepository persistentTokenRepository;

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring()
                    .antMatchers("/resources/blog/css/**")
                    .antMatchers("/resources/blog/js/**")
                    .antMatchers("/webjars/**");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/**")
                    .authorizeRequests()
                    .antMatchers("/settings/**").hasRole("VIEWER")
                    .antMatchers("/**/viet-bai").hasAnyRole("ADMIN", "EDITOR", "AUTHOR", "VIEWER")
                    .antMatchers("/comments/**").hasRole("VIEWER")
                    .and()
                    .formLogin()
                    .loginPage("/login").permitAll()
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/")
                    .failureUrl("/login?error")
                    .permitAll()
                    .and()
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                    .logoutSuccessUrl("/?logout")
                    .deleteCookies("my-remember-me-cookie")
                    .permitAll()
                    .and()
                    .rememberMe()
                    .tokenRepository(persistentTokenRepository)
                    .and()
                    .headers()
                    .frameOptions().disable()
                    .cacheControl().disable()
                    .httpStrictTransportSecurity().disable()
                    .and()
                    .csrf()
                    .disable()
                    .exceptionHandling()
                    .accessDeniedPage("/login");
        }
    }

    @Bean
    public UserDetailsService authorizedUserDetailsService() {
        return new AuthorizedUserDetailsService();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();
        repository.setDataSource(dataSource);
        return repository;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("guest/login");
    }
}

