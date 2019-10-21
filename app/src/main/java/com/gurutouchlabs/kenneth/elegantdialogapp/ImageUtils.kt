package com.gurutouchlabs.kenneth.elegantdialogapp

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey




/**
 * Created by Kenneth Waweru on 19/10/2019.
 */
object ImageUtils {
    @SuppressLint("CheckResult")
    fun requestThumbnailProfile(context: Context): RequestBuilder<Drawable> {
        val optionsThumbnail = RequestOptions()
        optionsThumbnail.centerCrop().transform(CircleCrop())
        return Glide.with(context.applicationContext)
            .load(R.color.transparent).apply(optionsThumbnail)
    }
    fun requestAvatarTransitionOptions(): DrawableTransitionOptions {
        val options = DrawableTransitionOptions()
        return options.crossFade()
    }

    @SuppressLint("CheckResult")
    fun requestAvatarOptions(signature: String): RequestOptions {
        val options = RequestOptions()
        options.signature(ObjectKey(signature))
        options.priority(Priority.HIGH)
            .transform(CircleCrop())
        return options
    }
    @SuppressLint("CheckResult")
    fun requestProductSquareOptions(): RequestOptions {
        val options = RequestOptions()
        options.placeholder(R.drawable.hamburger)
            .priority(Priority.NORMAL)
            .error(R.drawable.hamburger)
            .centerCrop()
        return options
    }

}