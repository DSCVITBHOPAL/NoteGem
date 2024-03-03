package com.gdsc_vitbhopal.notegem.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
//    val title: String,
//    val content: String,
    val title: String = "",
    val content: String = "",
    @ColumnInfo(name = "created_date")
//    val createdDate: Long,
    val createdDate: Long = 0L,
    @ColumnInfo(name = "updated_date")
//    val updatedDate: Long,
//    val color: Long,
//    val pinned: Boolean,
    val updatedDate: Long = 0L,
    val pinned: Boolean = false,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
)