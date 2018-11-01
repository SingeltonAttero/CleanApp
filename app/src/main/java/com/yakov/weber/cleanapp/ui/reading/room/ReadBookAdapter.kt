package com.yakov.weber.cleanapp.ui.reading.room

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.yakov.weber.cleanapp.R
import com.yakov.weber.cleanapp.entity.Book
import com.yakov.weber.cleanapp.extension.inflate
import kotlinx.android.synthetic.main.item_reading_book.view.*

/**
 * Created on 01.11.18
 * @author YWeber
 * project CleanApp */

class ReadBookAdapter(private val bookList: List<Book>) : RecyclerView.Adapter<ReadBookAdapter.ReadBookHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReadBookHolder {
        val view = parent.inflate(R.layout.item_reading_book)
        return ReadBookHolder(view)
    }

    override fun getItemCount(): Int = bookList.size

    override fun onBindViewHolder(holder: ReadBookHolder, position: Int) {
        holder.bind(bookList[position])
    }

    inner class ReadBookHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        fun bind(book:Book){
            itemView.title_reading_book.text = book.title
            itemView.description_reading_book.text = book.description
            Glide.with(itemView.context)
                    .load(book.urlImage)
                    .into(itemView.icon_reading_book)
        }

    }
}