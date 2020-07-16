package br.com.isaias.bible_text_to_speech.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Versions (
    @SerializedName("version")
    var version: String = "",
    @SerializedName("verses")
    var verses : String = ""
) : Parcelable