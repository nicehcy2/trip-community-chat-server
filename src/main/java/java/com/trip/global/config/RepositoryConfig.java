package java.com.trip.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {
        "java.com.trip.user.repository",    // UserRepository
        "java.com.trip.chat.repository"     // ChatRoomRepository, ChatRoomMembershipRepository
})
@EnableMongoRepositories(basePackages = {
        "java.com.trip.chat.repository.mongo"     // ChatMessageRepository
})
public class RepositoryConfig {
}
