package com.digitalinovationone.heroesapi.document;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;


import lombok.Data;
import lombok.NoArgsConstructor;

//import static com.digitalinovationone.heroesapi.constants.HeroesConstant.TABLE_NAME;
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "Heroes_Table")
public class Heroes {

    @Id
    @DynamoDBHashKey (attributeName = "id")
    private String id;

    @DynamoDBAttribute (attributeName = "name")
    private String name;

    @DynamoDBAttribute (attributeName = "universe")
    private String universe;

    @DynamoDBAttribute (attributeName = "films")
    private Long films;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public Long getFilms() {
        return films;
    }

    public void setFilms(Long films) {
        this.films = films;
    }
}