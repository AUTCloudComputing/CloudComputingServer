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
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;

import ac.aut.CloudComputing.bookingsystem.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;
    
    @Override
    public <S extends User> S save(S entity) {
        dynamoDBMapper.save(entity);
        return entity;
    }

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
        dynamoDBMapper.batchSave(entities);
        return entities;
    }

    @Override
    public Optional<User> findById(String id) {
        User user = dynamoDBMapper.load(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public boolean existsById(String id) {
        return findById(id).isPresent();
    }

    @Override
    public Iterable<User> findAll() {
        return dynamoDBMapper.scan(User.class, new DynamoDBScanExpression());
    }

    @Override
    public Iterable<User> findAllById(Iterable<String> ids) {
        List<User> users = new ArrayList<>();
        ids.forEach(id -> findById(id).ifPresent(users::add));
        return users;
    }

    @Override
    public long count() {
        return findAll().spliterator().getExactSizeIfKnown();
    }

    @Override
    public void deleteById(String id) {
        dynamoDBMapper.delete(findById(id).orElseThrow(() -> new IllegalArgumentException("No user found with id: " + id)));
    }

    @Override
    public void delete(User entity) {
        dynamoDBMapper.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends String> ids) {
        ids.forEach(this::deleteById);
    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {
        dynamoDBMapper.batchDelete(entities);
    }

    @Override
    public void deleteAll() {
        dynamoDBMapper.batchDelete(findAll());
    }

    @Override
    public Optional<User> findByUserName(String userName) {
    	// Create a mutable map to hold expression attribute values
    	
        HashMap<String, AttributeValue> eav = new HashMap<>();
        eav.put(":val", new AttributeValue().withS(userName)); 

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("user_name = :val").withExpressionAttributeValues(eav);

        List<User> users = dynamoDBMapper.scan(User.class, scanExpression);
        
        return users.stream().findFirst();  
        
         
    }
}


//https://docs.aws.amazon.com/zh_cn/amazondynamodb/latest/developerguide/DynamoDBMapper.QueryScanExample.html
//http://www.mxblog.top/toBlog/183

//
//public String editPerson(Person person) {
//    mapper.save(person, buildExpression(person));
//    return "record updated ...";
//}
//
//private DynamoDBSaveExpression buildExpression(Person person) {
//    DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
//    Map<String, ExpectedAttributeValue> expectedMap = new HashMap<>();
//    expectedMap.put("personId", new ExpectedAttributeValue(new AttributeValue().withS(person.getPersonId())));
//    dynamoDBSaveExpression.setExpected(expectedMap);
//    return dynamoDBSaveExpression;
//}


// reference: https://github.com/JoseLuisSR/springboot-aws-serverless/blob/master/Customer/src/main/java/com/aws/lambda/customer/repositories/CustomerRepositoryImpl.java
//https://github.com/Java-Techie-jt/springboot-dynamodb-example/blob/master/src/main/java/com/javatechiue/aws/repository/PersonRepository.java
//https://github.com/JoseLuisSR/springboot-aws-serverless/blob/master/Customer/src/main/java/com/aws/lambda/customer/repositories/CustomerRepositoryImpl.java
