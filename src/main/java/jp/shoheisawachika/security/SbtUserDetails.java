package jp.shoheisawachika.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jp.shoheisawachika.infrastructure.entity.SbtUserdata;
import lombok.Data;

@Data
public class SbtUserDetails implements UserDetails {

    private SbtUserdata user;
    
    public SbtUserDetails(SbtUserdata user) {
    	this.user = user;
    	this.authority = user.getRoles().stream()
    			.map(role -> new SimpleGrantedAuthority(role.getName()))
    			.collect(Collectors.toList());
    }
    
    private Collection<? extends GrantedAuthority> authority;
    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authority;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getName();
	}

	public String getDescription() {
		return user.getDescription();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true; //全通し; アカウント期限切れなし
	}

	@Override
	public boolean isAccountNonLocked() {
		return true; //全通し; アカウントロックなし
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true; //全通し; 資格情報の期限切れなし
	}

	@Override
	public boolean isEnabled() {
		return true; //全通し; アカウント無効なし
	}

}
