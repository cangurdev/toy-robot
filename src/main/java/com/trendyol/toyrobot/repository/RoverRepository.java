package com.trendyol.toyrobot.repository;

import com.couchbase.client.core.error.DocumentNotFoundException;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.kv.GetResult;
import com.couchbase.client.java.query.QueryResult;
import com.trendyol.toyrobot.domain.Rover;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class RoverRepository {

    private final Cluster couchbaseCluster;
    private final Collection roverCollection;


    public RoverRepository(Cluster couchbaseCluster, Collection roverCollection) {
        this.couchbaseCluster = couchbaseCluster;
        this.roverCollection = roverCollection;
    }

    public void insert(Rover rover) {
        roverCollection.insert(rover.getId(), rover);
    }

    public void update(Rover rover) {
        roverCollection.replace(rover.getId(), rover);
    }

    public Rover findById(String id) {
        GetResult getResult = roverCollection.get(id);
        Rover rover = getResult.contentAs(Rover.class);
        return rover;
    }

    public Optional<Rover> findByIdOptional(String id) {
        try {
            GetResult getResult = roverCollection.get(id);
            Rover rover = getResult.contentAs(Rover.class);
            return Optional.of(rover);

        } catch (DocumentNotFoundException exception) {
            return Optional.empty();
        }
    }

    public List<Rover> findAll () {
        String statement = "Select id, x, y, material from rover";
        QueryResult query = couchbaseCluster.query(statement);
        return query.rowsAs(Rover.class);
    }

}
