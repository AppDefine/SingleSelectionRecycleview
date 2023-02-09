package com.example.singleselectionrecycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.singleselectionrecycleview.databinding.RawItemBinding

class TextAdapter(val list: ArrayList<TextDataClass>) :
    RecyclerView.Adapter<TextAdapter.ViewHolder>() {


    var callBack: ((TextDataClass) -> Unit)? = null

    inner class ViewHolder(var binding: RawItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(textDataClass: TextDataClass) {
            binding.textViewName.text = textDataClass.name
            binding.root.setOnClickListener {
                callBack?.invoke(textDataClass)
            }
            if (textDataClass.isSelected){
                binding.textViewName.background  = ContextCompat.getDrawable(itemView.context,R.color.color_0045FF)
            }
            else{
                binding.textViewName.background  = ContextCompat.getDrawable(itemView.context,R.color.color_fc0352)
            }
        }
    }

    fun Single(textDataClass: TextDataClass) {
        for (i in list){
            if (i.isSelected){
                i.isSelected = false
                //break
            }
        }
        textDataClass.isSelected = true

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RawItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}