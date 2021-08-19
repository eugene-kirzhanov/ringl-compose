package com.ringl.common.core.util

actual fun String.format(vararg args: Any?): String = java.lang.String.format(this, *args)