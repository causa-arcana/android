package com.causa_arcana

import org.junit.Test

import org.junit.Assert.*

class ExampleUnitTest {
    @Test
    fun articleIdFromString() {
        val articleId = ArticleId.fromString("2021-01-01-hello-world")
        assertEquals(2021u, articleId.year)
        assertEquals(1u, articleId.month)
        assertEquals(1u, articleId.day)
        assertEquals("hello-world", articleId.slug)
    }

    @Test
    fun articleIdToString() {
        val articleId = ArticleId(2021u, 1u, 1u, "hello-world")
        assertEquals("2021-01-01-hello-world", articleId.toString())
    }
}
