package com.utad.tema12recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.utad.enviopantallas.R

class MainAdapter(private val mDataSet: List<LibroPrueba>, var onClick: (LibroPrueba) -> Unit) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        //Item block es el laayout donde estara la lista
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_block, parent, false)
        return MainViewHolder(v)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = mDataSet.get(position)
        holder.bindItems(data)
        holder.itemView.setOnClickListener() {
            onClick(data)
        }
    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }

    inner class MainViewHolder(var v: View) : RecyclerView.ViewHolder(v) {
        //mytexto = text view de itemblock
        val mytexto = v.findViewById<TextView>(R.id.mytexto)
        val myauthor = v.findViewById<TextView>(R.id.myautor)
        val myimage = v.findViewById<ImageView>(R.id.imagenCeldas)

        fun bindItems(data: LibroPrueba) {
            mytexto.text = data.name
            myauthor.text = data.author
            Glide.with(myimage.context).load(data.fotolibro).into(myimage)
        }
    }
}