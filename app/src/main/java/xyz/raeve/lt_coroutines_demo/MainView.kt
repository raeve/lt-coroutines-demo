package xyz.raeve.lt_coroutines_demo

interface MainView {
  fun showLoading()
  fun hideLoading()
  fun showPhotos(list: List<PicsumPhoto>)
  fun showMillis(millis: Long)
}