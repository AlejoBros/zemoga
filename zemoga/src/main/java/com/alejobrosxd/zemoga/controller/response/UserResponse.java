package com.alejobrosxd.zemoga.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Integer id;

    private String firstName;

    private String lastName;

    private String workExperience;

    private String photo;

    private String usernameTwitter;

}
