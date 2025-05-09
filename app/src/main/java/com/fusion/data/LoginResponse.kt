package com.fusion.data
data class LoginResponse(
    val access_token: String,
    val expires_in: Int,
    val userId: Int,
    val orgId :String,
    val appId :String,
    val workspaceId : String,
    val itemCode : String
    )
