package xyz.raeve.lt_coroutines_demo.co.presentation

import kotlinx.coroutines.*
import xyz.raeve.lt_coroutines_demo.MainView
import xyz.raeve.lt_coroutines_demo.Presenter
import xyz.raeve.lt_coroutines_demo.co.domain.CoMainService
import java.util.*


class CoMainPresenter(private val view: MainView, private val service: CoMainService = CoMainService.create()) : Presenter {

  override fun retrieveData() {
    val beforeMillis = Calendar.getInstance().timeInMillis
    view.showLoading()
    CoroutineScope(Dispatchers.Main).launch {
      val photos = withContext(Dispatchers.IO) { service.requestData() }
      view.hideLoading()
      view.showMillis(Calendar.getInstance().timeInMillis - beforeMillis)
      view.showPhotos(photos)
    }
  }

  override fun clear() {
    // no-impl
  }
}