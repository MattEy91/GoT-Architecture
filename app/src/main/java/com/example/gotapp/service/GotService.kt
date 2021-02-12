package com.example.gotapp.service

import com.example.gotapp.domain.model.HouseResponse
import retrofit2.http.GET
import kotlinx.coroutines.Deferred
import java.io.IOException

class GotGateway(private val service: GotService) {

    suspend fun getAllHouses(): GetResult<HouseResponse> {
        return try {
            val response = service.getAllHouses().await()
            GetResult.Success(response)
        } catch (e: NoConnectivityException) {
            GetResult.Failure()
        }
    }
}

sealed class GetResult<T> {
    class Failure<S>: GetResult<S>()
    data class Success<V>(val data: V): GetResult<V>()
}

interface GotService {
    @GET("api/houses")
    fun getAllHouses(): Deferred<HouseResponse>
}

class NoConnectivityException : IOException() {
    override val message: String
        get() = "No connectivity exception"
}