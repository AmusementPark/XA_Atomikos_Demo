package zsh.demos.xa.conf;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages="zsh.demos.xa1.mapper", sqlSessionFactoryRef="db1SqlSessionFactory")
public class DB1SQLSessionConfig {

	@Autowired @Qualifier("db1DataSource")  
    private DataSource db1DataSource;  
	
	@Bean("db1SqlSessionFactory")  
    public SqlSessionFactory db1SqlSessionFactory() throws Exception {  
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();  
//        factoryBean.setConfigLocation(new ClassPathResource("mybatis/mybatis2.xml"));
        factoryBean.setDataSource(db1DataSource);  
        return factoryBean.getObject();  
    }
	
	@Bean
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("db1SqlSessionFactory") SqlSessionFactory db1SqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(db1SqlSessionFactory);
        return template;
    }
}
