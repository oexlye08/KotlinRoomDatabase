package id.my.okisulton.kotlinroomdatabase.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import id.my.okisulton.kotlinroomdatabase.R
import id.my.okisulton.kotlinroomdatabase.model.User
import kotlinx.android.synthetic.main.custom_row.view.*

/**
 *Created by osalimi on 12-01-2021.
 **/
class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    //kedua
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    //ketiga
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]

        holder.itemView.tv_id.text = currentItem.id.toString()
        holder.itemView.tv_firstname.text = currentItem.firstName
        holder.itemView.tv_lastname.text = currentItem.lastName
        holder.itemView.tv_age.text = currentItem.age.toString()

        holder.itemView.rowLayout.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    //Pertama
    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}