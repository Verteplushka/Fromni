package com.fromni.backend.dto;

import com.fromni.backend.entity.Button;
import com.fromni.backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private User user;
    private String channelName;
    private String message;
    private List<Button> buttons;
}
