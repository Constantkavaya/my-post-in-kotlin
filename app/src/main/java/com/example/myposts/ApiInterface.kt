package com.example.myposts

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
       @GET("posts")
       fun getPosts(): Call<List<POST>>


 @GET("post/postId")
 fun getPost(postId: Int):Call<Posts>
}








