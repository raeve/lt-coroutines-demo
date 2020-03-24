package xyz.raeve.lt_coroutines_demo.co.domain

class CoMainUseCase(private val repository: CoMainRepository = CoMainRepository.create()) :
  CoMainService {
  override suspend fun requestData() = repository.getPhotos()
}