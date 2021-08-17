package com.causa_arcana

import org.junit.Test

import org.junit.Assert.*

class ExampleUnitTest {
    private val articleId1 = ArticleId(2021, 1,  1,  "hello-world")
    private val articleId2 = ArticleId(2000, 6,  24, "123")
    private val articleId3 = ArticleId(3000, 12, 6,  "0foo-1-2")

    @Test
    fun articleIdFromString() {
        val articleId = ArticleId.fromString("2021-01-01-hello-world")

        assertEquals(2021,          articleId.year)
        assertEquals(1,             articleId.month)
        assertEquals(1,             articleId.day)
        assertEquals("hello-world", articleId.slug)
    }

    @Test
    fun articleIdToString() {
        assertEquals("2021-01-01-hello-world", articleId1.toString())
        assertEquals("2000-06-24-123",         articleId2.toString())
        assertEquals("3000-12-06-0foo-1-2",    articleId3.toString())
    }

    @Test
    fun articleIdToPath() {
        assertEquals("/2021/01/01/hello-world", articleId1.toPath())
        assertEquals("/2000/06/24/123",         articleId2.toPath())
        assertEquals("/3000/12/06/0foo-1-2",    articleId3.toPath())
    }

    @Test
    fun articleIdToPathWithExt() {
        assertEquals("/2021/01/01/hello-world.html", articleId1.toPathWithExt())
        assertEquals("/2000/06/24/123.html",         articleId2.toPathWithExt())
        assertEquals("/3000/12/06/0foo-1-2.html",    articleId3.toPathWithExt())
    }

    @Test
    fun articleIdToFullPath() {
        assertEquals("/blog/2021/01/01/hello-world", articleId1.toFullPath())
        assertEquals("/blog/2000/06/24/123",         articleId2.toFullPath())
        assertEquals("/blog/3000/12/06/0foo-1-2",    articleId3.toFullPath())
    }

    @Test
    fun articleIdToFullPathWithExt() {
        assertEquals("/blog/2021/01/01/hello-world.html", articleId1.toFullPathWithExt())
        assertEquals("/blog/2000/06/24/123.html",         articleId2.toFullPathWithExt())
        assertEquals("/blog/3000/12/06/0foo-1-2.html",    articleId3.toFullPathWithExt())
    }

    @Test
    fun articleIdYearPadded() {
        assertEquals("2021", articleId1.yearPadded())
        assertEquals("2000", articleId2.yearPadded())
        assertEquals("3000", articleId3.yearPadded())
    }

    @Test
    fun articleIdMonthPadded() {
        assertEquals("01", articleId1.monthPadded())
        assertEquals("06", articleId2.monthPadded())
        assertEquals("12", articleId3.monthPadded())
    }

    @Test
    fun articleIdDayPadded() {
        assertEquals("01", articleId1.dayPadded())
        assertEquals("24", articleId2.dayPadded())
        assertEquals("06", articleId3.dayPadded())
    }
}
