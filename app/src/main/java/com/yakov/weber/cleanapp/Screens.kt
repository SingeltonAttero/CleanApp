package com.yakov.weber.cleanapp

import android.support.v4.app.Fragment
import com.yakov.weber.cleanapp.ui.main.MainFlowFragment
import com.yakov.weber.cleanapp.ui.reading.room.ReadingRoomFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {


    data class ReadingRoom(val title: String) : SupportAppScreen(){
        override fun getFragment(): Fragment {
            return ReadingRoomFragment.newInstance(title)
        }
    }

    object MainFlow : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return MainFlowFragment()
        }
    }

}