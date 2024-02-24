package hunre.chinh.webbook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {
  @Autowired
  private UserDetailsService userDetailsService;

  @Bean
  public static PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .authorizeHttpRequests((authorize) ->
            authorize.requestMatchers("/register/**").permitAll()
                .requestMatchers("/index").permitAll()
                .requestMatchers("/home_admin").hasRole("ADMIN")

                .requestMatchers("/available_categories").hasRole("ADMIN")
                .requestMatchers("/save_categories").hasRole("ADMIN")
                .requestMatchers("/categories_register").hasRole("ADMIN")
                .requestMatchers("/editCategories/{idDM}").hasRole("ADMIN")
                .requestMatchers("/deleteCategories/{idDM}").hasRole("ADMIN")

                .requestMatchers("/available_author").hasRole("ADMIN")
                .requestMatchers("/save_author").hasRole("ADMIN")
                .requestMatchers("/author_register").hasRole("ADMIN")
                .requestMatchers("/editAuthor/{idTG}").hasRole("ADMIN")
                .requestMatchers("/deleteAuthor/{idTG}").hasRole("ADMIN")

                .requestMatchers("/available_publisher").hasRole("ADMIN")
                .requestMatchers("/save_publisher").hasRole("ADMIN")
                .requestMatchers("/publisher_register").hasRole("ADMIN")
                .requestMatchers("/editPublisher/{idNXB}").hasRole("ADMIN")
                .requestMatchers("/deletePublisher/{idNXB}").hasRole("ADMIN")

                .requestMatchers("/available_books").hasRole("ADMIN")
                .requestMatchers("/save_books").hasRole("ADMIN")
                .requestMatchers("/books_register").hasRole("ADMIN")
                .requestMatchers("/editBooks/{idSach}").hasRole("ADMIN")
                .requestMatchers("/deleteBooks/{idSach}").hasRole("ADMIN")

                .requestMatchers("/available_users").hasRole("ADMIN")
                .requestMatchers("/available_orders").hasRole("ADMIN")
                .requestMatchers("dashboard.html").hasRole("ADMIN")
        ).formLogin(
            form -> form
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/home_admin")
                .permitAll()
        ).logout(
            logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .permitAll()
        );
    return http.build();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .userDetailsService(userDetailsService)
        .passwordEncoder(passwordEncoder());
  }
}
