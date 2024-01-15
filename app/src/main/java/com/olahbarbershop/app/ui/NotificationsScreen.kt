package com.olahbarbershop.app.ui

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.olahbarbershop.app.R
import com.olahbarbershop.app.data.Notification
import com.olahbarbershop.app.data.notificationList
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NotificationsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(R.string.notifications),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp, bottom = 12.dp),
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.h1
        )
        val refreshScope = rememberCoroutineScope()
        var refreshing by remember { mutableStateOf(false) }
        var notificationsList by remember { mutableStateOf(notificationList) }

        fun refresh() = refreshScope.launch {
            refreshing = true
            delay(1500)
            notificationsList = notificationList
            refreshing = false
        }

        val state = rememberPullRefreshState(refreshing, ::refresh)

        Box(Modifier.pullRefresh(state)) {
            LazyColumn(
                Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background)
            ) {
                if (!refreshing) {
                    items(notificationsList) {
                        NotificationItem(notification = it)
                    }
                }
            }

            PullRefreshIndicator(
                refreshing,
                state,
                Modifier.align(Alignment.TopCenter),
                backgroundColor = MaterialTheme.colors.background,
                contentColor = MaterialTheme.colors.onSurface,
                scale = true
            )
        }
    }
}

@Composable
fun NotificationItem(modifier: Modifier = Modifier, notification: Notification) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card(
        modifier = modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(if (expanded) 20 else 40)),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .background(color = MaterialTheme.colors.surface)
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                NotificationIcon(notification.imageResourceId)
                NotificationInfo(notificationType = notification.type, posted = notification.posted)
                Spacer(modifier = Modifier.weight(1f))
                NotificationItemButton(expanded = expanded, onClick = { expanded = !expanded })
            }
            if (expanded) {
                NotificationDescription(notificationDesc = notification.description)
            }
        }
    }
}

@Composable
fun NotificationDescription(notificationDesc: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(
            start = 16.dp,
            top = 8.dp,
            bottom = 16.dp,
            end = 16.dp
        )
    ) {
        Text(
            text = stringResource(R.string.about),
            style = MaterialTheme.typography.h3,
        )
        Text(
            text = notificationDesc,
            style = MaterialTheme.typography.body1,
        )
    }
}

@Composable
private fun NotificationItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(onClick = onClick, modifier = modifier.padding(top = 9.dp)) {
        Icon(
            painter = painterResource(if (expanded) R.drawable.baseline_expand_less_24 else R.drawable.baseline_expand_more_24),
            tint = MaterialTheme.colors.secondary,
            contentDescription = stringResource(R.string.expand_button_content_description)
        )
    }
}

@Composable
fun NotificationInfo(
    notificationType: String,
    posted: String,
    modifier: Modifier = Modifier
) {
    Column() {
        Text(
            text = notificationType,
            modifier = Modifier.padding(top = 12.dp),
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.h2
        )
        Text(
            text = posted,
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
fun NotificationIcon(@DrawableRes icon: Int, modifier: Modifier = Modifier) {
    Image(
        painterResource(icon),
        contentDescription = null,
        modifier = Modifier
            .size(64.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(50)),
        contentScale = ContentScale.Crop
    )
}