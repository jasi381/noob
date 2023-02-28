package com.example.pregame

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pregame.Utils.Common
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabView() {

    val pagerState = rememberPagerState()
    val currentPage = pagerState.currentPage
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TabRow(
            selectedTabIndex = currentPage,
            backgroundColor = Common.navyBlue,
            contentColor = Color.White
        )


        {
            tabList.forEachIndexed { index, tabData ->
                Tab(
                    selected = currentPage == index, onClick = {
                        //cant directly pass animated scroll we put in scope
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    modifier = Modifier
                        .padding(10.dp),
                ) {
                    Text(text = tabList[index].tab)
                }
            }
        }
        HorizontalPager(count = tabList.size, state = pagerState
        ) { index ->
            Text(text = tabList[index].des)
        }

    }

}

data class TabData(
    val tab: String,
    val des: String,
)

val tabList = listOf(
    TabData(
        "Stats",
        "This is Stats"
    ),
    TabData(
        "Insights",
        "This is Insight"
    ),
    TabData(
        "Related",
        "This is Related"
    ),
    TabData(
        "Bet+",
        "This is Bet"
    ),
)
