package mezzari.torres.lucas.motion_layout_test.model

import com.google.gson.annotations.SerializedName

data class Anime (
    @SerializedName("mal_id") val id: Long,
    @SerializedName("title") val title: String,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("synopsis") val synopsis: String,
    @SerializedName("type") val type: String,
    @SerializedName("airing_start") val airingStart: String,
    @SerializedName("episodes") val episodes: Int,
    @SerializedName("source") val source: String,
    @SerializedName("licensors") val licensors: List<String>,
    @SerializedName("genres") val genres: List<Detail>,
    @SerializedName("producers") val producers: List<Detail>
)