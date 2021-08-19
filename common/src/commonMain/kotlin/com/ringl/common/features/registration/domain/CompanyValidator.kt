package com.ringl.common.features.registration.domain

import com.ringl.common.core.models.Address

internal interface CompanyValidator {

    fun validateCompanyName(company: String): Boolean

}

internal class CommonCompanyValidator : CompanyValidator {

    private val companyNamePattern = "^${Address.DOMAIN_DELIMITER}?[a-z0-9\\-]{1,100}\$".toRegex()

    override fun validateCompanyName(company: String): Boolean {
        return companyNamePattern.matches(company.trim())
    }

}