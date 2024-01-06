package com.example.mmvm_practise.data.Network.Response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@javax.annotation.Generated("jsonschema2pojo")
class UserDetail {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("username")
    @Expose
    var username: String? = null

    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("firstName")
    @Expose
    var firstName: String? = null

    @SerializedName("lastName")
    @Expose
    var lastName: String? = null

    @SerializedName("gender")
    @Expose
    var gender: String? = null

    @SerializedName("image")
    @Expose
    var image: String? = null

    @SerializedName("token")
    @Expose
    var token: String? = null
}