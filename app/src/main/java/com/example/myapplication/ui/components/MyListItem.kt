package com.example.myapplication.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myapplication.ui.theme.Dimensions

@Composable
fun MyListItem(modifier: Modifier = Modifier, title: String, description: String, onItemClick: ()-> Unit) {
    Card(
        modifier = modifier
            .padding(top = Dimensions.smallPadding, start = Dimensions.smallPadding, end = Dimensions.smallPadding)
            .fillMaxWidth()
            .clickable {
                onItemClick()
            }
    ) {
        Column(modifier = modifier) {

            Text(
                modifier = Modifier.padding(vertical = Dimensions.smallPadding),
                text = title,
            )

            Text(
                modifier = Modifier.padding(vertical = Dimensions.smallPadding),
                text = description,
            )
        }
    }
}