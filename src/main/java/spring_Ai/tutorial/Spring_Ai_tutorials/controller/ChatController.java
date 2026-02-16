package spring_Ai.tutorial.Spring_Ai_tutorials.controller;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ChatController {

    private ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        chatClient = builder.build();
    }







    @GetMapping("/chat")
    public ResponseEntity<String> chat(
            @RequestParam(value = "q") String query

    ) {

        String responseContent =  this.chatClient.prompt(query).call().content();







        return ResponseEntity.ok(responseContent);
    }


}
