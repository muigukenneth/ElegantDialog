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
import androidx.recyclerview.widget.LinearLayoutManager
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.color.colorChooser
import com.bumptech.glide.Glide
import com.gurutouchlabs.kenneth.elegantdialog.ElegantActionListeners
import com.gurutouchlabs.kenneth.elegantdialog.ElegantDialog
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.typeface.library.googlematerial.GoogleMaterial
import com.mikepenz.iconics.utils.toIconicsSizeDp
import kotlinx.android.synthetic.main.custom_image_layout.view.*
import kotlinx.android.synthetic.main.custom_recyclerview_layout.view.*
import kotlinx.android.synthetic.main.fragment_custom_dialog.*


/**
 * Created by Kenneth Waweru on 21/10/2019.
 */
class CustomDialogFragment : Fragment() {

    private var backgroundTopColor: Int = Color.RED
    private var backgroundBottomColor: Int = Color.WHITE
    private var titleTextColor: Int = Color.WHITE
    private var backgroundIconColor: Int = Color.WHITE
    private var textViewColorBackgroundTop: GradientDrawable? = null
    private var textViewColorBackgroundBottom: GradientDrawable? = null
    private var textViewIconBackgroundColorText: GradientDrawable? = null
    private var textViewColorIcon: GradientDrawable? = null
    private var titleText: String = ""
    private var positiveText: String = ""
    private var negativeText: String = ""
    private var gotItText: String = ""
    private var titleIconColor: Int = Color.BLACK
    private var positiveIconColor: Int = Color.BLACK
    private var negativeIconColor: Int = Color.BLACK
    private var gotItIconColor: Int = Color.BLACK
    private var cancelOnTouchOutside: Boolean = false
    private var hideRoundedCorners: Boolean = false
    private var hideButtonText: Boolean = false
    private var showRecyclerView: Boolean = false
    private var picks: ArrayList<Int> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_custom_dialog, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        titleText = resources.getString(R.string.hot_offers)
        positiveText = resources.getString(R.string.accept)
        negativeText = resources.getString(R.string.decline)
        gotItText = resources.getString(R.string.pass)
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
        this.textViewIconBackgroundColorText =
            textViewBackgroundIconColor.background as GradientDrawable
        textViewIconBackgroundColorText!!.setColor(
            ContextCompat.getColor(
                context!!,
                R.color.md_white_1000
            )
        )
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
        textViewBackgroundIconColor.setOnClickListener {
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
                    backgroundIconColor = color
                    textViewIconBackgroundColorText!!.setColor(color)

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

            if (textInputEditTextPositiveButton.text.toString().isNotEmpty())
                positiveText = textInputEditTextPositiveButton.text.toString()
            if (textInputEditTextNegativeButton.text.toString().isNotEmpty())
                negativeText = textInputEditTextNegativeButton.text.toString()
            if (textInputEditTextGotItButton.text.toString().isNotEmpty())
                gotItText = textInputEditTextGotItButton.text.toString()
            val titleIcon = IconicsDrawable(context!!)
                .icon(GoogleMaterial.Icon.gmd_whatshot)
                .size(24.toIconicsSizeDp())
            val positiveIcon = IconicsDrawable(context!!)
                .icon(GoogleMaterial.Icon.gmd_mood)
                .size(24.toIconicsSizeDp())
            val negativeIcon = IconicsDrawable(context!!)
                .icon(GoogleMaterial.Icon.gmd_sentiment_neutral)
                .size(24.toIconicsSizeDp())
            val gotItIcon = IconicsDrawable(context!!)
                .icon(GoogleMaterial.Icon.gmd_mood_bad)
                .size(24.toIconicsSizeDp())
            val favouriteIcon = IconicsDrawable(context!!)
                .icon(GoogleMaterial.Icon.gmd_favorite)
                .size(24.toIconicsSizeDp())
            showRecyclerView = switchShowRecyclerView.isChecked
            cancelOnTouchOutside = switchCancelOnTouchOutside.isChecked
            hideRoundedCorners = switchHideRoundedCorners.isChecked
            hideButtonText = switchHideButtonText.isChecked
            if (showRecyclerView) {
                titleText = resources.getString(R.string.hey_kenneth_take_a_pick)
                positiveText = resources.getString(R.string.okay)
                negativeText = resources.getString(R.string.cancel)
                gotItText = resources.getString(R.string.pass)
            } else {
                titleText = resources.getString(R.string.hot_offers)
                positiveText = resources.getString(R.string.accept)
                negativeText = resources.getString(R.string.decline)
                gotItText = resources.getString(R.string.pass)
            }
            val dialog = ElegantDialog(context)
                .setCustomView(if(showRecyclerView)R.layout.custom_recyclerview_layout else R.layout.custom_image_layout)
                .setTitleIcon(titleIcon)
                .setTitleIconBackgroundColor(backgroundIconColor)
                .setBackgroundTopColor(backgroundTopColor)
                .setBackgroundBottomColor(backgroundBottomColor)
                .setCanceledOnTouchOutside(cancelOnTouchOutside)
                .setCornerRadius(if (hideRoundedCorners) 0f else 50f)
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
                if (showRecyclerView) {
                    // You can use glide or picasso to display your title image
                    val imageUrl =
                        R.drawable.face
                    Glide.with(this).load(imageUrl)
                        .transition(ImageUtils.requestAvatarTransitionOptions())
                        .apply(ImageUtils.requestAvatarOptions("app"))
                        .into(dialog.getTitleIconView()!!)
                }
                dialog.getTitleTextView()!!.text = titleText
                dialog.getTitleTextView()!!.setTextColor(titleTextColor)
                dialog.getPositiveButtonIconView()!!.setImageDrawable(if(showRecyclerView)favouriteIcon else positiveIcon)
                dialog.getPositiveButtonIconView()!!.setColorFilter(positiveIconColor)
                dialog.getPositiveButtonTextView()!!.text = positiveText
                dialog.getNegativeButtonIconView()!!.setImageDrawable(negativeIcon)
                dialog.getNegativeButtonIconView()!!.setColorFilter(negativeIconColor)
                dialog.getNegativeButtonTextView()!!.text = negativeText
                dialog.getGotItButtonIconView()!!.setImageDrawable(gotItIcon)
                dialog.getGotItButtonIconView()!!.setColorFilter(gotItIconColor)
                dialog.getGotItButtonTextView()!!.text = gotItText
                dialog.getPositiveButtonTextView()!!.visibility =
                    if (hideButtonText) View.GONE else View.VISIBLE
                dialog.getNegativeButtonTextView()!!.visibility =
                    if (hideButtonText) View.GONE else View.VISIBLE
                dialog.getGotItButtonTextView()!!.visibility =
                    if (hideButtonText) View.GONE else View.VISIBLE
                if (showRecyclerView) {
                    dialog.getPositiveButton()!!.visibility = View.VISIBLE
                    dialog.getNegativeButton()!!.visibility = View.GONE
                    dialog.getGotItButton()!!.visibility = View.GONE
                } else {
                    dialog.getPositiveButton()!!.visibility = View.VISIBLE
                    dialog.getNegativeButton()!!.visibility = View.VISIBLE
                    dialog.getGotItButton()!!.visibility = View.VISIBLE
                }
            }
            val contentView: View? = dialog.getCustomView()
            if (contentView != null) {
                if(showRecyclerView){
                    picks.clear()
                    picks.add( R.drawable.woman1)
                    picks.add( R.drawable.woman2)
                    picks.add( R.drawable.woman5)
                    picks.add( R.drawable.woman3)
                    picks.add( R.drawable.woman4)
                    picks.add( R.drawable.woman6)
                    picks.add( R.drawable.woman1)
                    picks.add( R.drawable.woman2)
                    picks.add( R.drawable.woman5)
                    picks.add( R.drawable.woman3)
                    picks.add( R.drawable.woman4)
                    picks.add( R.drawable.woman6)
                    val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                    contentView.recyclerView.layoutManager = layoutManager
                    contentView.recyclerView.setHasFixedSize(true)
                    val colorPickerAdapter = YourPickAdapter(activity!!, picks)
                    colorPickerAdapter.setOnYourPickPickerClickListener(object : YourPickAdapter.YourPickClickListener {
                        override fun onYourPickClickListener(colorCode: Int) {
                            /** Do something.*/
                        }

                    })
                    contentView.recyclerView.adapter = colorPickerAdapter
                }else {
                    contentView.textViewCustomTitle.text =
                        resources.getString(R.string.burgers_for_days)
                    contentView.textViewCustomDescription.text =
                        resources.getString(R.string.buy_one_get_one_free)
                    val imageUrl =
                        R.drawable.hamburger
                    Glide.with(context!!).load(imageUrl)
                        .apply(ImageUtils.requestProductSquareOptions())
                        .into(contentView.imageView!!)
                }

            }
        }
    }


    companion object {
        /** Start the Fragment Instance.*/
        fun newInstance(): CustomDialogFragment {
            val fragment = CustomDialogFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }

        private val TAG = CustomDialogFragment::class.java.simpleName
    }
}