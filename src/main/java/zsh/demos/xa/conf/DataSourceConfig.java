package zsh.demos.xa.conf;

import java.io.IOException;

import javax.sql.DataSource;
import javax.transaction.UserTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {
	
	@Autowired @Qualifier("Xa0Property") private DataSourceProperty xa0Property;
	@Autowired @Qualifier("Xa1Property") private DataSourceProperty xa1Property;
	
	@Bean(name="Xa0Property")
    @ConfigurationProperties(prefix="spring.datasource.db0")
    public DataSourceProperty dataSourceProperty0() {
        return new DataSourceProperty();
    }
	
	@Bean(name="Xa1Property")
    @ConfigurationProperties(prefix="spring.datasource.db1")
    public DataSourceProperty dataSourceProperty1() {
        return new DataSourceProperty();
    }
	
	@Bean(name="db0DataSource")
	public DataSource db0DataSource() throws IOException {
		AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
		atomikosDataSourceBean.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
		atomikosDataSourceBean.setUniqueResourceName("db0DataSource");
		atomikosDataSourceBean.setPoolSize(5);
		atomikosDataSourceBean.setXaProperties(xa0Property.toProperties());
        return atomikosDataSourceBean;
	}
	
	@Bean(name="db1DataSource")
	public DataSource db1DataSource() throws IOException {
		AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
		atomikosDataSourceBean.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
		atomikosDataSourceBean.setUniqueResourceName("db1DataSource");
		atomikosDataSourceBean.setPoolSize(5);
		atomikosDataSourceBean.setXaProperties(xa1Property.toProperties());
        return atomikosDataSourceBean;
	}
	
//	@Primary
//	@Bean(name="db0DataSource")
//	@ConfigurationProperties(prefix="spring.datasource.db1")
//	public DataSource db1DataSource() {
//	    return DataSourceBuilder.create().build();
//	}
	
	@Bean(name="jtaTransactionManager")
    public JtaTransactionManager regTransactionManager() {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        UserTransaction userTransaction = new UserTransactionImp();
        return new JtaTransactionManager(userTransaction, userTransactionManager);
    }
}
