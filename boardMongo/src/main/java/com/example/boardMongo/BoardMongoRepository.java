package com.example.boardMongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BoardMongoRepository extends MongoRepository<BoardMongoVO, String> {

}
