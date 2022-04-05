package com.alejobrosxd.zemoga.core.gateway;

import com.alejobrosxd.zemoga.core.gateway.response.TweetsGResponse;
import com.alejobrosxd.zemoga.core.gateway.response.UsersGResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TwitterGatewayEndpointService {

    @GET("by")
    Call<UsersGResponse> getUserByUsername(@Query("usernames") String username);

    @GET("{userId}/tweets")
    Call<TweetsGResponse> getTweetsByUserId(@Path("userId") String userId, @Query("max_results") String maxResults);

}
