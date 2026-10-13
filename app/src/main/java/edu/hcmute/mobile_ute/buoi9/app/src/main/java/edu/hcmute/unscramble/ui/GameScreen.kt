package edu.hcmute.unscramble.ui



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.activity.compose.LocalActivity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.hcmute.unscramble.R
import edu.hcmute.unscramble.data.MAX_NO_OF_WORDS

@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    gameViewModel: GameViewModel = viewModel()
) {
    val gameUiState by gameViewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            .safeDrawingPadding()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.headlineMedium
        )
        GameLayout(
            currentScrambledWord = gameUiState.currentScrambledWord,
            wordCount = gameUiState.currentWordCount,
            userGuess = gameViewModel.userGuess,
            isGuessWrong = gameUiState.isGuessedWordWrong,
            onUserGuessChanged = { gameViewModel.updateUserGuess(it) },
            onKeyboardDone = { gameViewModel.checkUserGuess() },
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { gameViewModel.checkUserGuess() }
            ) { Text(stringResource(R.string.submit)) }

            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { gameViewModel.skipWord() }
            ) { Text(stringResource(R.string.skip)) }
        }
        Text(
            text = stringResource(R.string.score, gameUiState.score),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(top = 16.dp)
        )
    }

    if (gameUiState.isGameOver) {
        FinalScoreDialog(
            score = gameUiState.score,
            onPlayAgain = { gameViewModel.resetGame() }
        )
    }
}

@Composable
fun GameLayout(
    currentScrambledWord: String,
    wordCount: Int,
    userGuess: String,
    isGuessWrong: Boolean,
    onUserGuessChanged: (String) -> Unit,
    onKeyboardDone: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.word_count, wordCount, MAX_NO_OF_WORDS),
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                text = currentScrambledWord,
                style = MaterialTheme.typography.displayMedium
            )
            Text(
                text = stringResource(R.string.instructions),
                style = MaterialTheme.typography.titleMedium
            )
            OutlinedTextField(
                value = userGuess,
                onValueChange = onUserGuessChanged,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(
                        if (isGuessWrong) stringResource(R.string.error_word)
                        else stringResource(R.string.label_word)
                    )
                },
                isError = isGuessWrong,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = { onKeyboardDone() })
            )
        }
    }
}

@Composable
fun FinalScoreDialog(score: Int, onPlayAgain: () -> Unit) {
    val activity = LocalActivity.current
    AlertDialog(
        onDismissRequest = {},
        title = { Text(stringResource(R.string.congratulations)) },
        text = { Text(stringResource(R.string.you_scored, score)) },
        dismissButton = {
            TextButton(onClick = { activity?.finish() }) {
                Text(stringResource(R.string.exit))
            }
        },
        confirmButton = {
            TextButton(onClick = onPlayAgain) {
                Text(stringResource(R.string.play_again))
            }
        }
    )
}