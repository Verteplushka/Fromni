package com.fromni.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "message_fromni")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "channel_id")
    private Long channelId;
    @Column(name = "message_text")
    private String messageText;

    public Message(Long userId, Long channelId, String messageText){
        this.userId = userId;
        this.channelId = channelId;
        this.messageText = messageText;
    }
}
