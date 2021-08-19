package com.ringl.common.resources.strings

abstract class IStrings(
    val common: Common,
    val registration: Registration
) {

    class Common(
        val appName: String
    )

    class Registration(
        val title: String,
        val subtitle: String,
        val countryCodeHint: String,
        val phoneNumberHint: String,
        val companyHint: String,
        val requestCode: String,
        val agreementLinks: String
    )

}