package com.gurutouchlabs.kenneth.elegantdialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import kotlinx.android.synthetic.main.dialog_elegant.*

/**
 * Created by Kenneth Waweru on 17/10/2019.
 */
class ElegantDialog(private val mContext: Context?) {

    private var cornerRadius: Float = 50f

    private var cancelledOnTouchOutside: Boolean = false

    private var useCustomLayout: Boolean = false

    private var hideTitle: Boolean = false

    private var titleIcon: Drawable? = null

    private var titleIconColor: Int = Color.BLACK

    private var titleIconBackgroundColor: Int = Color.WHITE

    private var backgroundTopColor: Int = Color.RED

    private var backgroundBottomColor: Int = Color.WHITE

    private var imageViewIcon: ImageView? = null
    private var textViewTitle: TextView? = null

    private var textViewContent: TextView? = null

    private var linearLayoutPositive: LinearLayout? = null
    private var linearLayoutNegative: LinearLayout? = null
    private var linearLayoutGotIt: LinearLayout? = null
    private var linearLayoutRootTop: RelativeLayout? = null
    private var linearLayoutRootBottom: LinearLayout? = null
    private var linearLayoutRootDescription: LinearLayout? = null
    private var textViewPositive: TextView? = null
    private var textViewNegative: TextView? = null
    private var textViewGotIt: TextView? = null

    private var imageViewPositive: ImageView? = null
    private var imageViewNegative: ImageView? = null
    private var imageViewGotIt: ImageView? = null


    private val mDialog: Dialog?

    private var elegantActionListener: ElegantActionListeners? = null

    private var customView: View? = null

    init {

        mDialog = Dialog(mContext!!, R.style.ElegantDialog_Theme_Dialog)
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        mDialog.setContentView(R.layout.dialog_elegant)
    }

    fun setCustomView(layout: Int): ElegantDialog {
        if (mDialog != null && mContext != null) {
            val stub = mDialog.layoutStub
            stub.layoutResource = layout
            customView = stub.inflate()
            useCustomLayout = true
        }
        return this
    }

    private fun initiateAllViews() {
        imageViewIcon = mDialog!!.imageViewIcon
        textViewTitle = mDialog.textViewTitle
        textViewContent = mDialog.textViewContent
        linearLayoutRootTop = mDialog.relativeLayoutDialogRoot

        linearLayoutRootBottom = mDialog.linearLayoutRootBottom
        linearLayoutRootDescription = mDialog.linearLayoutDescription
        linearLayoutPositive = mDialog.linearLayoutPositive
        linearLayoutNegative = mDialog.linearLayoutNegative
        linearLayoutGotIt = mDialog.linearLayoutGotIt


        textViewPositive = mDialog.textViewPositive
        textViewNegative = mDialog.textViewNegative
        textViewGotIt = mDialog.textViewGotIt

        imageViewPositive = mDialog.imageViewPositive
        imageViewNegative = mDialog.imageViewNegative
        imageViewGotIt = mDialog.imageViewGotIt
        if (useCustomLayout) {
            linearLayoutRootDescription!!.visibility = View.GONE
        } else {
            linearLayoutRootDescription!!.visibility = View.VISIBLE
        }
    }

    private fun initiateListeners() {

        linearLayoutPositive!!.setOnClickListener {
            this.onPositiveFeedbackClicked(
                it
            )
        }

        linearLayoutNegative!!.setOnClickListener {
            this.onNegativeFeedbackClicked(
                it
            )
        }

        linearLayoutGotIt!!.setOnClickListener {
            this.onGotItFeedbackClicked(
                it
            )
        }

        mDialog?.setOnCancelListener { this.onCancelListener(it) }
    }

