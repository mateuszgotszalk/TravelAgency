package com.gotszalk.travelservice.security;

import com.gotszalk.travelservice.security.jwt.JwtConfig;
import com.gotszalk.travelservice.security.jwt.JwtTokenVerifier;
import com.gotszalk.travelservice.security.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final SecretKey key;
    private final JwtConfig jwtConfig;

    @Autowired
    public SecurityConfig(@Qualifier("myUserDetailService") UserDetailsService userDetailsService, SecretKey key, JwtConfig jwtConfig) {
        this.userDetailsService = userDetailsService;
        this.key = key;
        this.jwtConfig = jwtConfig;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), key, jwtConfig))
                .addFilterAfter(new JwtTokenVerifier(key, jwtConfig), JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                // TODO sprawdz jeszcze czy front strzela getOffer/{id}
                .antMatchers("/login", "/registration", "/offer/getOffers").permitAll()
                .antMatchers("/show").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "offer/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "offer/**").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "offer/**").hasRole("USER")
                .antMatchers("hotels/**").hasRole("USER")
                .antMatchers("trip/**").hasRole("USER")
                .antMatchers("flights/**").hasRole("USER")
                .antMatchers("people/**").hasRole("USER")
                .anyRequest()
                .authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
