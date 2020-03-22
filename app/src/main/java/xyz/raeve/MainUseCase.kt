package xyz.raeve

class MainUseCase(private val repository: MainRepository) : MainService {
  override fun requestData(): List<PicsumPhoto> = repository.getPhotos()
}