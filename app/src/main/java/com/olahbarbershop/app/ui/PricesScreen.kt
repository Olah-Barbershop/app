package com.olahbarbershop.app.ui

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.olahbarbershop.app.R
import com.olahbarbershop.app.data.Service
import com.olahbarbershop.app.data.services
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ServicesScreen(modifier: Modifier = Modifier) {
    Column(
        Modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(R.string.services),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp, bottom = 20.dp),
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.h1
        )
        Row(
            Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(R.string.servicesDesc),
                modifier = Modifier
                    .padding(bottom = 20.dp),
                color = MaterialTheme.colors.onSurface,
                style = MaterialTheme.typography.h2
            )
            Spacer(modifier = Modifier.weight(1f))
        }

        val refreshScope = rememberCoroutineScope()
        var refreshing by remember { mutableStateOf(false) }
        var servicesList by remember { mutableStateOf(services)}

        fun refresh() = refreshScope.launch {
            refreshing = true
            delay(1500)
            servicesList = servicesList
            refreshing = false
        }

        val state = rememberPullRefreshState(refreshing, ::refresh)

        Box(Modifier.pullRefresh(state)) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if(!refreshing) {
                    items(servicesList) {
                        ServiceItem(service = it)
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
fun ServiceItem(modifier: Modifier = Modifier, service: Service) {
    Card(
        modifier = modifier
            .padding(8.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(2.dp, color = Color(0xFFFFFFFF))
    ) {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colors.surface)
                .width(280.dp)
                .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image (
                painter = painterResource(R.drawable.scissors),
                contentDescription = null,
                modifier = Modifier
                    .size(55.dp)
                    .padding(8.dp)
            )
            ServiceItemName(name = service.name)
            ServiceItemPrice(amount = service.amount)
            ServiceItemDescription(text = service.description)
        }
    }
}

@Composable
fun ServiceItemName(name: String) {
    Text (
        text = name,
        modifier = Modifier.padding(6.dp, bottom = 0.dp),
        color = MaterialTheme.colors.onSurface,
        style = MaterialTheme.typography.body1
    )
}

@Composable
fun ServiceItemPrice(amount: Number) {
    Text (
        text = stringResource(R.string.currency, amount),
        modifier = Modifier.padding(6.dp, top = 0.dp),
        color = MaterialTheme.colors.onSurface,
        style = MaterialTheme.typography.h3
    )
}

@Composable
fun ServiceItemDescription(text: String) {
    Text (
        text = text,
        modifier = Modifier.padding(6.dp),
        color = MaterialTheme.colors.onSurface,
        style = MaterialTheme.typography.body1
    )
}