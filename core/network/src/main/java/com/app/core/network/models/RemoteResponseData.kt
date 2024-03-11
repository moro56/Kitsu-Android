package com.app.core.network.models

data class RemoteResponseData<T>(val id: String, val type: String, val attributes: T)
