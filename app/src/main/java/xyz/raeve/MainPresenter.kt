package xyz.raeve

interface MainView {
  fun showLoading()
  fun hideLoading()
  fun showData(data: String)
}

interface MainService {
  fun requestData(): String

  companion object {
    fun create(): MainService = MainUseCase()
  }
}

class MainPresenter(private val view: MainView, private val service: MainService = MainService.create()) {

  fun retrieveData() {
    // 1 step show loading
    view.showLoading()
    // 2 step request data
    val data = service.requestData()
    // 3 step hide loading
    view.hideLoading()
    // 4 step show data
    view.showData(data)
  }
}