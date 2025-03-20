package com.wonderrobot.ankenmatchingu.security;
// SecurityConfig.vm
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.wonderfulfly.core.constant.JsonConstant;
import com.wonderfulfly.core.json.JSONWFCObject;
import com.wonderfulfly.core.security.Encrypt;

/**
 * Security configuration
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {

    /**
     * 認証失敗処理クラス
     */
    @Autowired
    private AuthenticationEntryPointImpl unauthorizedHandler;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf.disable())
                // 認証失敗処理クラス
                .exceptionHandling(handling -> handling.authenticationEntryPoint(unauthorizedHandler))
                // リクエストのフィルタリング
                .authorizeHttpRequests(request -> request
                    // インターフェイスへの匿名アクセスを許可する
                	.mvcMatchers("/error", "/login", "/logout", "/login.do", "/**/*.jsp", "/**/*.js", "/static/**", "/fonts/**", "/**/*.css").permitAll()
                	// 上記以外のすべてのリクエストには認証が必要
                	.anyRequest().authenticated()
                )

                // logout
                .logout(logout -> logout
                    .logoutUrl("/logout")
                    .logoutSuccessHandler((request, response, authentication) -> {

                    	// post method for ajax
                        if ("POST".equals(request.getMethod())) {

                        	JSONWFCObject jsonObj = new JSONWFCObject();
                        	jsonObj.setScript(JsonConstant.JSONID_RUN_SCRIPT, "location.href='/logout'");
                        	try {
                        		response.getWriter().print(jsonObj.toJSONString());
                        	} catch (IOException e) {
                        	}
                        	return;
                    	}

                        // other method
                        response.sendRedirect("/login");
                    })
                 ).headers(headers -> headers
					 .frameOptions(frameOptions -> frameOptions.sameOrigin())
              );
        return httpSecurity.build();
    }

    /**
     * ID 認証インターフェース
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            // パスワード暗号化チェック
            @Override
            public String encode(CharSequence rawPassword) {
                return Encrypt.encrypt(rawPassword.toString());
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encode(rawPassword).equals(encodedPassword);
            }
        };
    }
    // ログイン時の認証に使用されるAuthenticationManager（認証マネージャー）を取得します。
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
