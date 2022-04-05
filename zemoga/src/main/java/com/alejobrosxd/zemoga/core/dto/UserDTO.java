package com.alejobrosxd.zemoga.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Integer id;

    private String firstName;

    private String lastName;

    private String workExperience;

    private String photo;

    private String usernameTwitter;

}
