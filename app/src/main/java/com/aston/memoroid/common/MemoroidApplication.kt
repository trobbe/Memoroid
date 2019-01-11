package com.aston.memoroid.common

import android.app.Application
import com.aston.memoroid.model.UserKt
import com.facebook.drawee.backends.pipeline.Fresco

import com.orhanobut.hawk.Hawk

class MemoroidApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Hawk.init(this).build()
        Fresco.initialize(this)
    }
}
