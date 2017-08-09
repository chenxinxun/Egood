package com.tapcash.egood.usercenter;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by TC10795 on 2017/8/9.
 */
public interface UserService {
    //@FormUrlEncoded 使用的情况参数 使用@Field 替代 @Query
    //@FormUrlEncoded
    @POST("user/login")
    /**以正常参数形式请求*/
    //Observable<User> login(@Query("userName") String username, @Query("password") String password);
    /**以json的body的形式请求*/
    Observable<User> login(@Body User user);
}
