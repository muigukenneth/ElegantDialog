package com.gurutouchlabs.kenneth.elegantdialog

import android.content.DialogInterface



/**
 * Created by Kenneth Waweru on 17/10/2019.
 */
interface ElegantActionListeners {
    fun onPositiveListener(dialog: ElegantDialog)
    fun onNegativeListener(dialog: ElegantDialog)
    fun onGotItListener(dialog: ElegantDialog)
    fun onCancelListener(dialog: DialogInterface)
}
