package mezzari.torres.lucas.motion_layout_test.archive

import java.text.SimpleDateFormat
import java.util.*

/**
 * @author Lucas T. Mezzari
 * @author lucas.mezzari@rcadigital.com.br
 * @since 10/06/21
 */
fun Date.format(format: String = "yyyy-MM-dd", locale: Locale = Locale.getDefault()): String {
    return SimpleDateFormat(format, locale).format(this) ?: ""
}

fun String?.toDate(format: String = "yyyy-MM-dd", locale: Locale = Locale.getDefault()): Date? {
    if (this == null) {
        return null
    }
    return SimpleDateFormat(format, locale).parse(this)
}