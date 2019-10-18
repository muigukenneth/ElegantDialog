package com.gurutouchlabs.kenneth.elegantdialogapp

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
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import kotlinx.android.synthetic.main.dialog_elegant.*

/**
 * Created by Kenneth Waweru on 17/10/2019.
 */
class ElegantDialog(private val mContext: Context?) {

    var iconDrawable: Drawable? = null
        private set

    private var titleIconColor: Int = Color.BLACK

    private var positiveIconColor: Int = Color.BLACK

    private var negativeIconColor: Int = Color.BLACK

    private var gotItIconColor: Int = Color.BLACK

    private var title: String = ""

    private var backgroundTopColor: Int = Color.RED

    private var backgroundBottomColor: Int = Color.WHITE

    private var description: String = ""

    private var content: String = ""


    private var imageViewIcon: ImageView? = null
    private var textViewTitle: TextView? = null
    private var textViewDescription: TextView? = null
    private var textViewContent: TextView? = null

    private var linearLayoutPositive: LinearLayout? = null
    private var linearLayoutNegative: LinearLayout? = null
    private var linearLayoutGotIt: LinearLayout? = null
    private var linearLayoutRootTop: LinearLayout? = null
    private var linearLayoutRootBottom: LinearLayout? = null
    private var textViewPositive: TextView? = null
    private var textViewNegative: TextView? = null
    private var textViewGotIt: TextView? = null

    private var imageViewPositive: ImageView? = null
    private var imageViewNegative: ImageView? = null
    private var imageViewGotIt: ImageView? = null


    private var positiveButtonText: String = ""

    private var positiveButtonIcon: Drawable? = null

    private var negativeButtonText: String = ""

    private var negativeButtonIcon: Drawable? = null

    private var gotItButtonText: String = ""

    private var gotItIcon: Drawable? = null

    private val mDialog: Dialog?

    private var elegantActionListener: ElegantActionListeners? = null

    init {

        mDialog = Dialog(mContext, R.style.ElegantDialog_Theme_Dialog)
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        mDialog.setContentView(R.layout.dialog_elegant)
        mDialog.setCanceledOnTouchOutside(false)

    }

    private fun initiateAllViews() {
        imageViewIcon = mDialog!!.imageViewIcon
        textViewTitle = mDialog.textViewTitle
        textViewDescription = mDialog.textViewDescription
        textViewContent = mDialog.textViewContent
        linearLayoutRootTop = mDialog.linearLayoutRootTop
        linearLayoutRootBottom = mDialog.linearLayoutRootBottom
        linearLayoutPositive = mDialog.linearLayoutPositive
        linearLayoutNegative = mDialog.linearLayoutNegative
        linearLayoutGotIt = mDialog.linearLayoutGotIt


        textViewPositive = mDialog.textViewPositive
        textViewNegative = mDialog.textViewNegative
        textViewGotIt = mDialog.textViewGotIt

        imageViewPositive = mDialog.imageViewPositive
        imageViewNegative = mDialog.imageViewNegative
        imageViewGotIt = mDialog.imageViewGotIt
    }

    private fun initiateListeners() {

        linearLayoutPositive!!.setOnClickListener(View.OnClickListener {
            this.onPositiveFeedbackClicked(
                it
            )
        })

        linearLayoutNegative!!.setOnClickListener(View.OnClickListener {
            this.onNegativeFeedbackClicked(
                it
            )
        })

        linearLayoutGotIt!!.setOnClickListener(View.OnClickListener {
            this.onAmbiguityFeedbackClicked(
                it
            )
        })

        mDialog?.setOnCancelListener { this.onCancelListener(it) }
    }

