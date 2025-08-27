package com.sistema.regisstro.Sistemademo.Seguridad;

import com.sistema.regisstro.Sistemademo.Servicio.ServicioUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class Seguridad {

    @Bean
    public BCryptPasswordEncoder encriptador() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider autenticacon(ServicioUsuario se){
        DaoAuthenticationProvider auth=new DaoAuthenticationProvider();
        auth.setUserDetailsService(se);
        auth.setPasswordEncoder(encriptador());

        return auth;
    }

    @Bean
    public SecurityFilterChain d (HttpSecurity ss, AuthenticationSuccessHandler vars) throws Exception{
        ss.authorizeHttpRequests(configurer->configurer
                        .requestMatchers("/").hasRole("CLIENTE")
                        .requestMatchers("/socio/**").hasRole("VENDEDOR")
                        .requestMatchers("/gerencia/**").hasRole("ADMIN")
                        .requestMatchers("/registrar/**").permitAll()
                        .anyRequest().authenticated())
                .formLogin(form->form.loginPage("/login")
                        .loginProcessingUrl("/procesamiento")
                        .successHandler(vars)
                        .permitAll())
                .logout(logout->logout.permitAll())
                .exceptionHandling(configurer->configurer
                        .accessDeniedPage("/acceso-denegado"))
        ;

        return ss.build();
    }

}
