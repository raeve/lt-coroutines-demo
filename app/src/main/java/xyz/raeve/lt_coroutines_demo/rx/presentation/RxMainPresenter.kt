package xyz.raeve.lt_coroutines_demo.rx.presentation

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import xyz.raeve.lt_coroutines_demo.MainView
import xyz.raeve.lt_coroutines_demo.Presenter
import xyz.raeve.lt_coroutines_demo.rx.domain.RxMainService

class RxMainPresenter(private val view: MainView, private val service: RxMainService = RxMainService.create()): Presenter {

  override fun retrieveData() {
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