package com.cosmospire.rxtestapp.model

/**
 * Language class containing the name of the language and the code.
 */
class Language(val name: String, val code: LanguageCode) {

    enum class LanguageCode {
        EN, DE, HR
    }
}