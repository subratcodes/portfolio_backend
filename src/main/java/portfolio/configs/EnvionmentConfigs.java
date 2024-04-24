package portfolio.configs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "spring.data.mongodb")
@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EnvionmentConfigs {

    private String uri;
    private String database;

    @Override
    public String toString() {
        return "EnvionmentConfigs{" +
                "uri='" + uri + '\'' +
                ", database='" + database + '\'' +
                '}';
    }
}
