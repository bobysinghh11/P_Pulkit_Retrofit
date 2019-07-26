package com.stuffshuf.p_pulkit_retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.user_list.view.*

class UsersAdapter(val user:ArrayList<Users>):RecyclerView.Adapter<UsersAdapter.UserAdapterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapterViewHolder {
        val li=parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView=li.inflate(R.layout.user_list, parent, false)
        return UserAdapterViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return user.size
    }

    override fun onBindViewHolder(holder: UserAdapterViewHolder, position: Int) {
       val userdata=user[position]
        holder.bind(userdata)
    }


    class UserAdapterViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        fun bind(users: Users)
        {
            with(itemView)
            {
              tvLogin.text=users.login
                tvID.text=users.id.toString()
            }
        }
    }
}