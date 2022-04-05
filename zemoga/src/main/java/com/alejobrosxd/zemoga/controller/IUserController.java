package com.alejobrosxd.zemoga.controller;


import com.alejobrosxd.zemoga.controller.request.UserRequest;
import com.alejobrosxd.zemoga.controller.response.UserResponse;
import com.alejobrosxd.zemoga.core.dto.TweetDTO;
import java.util.List;
import twitter4j.TwitterException;

public interface IUserController {

    UserResponse create(UserRequest userRequest);

    UserResponse get(Integer id);

    List<UserResponse> getAll();

    UserResponse modify(Integer id, UserRequest userRequest);

    List<TweetDTO> getTweets(Integer id) throws TwitterException;

}
