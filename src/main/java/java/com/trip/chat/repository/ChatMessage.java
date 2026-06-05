package java.com.trip.chat.repository;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.com.trip.chat.entity.enums.MessageType;
import java.time.LocalDateTime;

@Document(collection = "chat_messages") // collation → collection 오타 수정
@Getter
@Builder
public class ChatMessage {

    @Id // jakarta.persistence.Id → org.springframework.data.annotation.Id 수정
    private String messageTSID;
    private Long chatRoomId;     // 목적지(전달할 그룹 채팅방) ID
    private Long senderId;       // 발신인 ID
    private String senderNickname; // 발신인 닉네임
    private MessageType messageType; // 메시지 타입(텍스트, 사진, 영수증)
    private String content;      // 메시지 내용
    private LocalDateTime timestamp; // String → LocalDateTime 수정
}
