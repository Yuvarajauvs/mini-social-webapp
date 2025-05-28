package com.example.Yuva;
/*
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/posts/create").authenticated() // Ensure the create post API is authenticated
                .antMatchers("/api/posts/**").permitAll() // Allow public access to get posts
                .and()
                .formLogin().permitAll() // Allow form login if using form-based authentication
                .and()
                .httpBasic(); // Allow basic auth or JWT-based authentication
    }
}


 */