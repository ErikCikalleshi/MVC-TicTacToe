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
Braucht man für dem Model

In der **onCreate()** Methode wird die Datenbank inizialisiert und das Spielfeld zu erstellen. 
Die **checkDuplicate()** sucht in der Datenbank für Duplikate und wenn es keine findet, dann werden die Spieler hinzugefügt.

* Jedes Mal, wenn Sie einen Radio-Button oder einen TextInput drücken, wird die **Operation()** Funktion aufgerufen.
* Mit **radioGroup.chechRadioButtonid** können Sie herausfinden, welcher Radiobutton ausgewählt wurde.
* Wenn die Schaltfläche "Historie" angeklickt wird, dann wird zum zweiten Bildschirm gesprungen und alle berechneten Listendaten werden zusammen mitgesendet + ob der Switch-Save-Result aktiviert ist 

## How to use

Wählen Sie eine Operation aus und geben Sie zwei Zahlen ein.

![FirstScreen](firstGif.gif)

![SecondScreen](thirdGif.gif)

## Features

![Features](firstPic.png)

### Save Result

![Switch](secondGif.gif)

Auf Bedarf können Sie ihre Ergebnisse speichern, indem Sie auf "Save Result" klicken.

### See Results

![Switch](button.png)

Um die Ergebnisse zu sehen, können sie auf dem Button **History** klicken.

## Fazit
Man kann feststellen, dass Kotlin Java sehr ähnlich ist, aber die Syntax von Kotlin ist dennoch ungewohnt, wenn man immer mit Java programmiert hat. Für setOn... Actions, gibt es in Kotlin mehr Möglichkeiten als in Java. Insgesamt hatte ich keine großen Schwierigkeiten beim Programmieren, da Kotlin viele verschiedene Möglichkeiten bietet.
