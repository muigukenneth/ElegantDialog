package com.gurutouchlabs.kenneth.elegantdialogapp

import android.annotation.SuppressLint
import com.bumptech.glide.Priority
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey




/**
 * Created by Kenneth Waweru on 19/10/2019.
 * Contains some text Utils
 */
object ImageUtils {

    /** Get the Avatar transition using Glide*/
    fun requestAvatarTransitionOptions(): DrawableTransitionOptions {
        val options = DrawableTransitionOptions()
        return options.crossFade()
    }
    /** Get the circular Avatar using Glide*/
    @SuppressLint("CheckResult")
    fun requestAvatarOptions(signature: String): RequestOptions {
        val options = RequestOptions()
        options.signature(ObjectKey(signature))
        options.priority(Priority.HIGH)
            .transform(CircleCrop())
        return options
    }

    /** Get the square image using Glide*/
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