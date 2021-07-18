package com.example.myposts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentViewAdapter(var commentlist:List<Comments>) :RecyclerView.Adapter<CommentViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.comment_list_item,parent,false)
        return  CommentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var currentComments=commentlist.get(position)
        holder.tvName.text=currentComments.Names
        holder.tvEmail.text=currentComments.Email
        holder.tvEmail.text=currentComments.Body

    }

    override fun getItemCount(): Int {
        return  commentlist.size
    }

}



class CommentViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var tvName=itemView.findViewById<TextView>(R.id.tvName)
    var tvEmail=itemView.findViewById<TextView>(R.id.tvEmails)
    var tvBody=itemView.findViewById<TextView>(R.id.tvBodys)
}