package com.app.core.network.models

import com.google.gson.annotations.SerializedName

data class RemoteAnimeTitle(
    val en: String?,
    @SerializedName("en_jp") val enJp: String?,
    @SerializedName("ja_jp") val jaJp: String
) {
    val title: String
        get() = en ?: enJp ?: jaJp
}
