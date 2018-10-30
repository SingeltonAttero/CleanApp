package com.yakov.weber.cleanapp.ui.main

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.cleanapp.presention.main.MainPresenter
import com.yakov.weber.cleanapp.toothpick.DI
import com.yakov.weber.cleanapp.ui.global.BaseFragment
import toothpick.Toothpick

/**
 * Created on 30.10.18
 * @author YWeber
 * project CleanApp */

class MainFragment : BaseFragment() {
    override val layout: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    @InjectPresenter
    lateinit var presenter:MainPresenter
    @ProvidePresenter
    fun providerPresenter() = Toothpick
            .openScope(DI.APP_SCOPE)
            .getInstance(MainPresenter::class.java)


}