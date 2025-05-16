package com.example.kisileruygulamasi.data.datasource

import android.util.Log
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.room.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


//veritabanı işlemleri burada yapılcak
class KisilerDataSource(var kisilerDao: KisilerDao) { //interfacei dışardan isteme
    suspend fun kaydet(kisi_ad:String , kisi_tel:String){//suspend diyince o fonk aynı anda birden fazla şekilde çalışcak anlamına geliyor thred gibi
        //suspend asycn çalışma deemek
        val yeniKisi= Kisiler(0,kisi_ad, kisi_tel)
        kisilerDao.kaydet(yeniKisi)
    }

    suspend fun guncelle(kisiId: Int, kisiAd: String, kisiTel: String) {
        val guncellenenKisi=Kisiler(kisiId,kisiAd,kisiTel)
        kisilerDao.guncelle(guncellenenKisi)
    }

    suspend fun sil(kisiId: Int) {
        val silinenKisi=Kisiler(kisiId,"","")
        kisilerDao.sil(silinenKisi)
    }

    //withcontext :coroutıne lerle verileri return etmek için kullanılıyor, katmanlar arası veritaşıma
    suspend fun kisileriYukle(): List<Kisiler> = withContext(Dispatchers.IO){ //coroutine fonksiyonlarda bu şekilde veri iletiyoruz repoya

        return@withContext kisilerDao.kisileriYukle()

    }
    suspend fun ara(aramaKelimesi :String): List<Kisiler> = withContext(Dispatchers.IO){//şu anda ne ararsak arabyalım ebrar çıkcak,veritabanı işlemlerinde düzelir
        return@withContext kisilerDao.ara(aramaKelimesi)

    }

}