package lk.ijse.smarttravelapi.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // ඔයාගේ images තියෙන්නේ project root එකේ 'uploads' folder එකේ නම්:
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:uploads/");
    }
}
