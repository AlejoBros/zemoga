package com.alejobrosxd.zemoga.commons.mapper;

import com.alejobrosxd.zemoga.core.dto.TweetDTO;
import com.alejobrosxd.zemoga.core.gateway.response.TweetGResponse;
import org.mapstruct.Mapper;

@Mapper
public interface ITweetMapper {

    TweetDTO tweetGResponseToTweetDTO(TweetGResponse tweetGResponse);

}
