package com.restapi.potatrocapi.Service;


import com.restapi.potatrocapi.model.Conversation;

import com.restapi.potatrocapi.model.Unit;
import com.restapi.potatrocapi.model.User;
import com.restapi.potatrocapi.model.Vegetable;
import com.restapi.potatrocapi.repository.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ConversationService {
    @Autowired
    ConversationRepository conversationRepository;
    @Autowired
    private UserService userService;

    public Optional getConversationForCurrentUser(long id) {
        User user= userService.findByAuthid();
        Optional<Conversation> conversation  = conversationRepository.findConversationByIdForCurrentUser(id, user.getId());
        return conversation;
    }

    public List<Conversation> getAllConversationsForCurrentUser() {
        User user= userService.findByAuthid();
        List<Conversation> conversations = conversationRepository.findConversationsByCurrentUser(user.getId());
        return conversations;
    }

    public ResponseEntity<Conversation> addConversation(Conversation conversation) {
        conversation.setCreatedAt(new Date());
        conversation.setUpdatedAt(new Date());
        return new ResponseEntity<>(conversationRepository.save(conversation), HttpStatus.OK);
    }
}

