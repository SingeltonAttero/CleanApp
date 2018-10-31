package com.yakov.weber.cleanapp.presention

import com.arellomobile.mvp.InjectViewState
import com.yakov.weber.cleanapp.Screens
import com.yakov.weber.cleanapp.model.system.message.SystemMessageNotifier
import com.yakov.weber.cleanapp.presention.global.BasePresenter
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Screen
import javax.inject.Inject

/**
 * Created on 29.10.18
 * @author YWeber
 * project CleanApp */
@InjectViewState
class AppPresenter @Inject constructor(private val router: Router) : BasePresenter<AppView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(Screens.MainFlow)
    }

}