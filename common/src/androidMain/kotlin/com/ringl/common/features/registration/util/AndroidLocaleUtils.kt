package com.ringl.common.features.registration.util

import android.content.Context
import android.os.Build
import android.telephony.TelephonyManager
import androidx.compose.ui.text.intl.Locale
import com.google.i18n.phonenumbers.PhoneNumberUtil

internal class AndroidLocaleUtils(
    private val context: Context
) : LocaleUtils {

    override fun getPhoneNumberCountryCode(locale: Locale): String {
        val countryCode = PhoneNumberUtil.getInstance()
            .getCountryCodeForRegion(getCountryCode(context))
        return "+$countryCode"
    }

    private fun getCountryCode(context: Context): String {
        val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as? TelephonyManager
        val countryCode = telephonyManager?.simCountryIso?.uppercase(java.util.Locale.US)
        return if (countryCode.isNullOrEmpty()) {
            // for devices without sim (wifi tablets)
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                context.resources.configuration.locales[0].country
            } else {
                @Suppress("DEPRECATION")
                context.resources.configuration.locale.country
            }
        } else countryCode
    }

}