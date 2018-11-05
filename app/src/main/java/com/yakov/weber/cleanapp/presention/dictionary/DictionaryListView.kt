package com.yakov.weber.cleanapp.presention.dictionary

import com.arellomobile.mvp.MvpView
import com.yakov.weber.cleanapp.entity.Word

/**
 * Created on 05.11.18
 * @author YWeber
 * project CleanApp */

interface DictionaryListView : MvpView {
    fun setListAdapter(words:List<Word>)
    fun setDataSort(words:List<Word>)
    fun progressDialog(visible:Boolean)

}