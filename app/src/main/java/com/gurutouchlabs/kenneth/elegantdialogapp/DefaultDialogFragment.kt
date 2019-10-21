package com.gurutouchlabs.kenneth.elegantdialogapp

import android.content.ActivityNotFoundException
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.color.colorChooser
import com.bumptech.glide.Glide
import com.gurutouchlabs.kenneth.elegantdialog.ElegantActionListeners
import com.gurutouchlabs.kenneth.elegantdialog.ElegantDialog
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.typeface.library.googlematerial.GoogleMaterial
import com.mikepenz.iconics.utils.toIconicsSizeDp
import kotlinx.android.synthetic.main.fragment_default_dialog.*

/**
 * Created by Kenneth Waweru on 21/10/2019.
 */
class DefaultDialogFragment : Fragment() {

    private var backgroundTopColor: Int = Color.RED
    private var backgroundBottomColor: Int = Color.WHITE
    private var titleTextColor: Int = Color.WHITE
    private var contentTextColor: Int = Color.WHITE
    private var textViewColorBackgroundTop: GradientDrawable? = null
    private var textViewColorBackgroundBottom: GradientDrawable? = null
    private var textViewColorText: GradientDrawable? = null
    private var textViewColorIcon: GradientDrawable? = null
    private var titleText: String = ""
    private var contentText: String = ""
    private var positiveText: String = ""
    private var negativeText: String = ""
    private var gotItText: String = ""
    private var titleIconColor: Int = Color.BLACK
    private var positiveIconColor: Int = Color.BLACK
    private var negativeIconColor: Int = Color.BLACK
    private var gotItIconColor: Int = Color.BLACK
    private var hidePositiveButton: Boolean = false
    private var hideNegativeButton: Boolean = false
    private var hideGotItButton: Boolean = false
    private var hideButtonText: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_default_dialog, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        titleText = resources.getString(R.string.hey_kenneth)
        contentText = resources.getString(R.string.content_text)
        positiveText = resources.getString(R.string.yes)
        negativeText = resources.getString(R.string.no)
        gotItText = resources.getString(R.string.later)
        backgroundTopColor = ContextCompat.getColor(context!!, R.color.red)
        backgroundBottomColor = ContextCompat.getColor(context!!, R.color.md_white_1000)
        this.textViewColorBackgroundTop = textViewBackgroundTopColor.background as GradientDrawable
        textViewColorBackgroundTop!!.setColor(ContextCompat.getColor(context!!, R.color.red))
        this.textViewColorBackgroundBottom =
            textViewBackgroundBottomColor.background as GradientDrawable
        textViewColorBackgroundBottom!!.setColor(
            ContextCompat.getColor(
                context!!,
                R.color.md_white_1000
            )
        )
        this.textViewColorText = textViewTextColor.background as GradientDrawable
        textViewColorText!!.setColor(ContextCompat.getColor(context!!, R.color.md_white_1000))
        this.textViewColorIcon = textViewIconColor.background as GradientDrawable
        textViewColorIcon!!.setColor(ContextCompat.getColor(context!!, R.color.md_black_1000))
        textViewBackgroundTopColor.setOnClickListener {
            val colors = intArrayOf(
                ContextCompat.getColor(context!!, R.color.red),
                ContextCompat.getColor(context!!, R.color.purple),
                ContextCompat.getColor(context!!, R.color.deepPurple),
                ContextCompat.getColor(context!!, R.color.blue),
                ContextCompat.getColor(context!!, R.color.teal),
                ContextCompat.getColor(context!!, R.color.green),
                ContextCompat.getColor(context!!, R.color.yellow),
                ContextCompat.getColor(context!!, R.color.orange),
                ContextCompat.getColor(context!!, R.color.deepOrange),
                ContextCompat.getColor(context!!, R.color.brown),
                ContextCompat.getColor(context!!, R.color.grey),
                ContextCompat.getColor(context!!, R.color.darkGrey),
                ContextCompat.getColor(context!!, R.color.md_white_1000),
                ContextCompat.getColor(context!!, R.color.md_black_1000)
            )

            MaterialDialog(context!!).show {
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
                ContextCompat.getColor(context!!, R.color.red),
                ContextCompat.getColor(context!!, R.color.purple),
                ContextCompat.getColor(context!!, R.color.deepPurple),
                ContextCompat.getColor(context!!, R.color.blue),
                ContextCompat.getColor(context!!, R.color.teal),
                ContextCompat.getColor(context!!, R.color.green),
                ContextCompat.getColor(context!!, R.color.yellow),
                ContextCompat.getColor(context!!, R.color.orange),
                ContextCompat.getColor(context!!, R.color.deepOrange),
                ContextCompat.getColor(context!!, R.color.brown),
                ContextCompat.getColor(context!!, R.color.grey),
                ContextCompat.getColor(context!!, R.color.darkGrey),
                ContextCompat.getColor(context!!, R.color.md_white_1000),
                ContextCompat.getColor(context!!, R.color.md_black_1000)
            )

            MaterialDialog(context!!).show {
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
                ContextCompat.getColor(context!!, R.color.red),
                ContextCompat.getColor(context!!, R.color.purple),
                ContextCompat.getColor(context!!, R.color.deepPurple),
                ContextCompat.getColor(context!!, R.color.blue),
                ContextCompat.getColor(context!!, R.color.teal),
                ContextCompat.getColor(context!!, R.color.green),
                ContextCompat.getColor(context!!, R.color.yellow),
                ContextCompat.getColor(context!!, R.color.orange),
                ContextCompat.getColor(context!!, R.color.deepOrange),
                ContextCompat.getColor(context!!, R.color.brown),
                ContextCompat.getColor(context!!, R.color.grey),
                ContextCompat.getColor(context!!, R.color.darkGrey),
                ContextCompat.getColor(context!!, R.color.md_white_1000),
                ContextCompat.getColor(context!!, R.color.md_black_1000)
            )

            MaterialDialog(context!!).show {
                title(R.string.colors)
                colorChooser(
                    colors,
                    initialSelection = ContextCompat.getColor(
                        context!!,
                        R.color.md_white_1000
                    )
                ) { dialog, color ->
                    // Use color integer
                    titleTextColor = color
                    contentTextColor = color
                    textViewColorText!!.setColor(color)

                }
                positiveButton(R.string.select)
            }
        }

