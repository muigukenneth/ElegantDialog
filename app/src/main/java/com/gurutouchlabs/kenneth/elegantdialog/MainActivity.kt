package com.gurutouchlabs.kenneth.elegantdialog

import android.content.ActivityNotFoundException
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.color.colorChooser
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.typeface.library.googlematerial.GoogleMaterial
import com.mikepenz.iconics.utils.toIconicsSizeDp
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var backgroundTopColor: Int = Color.RED
    private var backgroundBottomColor: Int = Color.WHITE
    private var titleTextColor: Int = Color.BLACK
    private var descriptionTextColor: Int = Color.BLACK
    private var contentTextColor: Int = Color.BLACK
    private var textViewColorBackgroundTop: GradientDrawable? = null
    private var textViewColorBackgroundBottom: GradientDrawable? = null
    private var textViewColorText: GradientDrawable? = null
    private var titleText: String = ""
    private var descriptionText: String = ""
    private var contentText: String = ""
    private var positiveText: String = ""
    private var negativeText: String = ""
    private var gotItText: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        titleText = resources.getString(R.string.app_name)
        descriptionText = resources.getString(R.string.description_text)
        contentText = resources.getString(R.string.content_text)
        positiveText = resources.getString(R.string.yes)
        negativeText = resources.getString(R.string.no)
        gotItText = resources.getString(R.string.not_now)
        backgroundTopColor = ContextCompat.getColor(this, R.color.red)
        backgroundBottomColor = ContextCompat.getColor(this, R.color.md_white_1000)
        this.textViewColorBackgroundTop = textViewBackgroundTopColor.background as GradientDrawable
        textViewColorBackgroundTop!!.setColor(ContextCompat.getColor(this, R.color.red))
        this.textViewColorBackgroundBottom =
            textViewBackgroundBottomColor.background as GradientDrawable
        textViewColorBackgroundBottom!!.setColor(
            ContextCompat.getColor(
                this,
                R.color.md_white_1000
            )
        )
        this.textViewColorText = textViewTextColor.background as GradientDrawable
        textViewColorText!!.setColor(Color.WHITE)
        textViewBackgroundTopColor.setOnClickListener {
            val colors = intArrayOf(
                ContextCompat.getColor(this, R.color.red),
                ContextCompat.getColor(this, R.color.purple),
                ContextCompat.getColor(this, R.color.deepPurple),
                ContextCompat.getColor(this, R.color.blue),
                ContextCompat.getColor(this, R.color.teal),
                ContextCompat.getColor(this, R.color.green),
                ContextCompat.getColor(this, R.color.yellow),
                ContextCompat.getColor(this, R.color.orange),
                ContextCompat.getColor(this, R.color.deepOrange),
                ContextCompat.getColor(this, R.color.brown),
                ContextCompat.getColor(this, R.color.grey),
                ContextCompat.getColor(this, R.color.darkGrey),
                ContextCompat.getColor(this, R.color.md_white_1000),
                ContextCompat.getColor(this, R.color.md_black_1000)
            )

            MaterialDialog(this).show {
                title(R.string.colors)
                colorChooser(colors, initialSelection = Color.BLUE) { dialog, color ->
                    // Use color integer
                    backgroundTopColor = color
                    textViewColorBackgroundTop!!.setColor(color)

                }
                positiveButton(R.string.select)
            }
        }
        textViewBackgroundBottomColor.setOnClickListener {
            val colors = intArrayOf(
                ContextCompat.getColor(this, R.color.red),
                ContextCompat.getColor(this, R.color.purple),
                ContextCompat.getColor(this, R.color.deepPurple),
                ContextCompat.getColor(this, R.color.blue),
                ContextCompat.getColor(this, R.color.teal),
                ContextCompat.getColor(this, R.color.green),
                ContextCompat.getColor(this, R.color.yellow),
                ContextCompat.getColor(this, R.color.orange),
                ContextCompat.getColor(this, R.color.deepOrange),
                ContextCompat.getColor(this, R.color.brown),
                ContextCompat.getColor(this, R.color.grey),
                ContextCompat.getColor(this, R.color.darkGrey),
                ContextCompat.getColor(this, R.color.md_white_1000),
                ContextCompat.getColor(this, R.color.md_black_1000)
            )

            MaterialDialog(this).show {
                title(R.string.colors)
                colorChooser(colors, initialSelection = Color.BLUE) { dialog, color ->
                    // Use color integer
                    backgroundBottomColor = color
                    textViewColorBackgroundBottom!!.setColor(color)

                }
                positiveButton(R.string.select)
            }
        }
        textViewTextColor.setOnClickListener {
            val colors = intArrayOf(
                ContextCompat.getColor(this, R.color.red),
                ContextCompat.getColor(this, R.color.purple),
                ContextCompat.getColor(this, R.color.deepPurple),
                ContextCompat.getColor(this, R.color.blue),
                ContextCompat.getColor(this, R.color.teal),
                ContextCompat.getColor(this, R.color.green),
                ContextCompat.getColor(this, R.color.yellow),
                ContextCompat.getColor(this, R.color.orange),
                ContextCompat.getColor(this, R.color.deepOrange),
                ContextCompat.getColor(this, R.color.brown),
                ContextCompat.getColor(this, R.color.grey),
                ContextCompat.getColor(this, R.color.darkGrey),
                ContextCompat.getColor(this, R.color.md_white_1000),
                ContextCompat.getColor(this, R.color.md_black_1000)
            )

            MaterialDialog(this).show {
                title(R.string.colors)
                colorChooser(
                    colors,
                    initialSelection = ContextCompat.getColor(
                        this@MainActivity,
                        R.color.md_white_1000
                    )
                ) { dialog, color ->
                    // Use color integer
                    titleTextColor = color
                    descriptionTextColor = color
                    contentTextColor = color
                    textViewColorText!!.setColor(color)

                }
                positiveButton(R.string.select)
            }
        }
        buttonShow.setOnClickListener {

            if (textInputEditTextTitle.text.toString().isNotEmpty())
                titleText = textInputEditTextTitle.text.toString()
            if (textInputEditTextDescription.text.toString().isNotEmpty())
                descriptionText = textInputEditTextDescription.text.toString()
            if (textInputEditTextContent.text.toString().isNotEmpty())
                contentText = textInputEditTextContent.text.toString()
            if (textInputEditTextPositiveButton.text.toString().isNotEmpty())
                positiveText = textInputEditTextPositiveButton.text.toString()
            if (textInputEditTextNegativeButton.text.toString().isNotEmpty())
                negativeText = textInputEditTextNegativeButton.text.toString()
            if (textInputEditTextGotItButton.text.toString().isNotEmpty())
                gotItText = textInputEditTextGotItButton.text.toString()
            ElegantDialog(this@MainActivity)
                .setIconDrawable(
                    IconicsDrawable(this)
                        .icon(GoogleMaterial.Icon.gmd_stars)
                        .size(24.toIconicsSizeDp())
                )
                .setPositiveButtonIcon(
                    IconicsDrawable(this)
                        .icon(GoogleMaterial.Icon.gmd_check_circle)
                        .size(24.toIconicsSizeDp())
                )
                .setNegativeButtonIcon(
                    IconicsDrawable(this)
                        .icon(GoogleMaterial.Icon.gmd_highlight_off)
                        .size(24.toIconicsSizeDp())
                )
                .setGotItIcon(
                    IconicsDrawable(this)
                        .icon(GoogleMaterial.Icon.gmd_watch_later)
                        .size(24.toIconicsSizeDp())
                )
                .setTitleIconColor(Color.BLACK)
                .setTitle(titleText)
                .setBackgroundTopColor(backgroundTopColor)
                .setBackgroundBottomColor(backgroundBottomColor)
                .setDescription(descriptionText)
                .setContent(contentText)
                .setPositiveButtonText(positiveText)
                .setNegativeButtonText(negativeText)
                .setGotItButtonText(gotItText)
                .setElegantActionClickListener(object : ElegantActionListeners {
                    override fun onPositiveListener(dialog: ElegantDialog) {
                        try {
                            val intentToAppStore =
                                TextUtils.createIntentForGooglePlay(
                                    this@MainActivity
                                )
                            startActivity(intentToAppStore)
                        } catch (e: ActivityNotFoundException) {
                            e.printStackTrace()
                        }
                        dialog.dismiss()
                    }

                    override fun onNegativeListener(dialog: ElegantDialog) {
                        dialog.dismiss()
                    }

                    override fun onGotItListener(dialog: ElegantDialog) {

                        dialog.dismiss()
                    }

                    override fun onCancelListener(dialog: DialogInterface) {
                        dialog.dismiss()
                    }
                })
                .show()  // Finally don't forget to call show()
        }
    }
}
