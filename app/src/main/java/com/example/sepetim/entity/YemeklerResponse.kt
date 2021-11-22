package com.example.sepetim.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class YemeklerResponse(@SerializedName("yemekler")
                            @Expose
                            var yemekler:List<Yemekler>,
                            @SerializedName("success")
                            @Expose
                            var success:Int) : Serializable{
}