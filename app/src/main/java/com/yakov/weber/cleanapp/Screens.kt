package com.yakov.weber.cleanapp

import android.support.v4.app.Fragment
import com.yakov.weber.cleanapp.ui.dictionary.DictionaryListFragment
import com.yakov.weber.cleanapp.ui.main.MainFlowFragment
import com.yakov.weber.cleanapp.ui.reading.room.ReadingRoomFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {


    object DictionaryList : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return DictionaryListFragment.newInstance()
        }
    }

    object ReadingRoom : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return ReadingRoomFragment.newInstance()
        }
    }

    object MainFlow : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return MainFlowFragment()
        }
    }

}