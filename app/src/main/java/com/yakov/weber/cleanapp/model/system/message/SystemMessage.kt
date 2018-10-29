package com.yakov.weber.cleanapp.model.system.message

/**
 * Created on 29.10.18
 * @author YWeber
 * project CleanApp */

data class SystemMessage(val text:String,
                         val type: SystemMessageType = SystemMessageType.TOAST)