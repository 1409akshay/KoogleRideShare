package koogle.ride.share.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import koogle.ride.share.databinding.UserHelpItemBinding
import koogle.ride.share.model.Help

class UserHelpListAdapter : RecyclerView.Adapter<UserHelpViewHolder>() {
    var helpList = mutableListOf<Help>()

    fun updateHelpList(list: List<Help>) {
        this.helpList = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHelpViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserHelpItemBinding.inflate(inflater, parent, false)
        return UserHelpViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserHelpViewHolder, position: Int) {
        val item = helpList[position]
        holder.binding.descriptionTV.text = item.created_at
        holder.binding.descriptionTV.setOnClickListener{
            // if data was populated click event will fire a request to call particular ID
            // and will render that data into dialog.
        }
    }

    override fun getItemCount() = helpList.size

}
