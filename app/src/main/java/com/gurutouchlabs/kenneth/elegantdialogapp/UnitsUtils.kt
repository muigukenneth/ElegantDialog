package com.gurutouchlabs.kenneth.elegantdialogapp

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics
import java.text.DecimalFormat
import java.util.*


/**
 * Created by Kenneth Waweru on 20/10/2019.
 */
class UnitsUtils {
    var density = 1f

    /**
     * Converts dp to pixels.
     */
    fun dpToPx(context: Context, dp: Int): Int {
        val displayMetrics = context.getResources().getDisplayMetrics()
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
    }

    fun dpToPx(dp: Int): Int {
        val metrics = Resources.getSystem().getDisplayMetrics()
        return dp * (metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)
    }

    /**
     * Converts pixels to dp.
     */
    fun pxToDp(context: Context, px: Int): Int {
        val displayMetrics = context.getResources().getDisplayMetrics()
        return Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
    }

    fun spToPx(context: Context, sp: Float): Float {
        val scaledDensity = context.getResources().getDisplayMetrics().scaledDensity
        return sp * scaledDensity
    }

    fun pxToSp(context: Context, px: Float): Float {
        val scaledDensity = context.getResources().getDisplayMetrics().scaledDensity
        return px / scaledDensity
    }

    fun dp(value: Float): Int {
        return if (value == 0f) {
            0
        } else Math.ceil((density * value).toDouble()).toInt()
    }

    fun dpToPx(context: Context, dp: Float): Int {
        val scale = context.getResources().getDisplayMetrics().density
        return Math.round(dp * scale)
    }

    fun getTwoDecimal(quantity: Double): Double {
        return java.lang.Double.valueOf(String.format(Locale.getDefault(), "%.2f", quantity))
    }

    fun getDecimalFormat(quantity: Double): String {
        val decimalFormat = DecimalFormat("#.#")
        return decimalFormat.format(quantity)
    }

}