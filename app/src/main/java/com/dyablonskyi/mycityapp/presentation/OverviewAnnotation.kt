package com.dyablonskyi.mycityapp.presentation

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview


@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    name = "Dark Theme",
    device = "spec:width=1080px,height=2340px,dpi=480"
)
annotation class DarkTheme

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    name = "Light Theme",
    device = "spec:width=1080px,height=2340px,dpi=480"
)
annotation class LightTheme