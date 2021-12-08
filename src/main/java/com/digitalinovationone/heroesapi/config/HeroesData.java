package com.digitalinovationone.heroesapi.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

import static com.digitalinovationone.heroesapi.constants.HeroesConstant.*;

public class HeroesData {

    public static void main(String[] args) throws Exception{
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO,REGION_DYNAMO))
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable(TABLE_NAME);
        Item hero0 = new Item()
                .withPrimaryKey("id","1")
                .withString("name","Mulher Maravilha")
                .withString("universe","dc comics")
                .withNumber("films",3);


      Item hero1 = new Item()
                .withPrimaryKey("id", "2")
                .withString("name", "Herbert O Grande")
                .withString("universe", "Marvel")
                .withNumber("films", 3);

        Item hero2 = new Item()
                .withPrimaryKey("id", "3")
                .withString("name", "Viuva negra")
                .withString("universe", "marvel")
                .withNumber("films", 2);
        Item hero3 = new Item()
                .withPrimaryKey("id", "4")
                .withString("name", "Capita marvel")
                .withString("universe", "marvel")
                .withNumber("films", 2);

        PutItemOutcome outcome1 = table.putItem(hero0);
        PutItemOutcome outcome2 = table.putItem(hero1);
        PutItemOutcome outcome3 = table.putItem(hero2);
        PutItemOutcome outcome4 = table.putItem(hero3);








    }
}
