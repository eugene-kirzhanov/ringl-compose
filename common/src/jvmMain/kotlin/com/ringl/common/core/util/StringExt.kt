package com.ringl.common.core.util

actual fun String.format(vararg args: Any?): String {
    return String.format(this, *args)
}