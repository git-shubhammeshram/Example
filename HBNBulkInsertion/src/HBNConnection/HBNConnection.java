package HBNConnection;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import Model.Employee;

public class HBNConnection {
	
	public static Session getSession() {
		
		Configuration conf = new Configuration();
		
		Properties prop = new Properties();
		prop.put(Environment.URL, "jdbc:mysql://localhost:3306/employee");
		prop.put(Environment.USER, "root");
		prop.put(Environment.PASS, "root");
		prop.put(Environment.HBM2DDL_AUTO, "update");
		prop.put(Environment.SHOW_SQL, true);
		prop.put(Environment.FORMAT_SQL, true);
		
		conf.setProperties(prop);
		conf.addAnnotatedClass(Employee.class);
		
		return conf.buildSessionFactory().openSession();


		
	}

}
