package com.example.gotapp.domain.usecases

import com.example.gotapp.CoroutineDispatchers
import com.example.gotapp.domain.model.HouseResponse
import com.example.gotapp.service.GetResult
import com.example.gotapp.service.GotGateway
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class GetAllHousesUseCase internal constructor(
    private val dispatchers: CoroutineDispatchers,
    private val gateway: GotGateway
) : UseCase<HouseResponse>(dispatchers) {
    fun execute(onResult: (houses: HouseResponse) -> Unit) {
        job = async(dispatchers.io) {
            when(val response = gateway.getAllHouses()) {
                is GetResult.Success -> {
                    response.data
                }
                is GetResult.Failure -> HouseResponse(mutableListOf())
            }
        }
        launch(dispatchers.ui) {
                onResult(job?.await() ?: HouseResponse(mutableListOf()))
        }
    }
}