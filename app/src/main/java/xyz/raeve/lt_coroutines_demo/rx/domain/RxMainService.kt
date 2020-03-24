package xyz.raeve.lt_coroutines_demo.rx.domain

import io.reactivex.rxjava3.core.Observable
import xyz.raeve.lt_coroutines_demo.PicsumPhoto

interface RxMainService {
  fun requestData(): Observable<List<PicsumPhoto>>

  companion object {
    fun create(): RxMainService = RxMainUseCase()
  }
}