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

private const val PROGRESS_TAG = "bf_progress"

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
    protected fun showProgressDialog(progress: Boolean) {
        if (!isAdded) return
        val fragment = childFragmentManager.findFragmentByTag(PROGRESS_TAG)
        if (fragment != null && !progress) {
            (fragment as ProgressDialog).dismissAllowingStateLoss()
            childFragmentManager.executePendingTransactions()
        } else if (fragment == null && progress) {
            ProgressDialog().show(childFragmentManager, PROGRESS_TAG)
            childFragmentManager.executePendingTransactions()
        }
    }



    open fun onBackPressed(){}

}