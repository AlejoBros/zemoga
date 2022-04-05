package com.alejobrosxd.zemoga.controller.request;

import com.alejobrosxd.zemoga.commons.constant.PatternConstant;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotBlank
    @Pattern(regexp = PatternConstant.ALPHABETIC)
    private String firstName;

    @NotBlank
    @Pattern(regexp = PatternConstant.ALPHANUMERIC)
    private String lastName;

    @NotBlank
    private String workExperience;

    @NotBlank
    private String photo;

    @NotBlank
    private String usernameTwitter;

}
