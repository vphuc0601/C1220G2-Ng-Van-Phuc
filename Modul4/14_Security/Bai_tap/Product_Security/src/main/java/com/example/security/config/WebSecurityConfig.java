package com.example.security.config;

import com.example.security.service.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailServiceImpl();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(passwordEncoder());
        authProvider.setUserDetailsService(userDetailsService());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .antMatchers("/product/delete/*", "/productOrder","/productOrder/*").hasAuthority("ADMIN")
//            .antMatchers().hasAuthority("USER")
//            .antMatchers("/product", "/product/edit","/product/view").hasAnyAuthority("USER", "ADMIN")
//            .and()
//            .formLogin().permitAll()
//            .and()
//            .logout().permitAll()
//            .and()
//            .exceptionHandling().accessDeniedPage("/403")
//            ;
        http.csrf().disable();

        http
                .authorizeRequests()
                //C???u h??nh cho c??c ??u??ng d???n kh??ng c???n x??c th???c
                .antMatchers("/", "/login", "/register").permitAll()
                .antMatchers("/product/delete/*","/productOrder","/productOrder/*").hasAnyAuthority("ADMIN")
                .antMatchers("/product", "/product/edit","/product/view").hasAnyAuthority("USER", "ADMIN")
                .and()
                //formlogin
                .formLogin()
                //???????ng d???n tr??? v??? trang authentication
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                //N???u authentication th??nh c??ng
                .defaultSuccessUrl("/")
                //N???u authentication th???t b???i
                .failureUrl("/login?error")
                //N???u authentication th??nh c??ng nh??ng v??o trang kh??ng ????ng role
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/").permitAll()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
        ;

//        http.authorizeRequests().and() //
//                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
//                .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h
    }
}
