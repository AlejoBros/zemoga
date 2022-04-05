package com.alejobrosxd.zemoga.core.gateway.impl;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TwitterGatewayTokenInterceptor implements Interceptor {

    private final String token;

    public TwitterGatewayTokenInterceptor(@Value("${twitter.token}") String token) {
        this.token = token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request newRequest=chain.request().newBuilder()
            .header("Authorization","Bearer " + token)
            .build();

        return chain.proceed(newRequest);
    }

}
