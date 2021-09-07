package tech.pdai.mybatis.xml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
// 表示通过aop框架暴露该代理对象,AopContext能够访问
@EnableAspectJAutoProxy(exposeProxy = true)
public class SpringbootCrudMybatisXmlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudMybatisXmlDemoApplication.class, args);
	}

}
