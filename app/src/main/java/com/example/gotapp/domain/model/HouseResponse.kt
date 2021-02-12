package com.example.gotapp.domain.model

import android.os.Parcelable
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.JsonAdapter
import kotlinx.android.parcel.Parcelize
import java.lang.reflect.Type

@JsonAdapter(HouseResponseAdapter::class)
@Parcelize
data class HouseResponse(val response: List<House>) : Parcelable

class HouseResponseAdapter : JsonDeserializer<HouseResponse> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): HouseResponse {
        val houseList = listOf<House>().toMutableList()

        json?.asJsonArray?.forEach {
            context?.deserialize<House>(it, House::class.java)?.let { house -> houseList.add(house) }
        }
        return HouseResponse(houseList.toList())
    }
}