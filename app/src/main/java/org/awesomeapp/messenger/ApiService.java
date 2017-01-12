package org.awesomeapp.messenger;

import org.awesomeapp.messenger.model.UPSUser;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by rnecesito on 7/28/16.
 */
public interface ApiService {

    //create user
    @FormUrlEncoded
    @Headers("x-app: zcommerce")
    @POST("users")
    Call<UPSUser> createUser(
            @Field("firstName") String firstname,
            @Field("lastName") String lastname,
            @Field("username") String username,
            @Field("password") String password,
            @Field("confirmPassword") String confirmPass,
            @Field("email") String email
    );

    //login
    @FormUrlEncoded
    @Headers("x-app: zcommerce")
    @POST("sessions")
    Call<UPSUser> login(
            @Field("userEmail") String username,
            @Field("password") String password,
            @Field("type") String type
    );
}
