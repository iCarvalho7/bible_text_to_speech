package br.com.isaias.bible_text_to_speech.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Books(
    var abbrev : MutableMap<String, String>? = mutableMapOf(),
    var author : String? = "",
    var chapters: Int? = 0,
    var group: String = "",
    var name: String = "",
    var testament : String= ""
) : Parcelable