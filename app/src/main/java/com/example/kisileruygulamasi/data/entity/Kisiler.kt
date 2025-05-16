package com.example.kisileruygulamasi.data.entity

import androidx.room.ColumnInfo
import java.io.Serializable
import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.Nonnull


@Entity(tableName ="kisiler")
data class Kisiler(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="kisi_id") @Nonnull var kisi_id :Int ,
    @ColumnInfo(name="kisi_ad") @Nonnull var kisi_ad :String,
    @ColumnInfo(name="kisi_tel") @Nonnull var kisi_tel :String) :Serializable {
}