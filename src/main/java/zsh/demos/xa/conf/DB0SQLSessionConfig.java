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
@MapperScan(basePackages="zsh.demos.xa0.mapper", sqlSessionFactoryRef="db0SqlSessionFactory")
public class DB0SQLSessionConfig {
	
	@Autowired @Qualifier("db0DataSource")  
    private DataSource db0DataSource;  
	
	@Bean("db0SqlSessionFactory")
    public SqlSessionFactory db0SqlSessionFactory() throws Exception {  
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();  
//        factoryBean.setConfigLocation(new ClassPathResource("mybatis/mybatis1.xml"));
        factoryBean.setDataSource(db0DataSource);
        return factoryBean.getObject();  
    }
	
	@Bean
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("db0SqlSessionFactory") SqlSessionFactory db0SqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(db0SqlSessionFactory);
        return template;
    }
}
