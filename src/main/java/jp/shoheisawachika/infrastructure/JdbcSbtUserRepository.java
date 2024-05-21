package jp.shoheisawachika.infrastructure;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.shoheisawachika.domain.SbtUserRepository;
import jp.shoheisawachika.infrastructure.entity.SbtRole;
import jp.shoheisawachika.infrastructure.entity.SbtUserdata;

@Repository
public class JdbcSbtUserRepository implements SbtUserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Deprecated
    public ArrayList<SbtUserdata> findAll() {
    	final String sql = "SELECT * FROM userdata";
        return (ArrayList<SbtUserdata>) jdbcTemplate.query(
        		sql,
        		(rs, rowNum) -> new SbtUserdata(
        				rs.getString("id_user"),
                		rs.getString("name"),
                		rs.getString("password"),
                		rs.getString("description"),
                		null)
        		);
    }

    @Deprecated
    public ArrayList<SbtUserdata> findAll_2() {
    	final String sql = "SELECT * FROM userdata";
        return (ArrayList<SbtUserdata>) jdbcTemplate.query(
        		sql,
        		new DataClassRowMapper<>(SbtUserdata.class)); // note : こう書くとDBカラム名と結果クラスのフィールド名が一致する場合のみ自動でフィールド値に渡す(この場合id_user->idのみ移らない) 
    }

    public SbtUserdata findByUsername(String username) {
//        final String sql = "SELECT * FROM userdata WHERE name = ?" ;
        final String sql = "SELECT u.id_user, u.name AS u_name, u.password, u.description, r.id_role, r.no AS r_no, r.name AS r_name " +
        		" FROM userdata u " +
        		"  LEFT JOIN user_role ur ON u.id_user = ur.id_user " +
        		"  LEFT JOIN role r ON r.no = ur.role_no " +
        		" WHERE u.name = ?" ;
        return jdbcTemplate.queryForObject(
        		sql,
        		(rs, rowNum) -> {
        			List<SbtRole> roles = new ArrayList<SbtRole>();
        			SbtUserdata userdata = null;
        			userdata = new SbtUserdata(
        					rs.getString("id_user"),
                     		rs.getString("u_name"),
                     		rs.getString("password"),
                     		rs.getString("description"),
                     		null);
        			roles.add(new SbtRole(
    						rs.getString("id_role"),
    						rs.getString("r_no"),
    						rs.getString("r_name")));
        			while (rs.next()) {
        				roles.add(new SbtRole(
        						rs.getString("id_role"),
        						rs.getString("r_no"),
        						rs.getString("r_name")));
        			}
        			if (userdata != null) {
        				userdata.setRoles(roles);
        			}
        			return userdata;
        		},
        		username); // sql内のバインド変数 可変長引数
    }

    @Deprecated
    public SbtUserdata findByUsername_2(String username) {
    	final String sql = "SELECT * FROM userdata WHERE name = ?";
        return jdbcTemplate.queryForObject(
        		sql,
        		new DataClassRowMapper<>(SbtUserdata.class),  // note : こう書くとDBカラム名と結果クラスのフィールド名が一致する場合のみ自動でフィールド値に渡す(この場合id_user->idのみ移らない)
        		username); // sql内のバインド変数 可変長引数
    }

    public int update(String id_user, String description) {
        final String sql = "UPDATE userdata " +
        		"   SET description = ? " +
        		" WHERE id_user = ? " ;
        return jdbcTemplate.update(
        		sql,
        		description, id_user); // sql内のバインド変数 可変長引数
    }

    public int updatePassword(String id_user, String password) {
        final String sql = "UPDATE userdata " +
        		"   SET password = ? " +
        		" WHERE id_user = ? " ;
        return jdbcTemplate.update(
        		sql,
        		password, id_user); // sql内のバインド変数 可変長引数
    }

}