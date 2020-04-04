package com.globalmatics.biker.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * Authorization Server – Server issuing access tokens to client after successfully authentication the resource owner and obtaining authorization.
 * 		[1]: The convenient annotation @EnableAuthorizationServer is used. 
 * 			The server is customized by extending the class AuthorizationServerConfigurerAdapter
 *  		which provides empty method implementations for the interface AuthorizationServerConfigurer.
 *  
 *  	[2]: By default, the authorization server does not secure the authorization end point (/oauth/authorize). 
 *  		The configure method here injects the Spring Security authentication manager 
 *  		(set up in @EnableWebSecurity as in normal Spring Security)
 *  
 *  	[3]: The configure method here setup the clients that can access the server. 
 *  		An in memory client detail service is used here for demo purpose.
 *  		Registers a client with client-id ‘my-trusted-client’ and password ‘secret’ and roles & scope he is allowed for.
 * @author knguyen97
 *
 */
@Configuration
@EnableAuthorizationServer //[1]
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
		
    private static String REALM="MY_OAUTH_REALM";
//	 
//    @Autowired
//    private TokenStore tokenStore;
 
//    @Autowired
//    private UserApprovalHandler userApprovalHandler;
//    
    
	@Autowired
	private AuthenticationManager authenticationManager;

	/**
	 * Here we’ve used an in-memory client detail but it serves its purpose. 
	 * Client ID here is android-client and Client Secret is android-secret. 
	 */
    @Override // [3]
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    	
    	//Registers a client with client-id ‘my-trusted-client’ and password ‘secret’ and roles & scope he is allowed for.
        clients.inMemory()
            .withClient("my-trusted-client")
            .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
            .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
            .scopes("read", "write", "trust")
            //.secret(encoder.encode("secret"))
            .secret("{noop}secret")
            .accessTokenValiditySeconds(120).//Access token is only valid for 2 minutes.
            refreshTokenValiditySeconds(600);//Refresh token is only valid for 10 minutes.
    }     
    
	
    @Override // [2]
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore())
        .accessTokenConverter(accessTokenConverter())
        .authenticationManager(authenticationManager);
    }
    
    @Bean
    public TokenStore tokenStore() {
        //return new InMemoryTokenStore();
        return new JwtTokenStore(accessTokenConverter());

    }
    
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("as466gf");
        return converter;
	}

//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
//        oauthServer.realm(REALM+"/client");
//    }


}