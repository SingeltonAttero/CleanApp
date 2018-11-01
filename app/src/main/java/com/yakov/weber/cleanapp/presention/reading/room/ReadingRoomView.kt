package com.yakov.weber.cleanapp.presention.reading.room

import com.arellomobile.mvp.MvpView
import com.yakov.weber.cleanapp.entity.Book

/**
 * Created on 31.10.18
 * @author YWeber
 * project CleanApp */

interface ReadingRoomView : MvpView {
    fun setBookList(bookList: List<Book>)
}