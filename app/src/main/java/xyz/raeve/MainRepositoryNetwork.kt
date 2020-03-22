package xyz.raeve

class MainRepositoryNetwork(private val api: MainApi = MainApi.create()) : MainRepository {
  override fun getPhotos() = api.getPhotos()
}