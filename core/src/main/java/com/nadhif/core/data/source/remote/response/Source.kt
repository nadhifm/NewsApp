package com.nadhif.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class Source(
    @field:SerializedName("id")
    val id: Any? = null,
    @field:SerializedName("name")
    val name: String
)
