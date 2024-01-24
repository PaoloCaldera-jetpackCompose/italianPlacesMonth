package com.example.italianplacesmonth

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.italianplacesmonth.ui.theme.ItalianPlacesMonthTheme
import org.junit.Rule
import org.junit.Test

class MainActivityTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun placesList_displayClosed() {
        composeTestRule.setContent {
            ItalianPlacesMonthTheme {
                MainActivityLayout()
            }
        }

        composeTestRule.onNodeWithText("Basilica di San Pietro")
            .assertExists("No node found with text 'Basilica di San Pietro'")
        composeTestRule.onNodeWithText("Day 2")
            .assertExists("No node found with text 'Day 2'")
        composeTestRule.onNodeWithText("Roma, Lazio (1506)")
            .assertDoesNotExist()
    }

    @Test
    fun placesList_openCard_displayTextAndImage() {
        composeTestRule.setContent {
            ItalianPlacesMonthTheme {
                MainActivityLayout()
            }
        }

        composeTestRule.onNodeWithText("Basilica di San Pietro")
            .assertExists("No node found with text 'Basilica di San Pietro'")

        composeTestRule.onNodeWithText("Basilica di San Pietro").performClick()

        composeTestRule.onNodeWithText("Roma, Lazio (1506)")
            .assertExists("No node found with text 'Roma, Lazio (1506)'")
        composeTestRule.onNodeWithContentDescription("Basilica di San Pietro")
            .assertExists("No node found with content description 'Basilica di San Pietro'")
        composeTestRule.onNodeWithText("Day 2")
            .assertDoesNotExist()
    }
}