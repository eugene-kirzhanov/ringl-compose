package com.ringl.common.resources

import androidx.compose.ui.text.intl.Locale

object Strings {

    private val dictionaries = mapOf(
        "en" to EnStrings
    )

    private fun strings(locale: Locale = Locale.current): IStrings {
        return dictionaries[locale.language.lowercase()] ?: EnStrings
    }

    object Common : IStrings.ICommon {
        override val appName = strings().common.appName
    }

    object Registration : IStrings.IRegistration {
        override val title = strings().registration.title
        override val subtitle = strings().registration.subtitle
        override val countryCodeHint = strings().registration.countryCodeHint
        override val phoneNumberHint = strings().registration.phoneNumberHint
        override val companyHint = strings().registration.companyHint
        override val requestCode = strings().registration.requestCode
        override val agreementLinks = strings().registration.agreementLinks
    }

}

interface IStrings {

    val common: ICommon
    val registration: IRegistration

    interface ICommon {
        val appName: String
    }

    interface IRegistration {
        val title: String
        val subtitle: String
        val countryCodeHint: String
        val phoneNumberHint: String
        val companyHint: String
        val requestCode: String
        val agreementLinks: String
    }

}

object EnStrings : IStrings {
    override val common = object : IStrings.ICommon {
        override val appName = "Ringl Compose"
    }

    override val registration = object : IStrings.IRegistration {
        override val title = "Welcome to Ringl"
        override val subtitle = "Please enter your phone number"
        override val countryCodeHint = "Code"
        override val phoneNumberHint = "Phone number"
        override val companyHint = "Company"
        override val requestCode = "Request Code"
        override val agreementLinks = "By continuing, you are indicating that agree to the Privacy policy and Terms"
    }
}
