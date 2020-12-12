package com.example.ebay;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

interface RetrofitApi {

    String BASE_URL = "http://192.168.1.135:8000/";

    @POST("createUser")
    @FormUrlEncoded
    Call<CreateUserResponse> createUser(
            @Field("firstname") String firstname,
            @Field("lastname") String lastname,
            @Field("email") String email,
            @Field("password") String password,
            @Field("address") String address

    );

    @POST("authenticateUser")
    @FormUrlEncoded
    Call<AuthenticationResponse> authenticateUser(
            @Field("email") String email,
            @Field("password") String password);


    @POST("products")
    @FormUrlEncoded
    Call<ProductsResponse> products(
            @Field("id") String id
    );
    @POST("placeOder")
    @FormUrlEncoded
    Call<String> placeOder(
            @Field("email") String id,
            @Field("productid") String productid);
}
