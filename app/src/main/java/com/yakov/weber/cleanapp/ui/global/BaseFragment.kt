package com.yakov.weber.cleanapp.ui.global

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.yakov.weber.cleanapp.presention.global.DisposableComponent
import com.yakov.weber.cleanapp.presention.global.DisposableComponentImpl

/**
 * Created on 29.10.18
 * @author YWeber
 * project CleanApp */

abstract class BaseFragment : MvpAppCompatFragment(), DisposableComponent by DisposableComponentImpl() {

    abstract val layout: Int
        @LayoutRes get

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layout, container, false)
    }

    override fun onDestroy() {
        clear()
        super.onDestroy()
    }

    open fun onBackPressed(){}

}