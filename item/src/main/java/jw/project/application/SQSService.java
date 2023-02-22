package jw.project.application;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class SQSService {
    @Value("${cloud.aws.sqs.queue.url}")
    private String url;
    private final AmazonSQS amazonSQS;

    public SendMessageResult sendMessage(String itemName) {
        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(url)
                .withMessageBody(itemName);
        return amazonSQS.sendMessage(send_msg_request);
    }
}
