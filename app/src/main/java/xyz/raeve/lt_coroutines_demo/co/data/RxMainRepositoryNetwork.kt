package xyz.raeve.lt_coroutines_demo.co.data

import xyz.raeve.lt_coroutines_demo.co.domain.CoMainRepository

class CoMainRepositoryNetwork(private val api: CoMainApi = CoMainApi.create()) :
  CoMainRepository {
  override suspend fun getPhotos() = api.getPhotos()
}