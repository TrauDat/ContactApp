package in.traudat.capp.dao;

import java.util.List;

import in.traudat.capp.domain.User;

public interface UserDAO {
	public void save(User u);
	public void update(User u);
	public void delete(User u);
	public void deleteById(Integer id);
	public User findById(Integer userId);
	public List<User> findAll();
	public List<User> findByProperty(String propName, Object propValue);
}
