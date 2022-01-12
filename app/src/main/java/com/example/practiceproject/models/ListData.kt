package com.example.practiceproject.models

import java.io.FileDescriptor
import java.security.acl.Owner

data class ListData(
    val items: List<RecyclerData>
    )

data class RecyclerData(
    val name: String?,
    val description: String?,
    val owner: com.example.practiceproject.models.Owner
    )

data class Owner(
    val avatar_url: String?
    )
