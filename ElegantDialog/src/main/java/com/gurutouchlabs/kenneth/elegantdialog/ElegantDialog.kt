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

    //pull request variables
    private var title: String? = null
    private var titleColor: Int = Color.WHITE

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

    /**
     * Initialize the Dialog
     */
    init {
        mDialog = Dialog(mContext!!, R.style.ElegantDialog_Theme_Dialog)
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        mDialog.setContentView(R.layout.dialog_elegant)
    }

    /** Set Your custom View.
     * Can be any type of view we will compensate the min height*/
    fun setCustomView(layout: Int): ElegantDialog {
        if (mDialog != null && mContext != null) {
            val stub = mDialog.layoutStub
            stub.layoutResource = layout
            customView = stub.inflate()
            useCustomLayout = true
        }
        return this
    }

    /** Initialize the Views.
     * All views will be accessed here*/
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

    /** Initialize the listeners.
     * We need them to monitor clicks*/
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

    /** Show the dialog.
     * Lets now get everything connected so we display the Dialog as quickly as possible */
    fun show(): ElegantDialog {
        if (mDialog != null && mContext != null) {
            initiateAllViews()
            initiateListeners()
            if (this.titleIcon != null) {
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
            val gradientTopDrawable = linearLayoutRootTop!!.background as GradientDrawable
            gradientTopDrawable.cornerRadii =
                floatArrayOf(cornerRadius, cornerRadius, cornerRadius, cornerRadius, 0f, 0f, 0f, 0f)
            gradientTopDrawable.setColor(this.backgroundTopColor)
            linearLayoutRootTop!!.background = gradientTopDrawable
            val gradientBottomDrawable = linearLayoutRootBottom!!.background as GradientDrawable
            gradientBottomDrawable.cornerRadii =
                floatArrayOf(0f, 0f, 0f, 0f, cornerRadius, cornerRadius, cornerRadius, cornerRadius)
            gradientBottomDrawable.setColor(this.backgroundBottomColor)
            linearLayoutRootBottom!!.background = gradientBottomDrawable
            mDialog.setCanceledOnTouchOutside(cancelledOnTouchOutside)

            //pull request logic
            initTitleAndContent()
            mDialog.show()
        }
        return this
    }

    /** Set the Title icon drawable.
     * Only allows a drawable but you can load your own image using @getTitleIconView() if you opt so
     * don't call this method */
    fun setTitleIcon(titleIcon: Drawable): ElegantDialog {
        this.titleIcon = titleIcon
        return this
    }

    /** Set the title Icon drawable color.
     * Will only applied if you pass an icon @setTitleIcon()  */
    fun setTitleIconColor(titleIconColor: Int): ElegantDialog {
        this.titleIconColor = titleIconColor
        return this
    }

    /** Get the title Icon color.
     * Color is an Int */
    fun getTitleIconColor(): Int {
        return titleIconColor
    }

    /** Set the title Icon background color. This is the circular area where the title icon lies
     * Will only applied if you pass an icon @setTitleIcon()  */
    fun setTitleIconBackgroundColor(titleIconBackgroundColor: Int): ElegantDialog {
        this.titleIconBackgroundColor = titleIconBackgroundColor
        return this
    }

    /** Get the title Icon background color.
     * Color is an Int */
    fun getTitleIconBackgroundColor(): Int {
        return titleIconBackgroundColor
    }

    /** Set the Background Top color.
     * The Dialog is split into two and Color has to be an Int */
    fun setBackgroundTopColor(backgroundTopColor: Int): ElegantDialog {
        this.backgroundTopColor = backgroundTopColor
        return this
    }

    /** Get the Top bottom color.
     * The Dialog is split into two and Color is an Int */
    fun getBackgroundTopColor(): Int {
        return backgroundTopColor
    }

    /** Set the Background bottom color.
     * The Dialog is split into two and Color has to be an Int */
    fun setBackgroundBottomColor(backgroundBottomColor: Int): ElegantDialog {
        this.backgroundBottomColor = backgroundBottomColor
        return this
    }

    /** Get the Background bottom color.
     * The Dialog is split into two and Color is an Int */
    fun getBackgroundBottomColor(): Int {
        return backgroundBottomColor
    }

    /** Get the content ImageView for customization e.g load image using Glide or Picasso
     * (recommended you handle the image transformation to be circular to maintain the design).
     * You can do anything you want like you normally do with other ImageViews */
    fun getTitleIconView(): ImageView? {
        return imageViewIcon
    }

    /** Get the title TextView for customization.
     * You can do anything you want like you normally do with other TextViews */
    fun getTitleTextView(): TextView? {
        return textViewTitle
    }

    /** Get the content TextView for customization.
     * You can do anything you want like you normally do with other TextViews */
    fun getContentTextView(): TextView? {
        return textViewContent
    }

    /** Get the positive button ImageView for customization.
     * You can do anything you want like you normally do with other ImageViews*/
    fun getPositiveButtonIconView(): ImageView? {
        return imageViewPositive
    }

    /** Get the negative button ImageView for customization.
     * You can do anything you want like you normally do with other ImageViews*/
    fun getNegativeButtonIconView(): ImageView? {
        return imageViewNegative
    }

    /** Get the got it button ImageView for customization.
     * You can do anything you want like you normally do with other ImageViews*/
    fun getGotItButtonIconView(): ImageView? {
        return imageViewGotIt
    }

    /** Get the positive button TextView for customization.
     * You can do anything you want like you normally do with other TextViews*/
    fun getPositiveButtonTextView(): TextView? {
        return textViewPositive
    }

    /** Get the negative button TextView for customization.
     * You can do anything you want like you normally do with other TextViews*/
    fun getNegativeButtonTextView(): TextView? {
        return textViewNegative
    }

    /** Get the got it button TextView for customization.
     * You can do anything you want like you normally do with other TextViews*/
    fun getGotItButtonTextView(): TextView? {
        return textViewGotIt
    }

    /** Get the positive button View for customization.
     * You can do anything you want like you normally do with other View e.g hide and change click effect*/
    fun getPositiveButton(): LinearLayout? {
        return linearLayoutPositive
    }

    /** Get the negative button View for customization.
     * You can do anything you want like you normally do with other View e.g hide and change click effect*/
    fun getNegativeButton(): LinearLayout? {
        return linearLayoutNegative
    }

    /** Get the got it button View for customization.
     * You can do anything you want like you normally do with other View e.g hide and change click effect*/
    fun getGotItButton(): LinearLayout? {
        return linearLayoutGotIt
    }

    /** Get the custom View for initialization and customization.
     * You can access you parent views from here. You mast pass a View @setContentView() or this will return null*/
    fun getCustomView(): View? {
        return customView
    }

    /** Set the click listeners.
     * I have defined them for you */
    fun setElegantActionClickListener(elegantActionListener: ElegantActionListeners): ElegantDialog {
        this.elegantActionListener = elegantActionListener
        return this
    }

    /** Dismiss the Dialog.
     * This is a manual dismiss method you can also set @setCanceledOnTouchOutside() to dismiss it on touch outside */
    fun dismiss() {
        mDialog?.dismiss()
    }

    /** Set if setCanceledOnTouchOutside behaviour .
     * Just like a typical Dialog */
    fun setCanceledOnTouchOutside(cancelledOnTouchOutside: Boolean): ElegantDialog {
        this.cancelledOnTouchOutside = cancelledOnTouchOutside
        return this
    }

    /** Set if the Title text should be hidden.
     * Maybe you want to implement your own title in a custom layout */
    fun setTitleHidden(hideTitle: Boolean): ElegantDialog {
        this.hideTitle = hideTitle
        return this
    }

    /** Set corner radius for the corners.
     * The Default radius is 50f */
    fun setCornerRadius(cornerRadius: Float): ElegantDialog {
        this.cornerRadius = cornerRadius
        return this
    }

    /** On positive click Listener.*/
    private fun onPositiveFeedbackClicked(view: View) {
        if (elegantActionListener != null) {
            elegantActionListener!!.onPositiveListener(this)
        }
    }

    /** On negative click Listener.*/
    private fun onNegativeFeedbackClicked(view: View) {
        if (elegantActionListener != null) {
            elegantActionListener!!.onNegativeListener(this)
        }
    }

    /** On GotIt click Listener.*/
    private fun onGotItFeedbackClicked(view: View) {
        if (elegantActionListener != null) {
            elegantActionListener!!.onGotItListener(this)
        }
    }

    /** On Cancel click Listener.*/
    private fun onCancelListener(dialog: DialogInterface) {
        if (elegantActionListener != null) {
            elegantActionListener!!.onCancelListener(dialog)
        }
    }

    /**
     * Sets the dialogs title
     */
    fun setTitle(title: String): ElegantDialog {
        this.title = title
        return this
    }

    /**
     * Sets the dialogs title with its text color
     */
    fun setTitle(title: String, titleColor: Int): ElegantDialog {
        this.setTitle(title)
        this.titleColor = titleColor
        return this
    }

    fun initTitleAndContent() {
        if (this.title != null) textViewTitle!!.text = this.title
        textViewTitle!!.setTextColor(titleColor)
    }
}
