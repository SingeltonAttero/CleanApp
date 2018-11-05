package com.yakov.weber.cleanapp.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.jakewharton.rxbinding2.support.design.widget.RxBottomNavigationView
import com.yakov.weber.cleanapp.R
import com.yakov.weber.cleanapp.Screens
import com.yakov.weber.cleanapp.presention.main.MainFlowPresenter
import com.yakov.weber.cleanapp.presention.main.MainFlowView
import com.yakov.weber.cleanapp.toothpick.DI
import com.yakov.weber.cleanapp.ui.global.BaseFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragmnet_main_flow.*
import org.jetbrains.anko.support.v4.toast
import ru.terrakok.cicerone.android.support.SupportAppScreen
import toothpick.Toothpick

/**
 * Created on 30.10.18
 * @author YWeber
 * project CleanApp */

class MainFlowFragment : BaseFragment(), MainFlowView {
    override val layout: Int
        get() = R.layout.fragmnet_main_flow

    @InjectPresenter
    lateinit var Presenter: MainFlowPresenter

    @ProvidePresenter
    fun providerPresenter(): MainFlowPresenter = Toothpick
            .openScope(DI.APP_SCOPE)
            .getInstance(MainFlowPresenter::class.java)

    private val currentTabFragment: BaseFragment?
        get() = childFragmentManager.fragments.firstOrNull { !it.isHidden } as BaseFragment


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button_navigation.apply {
            selectedItemId = R.id.menu_reading_room
        }
        RxBottomNavigationView
                .itemSelections(button_navigation)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    when(it.itemId){
                        R.id.menu_reading_room -> selectFragment(Screens.ReadingRoom.fragment)
                        R.id.menu_dictionary -> selectFragment(Screens.DictionaryList.fragment)
                        else -> {}
                    }
                }.bind()

    }

    private fun selectFragment(fragment:Fragment){
        childFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_main_container,fragment)
        }.commit()
    }

    // TODO USE
    private fun selectTab(tab:SupportAppScreen){
        val currentFragment = currentTabFragment
        val newFragment = childFragmentManager.findFragmentByTag(tab.screenKey)

        if (currentFragment != null && newFragment != null && currentFragment == newFragment) return

        childFragmentManager.beginTransaction().apply {
            if (newFragment == null) replace(R.id.fragment_main_container,createTabFragment(tab),tab.screenKey)

            currentFragment?.let {
                hide(it)
                it.userVisibleHint = false
            }

            newFragment?.let {
                show(it)
                it.userVisibleHint = true
            }
        }.commitNow()
    }

    private fun createTabFragment(tab:SupportAppScreen): Fragment = tab.fragment

    override fun onBackPressed() {
        currentTabFragment?.onBackPressed()
    }

}