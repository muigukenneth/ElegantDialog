package com.gurutouchlabs.kenneth.elegantdialog

import android.content.DialogInterface



/**
 * Created by Shivasurya S on 13/01/18.
 */
interface ElegantActionListeners {
    fun onPositiveListener(dialog: ElegantDialog)
    fun onNegativeListener(dialog: ElegantDialog)
    fun onGotItListener(dialog: ElegantDialog)
    fun onCancelListener(dialog: DialogInterface)
}
