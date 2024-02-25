package com.fromni.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "button_fromni")
public class Button {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "message_id")
    private Long messageId;
    private String type;
    @Column(name = "button_text")
    private String buttonText;

    public Button(String type, String buttonText){
        this.type = type;
        this.buttonText = buttonText;
    }
}
