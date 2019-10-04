package random.learning.springbootangular.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("random.learning.springbootangular.repository")
@EnableTransactionManagement
public class DatabaseConfig {
}
