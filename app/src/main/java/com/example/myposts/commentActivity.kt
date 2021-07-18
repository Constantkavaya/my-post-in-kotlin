package com.example.myposts

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Comment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body

class commentActivity : AppCompatActivity() {
    var  postId=0
    lateinit var tvpostTitle:TextView
    lateinit var tvpostBody:TextView
    lateinit var tvName:TextView
    lateinit var tvEmail:TextView
    lateinit var tvBody:TextView
    lateinit var rvComment:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)
        tvName=findViewById(R.id.tvpost)
        tvBody=findViewById(R.id.tvbody)
        tvEmail=findViewById(R.id.tvtext)
        rvComment=findViewById(R.id.rvcomments)

        postId=intent.getIntExtra("Post_ID",0)
        castviews()
        getPost()
        getComment()

    }
    fun castviews(){
      var tvpostTitle=findViewById<TextView>(R.id.tvpost)
      var tvpostBody=findViewById<TextView>(R.id.tvbody)
    }
    fun  getPost(){
        if (postId==0){
            Toast.makeText(baseContext,"post not found" ,Toast.LENGTH_LONG).show()
            finish()
        }
var apiclient=ApiClient.buildApiClient(ApiInterface::class.java)
        var  request=apiclient.getPost(postId)

        request.enqueue(object :Callback<Posts?>{
            override fun onResponse(call: Call<Posts?>, response: Response<Posts?>) {
                if (response.isSuccessful) {
                    var post = response.body()
                    tvpostTitle.text = post?.title
                    tvpostTitle.text=post?.body
                }

            }
            override fun  onFailure(call: Call<Posts?>,t:Throwable){
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }
        })

        }
    }
fun  getComment(){
    var  rvcomment=findViewById<RecyclerView>(R.id.rvcomments)
    var  retrofit=ApiClient.buildApiClient(ApiInterface::class.java)
    var request=retrofit.getComments(retrofit)
    request.enqueue(object :Callback<List<Comment>>
    {
        override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
            var comment=response.body()!!
            var commentAdapter=CommentViewHolder(Comments)
            rvcomment.adapter=commentAdapter
            rvcomment.layoutManager=LinearLayoutManager(baseContext)

        }

        override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
            Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
        }
    })
}




fun <T> findViewById(rvcomments: Int): Any {
    return rvcomments

}

