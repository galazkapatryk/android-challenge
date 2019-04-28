package pl.branchdev.android_common.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageFromUrl(imageUrl: String) {
    Glide.with(this).load(imageUrl).into(this)
}