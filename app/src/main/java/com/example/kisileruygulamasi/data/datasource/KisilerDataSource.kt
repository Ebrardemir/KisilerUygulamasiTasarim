package com.example.kisileruygulamasi.data.datasource

import android.util.Log
import com.example.kisileruygulamasi.data.entity.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//veritabanı işlemleri burada yapılcak
class KisilerDataSource {
    suspend fun kaydet(kisi_ad:String , kisi_tel:String){//suspend diyince o fonk aynı anda birden fazla şekilde çalışcak anlamına geliyor thred gibi
        //suspend asycn çalışma deemek
        Log.e("kisi kaydet" ,"$kisi_ad - $kisi_tel")
    }

    suspend fun guncelle(kisiId: Int, kisiAd: String, kisiTel: String) {
        Log.e("kisi guncelle","$kisiAd - $kisiTel")
    }

    suspend fun sil(kisiId: Int) {
        Log.e("kişiyi sil",kisiId.toString())
    }

    //withcontext :coroutıne lerle verileri return etmek için kullanılıyor, katmanlar arası veritaşıma
    suspend fun kisileriYukle(): List<Kisiler> = withContext(Dispatchers.IO){ //coroutine fonksiyonlarda bu şekilde veri iletiyoruz repoya
        val liste =ArrayList<Kisiler>()
        val k1 = Kisiler(1,"ebrar","61")
        val k2 = Kisiler(2,"ebrar","61")
        val k3 = Kisiler(3,"ebrar","61")

        liste.add(k1)
        liste.add(k2)
        liste.add(k3)
        return@withContext liste

    }
    suspend fun ara(aramaKelimesi :String): List<Kisiler> = withContext(Dispatchers.IO){//şu anda ne ararsak arabyalım ebrar çıkcak,veritabanı işlemlerinde düzelir
        val liste =ArrayList<Kisiler>()
        val k1 = Kisiler(1,"ebrar","61")

        liste.add(k1)
        return@withContext liste

    }

}