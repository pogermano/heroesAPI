package com.digitalinovationone.heroesapi.config;

import com.amazonaws.ClientConfigurationFactory;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import  org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import static  com.digitalinovationone.heroesapi.config.HeroesConstant.ENDPOINT_DYNAMO;
import static  com.digitalinovationone.heroesapi.config.HeroesConstant.REGION_DYNAMO;
import static  com.digitalinovationone.heroesapi.config.HeroesConstant.HEROES_ENDPOINT_LOCAL;


import java.util.Arrays;

@Configuration
@EnableDynamoDBRepositories
public class HeroesTable {

    public static void main(String[] args) throws Exception{

        /*
        * @Bean
public AmazonDynamoDB amazonDynamoDB() throws IOException {
    return AmazonDynamoDBClientBuilder.standard()
            .withCredentials(
                    new AWSStaticCredentialsProvider(
                            new BasicAWSCredentials("fake", "credencial")
                    )
            )
            .withClientConfiguration(new ClientConfigurationFactory().getConfig().withProtocol(Protocol.HTTP))
            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("localhost:8443", "central"))
            .build();
}
        * */
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials("fake", "credencial")
                        )
                )
                .withClientConfiguration(new ClientConfigurationFactory().getConfig().withProtocol(Protocol.HTTP))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO,
                        REGION_DYNAMO))
                .build();
    /*    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO,REGION_DYNAMO))
                .build();*/

        DynamoDB dynamoDB = new DynamoDB(client);

        String tableName ="Heroes_Table";
        try {
//CREATE TABLE
            Table table = dynamoDB.createTable(tableName,
                    Arrays.asList(new KeySchemaElement("id", KeyType.HASH)),
                    Arrays.asList(new AttributeDefinition("id", ScalarAttributeType.S)),
                    new ProvisionedThroughput(5L,5L));
                    table.waitForActive();
// DELETE TABLE
/*            Table table = dynamoDB.getTable(tableName);
            System.out.println("Attempting to delete table; please wait...");
            table.delete();
         //   table.waitForDelete();
            System.out.print("Success.");*/
        } catch ( Exception e){

            System.out.println(e.getMessage());

        }



    }

}
