package com.sportgear.sportgear.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.sportgear.sportgear.Service.UsuarioServicio;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase de configuración de seguridad que define las reglas de seguridad para la aplicación.
 * Se extiende WebSecurityConfigurerAdapter para proporcionar la configuración de seguridad básica.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioServicio usuarioServicio;

    /**
     * Configuración del encriptador de contraseñas.
     * Se codifican las contraseñas antes de almacenarlas en la base de datos.
     * @return Instancia de BCryptPasswordEncoder.
     */

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configuración del proveedor de autenticación.
     * Cargar los detalles del usuario y verifica la autenticación.
     * @return Instancia de DaoAuthenticationProvider.
     */

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(usuarioServicio);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    /**
     * Configuración del AuthenticationManagerBuilder.
     * Creado para utilizar el proveedor de autenticación personalizado configurado en el método anterior.
     * @param auth AuthenticationManagerBuilder.
     * @throws Exception Excepción en caso de error en la configuración.
     */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    /**
     * Configuración de las reglas de seguridad HTTP.
     * @param http HttpSecurity.
     * @throws Exception Excepción en caso de error en la configuración.
     * authorizeRequests(): Indica que las solicitudes deben estar autorizadas según las reglas proporcionadas.
     * antMatchers().permitAll(): Permite el acceso sin autenticación a ciertas URL, como las páginas de registro, los recursos estáticos (CSS, JS, imágenes), etc.
     * antMatchers().hasRole(): Requiere que los usuarios estén autenticados y tengan un cierto rol para acceder a ciertas URL. Por ejemplo, los usuarios con el rol "Estudiante" pueden acceder a las URL /estudiante/**.
     * anyRequest().authenticated(): Requiere que todas las demás solicitudes estén autenticadas.
     * formLogin(): Configura la autenticación mediante un formulario de inicio de sesión personalizado.
     * loginPage("/login"): Especifica la URL de la página de inicio de sesión personalizada.
     * successHandler(): Especifica un manejador personalizado para redirigir a los usuarios después de un inicio de sesión exitoso, determinando la URL de destino basada en los roles del usuario autenticado.
     * Logout(): Configura la funcionalidad de cierre de sesión.
     * invalidateHttpSession(true): Invalida la sesión HTTP del usuario al cerrar sesión.
     * clearAuthentication(true): Borra la autenticación del usuario al cerrar sesión.
     * logoutRequestMatcher(new AntPathRequestMatcher("/logout")): Especifica la URL de cierre de sesión.
     * logoutSuccessUrl("/login?logout"): Especifica la URL de redirección después de cerrar sesión.
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(
                        "/registro**",
                        "/js/**",
                        "/css/**",
                        "/img/**").permitAll()
                .antMatchers("/estudiante/**").hasRole("Estudiante")
                .antMatchers("/administrativo/**").hasRole("Administrativo")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .successHandler((request, response, authentication) -> {
                    String targetUrl = determineTargetUrl(authentication);
                    response.sendRedirect(targetUrl);
                })
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();
    }

    /**
     * Determina la URL de destino después del inicio de sesión, basada en los roles del usuario autenticado.
     * @param authentication Authentication.
     * @return URL de destino.
     */

    private String determineTargetUrl(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        if (roles.contains("Administrativo")) {
            return "/admin/inventarioImplementos";
        } else {
            return "/student/panelPrincipal";
        }
    }
}

