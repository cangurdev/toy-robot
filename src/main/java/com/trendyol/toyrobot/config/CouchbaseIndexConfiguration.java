package com.trendyol.toyrobot.config;

import com.couchbase.client.java.Cluster;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CouchbaseIndexConfiguration {

    private final Cluster couchbaseCluster;

    public CouchbaseIndexConfiguration(Cluster couchbaseCluster) {
        this.couchbaseCluster = couchbaseCluster;
    }

    @Bean
    public void createIndexes() {
        couchbaseCluster.query("CREATE INDEX bootcampArray ON `rover`(DISTINCT ARRAY `m`.`name` FOR m in `material` END)");
    }
}
