package xyz.raeve.lt_coroutines_demo.rx.data

import xyz.raeve.lt_coroutines_demo.rx.domain.RxMainRepository

class RxMainRepositoryNetwork(private val api: RxMainApi = RxMainApi.create()) :
  RxMainRepository {
  override fun getPhotos() = api.getPhotos()
}