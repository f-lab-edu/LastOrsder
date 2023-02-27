package jw.project.infrastructure.dynamoDB.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;

@Repository
@RequiredArgsConstructor
public class KeywordUsersRepository {
    private final DynamoDBMapper dynamoDBMapper;

    private final DynamoDB dynamoDB;

    public KeywordUsers save(KeywordUsers keywordUsers) {
        dynamoDBMapper.save(keywordUsers);
        return keywordUsers;
    }

    public KeywordUsers getUsersbyKeyword(String keyword) {
        return dynamoDBMapper.load(KeywordUsers.class, keyword);
    }

    public void addUser(String keyword, String userId) {
        Table table = dynamoDB.getTable("keywordUsers");
        System.out.println(table.getItem());
        UpdateItemSpec updateItemSpec = new UpdateItemSpec()
                .withPrimaryKey("keyword", keyword)
                .withUpdateExpression("SET #users = list_append(if_not_exists(#users, :emptyList), :user)")
                .withNameMap(new HashMap<String, String>() {{
                    put("#users", "users");
                }})
                .withValueMap(new HashMap<String, Object>() {{
                    put(":user", Arrays.asList(userId));
                    put(":emptyList", Arrays.asList());
                }})
                .withReturnValues(ReturnValue.UPDATED_NEW);

        UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
        System.out.println(outcome.getItem().toJSONPretty());
    }
}
