package com.yakov.weber.cleanapp.presention

import com.arellomobile.mvp.InjectViewState
import com.yakov.weber.cleanapp.model.system.message.SystemMessageNotifier
import com.yakov.weber.cleanapp.presention.global.BasePresenter
import javax.inject.Inject

/**
 * Created on 29.10.18
 * @author YWeber
 * project CleanApp */
@InjectViewState
class AppPresenter @Inject constructor(private val systemMessage: SystemMessageNotifier) : BasePresenter<AppView>() {

}