package com.alejobrosxd.zemoga.core.service.impl;

import com.alejobrosxd.zemoga.commons.enums.ExceptionEnum;
import com.alejobrosxd.zemoga.commons.mapper.IUserMapper;
import com.alejobrosxd.zemoga.core.dto.TweetDTO;
import com.alejobrosxd.zemoga.core.dto.UserDTO;
import com.alejobrosxd.zemoga.core.entity.User;
import com.alejobrosxd.zemoga.core.exception.NotFoundException;
import com.alejobrosxd.zemoga.core.gateway.ITwitterGateway;
import com.alejobrosxd.zemoga.core.repo.IUserRepo;
import com.alejobrosxd.zemoga.core.service.IUserService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepo userRepo;
    private final IUserMapper userMapper;
    private final ITwitterGateway twitterGateway;

    @Override
    public UserDTO create(UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        return userMapper.userToUserDTO(userRepo.save(user));
    }

    @Override
    public UserDTO get(Integer id) {
        UserDTO userDTO = userMapper.userToUserDTO(userRepo.findById(id).orElseThrow(
            () -> new NotFoundException(ExceptionEnum.ERROR_USER_NOT_FOUND)
        ));
        return userDTO;
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> users = userRepo.findAll();
        return users.stream()
            .map(user -> userMapper.userToUserDTO(user)).collect(
                Collectors.toList());
    }

    @Override
    public UserDTO modify(Integer id, UserDTO userDTO) {
        get(id);
        User user = userMapper.userDTOToUser(id, userDTO);
        return userMapper.userToUserDTO(userRepo.save(user));
    }

    public List<TweetDTO> getTweets(Integer id) {
        UserDTO userDTO = get(id);
        String userId = twitterGateway.getUserIdByUsername(userDTO.getUsernameTwitter());
        return twitterGateway.getTweetsByUserId(userId);
    }

}
