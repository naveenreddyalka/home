package ok.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import reactor.core.publisher.Mono;

@SpringBootApplication
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.example.demo")
@EnableJpaAuditing
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void initDb() {
      
    	System.out.println(String.format("****** Creating table: %s, and Inserting test data ******", "Employees"));
        initTest();
        
        String sqlStatements[] = {
            "drop table employees if exists",
            "create table employees(id serial,first_name varchar(255),last_name varchar(255))",
            "insert into employees(first_name, last_name) values('Eugen','Paraschiv')",
            "insert into employees(first_name, last_name) values('Scott','Tiger')"
        };

        Arrays.asList(sqlStatements).stream().forEach(sql -> {
            System.out.println(sql);
            jdbcTemplate.execute(sql);
        });

        System.out.println(String.format("****** Fetching from table: %s ******", "Employees"));
        jdbcTemplate.query("select id,first_name,last_name from employees",
            new RowMapper<Object>() {
                @Override
                public Object mapRow(ResultSet rs, int i) throws SQLException {
                    System.out.println(String.format("id:%s,first_name:%s,last_name:%s",
                        rs.getString("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name")));
                    return null;
                }
            });
    }
    
    private void initTest() {
    	
    }
}
