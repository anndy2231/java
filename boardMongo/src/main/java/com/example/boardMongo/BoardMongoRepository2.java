package com.example.boardMongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BoardMongoRepository2 extends MongoRepository<BoardUserInfo, String> {

}
