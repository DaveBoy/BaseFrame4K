package com.daveboy.baseframe4k.bean

/**
 * 登录成功返回的实体
 * @property chapterTops List<Any>
 * @property collectIds List<Int>
 * @property email String
 * @property icon String
 * @property id Int
 * @property password String
 * @property token String
 * @property type Int
 * @property username String
 * @constructor
 */
data class LoginResponse(
    val chapterTops: List<Any>,
    val collectIds: List<Int>,
    val email: String,
    val icon: String,
    val id: Int,
    val password: String,
    val token: String,
    val type: Int,
    val username: String
)