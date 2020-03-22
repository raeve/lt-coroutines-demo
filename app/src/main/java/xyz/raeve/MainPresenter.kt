package xyz.raeve

interface MainView {
  fun showLoading()
  fun hideLoading()
  fun showPhotos(list: List<PicsumPhoto>)
}

interface MainService {
  fun requestData(): List<PicsumPhoto>

  companion object {
    fun create(): MainService = MainUseCase()
  }
}

class MainPresenter(private val view: MainView, private val service: MainService = MainService.create()) {

  fun retrieveData() {
    // 1 step show loading
    view.showLoading()
    // 2 step request data
    val photoList = service.requestData()
    // 3 step hide loading
    view.hideLoading()
    // 4 step show data
    view.showPhotos(photoList)
  }
}