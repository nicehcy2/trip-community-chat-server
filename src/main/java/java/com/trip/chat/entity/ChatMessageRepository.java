package java.com.trip.chat.entity;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.com.trip.chat.repository.ChatMessage;
import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {

    // 채티방 메시지 조회 (최신순)
    List<ChatMessage> findByChatRoomIdOrderByMessageTSIDDesc(Long chatRoomId);
}
