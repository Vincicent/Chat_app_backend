package com.vincicent.chatapp.api.mappers

import com.vincicent.chatapp.api.dto.PictureUploadResponse
import com.vincicent.chatapp.domain.models.ProfilePictureUploadCredentials

fun ProfilePictureUploadCredentials.toResponse(): PictureUploadResponse {
    return PictureUploadResponse(
        uploadUrl = uploadUrl,
        publicUrl = publicUrl,
        headers = headers,
        expiresAt = expiresAt
    )
}