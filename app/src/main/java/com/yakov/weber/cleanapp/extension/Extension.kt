package com.yakov.weber.cleanapp.extension

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppScreen
import ru.terrakok.cicerone.commands.BackTo
import ru.terrakok.cicerone.commands.Replace

/**
 * Created on 01.11.18
 * @author YWeber
 * project CleanApp */
 
fun ViewGroup.inflate(@LayoutRes layout:Int): View = LayoutInflater.from(context).inflate(layout,this,false)
fun Navigator.setLaunchScreen(screen: SupportAppScreen){applyCommands(arrayOf(BackTo(null),Replace(screen)))}
