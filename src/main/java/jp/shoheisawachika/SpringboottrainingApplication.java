package jp.shoheisawachika;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

import jp.shoheisawachika.util.MessageService;
import jp.shoheisawachika.util.MessageUtil;

@SpringBootApplication
@EnableConfigurationProperties(BuildInfoProperty.class)
public class SpringboottrainingApplication {
//public class SpringboottrainingApplication extends SpringBootServletInitializer {
// note:WARパッケージングするならSpringBootServletInitializerを継承して
//      configureを実装する必要有. だがJARなら不要

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(SpringboottrainingApplication.class);
//	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringboottrainingApplication.class, args);

		MessageService messageService = context.getBean(MessageService.class);
        MessageUtil.setMessageService(messageService);
	}
}
