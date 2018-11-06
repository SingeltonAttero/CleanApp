package com.yakov.weber.cleanapp.ui.reading.room.detailed

import android.os.Bundle
import com.yakov.weber.cleanapp.Screens
import com.yakov.weber.cleanapp.extension.setLaunchScreen
import com.yakov.weber.cleanapp.toothpick.DI
import com.yakov.weber.cleanapp.toothpick.module.FlowNavigationModule
import com.yakov.weber.cleanapp.ui.global.FlowFragment
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.commands.BackTo
import ru.terrakok.cicerone.commands.Replace
import toothpick.Toothpick

/**
 * Created on 06.11.18
 * @author YWeber
 * project CleanApp */

class DetailedRoomFlowFragment : FlowFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        initScope()
        super.onCreate(savedInstanceState)
        if (childFragmentManager.fragments.isEmpty()){
            navigator.applyCommands(arrayOf(Replace(Screens.DetailedRoom)))
        }
    }

    private fun initScope() {
        val openScopes = Toothpick.openScopes(DI.APP_SCOPE, DI.NAVIGATION_SCOPE)
        openScopes.installModules(FlowNavigationModule(openScopes.getInstance(Router::class.java)))
        Toothpick.inject(this, openScopes)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}