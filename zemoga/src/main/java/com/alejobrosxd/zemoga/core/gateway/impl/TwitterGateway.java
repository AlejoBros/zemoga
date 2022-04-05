package com.alejobrosxd.zemoga.core.gateway.impl;

import com.alejobrosxd.zemoga.commons.enums.ExceptionEnum;
import com.alejobrosxd.zemoga.commons.mapper.ITweetMapper;
import com.alejobrosxd.zemoga.core.dto.TweetDTO;
import com.alejobrosxd.zemoga.core.exception.APIException;
import com.alejobrosxd.zemoga.core.gateway.ITwitterGateway;
import com.alejobrosxd.zemoga.core.gateway.TwitterGatewayEndpointService;
import com.alejobrosxd.zemoga.core.gateway.response.TweetsGResponse;
import com.alejobrosxd.zemoga.core.gateway.response.UsersGResponse;
import java.util.List;
import java.util.stream.Collectors;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
public class TwitterGateway implements ITwitterGateway {

    private final ITweetMapper tweetMapper;

    private final TwitterGatewayTokenInterceptor twitterTokenInterceptor;

    private final String baseUrl;

    private final String maxResults;

    public TwitterGateway(ITweetMapper tweetMapper,
        TwitterGatewayTokenInterceptor twitterTokenInterceptor, @Value("${twitter.baseUrl}") String baseUrl,
        @Value("${twitter.maxResults}") String maxResults) {
        this.tweetMapper = tweetMapper;
        this.twitterTokenInterceptor = twitterTokenInterceptor;
        this.baseUrl = baseUrl;
        this.maxResults = maxResults;
    }

    @Override
    public String getUserIdByUsername(String username) {
        Call<UsersGResponse> call = getTwitterEndpointService().getUserByUsername(username);
        Response<UsersGResponse> response;
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new APIException(ExceptionEnum.ERROR_TWITTER_API);
        }
        if (response.isSuccessful()) {
            return response.body().getData().get(0).getId();
        } else {
            throw new APIException(ExceptionEnum.ERROR_TWITTER_USER_NOT_FOUND);
        }
    }

    @Override
    public List<TweetDTO> getTweetsByUserId(String userId) {
        Call<TweetsGResponse> call = getTwitterEndpointService().getTweetsByUserId(userId, maxResults);
        Response<TweetsGResponse> response;
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new APIException(ExceptionEnum.ERROR_TWITTER_API);
        }
        return response.body().getData().stream()
            .map(tweetGResponse -> tweetMapper.tweetGResponseToTweetDTO(tweetGResponse)).collect(
                Collectors.toList());
    }

    private TwitterGatewayEndpointService getTwitterEndpointService() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(twitterTokenInterceptor)
            .build();
        return new Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
            .create(TwitterGatewayEndpointService.class);
    }

}
