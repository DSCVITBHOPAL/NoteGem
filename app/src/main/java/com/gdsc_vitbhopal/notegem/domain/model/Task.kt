package com.gdsc_vitbhopal.notegem.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    val title: String,
    val description: String = "",
    @ColumnInfo(name = "is_completed")
    val isCompleted: Boolean = false,
    val priority: Int = 0,
    @ColumnInfo(name = "created_at")
    val createdAt: Long = 0L,
    @ColumnInfo(name = "updated_at")
    val updatedAt: Long = 0L,
    @ColumnInfo(name = "sub_tasks")
    val subTasks: List<SubTask> = emptyList(),
    val dueDate: Long = 0L,
    // TODO add colors
    val color: Int = 0,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)