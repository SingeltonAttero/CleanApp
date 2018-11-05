package com.yakov.weber.cleanapp.ui.dictionary

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.yakov.weber.cleanapp.R
import com.yakov.weber.cleanapp.entity.Word
import com.yakov.weber.cleanapp.extension.inflate
import kotlinx.android.synthetic.main.item_dictionary.view.*

/**
 * Created on 05.11.18
 * @author YWeber
 * project CleanApp */

class WordAdapter(listWord:List<Word>) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    private var words:MutableList<Word> = mutableListOf()
    init {
        words.addAll(listWord)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = parent.inflate(R.layout.item_dictionary)
        return WordViewHolder(view)
    }

    fun setData(listWord: List<Word>){
        words.clear()
        words.addAll(listWord)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = words.size

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(words[position])
    }

    inner class WordViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        fun bind(word:Word){
            itemView.title_dictionary.text = word.word
            itemView.description_dictionary.text = word.description
        }
    }
}