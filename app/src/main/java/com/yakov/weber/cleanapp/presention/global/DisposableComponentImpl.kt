package com.yakov.weber.cleanapp.presention.global

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created on 29.10.18
 * @author YWeber
 * project CleanApp */

class DisposableComponentImpl : DisposableComponent {
    override val disposableComponent: CompositeDisposable by lazy { CompositeDisposable() }

    override fun Disposable.bind() {
        disposableComponent.add(this)
    }

    override fun clear() {
        disposableComponent.clear()
    }
}