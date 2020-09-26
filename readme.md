# Detetive

This project is the implementation from the notes block from the [`Detetive` game from Estrela®](https://www.estrela.com.br/detetive/p).
If you live outside from Brazil, you may know this game by the name of `Clue`.

## Rules

The game rules implemented in this app are pretty simple.
The game has three types of cards: weapons, locations and characters.

On the start of the game you have to pick a random card from each type and this will be the crime that
the players need to discover.

This app helps you to keep tracking from the cards you know or guess by keeping notes from their states.
The possible states are: Unknown, Hand, Envelop (Secret), Maybe Hand, and Maybe Envelop.
You can also add some observation to help you discover the person that has that card.

## Technology

This project was a study project for the following technologies:

* Jetpack Compose
* Jetpack Navigation
* Koin

It was also a test for a modification from the Clean Architecture.
In this project we have the following structure:

1. View
    - Render the screens
    - Compose by:
        - Activity
        - Fragment
        - Components (Compose components that can be reuse)
        - Container (Groups of components that compose a screen)
2. ViewModel
    - Receive the dispatched actions from the view and execute it with some usecase
    - Works on a MVI style
        - Receives an action
        - Updates the state
    - Composed by:
        - Lifecycle ViewModel
3. UseCase
    - Perform some action. Generaly connects a ViewModel with the repository.
4. Repository
    - Connects to the data sources to to provide some data to the other layers
5. Datasources
    - Retrieve and update data
    - It can be a remote (like a web service) or local (like a cache) datasource

The dependency injection was made with koin and each module is a global variable that is included in the
library init.

The navigation is made by the jetpack navigation library. Even though the recomendadion is to have
only composable components that are rendered and use them to navigate, in this first version we are using
it to show composable fragments and dialogs.
