package xyz.raeve

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

interface MainView {
  fun showLoading()
  fun hideLoading()
  fun showPhotos(list: List<PicsumPhoto>)
}

interface MainService {
  fun requestData(): Observable<List<PicsumPhoto>>

  companion object {
    fun create(): MainService = MainUseCase()
  }
}

class MainPresenter(private val view: MainView, private val service: MainService = MainService.create()) {
  fun retrieveData() {
    view.showLoading()
    CompositeDisposable().add(
      service.requestData()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.newThread())
        .subscribe {
          view.hideLoading()
          view.showPhotos(it)
        })
  }
}