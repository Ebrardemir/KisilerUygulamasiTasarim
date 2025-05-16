package com.example.kisileruygulamasi.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kisileruygulamasi.data.entity.Kisiler

//db in tamamını temsil ediyo - her tablo için bi adet entity oluşturma gerekli -o classları da aşağıdaki gibi eklicektik

@Database(entities = [Kisiler ::class], version = 1)
abstract class Veritabani :RoomDatabase(){
    abstract fun getKisilerDao():KisilerDao //getKisilerDao fonk kullanarak o interface erişcez
}