    fun show(): ElegantDialog {
        if (mDialog != null && mContext != null) {
            initiateAllViews()
            initiateListeners()
            if(this.titleIcon!=null) {
                val layerDrawable =
                    ContextCompat.getDrawable(
                        mContext,
                        R.drawable.elegant_round_icon
                    ) as LayerDrawable
                val gradientDrawable =
                    layerDrawable.findDrawableByLayerId(R.id.round_background) as GradientDrawable
                gradientDrawable.setColor(titleIconBackgroundColor)
                layerDrawable.setDrawableByLayerId(R.id.round_background, gradientDrawable)
                DrawableCompat.setTint(this.titleIcon!!, titleIconColor)
                layerDrawable.setDrawableByLayerId(R.id.drawable_image, this.titleIcon!!)
                imageViewIcon!!.setImageDrawable(layerDrawable)
            }
            textViewTitle!!.visibility = if (hideTitle) View.GONE else View.VISIBLE
            if (useCustomLayout) {
                customView!!.setBackgroundColor(this.backgroundTopColor)
            } else {
                linearLayoutRootDescription!!.setBackgroundColor(this.backgroundTopColor)
            }
            val gradientTopDrawable=linearLayoutRootTop!!.background as GradientDrawable
            gradientTopDrawable.cornerRadii= floatArrayOf(cornerRadius,cornerRadius,cornerRadius,cornerRadius,0f,0f,0f,0f)
            gradientTopDrawable.setColor(this.backgroundTopColor)
            linearLayoutRootTop!!.background=gradientTopDrawable
            val gradientBottomDrawable=linearLayoutRootBottom!!.background as GradientDrawable
            gradientBottomDrawable.cornerRadii= floatArrayOf(0f,0f,0f,0f,cornerRadius,cornerRadius,cornerRadius,cornerRadius)
            gradientBottomDrawable.setColor(this.backgroundBottomColor)
            linearLayoutRootBottom!!.background=gradientBottomDrawable
            mDialog.setCanceledOnTouchOutside(cancelledOnTouchOutside)
            mDialog.show()
        }
        return this
    }

    fun setTitleIcon(titleIcon: Drawable): ElegantDialog {
        this.titleIcon = titleIcon
        return this
    }

    fun getTitleIconColor(): Int {
        return titleIconColor
    }

    fun setTitleIconColor(titleIconColor: Int): ElegantDialog {
        this.titleIconColor = titleIconColor
        return this
    }

    fun getTitleIconBackgroundColor(): Int {
        return titleIconBackgroundColor
    }

    fun setTitleIconBackgroundColor(titleIconBackgroundColor: Int): ElegantDialog {
        this.titleIconBackgroundColor= titleIconBackgroundColor
        return this
    }

    fun setBackgroundTopColor(backgroundTopColor: Int): ElegantDialog {
        this.backgroundTopColor = backgroundTopColor
        return this
    }

    fun getBackgroundBottomColor(): Int {
        return backgroundBottomColor
    }

    fun setBackgroundBottomColor(backgroundBottomColor: Int): ElegantDialog {
        this.backgroundBottomColor = backgroundBottomColor
        return this
    }

    fun getTitleIconView(): ImageView? {
        return imageViewIcon
    }

    fun getTitleTextView(): TextView? {
        return textViewTitle
    }


    fun getContentTextView(): TextView? {
        return textViewContent
    }

    fun getPositiveButtonIconView(): ImageView? {
        return imageViewPositive
    }

    fun getNegativeButtonIconView(): ImageView? {
        return imageViewNegative
    }

    fun getGotItButtonIconView(): ImageView? {
        return imageViewGotIt
    }

    fun getPositiveButtonTextView(): TextView? {
        return textViewPositive
    }

    fun getNegativeButtonTextView(): TextView? {
        return textViewNegative
    }

    fun getGotItButtonTextView(): TextView? {
        return textViewGotIt
    }

    fun getPositiveButton(): LinearLayout? {
        return linearLayoutPositive
    }

    fun getNegativeButton(): LinearLayout? {
        return linearLayoutNegative
    }

    fun getGotItButton(): LinearLayout? {
        return linearLayoutGotIt
    }

    fun getCustomView(): View? {
        return customView
    }

    fun setElegantActionClickListener(elegantActionListener: ElegantActionListeners): ElegantDialog {
        this.elegantActionListener = elegantActionListener
        return this
    }

    fun dismiss() {
        mDialog?.dismiss()
    }


    fun setCanceledOnTouchOutside(cancelledOnTouchOutside: Boolean): ElegantDialog {
        this.cancelledOnTouchOutside = cancelledOnTouchOutside
        return this
    }

    fun setTitleHidden(hideTitle: Boolean): ElegantDialog {
        this.hideTitle = hideTitle
        return this
    }

    fun setCornerRadius(cornerRadius: Float): ElegantDialog {
        this.cornerRadius = cornerRadius
        return this
    }

    private fun onPositiveFeedbackClicked(view: View) {
        if (elegantActionListener != null) {
            elegantActionListener!!.onPositiveListener(this)
        }
    }

    private fun onNegativeFeedbackClicked(view: View) {
        if (elegantActionListener != null) {
            elegantActionListener!!.onNegativeListener(this)
        }
    }

    private fun onGotItFeedbackClicked(view: View) {
        if (elegantActionListener != null) {
            elegantActionListener!!.onGotItListener(this)
        }
    }

    private fun onCancelListener(dialog: DialogInterface) {
        if (elegantActionListener != null) {
            elegantActionListener!!.onCancelListener(dialog)
        }
    }
    fun dpToPx(context: Context, dp: Float): Int {
        val scale = context.resources.displayMetrics.density
        return Math.round(dp * scale)
    }
}