    fun show(): ElegantDialog {
        if (mDialog != null && mContext != null) {
            initiateAllViews()
            initiateListeners()

            val layerDrawable =
                ContextCompat.getDrawable(mContext, R.drawable.elegant_round_icon) as LayerDrawable
            val gradientDrawable =
                layerDrawable.findDrawableByLayerId(R.id.round_background) as GradientDrawable
            gradientDrawable.setColor(Color.WHITE)
            layerDrawable.setDrawableByLayerId(R.id.round_background, gradientDrawable)

            val drawable = this.iconDrawable
            DrawableCompat.setTint(drawable!!.mutate(), titleIconColor)
            layerDrawable.setDrawableByLayerId(R.id.drawable_image, drawable)

            imageViewIcon!!.setImageDrawable(layerDrawable)
            textViewTitle!!.text = this.title
            textViewDescription!!.text = this.description
            textViewContent!!.text = this.content

            textViewPositive!!.text = this.positiveButtonText
            imageViewPositive!!.setImageDrawable(this.positiveButtonIcon)
            imageViewPositive!!.setColorFilter(titleIconColor)

            textViewNegative!!.text = this.negativeButtonText
            imageViewNegative!!.setImageDrawable(this.negativeButtonIcon)
            imageViewNegative!!.setColorFilter(titleIconColor)

            textViewGotIt!!.text = this.gotItButtonText
            imageViewGotIt!!.setImageDrawable(this.gotItIcon)
            imageViewGotIt!!.setColorFilter(titleIconColor)

            linearLayoutRootTop!!.setBackgroundColor(this.backgroundTopColor)
            linearLayoutRootBottom!!.setBackgroundColor(this.backgroundBottomColor)
            mDialog.show()
        }
        return this
    }

    fun setIconDrawable(iconDrawable: Drawable): ElegantDialog {
        this.iconDrawable = iconDrawable
        return this
    }

    fun getTitle(): String {
        return title
    }

    fun setTitle(title: String): ElegantDialog {
        this.title = title
        return this
    }

    fun getDescription(): String {
        return description
    }

    fun setDescription(description: String): ElegantDialog {
        this.description = description
        return this
    }

    fun getPositiveButtonText(): String {
        return positiveButtonText
    }

    fun setPositiveButtonText(positiveButtonText: String): ElegantDialog {
        this.positiveButtonText = positiveButtonText
        return this
    }

    fun getPositiveFeedbackIcon(): Drawable? {
        return positiveButtonIcon
    }

    fun setPositiveButtonIcon(positiveButtonIcon: Drawable): ElegantDialog {
        this.positiveButtonIcon = positiveButtonIcon
        return this
    }

    fun getNegativeButtonText(): String {
        return negativeButtonText
    }

    fun setNegativeButtonText(negativeButtonText: String): ElegantDialog {
        this.negativeButtonText = negativeButtonText
        return this
    }

    fun getNegativeButtonIcon(): Drawable? {
        return negativeButtonIcon
    }

    fun setNegativeButtonIcon(negativeButtonIcon: Drawable): ElegantDialog {
        this.negativeButtonIcon = negativeButtonIcon
        return this
    }

    fun getGotItButtonText(): String {
        return gotItButtonText
    }

    fun setGotItButtonText(gotItButtonText: String): ElegantDialog {
        this.gotItButtonText = gotItButtonText
        return this
    }

    fun getGotItIcon(): Drawable? {
        return gotItIcon
    }

    fun setGotItIcon(gotItIcon: Drawable): ElegantDialog {
        this.gotItIcon = gotItIcon
        return this
    }

    fun getBackgroundTopColor(): Int {
        return backgroundTopColor
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

    fun getTitleIconColor(): Int {
        return titleIconColor
    }

    fun setTitleIconColor(titleIconColor: Int): ElegantDialog {
        this.titleIconColor = titleIconColor
        return this
    }

    fun getContent(): String {
        return content
    }

    fun setContent(content: String): ElegantDialog {
        this.content = content
        return this
    }

    fun setElegantActionClickListener(elegantActionListener: ElegantActionListeners): ElegantDialog {
        this.elegantActionListener = elegantActionListener
        return this
    }

    fun dismiss() {
        mDialog?.dismiss()
    }

    fun setCanceledOnTouchOutside(dismiss: Boolean) {
        mDialog!!.setCanceledOnTouchOutside(dismiss)
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

    private fun onAmbiguityFeedbackClicked(view: View) {
        if (elegantActionListener != null) {
            elegantActionListener!!.onGotItListener(this)
        }
    }

    private fun onCancelListener(dialog: DialogInterface) {
        if (elegantActionListener != null) {
            elegantActionListener!!.onCancelListener(dialog)
        }
    }
}
