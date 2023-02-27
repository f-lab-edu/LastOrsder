package jw.project.infrastructure.dynamoDB;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDBConfiguration {
    @Bean
    public DynamoDBMapper dynamoDBMapper() {
        return new DynamoDBMapper(getBuildAmazonDynamoDB());
    }

    @Bean
    public DynamoDB DynamoDb() {
        return new DynamoDB(getBuildAmazonDynamoDB());
    }

    private static AmazonDynamoDB getBuildAmazonDynamoDB() {
        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                                "dynamodb.ap-northeast-2.amazonaws.com",
                                "ap-northeast-2"
                        )
                )
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials(
                                        "AKIA5VPD35GFD2QVZWWT",
                                        "1+XHmz+yE6kPLP5b4KWJHvOC9p33gni7Vu8xJTgC"
                                )
                        )
                ).build();
    }
}
