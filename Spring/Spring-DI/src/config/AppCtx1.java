package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import member.MemberDao;

@Configuration
public class AppCtx1 {

	@Bean(name = "memberDao1")
	public MemberDao getMemberDao() {
		return new MemberDao();
	}
	
}
