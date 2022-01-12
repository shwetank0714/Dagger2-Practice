package com.example.practiceproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.practiceproject.models.ListData
import com.example.practiceproject.models.RecyclerData
import kotlinx.android.synthetic.main.item_recycler_view.view.*

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder>() {

    private var listData: List<RecyclerData>? = null

    fun setUpdatedData(listData: List<RecyclerData>){
        this.listData = listData
    }

    class CustomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView = itemView.imageView
        val textViewName = itemView.textViewName
        val textViewContent = itemView.textViewContent

        fun bind(data: RecyclerData){
            textViewName.text = data.name
            textViewContent.text = data.description

            Glide.with(imageView)
                .load(data.owner.avatar_url)
                .apply(RequestOptions.centerCropTransform())
                .into(imageView)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view,parent,false)
        )
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(listData!![position])
    }

    override fun getItemCount(): Int {
        if(listData == null) return 0;

        return listData!!.size
    }
}