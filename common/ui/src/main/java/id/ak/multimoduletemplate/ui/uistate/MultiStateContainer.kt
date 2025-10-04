package id.ak.multimoduletemplate.ui.uistate

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DefaultLoadingState(modifier: Modifier = Modifier) {
    CircularProgressIndicator(modifier = modifier)
}

@Composable
fun DefaultErrorState(modifier: Modifier = Modifier, errorMessage: String? = null) {
    Text(text = errorMessage ?: "An error occurred", modifier = modifier)
}

@Composable
fun <T : Any> MultiStateContainer(
    uiState: UiState<T>,
    modifier: Modifier = Modifier,
    loadingState: @Composable () -> Unit = { DefaultLoadingState(modifier = modifier) },
    errorState: @Composable (String) -> Unit = { DefaultErrorState(modifier = modifier) },
    defaultContent: @Composable (T) -> Unit
) {
    Box(modifier = modifier) {
        Crossfade(targetState = uiState) {
            when (it) {
                UiState.Loading -> loadingState()
                is UiState.Success -> defaultContent(it.data)
                is UiState.Error -> {
                    errorState(it.message)
                    it.exception?.printStackTrace()
                }

                else -> {}
            }
        }
    }
}