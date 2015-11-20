//package noteKeepr.application;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http
////                .authorizeRequests()
////                .antMatchers("/public/**").permitAll()
////                .anyRequest().authenticated()
////                .and()
////                .formLogin()
////                .defaultSuccessUrl("/public/notekeepr.html")
////                .loginProcessingUrl("/authenticate")
////                .loginPage("/public/login.html")
////                .and()
////                .httpBasic()
////                .and()
////                .logout()
////                .logoutUrl("/logout");
////    }
//
//}
