package com.yakov.weber.cleanapp.ui.dictionary

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.cleanapp.R
import com.yakov.weber.cleanapp.entity.Word
import com.yakov.weber.cleanapp.presention.dictionary.DictionaryListPresenter
import com.yakov.weber.cleanapp.presention.dictionary.DictionaryListView
import com.yakov.weber.cleanapp.toothpick.DI
import com.yakov.weber.cleanapp.ui.global.BaseFragment
import com.yakov.weber.cleanapp.ui.global.ProgressDialog
import kotlinx.android.synthetic.main.fragment_dictionary_list.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.support.v4.progressDialog
import toothpick.Toothpick

/**
 * Created on 05.11.18
 * @author YWeber
 * project CleanApp */

class DictionaryListFragment : BaseFragment(), DictionaryListView {

    companion object {
        fun newInstance() = DictionaryListFragment()
    }

    override val layout: Int
        get() = R.layout.fragment_dictionary_list

    @InjectPresenter
    lateinit var presenter: DictionaryListPresenter

    @ProvidePresenter
    fun providerPresenter(): DictionaryListPresenter = Toothpick
            .openScope(DI.APP_SCOPE)
            .getInstance(DictionaryListPresenter::class.java)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.apply {
            title = getString(R.string.dictionary)
            setNavigationOnClickListener { onBackPressed() }
            setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        }
        fab.setOnClickListener {
            presenter.sortWord()
        }
    }

    override fun progressDialog(visible: Boolean) {
       showProgressDialog(visible)
    }


    override fun setDataSort(words: List<Word>) {
        (recycler_dictionary.adapter as WordAdapter).setData(words)
    }

    override fun setListAdapter(words: List<Word>) {
        recycler_dictionary.adapter = WordAdapter(words)
        recycler_dictionary.layoutManager = GridLayoutManager(activity, 2)
    }

}