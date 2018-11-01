package com.yakov.weber.cleanapp.extension

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created on 01.11.18
 * @author YWeber
 * project CleanApp */
 
fun ViewGroup.inflate(@LayoutRes layout:Int) = LayoutInflater.from(context).inflate(layout,this,false)