package com.yakov.weber.cleanapp.ui.global

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.yakov.weber.cleanapp.R
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import javax.inject.Inject

/**
 * Created on 29.10.18
 * @author YWeber
 * project CleanApp */

abstract class FlowFragment : BaseFragment() {
    override val layout: Int
        get() = R.layout.container_layout

    private val currentFragment:BaseFragment? get() = childFragmentManager.findFragmentById(R.id.flow_container) as BaseFragment

    @Inject
    lateinit var navigatorHolder:NavigatorHolder

    protected val navigator:Navigator by lazy {
        object : SupportAppNavigator(this.activity,childFragmentManager,R.id.flow_container){

            override fun activityBack() {
                exit()
            }

            override fun setupFragmentTransaction(command: Command?,
                                                  currentFragment: Fragment?,
                                                  nextFragment: Fragment?,
                                                  fragmentTransaction: FragmentTransaction?) {
                fragmentTransaction?.setReorderingAllowed(true)
            }
        }
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }

    open fun exit(){}

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}