package com.example.myapplication.utils

import java.util.Locale

const val EMPTY = ""
const val SPACE = " "
const val ENTER = "\n"
const val COMMA = ", "

fun String?.safe(default: String = ""): String {
    return this ?: default
}

fun String?.isNotNullOrBlank(): Boolean = !this.isNullOrBlank()

