import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.register(AppConfig.class);

            ConfigurableEnvironment environment = context.getEnvironment();

//            ClassPathResource classPathResource = new ClassPathResource("путь_к_вашему_файлу.properties");
//
//            ResourcePropertySource resourcePropertySource = new ResourcePropertySource(classPathResource);
//
//            MutablePropertySources propertySources = environment.getPropertySources();
//
//            propertySources.addLast(resourcePropertySource);

            context.registerShutdownHook();

            context.refresh();

            MessageService messageService = context.getBean(MessageService.class);

            System.out.println(messageService.getMessage());
        }
    }
}
