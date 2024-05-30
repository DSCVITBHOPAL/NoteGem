package com.gdsc_vitbhopal.notegem.controller.calendar

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.*
import androidx.glance.action.clickable
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.appwidget.cornerRadius
import androidx.glance.appwidget.lazy.LazyColumn
import androidx.glance.layout.*
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextAlign
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import com.gdsc_vitbhopal.notegem.app.getString
import com.gdsc_vitbhopal.notegem.controller.glance_widgets.AddEventAction
import com.gdsc_vitbhopal.notegem.controller.glance_widgets.GoToSettingsAction
import com.gdsc_vitbhopal.notegem.controller.glance_widgets.NavigateToCalendarAction
import com.gdsc_vitbhopal.notegem.controller.glance_widgets.RefreshCalendarAction
import com.gdsc_vitbhopal.notegem.domain.model.CalendarEvent
@Composable
fun CalendarHomeScreenWidget(
    events: Map<String, List<CalendarEvent>>,
    permissionGranted: Boolean
) {
    Box(
        modifier = GlanceModifier
            .fillMaxWidth()
            .background(ImageProvider(com.gdsc_vitbhopal.notegem.R.drawable.large_item_rounded))
            .cornerRadius(25.dp)
    ) {
        Column(
            modifier = GlanceModifier
                .clickable(onClick = actionRunCallback<NavigateToCalendarAction>())
                .padding(8.dp)
        ) {
            Row(
                GlanceModifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    getString(com.gdsc_vitbhopal.notegem.R.string.calendar),
                    style = TextStyle(
                        color = ColorProvider(Color.White),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    ),
                    modifier = GlanceModifier.padding(horizontal = 8.dp),
                )
                Row(
                    modifier = GlanceModifier.fillMaxWidth().padding(horizontal = 8.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Button(
                        text = "",
                        modifier = GlanceModifier
                            .size(22.dp)
                            .background(ImageProvider(com.gdsc_vitbhopal.notegem.R.drawable.ic_refresh))
                            .padding(8.dp)
                        ,
                        onClick = actionRunCallback<RefreshCalendarAction>()
                    )
                    Spacer(GlanceModifier.width(12.dp))
                    Button(
                        text = "",
                        modifier = GlanceModifier
                            .size(22.dp)
                            .background(ImageProvider(com.gdsc_vitbhopal.notegem.R.drawable.ic_add))
                            .padding(8.dp)
                        ,
                        onClick = actionRunCallback<AddEventAction>()
                    )
                }
            }
            Spacer(GlanceModifier.height(8.dp))
//                    println("granted:::: $permissionGranted")
                    if (permissionGranted) {
                        LazyColumn(
                            modifier = GlanceModifier
                                .fillMaxSize()
                                .background(ImageProvider(com.gdsc_vitbhopal.notegem.R.drawable.large_inner_item_rounded))
                                .cornerRadius(20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            if (events.isEmpty()) {
                                item {
                                    Text(
                                        text = getString(com.gdsc_vitbhopal.notegem.R.string.no_events),
                                        modifier = GlanceModifier.padding(16.dp),
                                        style = TextStyle(
                                            color = ColorProvider(Color.White),
                                            fontWeight = FontWeight.Normal,
                                            fontSize = 18.sp
                                        )
                                    )
                                }
                            } else {
                                item { Spacer(GlanceModifier.height(6.dp))}
                                events.forEach { (day, events) ->
                                    item {
                                        Column(
                                            modifier = GlanceModifier
                                                .fillMaxWidth()
                                                .padding(start = 4.dp, end = 4.dp)
                                        ) {
                                            Text(
                                                text = day,
                                                style = TextStyle(
                                                    color = ColorProvider(Color.White),
                                                    fontWeight = FontWeight.Normal,
                                                    fontSize = 14.sp
                                                ),
                                                modifier = GlanceModifier.padding(bottom = 3.dp)
                                            )
                                            events.forEach { event ->
                                                CalendarEventWidgetItem(event = event)
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        Column(
                            modifier = GlanceModifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = getString(com.gdsc_vitbhopal.notegem.R.string.no_read_calendar_permission_message),
                                modifier = GlanceModifier.padding(16.dp),
                                style = TextStyle(
                                    textAlign = TextAlign.Center
                                )
                            )
                            Spacer(GlanceModifier.height(4.dp))
                            Button(
                                text = getString(com.gdsc_vitbhopal.notegem.R.string.go_to_settings),
                                onClick = actionRunCallback<GoToSettingsAction>()
                            )
                            Spacer(GlanceModifier.height(4.dp))
                            Text(
                                text = getString(com.gdsc_vitbhopal.notegem.R.string.calendar_widget_refresh_message),
                                modifier = GlanceModifier.padding(12.dp),
                                style = TextStyle(
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                    }
                }
            }
        }