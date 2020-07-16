package br.com.isaias.bible_text_to_speech.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Books(
    @SerializedName("abbrev")
    var abbrev : MutableMap<String, String>? = mutableMapOf(),
    @SerializedName("author")
    var author : String? = "",
    @SerializedName("chapters")
    var chapters: Int? = 0,
    @SerializedName("group")
    var group: String? = "",
    @SerializedName("name")
    var name: String? = "",
    @SerializedName("testament")
    var testament : String? = ""
) : Parcelable