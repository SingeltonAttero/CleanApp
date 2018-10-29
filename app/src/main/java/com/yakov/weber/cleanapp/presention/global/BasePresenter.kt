package com.yakov.weber.cleanapp.presention.global

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView

/**
 * Created on 29.10.18
 * @author YWeber
 * project CleanApp */

open class BasePresenter<V : MvpView> : MvpPresenter<V>(), DisposableComponent by DisposableComponentImpl() {

    override fun onDestroy() {
        super.onDestroy()
        clear()
    }

}