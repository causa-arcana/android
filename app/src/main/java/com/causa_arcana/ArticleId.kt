package com.causa_arcana

import java.lang.RuntimeException

class ArticleId(val year: Int, val month: Int, val day: Int, val slug: String) {
    init {
        if (year  !in 2000..3000)   throw RuntimeException("Invalid article year")
        if (month !in 1..12)        throw RuntimeException("Invalid article month")
        if (day   !in 1..31)        throw RuntimeException("Invalid article day")
        if (!SLUG_RE.matches(slug)) throw RuntimeException("Invalid article slug")
    }

    override fun toString(): String = "${yearPadded()}-${monthPadded()}-${dayPadded()}-$slug"
    fun toPath():            String = "/${yearPadded()}/${monthPadded()}/${dayPadded()}/$slug"

    fun toPathWithExt():     String = "${toPath()}.$PATH_EXT"
    fun toFullPath():        String = "$PATH_PREFIX${toPath()}"
    fun toFullPathWithExt(): String = "$PATH_PREFIX${toPath()}.$PATH_EXT"

    fun yearPadded():  String = year .toString().padStart(4, '0')
    fun monthPadded(): String = month.toString().padStart(2, '0')
    fun dayPadded():   String = day  .toString().padStart(2, '0')

    companion object {
        private val ID_RE = """^(\d{4})-(\d\d)-(\d\d)-([a-z0-9]+)(-[a-z0-9]+)*$""".toRegex()
        private val SLUG_RE = """^([a-z0-9]+)(-[a-z0-9]+)*$""".toRegex()

        private const val PATH_PREFIX = "/blog"
        private const val PATH_EXT = "html"

        fun fromString(id: String): ArticleId {
            (ID_RE.matchEntire(id) ?: throw RuntimeException("Invalid article ID")).destructured
                .let { (year, month, day, slugHead, slugTail) -> return ArticleId(
                        year.toInt(),
                        month.toInt(),
                        day.toInt(),
                        slugHead + slugTail,
                    )
                }
        }
    }
}
