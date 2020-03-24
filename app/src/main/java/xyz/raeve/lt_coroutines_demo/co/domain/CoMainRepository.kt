package xyz.raeve.lt_coroutines_demo.co.domain

import xyz.raeve.lt_coroutines_demo.PicsumPhoto
import xyz.raeve.lt_coroutines_demo.co.data.CoMainRepositoryNetwork

interface CoMainRepository {
  suspend fun getPhotos(): List<PicsumPhoto>

  companion object {
    fun create(): CoMainRepository =
      CoMainRepositoryNetwork()
  }
}