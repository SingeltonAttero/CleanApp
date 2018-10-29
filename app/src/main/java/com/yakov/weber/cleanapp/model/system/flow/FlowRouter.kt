package com.yakov.weber.cleanapp.model.system.flow

import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen

/**
 * Created on 28.10.18
 * @author YWeber
 * project CleanApp */

class FlowRouter(private val appRouter: Router) : Router() {
    fun startFlow(screens: SupportAppScreen) = appRouter.navigateTo(screens)
    fun newRootFlow(screens: SupportAppScreen) = appRouter.newRootScreen(screens)
    fun finishFlow() = appRouter.exit()
}