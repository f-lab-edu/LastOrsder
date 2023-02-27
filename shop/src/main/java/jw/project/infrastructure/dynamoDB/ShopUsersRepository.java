package jw.project.infrastructure.dynamoDB;

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
public class ShopUsersRepository {
    private final DynamoDBMapper dynamoDBMapper;

    private final DynamoDB dynamoDB;

    public ShopUsers save(ShopUsers shopUsers) {
        dynamoDBMapper.save(shopUsers);
        return shopUsers;
    }

    public ShopUsers getUsersbyShopId(String keyword) {
        return dynamoDBMapper.load(ShopUsers.class, keyword);
    }

    public void addUser(Long shopId, Long userId) {
        Table table = dynamoDB.getTable("shopUsers");
        System.out.println(table.getItem());
        UpdateItemSpec updateItemSpec = new UpdateItemSpec()
                .withPrimaryKey("shopId", shopId)
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
