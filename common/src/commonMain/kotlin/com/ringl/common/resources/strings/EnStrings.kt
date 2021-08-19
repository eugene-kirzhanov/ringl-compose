package com.ringl.common.resources.strings

internal object EnStrings : IStrings(
    common = Common(
        appName = "Ringl Compose"
    ),
    registration = Registration(
        title = "Welcome to Ringl",
        subtitle = "Please enter your phone number",
        countryCodeHint = "Code",
        phoneNumberHint = "Phone number",
        companyHint = "Company",
        requestCode = "Request Code",
        agreementText = "By continuing, you are indicating that agree to the %s\u00a0and\u00a0%s",
        agreementSubTextPrivacyPolicy = "Privacy\u00a0Policy",
        agreementSubTextTerms = "Terms\u00a0and\u00a0Conditions"
    ),
    about = About(
        privacyPolicyUrl = "https://ringl.im/app-privacy/",
        termsUrl = "https://ringl.im/app-terms/"
    )
)