package com.gurutouchlabs.kenneth.elegantdialogapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.row_your_pick.view.*


/**
 * Created by Kenneth Waweru on 21/10/2019.
 */

class YourPickAdapter(private val context: Context, private val picks: List<Int>) :
    RecyclerView.Adapter<YourPickAdapter.YourPickViewHolder>() {
    private var yourPickClickListener: YourPickClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourPickViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_your_pick, parent, false)
        return YourPickViewHolder(view)
    }

    override fun onBindViewHolder(holder: YourPickViewHolder, position: Int) {
        val imageUrl = picks[position]
        Glide.with(context).load(imageUrl)
            .transition(ImageUtils.requestAvatarTransitionOptions())
            .apply(ImageUtils.requestAvatarOptions("app"))
            .into(holder.containerView.imageView!!)
            holder.itemView.setOnClickListener {
            if (yourPickClickListener != null)
                yourPickClickListener!!.onYourPickClickListener(picks[position])
        }
    }

    override fun getItemCount(): Int {
        return picks.size
    }

    /** Set up click listeners.*/
    fun setOnYourPickPickerClickListener(yourPickClickListener: YourPickClickListener) {
        this.yourPickClickListener = yourPickClickListener
    }

    /** Set Up the ViewHolder.*/
     class YourPickViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),LayoutContainer

    /** Set up the click listener interface.*/
    interface YourPickClickListener {
        fun onYourPickClickListener(colorCode: Int)
    }
}
