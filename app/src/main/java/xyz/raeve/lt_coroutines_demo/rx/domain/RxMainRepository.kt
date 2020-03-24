package xyz.raeve.lt_coroutines_demo.rx.domain

import io.reactivex.rxjava3.core.Observable
import xyz.raeve.lt_coroutines_demo.PicsumPhoto
import xyz.raeve.lt_coroutines_demo.rx.data.RxMainRepositoryNetwork

interface RxMainRepository {
  fun getPhotos(): Observable<List<PicsumPhoto>>

  companion object {
    fun create(): RxMainRepository =
      RxMainRepositoryNetwork()
  }
}