package mx.com.mencrypto.wso2.is.sso.pocsso.sso;

import static org.springframework.security.extensions.saml2.config.SAMLConfigurer.saml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import mx.com.mencrypto.wso2.is.sso.pocsso.services.SamlUserService;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Value("${saml2.metadata-path}")
  private String metadataPath;

  @Value("${saml2.sp.protocol}")
  private String spProtocol;

  @Value("${saml2.sp.host}")
  private String spHost;

  @Value("${saml2.sp.path}")
  private String spBashPath;

  @Value("${saml2.sp.key-store.file}")
  private String keyStoreFile;

  @Value("${saml2.sp.key-store.password}")
  private String keyStorePassword;

  @Value("${saml2.sp.key-store.alias}")
  private String keyStoreAlias;

  @Value("${saml2.sp.protocol}")
  private String protocol;

  @Autowired
  private SamlUserService samlUserService;

  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    //@formatter:off
    http
      .csrf().and()
      .authorizeRequests()
        .antMatchers("/saml/**").permitAll()
        .anyRequest().authenticated()
        .and()
      .apply(saml())
      	.userDetailsService(samlUserService)
        .serviceProvider()
          .protocol(spProtocol)
          .hostname(spHost)
          .basePath(spBashPath)
          .keyStore()
            .storeFilePath(keyStoreFile)
            .keyPassword(keyStorePassword)
            .keyname(keyStoreAlias)
          .and()
        .and()
        .identityProvider()
          .metadataFilePath(metadataPath)
        .and()
    .and();
    //@formatter:on
  }
}