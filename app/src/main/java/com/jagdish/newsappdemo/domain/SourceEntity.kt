package com.jagdish.newsappdemo.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
open class SourceEntity(
    open val id: String?,
    open val name: String?
) : Parcelable