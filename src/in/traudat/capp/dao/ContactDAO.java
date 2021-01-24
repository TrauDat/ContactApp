package in.traudat.capp.dao;

import java.util.List;

import in.traudat.capp.domain.Contact;

public interface ContactDAO {
	public void save(Contact c);
	public void update(Contact c);
	public void delete(Contact c);
	public void deleteById(Integer id);
	public Contact findById(Integer userId);
	public List<Contact> findAll();
	public List<Contact> findByProperty(String propName, Object propValue);
}
