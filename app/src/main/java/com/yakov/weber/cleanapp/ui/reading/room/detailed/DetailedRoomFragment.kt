package com.yakov.weber.cleanapp.ui.reading.room.detailed

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.cleanapp.R
import com.yakov.weber.cleanapp.presention.reading.room.detailed.DetailedRoomPresenter
import com.yakov.weber.cleanapp.presention.reading.room.detailed.DetailedRoomView
import com.yakov.weber.cleanapp.toothpick.DI
import com.yakov.weber.cleanapp.ui.global.BaseFragment
import toothpick.Toothpick

/**
 * Created on 06.11.18
 * @author YWeber
 * project CleanApp */

class DetailedRoomFragment : BaseFragment(), DetailedRoomView {

    override val layout: Int
        get() = R.layout.fragment_detailed_room


    @InjectPresenter
    lateinit var presenter: DetailedRoomPresenter

    @ProvidePresenter
    fun providerPresenter(): DetailedRoomPresenter = Toothpick.openScope(DI.APP_SCOPE)
            .getInstance(DetailedRoomPresenter::class.java)

    override fun onBackPressed() {
        super.onBackPressed()
        presenter.onBack()
    }


}