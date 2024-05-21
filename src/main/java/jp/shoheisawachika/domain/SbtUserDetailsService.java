package jp.shoheisawachika.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import jp.shoheisawachika.infrastructure.JdbcSbtUserRepository;
import jp.shoheisawachika.infrastructure.entity.SbtUserdata;
import jp.shoheisawachika.security.SbtUser;

@Component
public class SbtUserDetailsService implements UserDetailsService {

    @Autowired
    private JdbcSbtUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	SbtUserdata sbtUserdata = userRepository.findByUsername(username);
        if (sbtUserdata == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new SbtUser(sbtUserdata);
    }
}
