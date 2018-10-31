package com.yakov.weber.cleanapp.ui.reading.room

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.cleanapp.R
import com.yakov.weber.cleanapp.presention.reading.room.ReadingRoomPresenter
import com.yakov.weber.cleanapp.presention.reading.room.ReadingRoomView
import com.yakov.weber.cleanapp.toothpick.DI
import com.yakov.weber.cleanapp.ui.global.BaseFragment
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.support.v4.toast
import toothpick.Toothpick

/**
 * Created on 31.10.18
 * @author YWeber
 * project CleanApp */

class ReadingRoomFragment : BaseFragment(), ReadingRoomView {

    companion object {
        private const val TITLE_FRAGMENT_BOOK = "title fragment book"
        fun newInstance(title:String) = ReadingRoomFragment().apply {
            val argument = Bundle()
            argument.putString(TITLE_FRAGMENT_BOOK,title)
            arguments = argument
        }
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
            title = arguments?.getString(TITLE_FRAGMENT_BOOK)
        }
    }
}