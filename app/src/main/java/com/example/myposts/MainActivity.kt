package com.example.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.POST

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPosts()
    }

    fun getPosts() {
        var retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = retrofit.getPosts()
        request.enqueue(object:Callback<List<POST>> {
            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                if (response.isSuccessful){
                    var  post=response.body()
//                    //Toast.makeText(baseContext,post?.size.toString(),Toast.LENGTH_LONG).show()

                }
            }


            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()

            }

        })
            }
        }





