package com.ringl.features.registration.core.data

interface RegistrationRepository {

    suspend fun requestSmsCode(phoneNumber: String, company: String)

}