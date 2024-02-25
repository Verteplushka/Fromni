package com.fromni.backend.dto;

import com.fromni.backend.entity.Channel;
import com.fromni.backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WrapperDto {
    private User user;
    private Channel channel;
}
