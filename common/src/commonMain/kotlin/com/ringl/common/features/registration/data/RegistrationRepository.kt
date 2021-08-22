package com.ringl.common.features.registration.data

interface RegistrationRepository {

    suspend fun requestSmsCode(phoneNumber: String, company: String)

}