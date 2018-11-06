package com.yakov.weber.cleanapp.presention.reading.room.detailed

import com.arellomobile.mvp.InjectViewState
import com.yakov.weber.cleanapp.Screens
import com.yakov.weber.cleanapp.presention.global.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created on 06.11.18
 * @author YWeber
 * project CleanApp */
@InjectViewState
class DetailedRoomPresenter @Inject constructor(private val router: Router) : BasePresenter<DetailedRoomView>() {
    fun onBack(){
        router.replaceScreen(Screens.MainFlow)
    }
}