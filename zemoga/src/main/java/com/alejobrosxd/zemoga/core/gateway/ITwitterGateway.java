package com.alejobrosxd.zemoga.core.gateway;

import com.alejobrosxd.zemoga.core.dto.TweetDTO;
import java.util.List;

public interface ITwitterGateway {

    String getUserIdByUsername(String username);

    List<TweetDTO> getTweetsByUserId(String userId);

}
