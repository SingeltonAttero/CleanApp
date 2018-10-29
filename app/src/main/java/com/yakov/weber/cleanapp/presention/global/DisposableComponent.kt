package com.yakov.weber.cleanapp.presention.global

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created on 29.10.18
 * @author YWeber
 * project CleanApp */

interface DisposableComponent {
    val disposableComponent:CompositeDisposable
    fun Disposable.bind()
    fun clear()
}