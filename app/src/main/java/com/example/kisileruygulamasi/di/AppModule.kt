package com.example.kisileruygulamasi.di

import android.content.Context
import androidx.room.Room
import com.example.kisileruygulamasi.data.datasource.KisilerDataSource
import com.example.kisileruygulamasi.data.repo.KisilerRepository
import com.example.kisileruygulamasi.room.KisilerDao
import com.example.kisileruygulamasi.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module //modul oldugunu belirtiyon sağlayıcı
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides //sağlayıcı
    @Singleton //tek yerde tanımlayıp bi çok yerde kullanmaya deniir

    fun provideKisilerRepository(kisilerDataSource: KisilerDataSource) : KisilerRepository{
        return KisilerRepository(kisilerDataSource)
    }

    @Provides
    @Singleton
    fun provideKisilerDataSource(kisilerDao: KisilerDao) : KisilerDataSource {
        return KisilerDataSource(kisilerDao)
    }

    @Provides
    @Singleton

    fun provideKisilerDao(@ApplicationContext context :Context):KisilerDao{ //kisilerdao ya direkt erişemiyon veritabanı üzerinden erişcez
        //@applicationcontext bi yapı bize direkt contextı sağlıyor
        val veritabani = Room.databaseBuilder(context, Veritabani::class.java,"rehber.sqlite")  //burda sadece veritabanına erişdik
            .createFromAsset("rehber.sqlite") //rehber.sqlite dosyasını kopyalama
            .build()
        return veritabani.getKisilerDao()
    }
}