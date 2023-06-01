package ru.authservice.configuration;

import java.time.LocalDateTime;
import java.util.Collections;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import ru.authservice.application.common.Endpoints;
import ru.authservice.error.ErrorDescriptor;
import ru.authservice.error.model.ApplicationError;
import ru.authservice.filter.JwtFilter;
import ru.authservice.utils.HttpResponseUtils;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final JwtFilter jwtFilter;

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/h2-console/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .configurationSource(corsConfigurationSource())
                .and()
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler())
                .authenticationEntryPoint(authenticationEntryPoint())
                .and()
                .logout()
                .logoutUrl("/api/v1/logout")
                .invalidateHttpSession(true)
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, Endpoints.LOGIN)
                .permitAll()
                .antMatchers(HttpMethod.POST, Endpoints.LOGOUT)
                .permitAll()
                .anyRequest().permitAll();
        http.headers().frameOptions().sameOrigin();
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * Конфигарация CORS.
     */
    private CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Collections.singletonList("*"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedMethods(Collections.singletonList("*"));
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.setAlwaysUseFullPath(true);
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


    /**
     * {@see AccessDeniedHandler}.
     */
    private AccessDeniedHandler accessDeniedHandler() {
        ErrorDescriptor errorDescription = ErrorDescriptor.ACCESS_DENIED;
        ApplicationError error = ApplicationError.of(errorDescription.getType(), errorDescription.getMessage(),
                LocalDateTime.now(), errorDescription.getStatus());
        return (request, response, ex) -> HttpResponseUtils.writeError(response, error,
                HttpServletResponse.SC_FORBIDDEN);
    }

    /**
     * {@see AuthenticationEntryPoint}.
     */
    private AuthenticationEntryPoint authenticationEntryPoint() {
        ErrorDescriptor errorDescription = ErrorDescriptor.UNAUTHORIZED_ACCESS;
        ApplicationError error = ApplicationError.of(errorDescription.getType(), errorDescription.getMessage(),
                LocalDateTime.now(), errorDescription.getStatus());
        return (request, response, ex) -> HttpResponseUtils.writeError(response, error,
                HttpServletResponse.SC_UNAUTHORIZED);
    }
}
