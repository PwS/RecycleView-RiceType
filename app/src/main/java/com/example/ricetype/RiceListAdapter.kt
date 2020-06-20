package com.example.ricetype

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ricetype.DetailActivity.Companion.DETAIL
import com.example.ricetype.DetailActivity.Companion.NAMA
import com.example.ricetype.DetailActivity.Companion.PHOTO

class RiceListAdapter(private val riceList: ArrayList<Rice>) :
    RecyclerView.Adapter<RiceListAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    //HandleOnClick
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        /*TODO("not implemented") //To change body of created functions use File | Settings | File Templates.*/
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row_rice, viewGroup, false)

        return ListViewHolder(view)

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Rice)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val rice = riceList[position]
        Glide.with(holder.itemView.context)
            .load(rice.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = rice.name
        holder.tvDetail.text =
            rice.detail //To change body of created functions use File | Settings | File Templates.

        holder.itemView.setOnClickListener {
            //OnClick
           /* fun onClick(view:View) {

                onItemClickCallback.onItemClicked(riceList.get(holder.getAdapterPosition()))
                val pindahhalaman = Intent(view.getContext().getApplicationContext(), DetailActivity::class.java)
                // Kirimkan nilai menggungkan intent
                pindahhalaman.putExtra(NAMA, rice.name)
                pindahhalaman.putExtra(DETAIL, rice.detail)
                pindahhalaman.putExtra(PHOTO, rice.photo)
                view.getContext().startActivity(pindahhalaman)
            }*/
            onItemClickCallback.onItemClicked(riceList[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return riceList.size //To change body of created functions use File | Settings | File Templates.
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

}