package br.com.isaias.bible_text_to_speech.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Version (
    var version: String = "",
    var verses : String = ""
) : Parcelable