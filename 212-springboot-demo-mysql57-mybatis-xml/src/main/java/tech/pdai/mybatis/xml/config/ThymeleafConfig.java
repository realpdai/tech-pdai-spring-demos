package tech.pdai.mybatis.xml.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import java.nio.charset.Charset;


@Configuration
public class ThymeleafConfig {

	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setPrefix("classpath:/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setCacheable(false);
		templateResolver.setCharacterEncoding(Charset.forName("UTF-8").toString());
		return templateResolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine() {
		// 可以在这里配置模板的方言等
		SpringTemplateEngine engine = new SpringTemplateEngine();
//		SpringSecurityDialect securityDialect = new SpringSecurityDialect();
//		Set<IDialect> dialects = new HashSet<>();
//		dialects.add(securityDialect);
//		engine.setAdditionalDialects(dialects);
//		engine.addDialect(xxxThymeleafDialect());
		engine.setTemplateResolver(templateResolver());
		engine.setEnableSpringELCompiler(true);
		return engine;
	}

	@Bean
	public ThymeleafViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		return viewResolver;
	}
}
