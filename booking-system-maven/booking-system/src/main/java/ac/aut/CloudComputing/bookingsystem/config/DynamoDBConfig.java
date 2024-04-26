package ac.aut.CloudComputing.bookingsystem.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; 

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB; 
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
@EnableDynamoDBRepositories(basePackages = "ac.aut.CloudComputing.bookingsystem.repositories")
public class DynamoDBConfig {
	
	@Value("${aws.dynamodb.endpoint}")
	private String amazonDynamoDBEndpoint;

	@Value("${aws.accesskey}")
	private String amazonAWSAccessKey;

	@Value("${aws.secretkey}")
	private String amazonAWSSecretKey;
	

    @Value("${aws.region}")
    private String region;

	@Autowired
	private ApplicationContext context;
 
//	
//	@Bean
//	public DynamoDBMapper mapper() {
//		return new DynamoDBMapper(amazonDynamoDB());
//	}
//	
	
	@Bean
    public AmazonDynamoDB amazonDynamoDB() {
        final BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
        return AmazonDynamoDBClientBuilder
                .standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
                .build();
    }
	 

	@Bean
	public AWSCredentials amazonAWSCredentials() {
		return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
	}

	 
}