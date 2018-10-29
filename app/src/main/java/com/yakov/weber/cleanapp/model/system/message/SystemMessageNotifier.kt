package com.yakov.weber.cleanapp.model.system.message

import com.jakewharton.rxrelay2.PublishRelay
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created on 29.10.18
 * @author YWeber
 * project CleanApp */

class SystemMessageNotifier @Inject constructor() {
    private val notifierRelay = PublishRelay.create<SystemMessage>()

    val notifier:Observable<SystemMessage> = notifierRelay.hide()
    fun send(message: SystemMessage) = notifierRelay.accept(message)
    fun send(message: String) = notifierRelay.accept(SystemMessage(message))
}