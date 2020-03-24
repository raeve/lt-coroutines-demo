package xyz.raeve.lt_coroutines_demo.co.data

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import xyz.raeve.lt_coroutines_demo.PicsumPhoto
import java.util.concurrent.TimeUnit

interface CoMainApi {
  @GET("/v2/list")
  suspend fun getPhotos(): List<PicsumPhoto>

  companion object {
    fun create(): CoMainApi {

      val client = OkHttpClient.Builder()
        .addInterceptor(
          HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
          }
        )
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

      val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .baseUrl("https://picsum.photos")
        .client(client)
        .build()
      return retrofit.create(CoMainApi::class.java)
    }
  }
}