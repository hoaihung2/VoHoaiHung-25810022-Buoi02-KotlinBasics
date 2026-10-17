package edu.hcmute.bookshelf


import retrofit2.http.GET
import retrofit2.http.Query

interface BookApiService {
    @GET("volumes")
    suspend fun searchBooks(
        @Query("q") query: String,
        @Query("maxResults") maxResults: Int = 30,
        @Query("key") apiKey: String = "AIzaSyARQqdZM3EjjAdMMqToudWSOztRQd6f54g"
    ): BooksResponse
}