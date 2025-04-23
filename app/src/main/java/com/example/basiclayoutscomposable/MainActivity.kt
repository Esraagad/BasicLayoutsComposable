package com.example.basiclayoutscomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiclayoutscomposable.ui.theme.BasicLayoutsComposableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicLayoutsComposableTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    SearchBar(modifier = Modifier.fillMaxWidth())
//                    AlignYourBodyElement(modifier = Modifier.padding(8.dp), drawable = R.drawable.ab1_inversions, text = R.string.ab1_inversions)
//                    FavoriteCollectionCard(
//                        modifier = Modifier.padding(innerPadding),
//                        drawable = R.drawable.fc1_short_mantras,
//                        text = R.string.fc1_short_mantras
//                    )
                    AlignYourBodyRow(Modifier)
                }
            }
        }
    }
}

@Composable
fun SearchBar(modifier: Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface
        ),
        placeholder = {
            Text(stringResource(R.string.placeholder_search))
        }
    )
}

@Composable
fun AlignYourBodyElement(
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int,
    @StringRes text: Int
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(drawable),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
}

@Composable
fun AlignYourBodyRow(modifier: Modifier = Modifier) {
    LazyRow(modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(drawable = item.drawable, text = item.text)
        }
    }
}

@Composable
fun FavoriteCollectionCard(modifier: Modifier, @DrawableRes drawable: Int, @StringRes text: Int) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(255.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier.size(80.dp)
            )
            Text(text = stringResource(text), style = MaterialTheme.typography.titleMedium)
        }
    }
}

//@Preview
@Composable
fun SearchBarPreview(showBackground: Boolean = true, backgroundColor: Long = 0xFFF5F0EE) {
    BasicLayoutsComposableTheme {
        Scaffold { innerPadding ->
            SearchBar(modifier = Modifier.padding(innerPadding))
        }
    }

}

//@Preview
@Composable
fun AlignYourBodyElementPreview(
    showBackground: Boolean = true, backgroundColor: Long = 0xFFF5F0EE
) {
    BasicLayoutsComposableTheme {
        AlignYourBodyElement(
            modifier = Modifier.padding(8.dp),
            drawable = R.drawable.ab1_inversions,
            text = R.string.ab1_inversions
        )
    }
}

@Preview
@Composable
fun AlignYourBodyRowPreview(
    showBackground: Boolean = true, backgroundColor: Long = 0xFFF5F0EE
) {
    BasicLayoutsComposableTheme {
        AlignYourBodyRow(
            modifier = Modifier
        )
    }
}

//@Preview
@Composable
fun FavoriteCollectionCardPreview(
    showBackground: Boolean = true,
    backgroundColor: Long = 0xFFF5F0EE
) {
    BasicLayoutsComposableTheme {
        FavoriteCollectionCard(
            modifier = Modifier.padding(8.dp),
            drawable = R.drawable.fc1_short_mantras,
            text = R.string.fc1_short_mantras
        )
    }
}

private val alignYourBodyData = listOf(
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
    R.drawable.ab3_stretching to R.string.ab3_stretching,
    R.drawable.ab4_tabata to R.string.ab4_tabata,
    R.drawable.ab5_hiit to R.string.ab5_hiit,
    R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
).map { DrawableStringPair(it.first, it.second) }

private val favoriteCollectionsData = listOf(
    R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
    R.drawable.fc4_self_massage to R.string.fc4_self_massage,
    R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
    R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down
).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)