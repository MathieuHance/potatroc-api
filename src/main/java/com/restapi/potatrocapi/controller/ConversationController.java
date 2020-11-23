package com.restapi.potatrocapi.controller;

import com.restapi.potatrocapi.Service.ConversationService;
import com.restapi.potatrocapi.model.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    @RequestMapping(value = "api/conversation/{id}", method = RequestMethod.GET, produces = "application/json")
    public Optional getConversation(@PathVariable("id") long id) {
        Optional<Conversation> conversation = conversationService.getConversationForCurrentUser(id);
        return conversation;
    }

    @RequestMapping(value = "api/conversations", method = RequestMethod.GET, produces = "application/json")
    public List<Conversation> getAllConversations() {
        List<Conversation> conversations = conversationService.getAllConversationsForCurrentUser();
        return conversations;

    }

    @PostMapping("api/conversation")
    public ResponseEntity<Conversation> postConversation(@RequestBody Conversation conversation) {
        ResponseEntity<Conversation> _conversation = conversationService.addConversation(conversation);
        return _conversation;
    }
}
