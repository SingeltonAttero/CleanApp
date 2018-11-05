package com.yakov.weber.cleanapp.ui.global

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yakov.weber.cleanapp.R

/**
 * Created on 05.11.18
 * @author YWeber
 * project CleanApp */

class ProgressDialog : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable = false
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            LayoutInflater.from(context).inflate(R.layout.dialog_fragment,null)


}