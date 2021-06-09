package mezzari.torres.lucas.motion_layout_test.model.network

import com.google.gson.annotations.SerializedName

data class ResponseWrapper<T>(
    @SerializedName("request_hash") val requestHash: String,
    @SerializedName("status") val status: Int,
    @SerializedName("type") val type: String,
    @SerializedName("message") val message: String,
    @SerializedName("error") val error: String,
    @SerializedName("data", alternate = ["anime"]) val data: T,
)