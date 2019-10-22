# ElegantDialog
[![Build status](https://app.nevercode.io/api/projects/465bc90f-16e5-4b6d-ab42-7e7d8036ad4f/workflows/62a7ba37-c8a4-4eda-8db1-9908daa93d8e/status_badge.svg?branch=master)](https://app.nevercode.io/#/project/465bc90f-16e5-4b6d-ab42-7e7d8036ad4f/workflow/62a7ba37-c8a4-4eda-8db1-9908daa93d8e/latestBuild?branch=master)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/8d75aa2085d94288bdefda48e3a518ca)](https://www.codacy.com/manual/muigukenneth/ElegantDialog?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=muigukenneth/ElegantDialog&amp;utm_campaign=Badge_Grade)
[![GitHub license](https://img.shields.io/github/license/muigukenneth/ElegantDialog)](https://github.com/muigukenneth/ElegantDialog/blob/master/LICENSE)
[![GitHub stars](https://img.shields.io/github/stars/muigukenneth/ElegantDialog)](https://github.com/muigukenneth/ElegantDialog/stargazers)
[![API](https://img.shields.io/badge/API-22%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=22)

<p align="left">
<img src="https://raw.githubusercontent.com/muigukenneth/ElegantDialog/master/art/Screenshot_1New.png" width="400px"  />
<img src="https://raw.githubusercontent.com/muigukenneth/ElegantDialog/master/art/Screenshot_3New.png" width="400px"  />
<img src="https://raw.githubusercontent.com/muigukenneth/ElegantDialog/master/art/Screenshot_2New.png" width="400px"  />
</p>
  
## Download
 [ ![Download](https://api.bintray.com/packages/chiefdroid/ElegantDialog/ElegantDialog/images/download.svg) ](https://bintray.com/chiefdroid/ElegantDialog/ElegantDialog/_latestVersion)
Easily add the dependencies:
```gradle
 allprojects {
   repositories {
	...
	 maven { url 'https://jitpack.io' }
      }
 }
     
dependencies {
  ...
  implementation 'com.github.muigukenneth:ElegantDialog:1.1.1'
}
 ``` 
## Features

Simple use cases will look something like this:
 * Top background customization
 * Bottom background customization
 * Custom layout
 * Custom icons(buttons and title)
 * Color customizations (Icons and Text)
 * Text customizations (Buttons, title and content)
 * Custom fonts (title and content)
 
## How to use ElegantDialog

Simple use cases will look something like this:
```kotlin
     val dialog = ElegantDialog(context)
                .setTitleIcon(titleIcon)//Set title icon drawable
                .setTitleIconBackgroundColor(backgroundIconColor) //Set title icon drawable background color
                .setBackgroundTopColor(backgroundTopColor)// Set top color
                .setBackgroundBottomColor(backgroundBottomColor) // Set bottom color
                .setCustomView(R.layout.custom_image_layout)//Set custom layout
                .setCornerRadius(50f) //Set dialog corner radius
                .setCanceledOnTouchOutside(false) // Dismiss on tap outside
                .setTitleHidden(false) // Hide title
                .setElegantActionClickListener(object :
                    ElegantActionListeners {
                    override fun onPositiveListener(dialog: ElegantDialog) {
                      
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
                
                 // access your customView
             val contentView: View? = dialog.getCustomView()
              
            // Now for the title, content and buttons customisations
            if (dialog.getTitleIconView() != null) {
                // You can use glide or picasso to display your own title image
                val imageUrl = R.drawable.face
                Glide.with(this).load(imageUrl)
                    .transition(ImageUtils.requestAvatarTransitionOptions())
                    .apply(ImageUtils.requestAvatarOptions("app"))
                    .into(dialog.getTitleIconView()!!)
                    
                dialog.getTitleTextView()!!.text = titleText //Set title text
                dialog.getTitleTextView()!!.setTextColor(titleTextColor) //Set title text color
                
                dialog.getContentTextView()!!.text = contentText //Set content text
                dialog.getContentTextView()!!.setTextColor(contentTextColor) //Set content text color
                
                dialog.getPositiveButtonIconView()!!.setImageDrawable(positiveIcon) //Set positive button icon drawable
                dialog.getPositiveButtonIconView()!!.setColorFilter(positiveIconColor) //Set positive button icon drawable color
                dialog.getPositiveButtonTextView()!!.text = positiveText //Set positive button text
                
                dialog.getNegativeButtonIconView()!!.setImageDrawable(negativeIcon) //Set negative button icon drawable
                dialog.getNegativeButtonIconView()!!.setColorFilter(negativeIconColor) //Set negative button icon drawable color
                dialog.getNegativeButtonTextView()!!.text = negativeText //Set negative button text
                
                dialog.getGotItButtonIconView()!!.setImageDrawable(gotItIcon) //Set got it button icon drawable
                dialog.getGotItButtonIconView()!!.setColorFilter(gotItIconColor) //Set negative button icon drawable color
                dialog.getGotItButtonTextView()!!.text = gotItText //Set got it button text
                
                dialog.getPositiveButtonTextView()!!.visibility = if (hideButtonText) View.GONE else View.VISIBLE //Hide positive button text
                dialog.getNegativeButtonTextView()!!.visibility = if (hideButtonText) View.GONE else View.VISIBLE //Hide negative button text
                dialog.getGotItButtonTextView()!!.visibility = if (hideButtonText) View.GONE else View.VISIBLE //Hide got it button text
                
                dialog.getPositiveButton()!!.visibility = if (hidePositiveButton) View.GONE else View.VISIBLE //Hide positive button 
                dialog.getNegativeButton()!!.visibility = if (hideNegativeButton) View.GONE else View.VISIBLE //Hide negative button
                dialog.getGotItButton()!!.visibility = if (hideGotItButton) View.GONE else View.VISIBLE  //Hide got it button
            }
            
``` 
### Pull requests are welcome!

Feel free to contribute to ElegantDialog. Just create a pull request for:
* Bug fixes
* New features
* Code optimizations

