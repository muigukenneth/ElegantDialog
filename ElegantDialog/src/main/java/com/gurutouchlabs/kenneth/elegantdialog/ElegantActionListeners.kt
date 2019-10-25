package com.gurutouchlabs.kenneth.elegantdialog

import android.content.DialogInterface



/**
 * Created by Kenneth Waweru on 17/10/2019.
 */
interface ElegantActionListeners {
    /** Called when positive button is clicked.*/
    fun onPositiveListener(dialog: ElegantDialog)
    /** Called when negative button is clicked.*/
    fun onNegativeListener(dialog: ElegantDialog)
    /** Called when got it button is clicked.*/
    fun onGotItListener(dialog: ElegantDialog)
    /** Called when dialog is cancelled.*/
    fun onCancelListener(dialog: DialogInterface)
}
