package com.app.core.network.models

data class RemoteListResponse<T>(
    val data: List<RemoteResponseData<T>>,
    val meta: RemoteResponseMeta,
    val links: RemoteResponseLinks
)
