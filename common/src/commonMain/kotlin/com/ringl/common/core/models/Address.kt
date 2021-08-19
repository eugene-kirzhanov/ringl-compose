package com.ringl.common.core.models

const val DEFAULT_DOMAIN = "im"

data class Address(
    val node: String, // registrationHash for contact address, or groupId for xmpp room jid
    val domain: String? = null // empty for B2C contacts, or "{company}" for B2B contact
) : Comparable<Address> {

    val serialized: String = buildString {
        append(node)
        domain?.let { append(DOMAIN_DELIMITER).append(it) }
    }

    override fun compareTo(other: Address): Int = serialized.compareTo(other.serialized)

    override fun toString(): String = serialized

    fun formatted(): String = serialized

    companion object {
        const val DOMAIN_DELIMITER = '@'

        // additionally for xmpp-room addresses (can contain '.' in domain)
        //  - [+]1a2b3c
        //  - [+]1a2b3c@domain
        //  - [+]1a2b3c@service.domain
        private val PATTERN = "(\\+?[a-z0-9_\\-]{1,50})($DOMAIN_DELIMITER[a-z0-9_.\\-]{1,30})?([./]\\d+)?".toRegex()

        fun from(phoneNumber: String, _domain: String? = null): Address {
            val domain = if (_domain.isNullOrBlank() || _domain.equals(
                    DEFAULT_DOMAIN,
                    ignoreCase = true
                )
            ) {
                null
            } else {
                _domain
            }
            return Address(phoneNumber, domain)
        }

        fun parse(serialized: String): Address {
            val source = serialized.trim()
            if (source.isEmpty())
                throw IllegalArgumentException("Parsing error: address \"$serialized\" is empty")

            if (PATTERN.matches(source)) {
                val result = PATTERN.find(source)
                if (result != null) {
                    val phoneNumber = result.groupValues.getOrNull(1)
                    if (phoneNumber.isNullOrEmpty())
                        throw IllegalArgumentException("Parsing error: address \"$serialized\" doesn't contain phone number")

                    var domain = result.groupValues.getOrNull(2)
                    if (!domain.isNullOrEmpty()) {
                        domain = domain.substring(1) // remove "@"
                    }

                    return from(phoneNumber, domain)
                }
            }
            throw IllegalArgumentException("Parsing error: address \"$serialized\" doesn't match pattern")
        }
    }
}