package com.alejobrosxd.zemoga.core.gateway.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TweetsGResponse {

    private List<TweetGResponse> data;

}
