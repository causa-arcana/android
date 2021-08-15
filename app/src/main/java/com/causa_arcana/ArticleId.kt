package com.causa_arcana

import java.lang.RuntimeException

class ArticleId(val year: UInt, val month: UInt, val day: UInt, val slug: String) {
    init {
        if (year  !in 2000u..3000u) throw RuntimeException("Invalid article year")
        if (month !in 1u..12u)      throw RuntimeException("Invalid article month")
        if (day   !in 1u..31u)      throw RuntimeException("Invalid article day")
        if (!SLUG_RE.matches(slug)) throw RuntimeException("Invalid article slug")
    }

    override fun toString(): String {
        return "${yearPadded()}-${monthPadded()}-${dayPadded()}-$slug"
    }

    private fun yearPadded():  String = year .toString().padStart(4, '0')
    private fun monthPadded(): String = month.toString().padStart(2, '0')
    private fun dayPadded():   String = day  .toString().padStart(2, '0')

    companion object {
        private val ID_RE = """^(\d{4})-(\d\d)-(\d\d)-([a-z0-9]+)(-[a-z0-9]+)*$""".toRegex()
        private val SLUG_RE = """^([a-z0-9]+)(-[a-z0-9]+)*$""".toRegex()

        fun fromString(id: String): ArticleId {
            (ID_RE.matchEntire(id) ?: throw RuntimeException("Invalid article ID")).destructured
                .let { (year, month, day, slugHead, slugTail) -> return ArticleId(
                        year.toUInt(),
                        month.toUInt(),
                        day.toUInt(),
                        slugHead + slugTail,
                    )
                }
        }
    }
}
