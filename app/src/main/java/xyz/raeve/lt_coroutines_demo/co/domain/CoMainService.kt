package xyz.raeve.lt_coroutines_demo.co.domain

import xyz.raeve.lt_coroutines_demo.PicsumPhoto

interface CoMainService {
  suspend fun requestData(): List<PicsumPhoto>

  companion object {
    fun create(): CoMainService = CoMainUseCase()
  }
}