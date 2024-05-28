package jp.shoheisawachika.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import jp.shoheisawachika.infrastructure.entity.SbtUserdata;

@Deprecated
public class SbtUser extends User {

	public SbtUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
	
	public SbtUser(SbtUserdata sbtUserdata) {
        super(sbtUserdata.getName(),
        		sbtUserdata.getPassword(),
        		sbtUserdata.getRoles().stream()
        			.map(role -> new SimpleGrantedAuthority(role.getName()))
        			.collect(Collectors.toList()));
    }
}