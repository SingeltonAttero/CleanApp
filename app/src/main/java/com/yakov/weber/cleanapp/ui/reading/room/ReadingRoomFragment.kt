package com.yakov.weber.cleanapp.ui.reading.room

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.cleanapp.R
import com.yakov.weber.cleanapp.entity.Book
import com.yakov.weber.cleanapp.presention.reading.room.ReadingRoomPresenter
import com.yakov.weber.cleanapp.presention.reading.room.ReadingRoomView
import com.yakov.weber.cleanapp.toothpick.DI
import com.yakov.weber.cleanapp.ui.global.BaseFragment
import kotlinx.android.synthetic.main.fragment_reading_room.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.support.v4.toast
import toothpick.Toothpick

/**
 * Created on 31.10.18
 * @author YWeber
 * project CleanApp */

class ReadingRoomFragment : BaseFragment(), ReadingRoomView {

    companion object {
        fun newInstance() = ReadingRoomFragment()
    }

    override val layout: Int
        get() = R.layout.fragment_reading_room

    @InjectPresenter
    lateinit var presenter: ReadingRoomPresenter

    @ProvidePresenter
    fun providerPresenter(): ReadingRoomPresenter = Toothpick.openScope(DI.APP_SCOPE)
            .getInstance(ReadingRoomPresenter::class.java)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        with(toolbar){
            title = getString(R.string.reading_room)
        }
    }

    override fun setBookList(bookList: List<Book>) {
        recycler_book.adapter = ReadBookAdapter(bookList)
        recycler_book.layoutManager = LinearLayoutManager(activity)
    }
}