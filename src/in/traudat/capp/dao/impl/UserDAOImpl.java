package in.traudat.capp.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import in.traudat.capp.dao.BaseDAO;
import in.traudat.capp.dao.UserDAO;
import in.traudat.capp.domain.User;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {

	@Override
	public void save(User u) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO user(name, phone, email, address, loginName, password, role, loginStatus)")
				.append(" VALUES(:name, :phone, :email, :address, :loginName, :password, :role, :loginStatus)");
		Map<String, Object> m = new HashMap<>();
		m.put("name", u.getName());
		m.put("phone", u.getPhone());
		m.put("email", u.getEmail());
		m.put("address", u.getAddress());
		m.put("loginName", u.getLoginName());
		m.put("password", u.getPassword());
		m.put("role", u.getRole());
		m.put("loginStatus", u.getLoginStatus());

		KeyHolder kh = new GeneratedKeyHolder();
		SqlParameterSource ps = new MapSqlParameterSource(m);
		super.getNamedParameterJdbcTemplate().update(sql.toString(), ps, kh);
		Integer userId = kh.getKey().intValue();
		u.setUserId(userId);
	}

	@Override
	public void update(User u) {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"UPDATE user SET name=:name, phone=:phone, email=:email, address=:address, role=:role, loginStatus=:loginStatus")
				.append(" WHERE userId=:userId");
		Map<String, Object> m = new HashMap<>();
			m.put("name", u.getName());
			m.put("phone", u.getPhone());
			m.put("email", u.getEmail());
			m.put("address", u.getAddress());
			m.put("role", u.getRole());
			m.put("loginStatus", u.getLoginStatus());
			m.put("userId", u.getUserId());
			getNamedParameterJdbcTemplate().update(sql.toString(), m);
			
	}

	@Override
	public void delete(User u) {
		this.deleteById(u.getUserId());
	}

	@Override
	public void deleteById(Integer userId) {
		String sql = "DELETE from user where userId=?";
		getJdbcTemplate().update(sql,userId);
	}

	@Override
	public User findById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByProperty(String propName, Object propValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
