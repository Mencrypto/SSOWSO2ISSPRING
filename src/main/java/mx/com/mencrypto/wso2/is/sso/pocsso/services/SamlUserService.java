package mx.com.mencrypto.wso2.is.sso.pocsso.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.saml.SAMLCredential;
import org.springframework.security.saml.userdetails.SAMLUserDetailsService;
import org.springframework.stereotype.Service;

import mx.com.mencrypto.wso2.is.sso.pocsso.models.UserModel;

@Service
public class SamlUserService implements SAMLUserDetailsService {

  @Override
  public Object loadUserBySAML(SAMLCredential credential) throws UsernameNotFoundException {
    return new UserModel(credential.getNameID().getValue());
  }
}
