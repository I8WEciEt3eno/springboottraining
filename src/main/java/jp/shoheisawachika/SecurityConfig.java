package jp.shoheisawachika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import jp.shoheisawachika.domain.SbtUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private SbtUserDetailsService sbtUserDetailsService;
	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(login -> login
                        .loginProcessingUrl("/login")
                        .loginPage("/login")
                        .defaultSuccessUrl("/hello")
                        .failureUrl("/login?error")
                        .permitAll()
        ).logout(logout -> logout
        				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login")
        ).authorizeHttpRequests(authz -> authz
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/home").permitAll()
                        .requestMatchers("/error").permitAll()
//                        .requestMatchers("/general").hasRole("GENERAL")
//                        .requestMatchers("/admin").hasRole("ADMIN")
                        .requestMatchers("/h2-console/**").permitAll()
                        .anyRequest().authenticated()
        ).csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**")
        ).headers(headers -> headers.frameOptions().disable())
        ;
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(sbtUserDetailsService)  // カスタムUserDetailsServiceを設定
            .passwordEncoder(new BCryptPasswordEncoder());  // パスワードエンコーダーをBCryptPasswordEncoderに設定
    }

    /*
        @Bean
        public InMemoryUserDetailsManager userDetailsService(){
            UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("password"))
                .authorities("ROLE_USER")
                .build();
            return new InMemoryUserDetailsManager(user);
        }
    */

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}