package com.gurutouchlabs.kenneth.elegantdialogapp

import android.content.Context
import android.content.Intent
import android.net.Uri


object TextUtils {


    private const val GOOGLE_PLAY_PACKAGE_NAME = "com.android.vending"
    fun createIntentForGooglePlay(context: Context): Intent {
        val packageName = context.packageName
        val intent = Intent(Intent.ACTION_VIEW, getGooglePlay("com.gurutouch.kenneth.memes"))
        if (isPackageExists(context, GOOGLE_PLAY_PACKAGE_NAME)) {
            intent.setPackage(GOOGLE_PLAY_PACKAGE_NAME)
        }
        return intent
    }
    private fun isPackageExists(context: Context, targetPackage: String): Boolean {
        val pm = context.packageManager
        val packages = pm.getInstalledApplications(0)
        for (packageInfo in packages) {
            if (packageInfo.packageName == targetPackage) return true
        }
        return false
    }

    private val GOOGLE_PLAY = "https://play.google.com/store/apps/details?id="

    private fun getGooglePlay(packageName: String?): Uri? {
        return if (packageName == null) null else Uri.parse(GOOGLE_PLAY + packageName)
    }
}