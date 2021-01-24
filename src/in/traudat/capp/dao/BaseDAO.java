package in.traudat.capp.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;


//NOTE: because this class is a container, so do not use @Repository, @Service, @Component annotation
public abstract class BaseDAO extends NamedParameterJdbcDaoSupport{
	@Autowired
	public void getDataSourceCustom(DataSource ds) {
		super.setDataSource(ds);
	}
}
