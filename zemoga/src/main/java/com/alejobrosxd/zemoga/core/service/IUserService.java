package com.alejobrosxd.zemoga.core.service;

import com.alejobrosxd.zemoga.core.dto.TweetDTO;
import com.alejobrosxd.zemoga.core.dto.UserDTO;
import java.util.List;
import twitter4j.TwitterException;

public interface IUserService {

    UserDTO create(UserDTO userDTO);

    UserDTO get(Integer id);

    List<UserDTO> getAll();

    UserDTO modify(Integer id, UserDTO userDTO);

    List<TweetDTO> getTweets(Integer id) throws TwitterException;

}
