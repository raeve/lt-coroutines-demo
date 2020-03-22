package xyz.raeve

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MainApi {
  @GET("/v2/list")
  fun getPhotos(): List<PicsumPhoto>

  companion object {
    fun create(): MainApi {

      val client = OkHttpClient.Builder()
        .addInterceptor(
          HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
          }
        ).build()
      return Retrofit.Builder()
        .baseUrl("https://picsum.photos")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MainApi::class.java)
    }
  }
}