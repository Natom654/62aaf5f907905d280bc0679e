package lesson30;

import jakarta.servlet.ServletContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ProductWebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) {
        var rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(WebApplicationConfig.class);

        container.addListener(new ContextLoaderListener(rootContext));

        var dispatcher = container.addServlet("ProductWebAppInitializer", new DispatcherServlet(rootContext));

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
