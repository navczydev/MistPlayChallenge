package com.example.mistplaychallenge.data.repositories

import com.example.mistplaychallenge.data.api.apis.PostsAPI
import com.example.mistplaychallenge.data.api.mappers.APIPostMapper
import com.example.mistplaychallenge.data.api.model.PostDTO
import com.example.mistplaychallenge.domain.model.Post
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class ImplPostsRepositoryTest {
    private lateinit var postsRepository: ImplPostsRepository

    @MockK
    private lateinit var postsAPI: PostsAPI
    private lateinit var postMapper: APIPostMapper

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        postMapper = APIPostMapper()
        postsRepository = ImplPostsRepository(postsAPI, postMapper)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `when postsAPI returns empty list, then getPosts returns empty list`() =
        runTest {
            coEvery { postsAPI.getPosts() } returns listOf()
            val result = postsRepository.getPosts()
            assertTrue(result.isEmpty())
        }

    @Test
    fun `getPosts returns list of posts when API call is successful`() = runTest {
        val postDTO = PostDTO(userId = 1, id = 1, title = "title", body = "body")
        coEvery { postsAPI.getPosts() } returns listOf(postDTO)
        val result = postsRepository.getPosts()
        assertEquals(1, result.size)
    }

    @Test
    fun `getPosts returns empty list when API call throws exception`() = runTest {
        coEvery { postsAPI.getPosts() } throws Exception("API Error")
        val result = postsRepository.getPosts()
        assertEquals(emptyList<Post>(), result)
    }
}