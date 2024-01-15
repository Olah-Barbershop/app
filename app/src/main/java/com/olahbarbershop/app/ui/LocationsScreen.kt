package com.olahbarbershop.app.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.olahbarbershop.app.R
import com.olahbarbershop.app.data.Location
import com.olahbarbershop.app.data.locationList
import io.ktor.client.statement.HttpResponse

@Composable
fun LocationsScreen() {
    Column(
        Modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(R.string.locations),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp, bottom = 20.dp),
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.h1
        )
        LazyColumn(
            Modifier
                .background(MaterialTheme.colors.background)
                .fillMaxSize()
        ) {
            items(locationList) {
                LocationItem(location = it)
            }
        }
    }
}

@Composable
fun LocationItem(modifier: Modifier = Modifier, location: Location) {
    Card(
        modifier = Modifier
            .padding(8.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(2.dp, color = Color(0xFFFFFFFF))
    ) {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colors.surface)
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(0.dp)
            ) {
                LocationItemText(stringResource(R.string.address))
                Spacer(Modifier.weight(1f))
                LocationItemText(location.address)
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(0.dp)
            ) {
                LocationItemText(stringResource(R.string.phoneNumber))
                Spacer(Modifier.weight(1f))
                LocationItemText(location.phoneNumber)
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(0.dp)
            ) {
                LocationItemText(stringResource(R.string.businessHours))
                Spacer(Modifier.weight(1f))
                LocationBusinessHours(location = location, modifier = Modifier.weight(0.5f))
            }
        }
    }
}

@Composable
fun LocationBusinessHours(modifier: Modifier = Modifier, location: Location) {
    Column() {
        Row(
            Modifier
                .padding(0.dp)
        ) {
            BusinessHoursText(stringResource(R.string.monday))
            Spacer(Modifier.weight(0.5f))
            BusinessHoursText(location.mondayToThursday)
        }
        Row(
            Modifier
                .padding(0.dp)
        ) {
            BusinessHoursText(stringResource(R.string.tuesday))
            Spacer(Modifier.weight(0.5f))
            BusinessHoursText(location.mondayToThursday)
        }
        Row(
            Modifier
                .padding(0.dp)
        ) {
            BusinessHoursText(stringResource(R.string.wednesday))
            Spacer(Modifier.weight(0.5f))
            BusinessHoursText(location.mondayToThursday)
        }
        Row(
            Modifier
                .padding(0.dp)
        ) {
            BusinessHoursText(stringResource(R.string.thursday))
            Spacer(Modifier.weight(0.5f))
            BusinessHoursText(location.mondayToThursday)
        }
        Row(
            Modifier
                .padding(0.dp)
        ) {
            BusinessHoursText(stringResource(R.string.friday))
            Spacer(Modifier.weight(0.5f))
            BusinessHoursText(location.friday)
        }
        Row(
            Modifier
                .padding(0.dp)
        ) {
            BusinessHoursText(stringResource(R.string.saturday))
            Spacer(Modifier.weight(0.5f))
            BusinessHoursText(location.saturdayToSunday)
        }
        Row(
            Modifier
                .padding(0.dp)
        ) {
            BusinessHoursText(stringResource(R.string.sunday))
            Spacer(Modifier.weight(0.5f))
            BusinessHoursText(location.saturdayToSunday)
        }
    }
}

@Composable
fun LocationItemText(text: String) {
    Text (
        text = text,
        modifier = Modifier.padding(6.dp),
        color = MaterialTheme.colors.onSurface,
        style = MaterialTheme.typography.body1
    )
}

@Composable
fun BusinessHoursText(text: String) {
    Text (
        text = text,
        modifier = Modifier.padding(6.dp),
        color = MaterialTheme.colors.onSurface,
        style = MaterialTheme.typography.h3
    )
}