package mezzari.torres.lucas.motion_layout_test.model

import com.google.gson.annotations.SerializedName

data class Detail (
    @SerializedName("mal_id") val id: Long,
    @SerializedName("type") val type: String,
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
)