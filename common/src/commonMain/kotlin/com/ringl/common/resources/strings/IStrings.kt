package com.ringl.common.resources.strings

abstract class IStrings(
    val common: Common,
    val registration: Registration,
    val about: About
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
        val agreementText: String,
        val agreementSubTextPrivacyPolicy: String,
        val agreementSubTextTerms: String
    )

    class About(
        val privacyPolicyUrl: String,
        val termsUrl: String
    )

}