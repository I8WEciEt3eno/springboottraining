package jp.shoheisawachika.domain;

import java.util.ArrayList;

import jp.shoheisawachika.infrastructure.entity.SbtUserdata;

public interface SbtUserRepository {
	
		ArrayList<SbtUserdata> findAll();
		ArrayList<SbtUserdata> findAll_2();
		SbtUserdata findByUsername(String username);
		SbtUserdata findByUsername_2(String username);

}
