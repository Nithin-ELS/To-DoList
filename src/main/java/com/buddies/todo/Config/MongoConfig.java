package com.buddies.todo.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Configuration
@EnableMongoAuditing // Enable MongoDB auditing
public class MongoConfig {
    // Additional configuration if needed
}
