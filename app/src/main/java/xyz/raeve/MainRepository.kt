package xyz.raeve

import io.reactivex.rxjava3.core.Observable

interface MainRepository {
  fun getPhotos(): Observable<List<PicsumPhoto>>

  companion object {
    fun create(): MainRepository = MainRepositoryNetwork()
  }
}