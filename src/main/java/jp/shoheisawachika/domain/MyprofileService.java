package jp.shoheisawachika.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.shoheisawachika.SecurityConfig;
import jp.shoheisawachika.domain.model.MyprofileDto;
import jp.shoheisawachika.infrastructure.JdbcSbtUserRepository;
import jp.shoheisawachika.infrastructure.entity.SbtUserdata;

@Service
public class MyprofileService {

    @Autowired
    private JdbcSbtUserRepository userRepository;

    public MyprofileDto initializeForm() {
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	if (!(principal instanceof UserDetails)) {
    		return null;
    	}
    	String username = ((UserDetails) principal).getUsername();
    	SbtUserdata sbtUserdata = userRepository.findByUsername(username);
        if (sbtUserdata == null) {
            throw new UsernameNotFoundException("User not found");
        }
        MyprofileDto dto = new MyprofileDto(sbtUserdata);
        
    	return dto;
    }

    public void update(MyprofileDto dto) {
    	int rows = userRepository.update(dto.getId(), dto.getDescription(), dto.getUpdateCount());
    	if (rows == 0) {
    		
    	}
    	return;
    }

    public void changePassword(MyprofileDto dto) {
    	String passwordEncode = (new SecurityConfig()).passwordEncoder()
    			.encode(dto.getCleartextPassword());
    	int rows = userRepository.updatePassword(dto.getId(), passwordEncode, dto.getUpdateCount());
    	if (rows == 0) {
    		
    	}
    	return;
    }
}