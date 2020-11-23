package com.restapi.potatrocapi.repository;

import com.restapi.potatrocapi.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long> {
    @Query(
            value = "SELECT * from potatroc.conversation c WHERE c.conversation_id = ?1 AND ( c.user_coneversation_one_id = ?2 OR C.user_coneversation_two_id = ?2)",
            nativeQuery = true)
    Optional<Conversation> findConversationByIdForCurrentUser(long conversation_id, long user_id);

    @Query(
            value = "SELECT * from potatroc.conversation c WHERE  c.user_coneversation_one_id = ?1 OR C.user_coneversation_two_id = ?1",
            nativeQuery = true)
    List<Conversation> findConversationsByCurrentUser(long user_id);
}