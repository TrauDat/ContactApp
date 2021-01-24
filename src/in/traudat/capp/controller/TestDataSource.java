package in.traudat.capp.controller;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import in.traudat.capp.config.SpringRootConfig;
import in.traudat.capp.dao.UserDAO;
import in.traudat.capp.domain.User;

public class TestDataSource {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
//		DataSource ds = ctx.getBean(DataSource.class);
//		JdbcTemplate jt = new JdbcTemplate(ds);
//		String sql = "INSERT INTO user(`name`, `phone`, `email`, `address`, `loginName`, `password`) VALUES(?,?,?,?,?,?)";
//		Object[] param = new Object[] {"Hoang","0379995384","hoang.hutech.97@gmail.com","Ca Mau", "b","b"};
//		jt.update(sql, param);
//		System.out.println("-----EXCUTED------");
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		User u = new User();
		u.setName("Hoang AB");
		u.setPhone("0379995384");
		u.setEmail("traudat2212@gmail.com");
		u.setAddress("Ca Mau");
		u.setLoginName("traudat3");
		u.setPassword("123123");
		u.setRole(1);
		u.setLoginStatus(1);
		userDAO.save(u);
		System.out.println("---------DATA--------");
	}

}
