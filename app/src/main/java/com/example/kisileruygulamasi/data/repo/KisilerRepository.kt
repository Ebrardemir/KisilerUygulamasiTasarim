package com.example.kisileruygulamasi.data.repo

import com.example.kisileruygulamasi.data.datasource.KisilerDataSource
import com.example.kisileruygulamasi.data.entity.Kisiler
import javax.inject.Inject

//data katmanını yöneten kısım, repository den datasource a erişmek istiyorum ilk adım
class KisilerRepository(var kisilerDataSource:KisilerDataSource) {
    //var kisilerDataSource=KisilerDataSource() hılt dolayıısyla yukaruya alındı

    /*aşağıdakiyle aynı işlem,fonks. amacı sadece çalıştırmak ise aşağıdaki gibi eşitleyebilirsin
    suspend fun kaydet(kisi_ad:String , kisi_tel:String){ //datasourcedaki fonk erişip veri gönderme, iletmek,taşıyıcı fonksiyon
        kisilerDataSource.kaydet(kisi_ad,kisi_tel) //
    }
    */
    suspend fun kaydet(kisi_ad:String , kisi_tel:String)=kisilerDataSource.kaydet(kisi_ad,kisi_tel)
    suspend fun guncelle( kisi_id :Int, kisi_ad:String, kisi_tel :String)= kisilerDataSource.guncelle(kisi_id,kisi_ad,kisi_tel)
    suspend fun sil(kisi_id:Int)= kisilerDataSource.sil(kisi_id)
    suspend fun kisileriYukle():List<Kisiler> = kisilerDataSource.kisileriYukle()
    suspend fun ara(aramaKelimesi:String): List<Kisiler> =kisilerDataSource.ara(aramaKelimesi)


}