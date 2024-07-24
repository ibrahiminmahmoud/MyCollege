package com.example.mycollege.data.model

import java.io.Serializable

data class Lec(
    val id: Int,
    val title: String,

    val description: String,
    val lecId: Int = 0
) : Serializable