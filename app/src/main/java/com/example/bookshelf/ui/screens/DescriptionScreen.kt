package com.example.bookshelf.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.bookshelf.R
import com.example.bookshelf.model.VolumeInfo
import com.example.bookshelf.ui.BooksViewModel
import com.example.bookshelf.ui.DescriptionStatus
import com.example.bookshelf.ui.theme.BookShelfTheme
import kotlinx.coroutines.launch

@Composable
fun DescriptionScreen(
    viewModel: BooksViewModel,
    modifier: Modifier = Modifier,
) {

    LaunchedEffect(Unit) {
        viewModel.fetchBookById(viewModel.bookId)
    }

    var descriptionStatus = viewModel.descriptionStatus


    when(descriptionStatus){
        is DescriptionStatus.Loading -> {
            LoadingScreen()
        }
        is DescriptionStatus.Error -> {
            ErrorScreen()
        }
        is DescriptionStatus.Success -> {
            DescriptionSuccessScreen(
                receivedBookData = descriptionStatus.receivedBookData,
                modifier = modifier,
            )
        }
    }
}



@Composable
fun DescriptionSuccessScreen(
    receivedBookData: VolumeInfo,
    modifier : Modifier,
){
    Surface(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(state = rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AsyncImage(
                model = receivedBookData .imageLinks.thumbnail,
                contentDescription = "Book thumbnail",
                error = painterResource(R.drawable.error),
                modifier = modifier
                    .height(400.dp)
                    .fillMaxSize(),
            )

            ContentSpacer(modifier)

            Text(
                text = "Title:",
                fontSize = 40.sp,
                textAlign = TextAlign.Center,
            )

            ContentSpacer(modifier)

            Text(
                text = receivedBookData.title,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                lineHeight = 40.sp
            )

            ContentSpacer(modifier)

            Text(
                text = "Authors:",
                fontSize = 40.sp,
                textAlign = TextAlign.Center,
            )

            ContentSpacer(modifier)

            receivedBookData.authors.forEach{ author ->
                Text(
                    text = author,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    )
            }
        }
    }
}


@Composable
fun ContentSpacer(
    modifier : Modifier,
){
    Spacer(
        modifier = modifier
            .height(20.dp)
    )
}

//@Preview
//@Composable
//fun DescriptionScreenPreview() {
//    BookShelfTheme {
//        DescriptionSuccessScreen()
//    }
//}