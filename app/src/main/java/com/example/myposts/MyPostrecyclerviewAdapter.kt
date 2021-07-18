package com.example.myposts

import android.content.Context
import android.content.Intent
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import retrofit2.http.POST

class MyPostrecyclerviewAdapter(var postlist:List<Posts>,var context:Context ) :RecyclerView.Adapter<postViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postViewHolder{
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.post_list_tem,parent,false)
          return postViewHolder(itemView)
        }


    override fun onBindViewHolder(holder: postViewHolder, position: Int) {
        var  currentPost=postlist[position]
        holder.user.text=currentPost.userId.toString()
        holder.Id.text=currentPost.userId.toString()
        holder.content.text=currentPost.title
        holder.person.text=currentPost.body
        holder.cvpost.setOnClickListener {
         var  intent=Intent()
        }
    }

    override fun getItemCount(): Int {
        return postlist.size
    }

}
class postViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var  user=itemView.findViewById<TextView>(R.id.tvusers)
    var  cvpost=itemView.findViewById< CardView>(R.id.cvpostlist)
    var  Id=itemView.findViewById<TextView>(R.id.tvid)
    var  content=itemView.findViewById<TextView>(R.id.tvtext)
    var  person=itemView.findViewById<TextView>(R.id.tvbody)

}