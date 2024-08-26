package com.uvg.lazystate.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.lazystate.ui.theme.LazyStateTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun NotificationLayout(
    modifier: Modifier = Modifier,
    notifications: List<Notification>
) {
    var selectedFilter by rememberSaveable { mutableStateOf<NotificationType?>(null) }
    val filteredNotifications = remember(notifications, selectedFilter) {
        notifications.filter { notification ->
            selectedFilter == null || notification.type == selectedFilter
        }
    }

    Column(
        modifier = Modifier.fillMaxHeight()
    ) {
        CustomHeader(
            modifier = modifier.fillMaxWidth(),
            selectedFilter = selectedFilter,
            onGeneralChange = {
                selectedFilter = if (selectedFilter == NotificationType.GENERAL) null else NotificationType.GENERAL
            },
            onNewMessageChange = {
                selectedFilter = if (selectedFilter == NotificationType.NEW_MESSAGE) null else NotificationType.NEW_MESSAGE
            },
            onNewLikeChange = {
                selectedFilter = if (selectedFilter == NotificationType.NEW_LIKE) null else NotificationType.NEW_LIKE
            },
            onNewPostChange = {
                selectedFilter = if (selectedFilter == NotificationType.NEW_POST) null else NotificationType.NEW_POST
            }
        )
        NotificationList(
            modifier = modifier.fillMaxWidth(),
            notifications = filteredNotifications
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CustomHeader(
    modifier: Modifier,
    selectedFilter: NotificationType?,
    onGeneralChange: () -> Unit,
    onNewPostChange: () -> Unit,
    onNewMessageChange: () -> Unit,
    onNewLikeChange: () -> Unit
){
    Column {
        TopAppBar(
            title = {
                Text("Notificaciones")
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            ),
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        )
        Column (
            modifier = Modifier
                .padding(15.dp)
        ){
            Text(
                text = "Tipos de notificaciones"
            )
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            contentPadding = PaddingValues(horizontal = 24.dp)
        ) {
            item {
                MyFilter(
                    label = "General",
                    selected = selectedFilter == NotificationType.GENERAL,
                    onSelectedChange = onGeneralChange
                )
            }
            item {
                MyFilter(
                    label = "Nuevo Post",
                    selected = selectedFilter == NotificationType.NEW_POST,
                    onSelectedChange = onNewPostChange
                )
            }
            item {
                MyFilter(
                    label = "Nuevo Mensaje",
                    selected = selectedFilter == NotificationType.NEW_MESSAGE,
                    onSelectedChange = onNewMessageChange
                )
            }
            item {
                MyFilter(
                    label = "Nuevo Like",
                    selected = selectedFilter == NotificationType.NEW_LIKE,
                    onSelectedChange = onNewLikeChange
                )
            }
        }
    }
}

@Composable
private fun CustomNotification(
    modifier: Modifier,
    title: String,
    body: String,
    sentAt: Date,
    type: NotificationType
){
    Row (
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(15.dp)
    ){
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            if (type == NotificationType.GENERAL || type == NotificationType.NEW_POST){
                Icon(
                    Icons.Filled.DateRange,
                    contentDescription = "Nueva notificación",
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colorScheme.secondary)
                        .padding(12.dp),
                    tint = MaterialTheme.colorScheme.onSecondary
                )
            } else {
                Icon(
                    Icons.Filled.Notifications,
                    contentDescription = "Nueva notificación",
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colorScheme.tertiary)
                        .padding(12.dp),
                    tint = MaterialTheme.colorScheme.onTertiary
                )
            }
        }
        Column {
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold
                )
                val dateFormat = SimpleDateFormat("dd MMM • h:mm a", Locale("es", "ES"))
                Text(
                    text = dateFormat.format(sentAt),
                    style = MaterialTheme.typography.labelSmall,

                )
            }
            Row {
                Text(
                    text = body,
                    style = MaterialTheme.typography.titleSmall,

                )
            }
        }
    }
}

@Composable
private fun MyFilter(
    label: String,
    selected: Boolean,
    onSelectedChange: () -> Unit
){
    FilterChip(
        onClick = onSelectedChange,
        label = { Text(label) },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        }
    )
}

@Composable
private fun NotificationList(
    modifier: Modifier,
    notifications: List<Notification>
){
    if(notifications.isEmpty()){
        Text(text = "List is empty")
    } else {
        LazyColumn (
            modifier = Modifier
                .padding(15.dp)
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(16.dp)
                )
        ){
            items(notifications.size) {
                notifications.forEachIndexed { index, notification ->
                    CustomNotification(
                        modifier = Modifier.fillMaxWidth(),
                        title = notification.title,
                        body = notification.body,
                        sentAt = notification.sendAt,
                        type = notification.type
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewNotificationLayout() {
    val notifications = rememberSaveable {
        generateFakeNotifications()
    }
    LazyStateTheme {
        Surface {
            NotificationLayout(
                notifications = notifications,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}