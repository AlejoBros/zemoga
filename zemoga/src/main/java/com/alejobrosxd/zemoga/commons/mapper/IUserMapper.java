package com.alejobrosxd.zemoga.commons.mapper;

import com.alejobrosxd.zemoga.controller.request.UserRequest;
import com.alejobrosxd.zemoga.controller.response.UserResponse;
import com.alejobrosxd.zemoga.core.dto.UserDTO;
import com.alejobrosxd.zemoga.core.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface IUserMapper {

    User userDTOToUser(UserDTO userDTO);

    UserDTO userToUserDTO(User user);

    @Mapping(source = "id", target = "id")
    User userDTOToUser(Integer id, UserDTO userDTO);

    UserDTO userRequestToUserDTO(UserRequest userRequest);

    UserResponse userDTOToUserResponse(UserDTO userDTO);

}