        textViewIconColor.setOnClickListener {
            val colors = intArrayOf(
                ContextCompat.getColor(context!!, R.color.red),
                ContextCompat.getColor(context!!, R.color.purple),
                ContextCompat.getColor(context!!, R.color.deepPurple),
                ContextCompat.getColor(context!!, R.color.blue),
                ContextCompat.getColor(context!!, R.color.teal),
                ContextCompat.getColor(context!!, R.color.green),
                ContextCompat.getColor(context!!, R.color.yellow),
                ContextCompat.getColor(context!!, R.color.orange),
                ContextCompat.getColor(context!!, R.color.deepOrange),
                ContextCompat.getColor(context!!, R.color.brown),
                ContextCompat.getColor(context!!, R.color.grey),
                ContextCompat.getColor(context!!, R.color.darkGrey),
                ContextCompat.getColor(context!!, R.color.md_white_1000),
                ContextCompat.getColor(context!!, R.color.md_black_1000)
            )

            MaterialDialog(context!!).show {
                title(R.string.colors)
                colorChooser(
                    colors,
                    initialSelection = ContextCompat.getColor(
                        context,
                        R.color.md_black_1000
                    )
                ) { dialog, color ->
                    // Use color integer
                    titleIconColor = color
                    positiveIconColor = color
                    negativeIconColor = color
                    gotItIconColor = color
                    textViewColorIcon!!.setColor(color)

                }
                positiveButton(R.string.select)
            }
        }
        buttonShow.setOnClickListener {

            if (textInputEditTextTitle.text.toString().isNotEmpty())
                titleText = textInputEditTextTitle.text.toString()
            if (textInputEditTextContent.text.toString().isNotEmpty())
                contentText = textInputEditTextContent.text.toString()
            if (textInputEditTextPositiveButton.text.toString().isNotEmpty())
                positiveText = textInputEditTextPositiveButton.text.toString()
            if (textInputEditTextNegativeButton.text.toString().isNotEmpty())
                negativeText = textInputEditTextNegativeButton.text.toString()
            if (textInputEditTextGotItButton.text.toString().isNotEmpty())
                gotItText = textInputEditTextGotItButton.text.toString()
            val positiveIcon = IconicsDrawable(context!!)
                .icon(GoogleMaterial.Icon.gmd_check_circle)
                .size(24.toIconicsSizeDp())
            val negativeIcon = IconicsDrawable(context!!)
                .icon(GoogleMaterial.Icon.gmd_highlight_off)
                .size(24.toIconicsSizeDp())
            val gotItIcon = IconicsDrawable(context!!)
                .icon(GoogleMaterial.Icon.gmd_watch_later)
                .size(24.toIconicsSizeDp())
            hidePositiveButton=switchHidePositiveButton.isChecked
            hideNegativeButton=switchHideNegativeButton.isChecked
            hideGotItButton=switchHideGotItButton.isChecked
            hideButtonText=switchHideButtonText.isChecked
            val dialog = ElegantDialog(context)
                .setBackgroundTopColor(backgroundTopColor)
                .setBackgroundBottomColor(backgroundBottomColor)
                .setCanceledOnTouchOutside(false)
                .setTitleHidden(false)
                .setElegantActionClickListener(object :
                    ElegantActionListeners {
                    override fun onPositiveListener(dialog: ElegantDialog) {
                        try {
                            val intentToAppStore =
                                TextUtils.createIntentForGooglePlay(
                                    context!!
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

            // Now for the customisations
            if (dialog.getTitleIconView() != null) {
                // You can use glide or picasso to display your title image
                val imageUrl =
                    R.drawable.face
                Glide.with(this).load(imageUrl)
                    .transition(ImageUtils.requestAvatarTransitionOptions())
                    .apply(ImageUtils.requestAvatarOptions("app"))
                    .into(dialog.getTitleIconView()!!)
                dialog.getTitleTextView()!!.text = titleText
                dialog.getTitleTextView()!!.setTextColor(titleTextColor)
                dialog.getContentTextView()!!.text = contentText
                dialog.getContentTextView()!!.setTextColor(contentTextColor)
                dialog.getPositiveButtonIconView()!!.setImageDrawable(positiveIcon)
                dialog.getPositiveButtonIconView()!!.setColorFilter(positiveIconColor)
                dialog.getPositiveButtonTextView()!!.text = positiveText
                dialog.getNegativeButtonIconView()!!.setImageDrawable(negativeIcon)
                dialog.getNegativeButtonIconView()!!.setColorFilter(negativeIconColor)
                dialog.getNegativeButtonTextView()!!.text = negativeText
                dialog.getGotItButtonIconView()!!.setImageDrawable(gotItIcon)
                dialog.getGotItButtonIconView()!!.setColorFilter(gotItIconColor)
                dialog.getGotItButtonTextView()!!.text = gotItText
//                dialog.getPositiveButtonIconView()!!.visibility = if (hidePositiveButton) View.GONE else View.VISIBLE
//                dialog.getNegativeButtonIconView()!!.visibility = if (hideNegativeButton) View.GONE else View.VISIBLE
//                dialog.getGotItButtonIconView()!!.visibility = if (hideGotItButton) View.GONE else View.VISIBLE
                dialog.getPositiveButtonTextView()!!.visibility = if (hideButtonText) View.GONE else View.VISIBLE
                dialog.getNegativeButtonTextView()!!.visibility = if (hideButtonText) View.GONE else View.VISIBLE
                dialog.getGotItButtonTextView()!!.visibility = if (hideButtonText) View.GONE else View.VISIBLE
                dialog.getPositiveButton()!!.visibility = if (hidePositiveButton) View.GONE else View.VISIBLE
                dialog.getNegativeButton()!!.visibility = if (hideNegativeButton) View.GONE else View.VISIBLE
                dialog.getGotItButton()!!.visibility = if (hideGotItButton) View.GONE else View.VISIBLE
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }


    companion object {
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        fun newInstance(): DefaultDialogFragment {
            val fragment = DefaultDialogFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }

        private val TAG = DefaultDialogFragment::class.java.simpleName
    }
}