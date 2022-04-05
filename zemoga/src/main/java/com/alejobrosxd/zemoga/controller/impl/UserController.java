package com.alejobrosxd.zemoga.controller.impl;

import com.alejobrosxd.zemoga.commons.mapper.IUserMapper;
import com.alejobrosxd.zemoga.controller.IUserController;
import com.alejobrosxd.zemoga.controller.request.UserRequest;
import com.alejobrosxd.zemoga.controller.response.UserResponse;
import com.alejobrosxd.zemoga.core.dto.TweetDTO;
import com.alejobrosxd.zemoga.core.dto.UserDTO;
import com.alejobrosxd.zemoga.core.service.IUserService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.TwitterException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController implements IUserController {

    private final IUserService userService;
    private final IUserMapper userMapper;

    @Override
    @PostMapping
    public UserResponse create(@RequestBody @Valid UserRequest userRequest) {
        UserDTO userDTO = userMapper.userRequestToUserDTO(userRequest);
        return userMapper.userDTOToUserResponse(userService.create(userDTO));
    }

    @Override
    @GetMapping("/{id}")
    public UserResponse get(@PathVariable(name = "id") Integer id) {
        return userMapper.userDTOToUserResponse(userService.get(id));
    }

    @Override
    @GetMapping("/all")
    public List<UserResponse> getAll() {
        List<UserDTO> usersDTO = userService.getAll();
        return usersDTO.stream()
            .map(userDTO -> userMapper.userDTOToUserResponse(userDTO)).collect(
                Collectors.toList());
    }

    @Override
    @PutMapping("/{id}")
    public UserResponse modify(@PathVariable(name = "id") Integer id, @RequestBody @Valid UserRequest userRequest) {
        UserDTO userDTO = userMapper.userRequestToUserDTO(userRequest);
        return userMapper.userDTOToUserResponse(userService.modify(id, userDTO));
    }

    @Override
    @GetMapping("/{id}/tweets")
    public List<TweetDTO> getTweets(@PathVariable(name = "id") Integer id) throws TwitterException {
        return userService.getTweets(id);
    }

}
