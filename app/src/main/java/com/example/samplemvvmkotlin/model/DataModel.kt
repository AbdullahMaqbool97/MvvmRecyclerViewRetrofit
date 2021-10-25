package com.example.samplemvvmkotlin.model

import com.google.gson.annotations.SerializedName

class dataModel {
    private var userID = 0
    private var id = 0

    @SerializedName("name")
    private var name: String? = null

    @SerializedName("email")
    private var title: String? = null

    @SerializedName("body")
    private var subTitle: String? = null

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getUserID(): Int {
        return userID
    }

    fun setUserID(userID: Int) {
        this.userID = userID
    }

    fun getId(): Int {
        return id
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title
    }

    fun getSubTitle(): String? {
        return subTitle
    }

    fun setSubTitle(subTitle: String?) {
        this.subTitle = subTitle
    }
}