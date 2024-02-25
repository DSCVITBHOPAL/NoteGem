package com.gdsc_vitbhopal.notegem.presentation.tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.gdsc_vitbhopal.notegem.R
import com.gdsc_vitbhopal.notegem.domain.model.SubTask
import java.nio.file.Files.delete
@Composable
fun SubTaskItem(
    subTask: SubTask,
    onCheckedChange: (Boolean) -> Unit,
    onDelete: () -> Unit
) {
    Row(
        Modifier
            .padding(horizontal = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        var text by remember { mutableStateOf("") }
        Row {
            Checkbox(
                checked = subTask.isCompleted,
                onCheckedChange = { onCheckedChange(it) },
            )
            Spacer(Modifier.width(8.dp))
            BasicTextField(
                value = text,
                onValueChange = { text = it },
                textStyle = if (subTask.isCompleted)
                    TextStyle(textDecoration = TextDecoration.LineThrough, color = MaterialTheme.colors.onBackground)
                else
                    MaterialTheme.typography.body2.copy(color = MaterialTheme.colors.onBackground),
            )
            Spacer(Modifier.width(8.dp))
        }
        IconButton(onClick = { onDelete() }) {
            Icon(
                painter = painterResource(R.drawable.ic_delete),
                contentDescription = stringResource(R.string.delete_sub_task)
            )
        }
    }
}