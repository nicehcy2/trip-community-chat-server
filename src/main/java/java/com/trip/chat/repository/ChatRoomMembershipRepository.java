package java.com.trip.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.com.trip.chat.entity.ChatRoom;
import java.com.trip.chat.entity.ChatRoomMembership;
import java.util.List;
import java.util.Optional;

public interface ChatRoomMembershipRepository extends JpaRepository<ChatRoomMembership, Long> {

    Optional<ChatRoomMembership> findByUserIdAndChatRoom(Long userId, ChatRoom chatRoom);
    List<ChatRoomMembership> findByChatRoomId(Long chatRoomId);
}
