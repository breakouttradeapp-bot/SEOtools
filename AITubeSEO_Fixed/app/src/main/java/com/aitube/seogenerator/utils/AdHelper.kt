package com.aitube.seogenerator.utils

import android.app.Activity
import android.widget.FrameLayout
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

/**
 * Safe banner ad loader — creates AdView entirely in code.
 * XML AdView declaration crashes with real App IDs at layout inflation.
 * Doing it in code + try/catch means it can NEVER crash the app.
 */
object AdHelper {

    fun loadBanner(activity: Activity, container: FrameLayout, adUnitId: String) {
        try {
            if (activity.isFinishing || activity.isDestroyed) return
            val adView = AdView(activity)
            adView.setAdSize(AdSize.BANNER)
            adView.adUnitId = adUnitId
            container.removeAllViews()
            container.addView(adView)
            adView.loadAd(AdRequest.Builder().build())
        } catch (e: Exception) {
            // Ad loading must never crash the app
        }
    }
}
