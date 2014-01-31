package pandox.anguloso.boot.mongo;

import com.mongodb.DBAddress;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoExceptionTranslator;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 *
 */
@Configuration
public class MongoConfig {

    public @Bean
    Mongo mongo() throws Exception {
        return MongoClient.connect(new DBAddress("localhost", "anguloso")).getMongo();
    }

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(), "anguloso");
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {

        return new MongoTemplate(mongo(), "anguloso");

    }



    @Bean
    public PersistenceExceptionTranslator exceptionTranslation() {
        return new MongoExceptionTranslator();
    }
}
