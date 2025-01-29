package com.example.mistplaychallenge.presentation.ui.mappers

import com.example.mistplaychallenge.domain.model.Post
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class UIPostMapperTest {

    private lateinit var uiPostMapper: UIPostMapper

    @Before
    fun setUp() {
        uiPostMapper = UIPostMapper()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun mapToView() {
        val post = Post(
            userId = 1,
            id = 1,
            title = "Test Title",
            body = "Test Body"
        )
        val postUI = uiPostMapper.mapToView(post)
        assertEquals(post.userId, postUI.userId)
    }
}