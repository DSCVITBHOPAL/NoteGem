package com.gdsc_vitbhopal.notegem.controller.tasks

import com.gdsc_vitbhopal.notegem.domain.model.Task
import com.gdsc_vitbhopal.notegem.util.settings.Order


sealed class TaskEvent {
    data class CompleteTask(val task: Task, val complete: Boolean) : TaskEvent()
    data class AddTask(val task: Task) : TaskEvent()
    data class GetTask(val taskId: Int) : TaskEvent()
    data class SearchTasks(val query: String) : TaskEvent()
    data class UpdateOrder(val order: Order) : TaskEvent()
    data class ShowCompletedTasks(val showCompleted: Boolean) : TaskEvent()
    data class UpdateTask(val task: Task, val dueDateUpdated: Boolean) : TaskEvent()
    data class DeleteTask(val task: Task) : TaskEvent()
    object ErrorDisplayed: TaskEvent()
}