package com.yakov.weber.cleanapp.model.interactor

import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.Android
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created on 05.11.18
 * @author YWeber
 * project CleanApp */

class DictionaryInteractor @Inject constructor() {


    fun sortMockTime(): Completable = Completable.timer(1000,TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}