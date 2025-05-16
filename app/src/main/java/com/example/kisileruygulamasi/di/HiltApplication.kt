package com.example.kisileruygulamasi.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp //uygulamamızın tamamını temsil eden class
class HiltApplication :Application() {
}