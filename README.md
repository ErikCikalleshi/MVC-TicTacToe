# MVC-TicTacToe
Technologie und Planung

## Prerequisites
* [Android Studio](https://developer.android.com/studio)

## Structure

Model: 

* Logic of TicTacToe Game
* Database
* Player-Entity-Data-Class
* Player-Data-Access-Object-Interface

View:

* Interface

Controller:

* MainActivity 

## Solution Approach

```
    companion object {
        lateinit var instance: MainActivity
        lateinit var db: AppDatabase
    }
```
**Static** für den Model

In der **onCreate()** Methode wird die Datenbank inizialisiert und das Spielfeld zu erstellen. 

## How to use

Predifined Users

![MaxMorit](max_moritz.gif)

With new players

![SecondScreen](new Player)

## Features

### Change Names

![change_names](change_names.gif)

**Remember**: Um den Spieler erfolgreich zu wechseln, muss man auf dem **+** Button klicken.

### Switch Player when winning

![Switch](secondGif.gif)

Auf Bedarf können Sie ihre Ergebnisse speichern, indem Sie auf "Save Result" klicken.

### See Results

![Switch](button.png)

Um die Ergebnisse zu sehen, können sie auf dem Button **History** klicken.

## Fazit
Man kann feststellen, dass Kotlin Java sehr ähnlich ist, aber die Syntax von Kotlin ist dennoch ungewohnt, wenn man immer mit Java programmiert hat. Für setOn... Actions, gibt es in Kotlin mehr Möglichkeiten als in Java. Insgesamt hatte ich keine großen Schwierigkeiten beim Programmieren, da Kotlin viele verschiedene Möglichkeiten bietet.
