package com.van.security.config;

import com.van.security.service.MyFilterSecurityInterceptor;
import com.van.security.service.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.annotation.Resource;

/**
 * 配置SpringSecirity
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;

    @Bean
    public static NoOpPasswordEncoder passwordEncoder(){
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Bean
    UserDetailsService myUserDetailsService(){
        return new MyUserDetailsService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/js/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/userLogin")
                .failureUrl("/userLogin?error")
                .permitAll() //登录页面用户任意访问
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable();

        http.exceptionHandling().accessDeniedPage("/accessDenied");

        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
    }


}
