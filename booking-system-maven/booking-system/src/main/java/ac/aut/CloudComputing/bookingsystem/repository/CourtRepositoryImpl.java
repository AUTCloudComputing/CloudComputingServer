package ac.aut.CloudComputing.bookingsystem.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper; 
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression; 

import ac.aut.CloudComputing.bookingsystem.model.Court;

@Repository
public class CourtRepositoryImpl implements CourtRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;
    
    @Override
    public <S extends Court> S save(S entity) {
        dynamoDBMapper.save(entity);
        return entity;
    }

    @Override
    public <S extends Court> Iterable<S> saveAll(Iterable<S> entities) {
        dynamoDBMapper.batchSave(entities);
        return entities;
    }

    @Override
    public Optional<Court> findById(String id) {
        Court Court = dynamoDBMapper.load(Court.class, id);
        return Optional.ofNullable(Court);
    }

    @Override
    public boolean existsById(String id) {
        return findById(id).isPresent();
    }

    @Override
    public Iterable<Court> findAll() {
        return dynamoDBMapper.scan(Court.class, new DynamoDBScanExpression());
    }

    @Override
    public Iterable<Court> findAllById(Iterable<String> ids) {
        List<Court> Courts = new ArrayList<>();
        ids.forEach(id -> findById(id).ifPresent(Courts::add));
        return Courts;
    }

    @Override
    public long count() {
        return findAll().spliterator().getExactSizeIfKnown();
    }

    @Override
    public void deleteById(String id) {
        dynamoDBMapper.delete(findById(id).orElseThrow(() -> new IllegalArgumentException("No Court found with id: " + id)));
    }

    @Override
    public void delete(Court entity) {
        dynamoDBMapper.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends String> ids) {
        ids.forEach(this::deleteById);
    }

    @Override
    public void deleteAll(Iterable<? extends Court> entities) {
        dynamoDBMapper.batchDelete(entities);
    }

    @Override
    public void deleteAll() {
        dynamoDBMapper.batchDelete(findAll());
    }
 
}


// reference: https://github.com/JoseLuisSR/springboot-aws-serverless/blob/master/Customer/src/main/java/com/aws/lambda/customer/repositories/CustomerRepositoryImpl.java
//https://github.com/Java-Techie-jt/springboot-dynamodb-example/blob/master/src/main/java/com/javatechiue/aws/repository/PersonRepository.java
//https://github.com/JoseLuisSR/springboot-aws-serverless/blob/master/Customer/src/main/java/com/aws/lambda/customer/repositories/CustomerRepositoryImpl.java
