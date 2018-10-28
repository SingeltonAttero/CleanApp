package com.yakov.weber.cleanapp

import android.app.Application
import com.yakov.weber.cleanapp.toothpick.DI
import com.yakov.weber.cleanapp.toothpick.module.AppModule
import timber.log.Timber
import toothpick.Toothpick
import toothpick.configuration.Configuration
import toothpick.registries.FactoryRegistryLocator
import toothpick.registries.MemberInjectorRegistryLocator

/**
 * Created on 28.10.18
 * @author YWeber
 * project CleanApp */

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initTimber()
        initToothpick()
        initScopes()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initScopes(){
        val appScope = Toothpick.openScope(DI.APP_SCOPE)
        appScope.installModules(AppModule(this))
    }

    private fun initToothpick() {
        if (BuildConfig.DEBUG) {
            Toothpick.setConfiguration(Configuration.forDevelopment().preventMultipleRootScopes())
        } else {
            Toothpick.setConfiguration(Configuration.forProduction().disableReflection())
          /*  FactoryRegistryLocator.setRootRegistry(com.yakov.weber.cleanapp.FactoryRegistry())
            MemberInjectorRegistryLocator.setRootRegistry(com.yakov.weber.cleanapp.MemberInjectorRegistry())*/
        }
    }

}