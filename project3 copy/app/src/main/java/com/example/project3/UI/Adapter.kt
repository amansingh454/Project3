package com.example.project3.UI
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.project3.FoodPacket
import com.example.project3.R
import com.example.project3.databinding.SingleItemBinding


class Adapter(private val data:List<FoodPacket>): RecyclerView.Adapter<Adapter.ItemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        return ItemViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.single_item,parent,false))
    }

    override fun onBindViewHolder(holder:ItemViewHolder, position: Int) {
        holder.singleItemBinding.foodPacket=data[position]
    }

    override fun getItemCount(): Int {
        return data.size
    }
    class ItemViewHolder(val singleItemBinding: SingleItemBinding):
            RecyclerView.ViewHolder(singleItemBinding.root){
    }
}