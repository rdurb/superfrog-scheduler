package tcu.webtech.superfrogscheduler.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import tcu.webtech.superfrogscheduler.models.ERole;
import tcu.webtech.superfrogscheduler.models.Role;
import tcu.webtech.superfrogscheduler.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        // securedEnabled = true,
        // jsr250Enabled = true,
        prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    Role r3 = new Role(ERole.ROLE_SPIRITDIRECTOR);
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                    .antMatchers("/h2-console/**").permitAll()
                    .antMatchers("/img/**", "/bootstrap/**", "/css/**", "/fonts/**", "/js/**").permitAll()
                    .antMatchers("/register").permitAll()
                    .antMatchers("/process_register").permitAll()
                    .antMatchers("/request").hasAnyAuthority()
                    .antMatchers("/spiritdirectortable").hasAuthority("ROLE_SPIRITDIRECTOR")
                    .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .usernameParameter("email")
                    .defaultSuccessUrl("/")
                    .permitAll()
                .and()
                    .logout().logoutSuccessUrl("/login").permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access_denied"); // 403 error

        http.headers().frameOptions().sameOrigin();

    }
}
