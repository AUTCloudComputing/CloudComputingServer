package ac.aut.CloudComputing.bookingsystem.service;


import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class S3Service { 
	
    private final AmazonS3 s3Client;   
    
    private final String bucketName;
    

    public S3Service(@Value("${aws.access-key}") String accessKey,
                     @Value("${aws.secret-key}") String secretKey,
                     @Value("${aws.region}") String region,
                     @Value("${aws.s3.bucket}") String bucketName) {
    	
        this.bucketName = bucketName;
        
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
        this.s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.fromName(region))
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
        
    }
    
 

    public String uploadFile(MultipartFile file) throws IOException {
        try {
            String fileName = file.getOriginalFilename();
            // Upload file to S3
            s3Client.putObject(new PutObjectRequest(bucketName, fileName, file.getInputStream(), null));
            // Return the URL of the uploaded file
            return s3Client.getUrl(bucketName, fileName).toString();
        } catch (AmazonServiceException e) {
            // Handle service exception
            e.printStackTrace();
            throw new RuntimeException("Error uploading file to S3: " + e.getMessage());
        }
    }
}
