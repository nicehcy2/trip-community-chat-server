package java.com.trip.chat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.com.trip.chat.repository.mongo.ChatMessage;
import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {

    // 채팅방 메시지 최신순 조회
    List<ChatMessage> findByChatRoomIdOrderByTimestampDesc(Long chatRoomId);
}
