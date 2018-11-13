package com.bloglaptrinh.app.config;

import com.bloglaptrinh.app.utils.Md5PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    // Roles
    public static final String ADMIN = "true";//1
    public static final String MANAGER = "2";//2
    public static final String USER = "false";//3

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.authorizeRequests().antMatchers("/*", "/admin_/**").permitAll();
        http.authorizeRequests().antMatchers("/getuser").hasAnyRole(USER,ADMIN);
        /*http.authorizeRequests().antMatchers("/user-package").hasAnyRole(USER,ADMIN);
        http.authorizeRequests().antMatchers("/setting-advertise").hasAnyRole(USER,ADMIN);
        http.authorizeRequests().antMatchers("/user/**","/resource-history", "/package/**","/user-package").hasAnyRole(USER,ADMIN);*/

        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        http.authorizeRequests()
                .and().formLogin()
                .loginProcessingUrl("/j_spring_security_check")
                .loginPage("/login")
                .defaultSuccessUrl("/package")
                .failureUrl("/login?loginError=true")
                .usernameParameter("username")
                .passwordParameter("password")
                
                .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Md5PasswordEncoder();
    }

}
