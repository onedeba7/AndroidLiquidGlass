package com.github.debacodex.backdrop.catalog

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.github.debacodex.backdrop.catalog.destinations.AdaptiveLuminanceGlassContent
import com.github.debacodex.backdrop.catalog.destinations.BottomTabsContent
import com.github.debacodex.backdrop.catalog.destinations.ButtonsContent
import com.github.debacodex.backdrop.catalog.destinations.ControlCenterContent
import com.github.debacodex.backdrop.catalog.destinations.DialogContent
import com.github.debacodex.backdrop.catalog.destinations.GlassPlaygroundContent
import com.github.debacodex.backdrop.catalog.destinations.HomeContent
import com.github.debacodex.backdrop.catalog.destinations.LazyScrollContainerContent
import com.github.debacodex.backdrop.catalog.destinations.LockScreenContent
import com.github.debacodex.backdrop.catalog.destinations.MagnifierContent
import com.github.debacodex.backdrop.catalog.destinations.ProgressiveBlurContent
import com.github.debacodex.backdrop.catalog.destinations.ScrollContainerContent
import com.github.debacodex.backdrop.catalog.destinations.SliderContent
import com.github.debacodex.backdrop.catalog.destinations.ToggleContent

@Composable
fun MainContent() {
    var destination by rememberSaveable { mutableStateOf(CatalogDestination.Home) }

    BackHandler(destination != CatalogDestination.Home) {
        destination = CatalogDestination.Home
    }

    when (destination) {
        CatalogDestination.Home -> HomeContent(onNavigate = { destination = it })

        CatalogDestination.Buttons -> ButtonsContent()
        CatalogDestination.Toggle -> ToggleContent()
        CatalogDestination.Slider -> SliderContent()
        CatalogDestination.BottomTabs -> BottomTabsContent()
        CatalogDestination.Dialog -> DialogContent()

        CatalogDestination.LockScreen -> LockScreenContent()
        CatalogDestination.ControlCenter -> ControlCenterContent()
        CatalogDestination.Magnifier -> MagnifierContent()

        CatalogDestination.GlassPlayground -> GlassPlaygroundContent()
        CatalogDestination.AdaptiveLuminanceGlass -> AdaptiveLuminanceGlassContent()
        CatalogDestination.ProgressiveBlur -> ProgressiveBlurContent()
        CatalogDestination.ScrollContainer -> ScrollContainerContent()
        CatalogDestination.LazyScrollContainer -> LazyScrollContainerContent()
    }
}
