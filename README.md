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

## Solution approach

Das Programm wurde mit einem Zweidimensionalen-Array geschrieben.

```
private var buttons = arrayOf<ArrayList<Button>>(arrayListOf(), arrayListOf(), arrayListOf())

for (row in 0..2) {
            for (col in 0..2) {
                val buttonId = "button$row$col"
                val resId = resources.getIdentifier(buttonId, "id", packageName)
                buttons[row].add(findViewById(resId))
                buttons[row][col].setOnClickListener { v ->
                    onClicked(v)
                }
            }
        }

```
Das Spielfeld ist ein TableLayout und die einzelne Spielfelder wurden mit Buttons realisiert, die nur auf dem Border gefärbt sind. (siehe border.xml)

```
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android" android:shape="rectangle">
    <stroke android:color="@color/black" android:width="1dp" />
    <solid android:color="@android:color/transparent" />
</shape>

```


## How to use

Predifined Users

![MaxMoritz](max_moritz.gif)

With new players

![SecondScreen](new_player.gif)

## Features

### Change Names

![change_names](change_names.gif)

**Remember**: Um den Spieler erfolgreich zu wechseln, muss man auf dem **+** Button klicken.

### Switch Player when winning

![Switch](switch_player.gif)

