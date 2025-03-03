package emailGernator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Map;

@Service
public class EmailGeneratorService {

    @Value("${gemini.api.url}")
    private String geminiApiUrl;

    @Value("${gemini.api.key}")
    private String geminiApiKey;


    private final WebClient webclient;

    public EmailGeneratorService(WebClient.Builder webclientbuilder) {
        this.webclient  =  webclientbuilder.build();
    }


    public String generateEmail(EmailRequest emailRequest) {
        String prompt = buildPrompt(emailRequest);
        Map<String,Object>  requestBody = Map.of(
                "contents", new Object[]{
                        Map.of("parts", new Object[]{
                                Map.of("text",prompt)
                        })
                }
        );
        String url = geminiApiUrl + "?Key=" + geminiApiKey;
        System.out.println(url);
        String response = webclient.post()
                .uri(url)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return extractContentRespose(response);
    }

    private String extractContentRespose(String response) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response);
            return rootNode.path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asText();
        } catch (Exception e) {
            return "Error processing request: " + e.getMessage();
        }
    }

    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("generate a email reply for the following mail, please don't generate a subject content");
        if (emailRequest.getTone() != null && !emailRequest.getTone().isEmpty()) {
            prompt.append("usa a").append(emailRequest.getTone()).append("tone");
        }
        prompt.append("original email \n").append(emailRequest.getEmail());
        return prompt.toString();
    }

}
