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

```
    companion object {
        lateinit var instance: MainActivity
        lateinit var db: AppDatabase
    }
```
Die Globale Variablen:

```
private var id: Int = 0 //id to get the selected radio-button from the radio-group
private var list = arrayListOf<String>() //each calculation is in a ArrayList saved
private var sw_save: Boolean = false 
```
Die Funktion **onActions** ist für die Interaktion mit verschiedenen Schaltflächen, Schaltern, TextViews ... zuständig. 

* Jedes Mal, wenn Sie einen Radio-Button oder einen TextInput drücken, wird die **Operation()** Funktion aufgerufen.
* Mit **radioGroup.chechRadioButtonid** können Sie herausfinden, welcher Radiobutton ausgewählt wurde.
* Wenn die Schaltfläche "Historie" angeklickt wird, dann wird zum zweiten Bildschirm gesprungen und alle berechneten Listendaten werden zusammen mitgesendet + ob der Switch-Save-Result aktiviert ist 

```
 private fun onActions(radioGroup: RadioGroup, input1: TextView, input2: TextView, switch: Switch, button: Button) {
        //History-Button
        button.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("data", list)
            intent.putExtra("sw_save", sw_save)
            startActivity(intent)
        }

        //setOnAction...
        switch.setOnCheckedChangeListener{_, isChecked ->
            sw_save = isChecked
        }
        radioGroup.setOnCheckedChangeListener { _, _ ->
            id = radioGroup.checkedRadioButtonId
            operation()
        }

        input1.doOnTextChanged { _, _, _, _->
            operation()
        }
        input2.doOnTextChanged { _, _, _, _->
            operation()
        }
    }
```
Der **when**-Case von der **operation()**-Funktion wird verwendet, um die gewünschte Operation herauszufinden. Alles ist in einem **try-catch** verschachtelt, da nicht immer eine Zahl in ein Eingabefeld eingegeben wird.

```
 private fun operation() {
        val result = findViewById<TextView>(R.id.res)
        var res = 0.0
        try {
            when (findViewById<RadioButton>(id).text) {
                "Addition" -> {
                    res = findViewById<TextView>(R.id.nr1).text.toString().toDouble() + findViewById<TextView>(R.id.nr2).text.toString().toDouble()
                    save("+", res)
                }
                ...
            }
            //print result
            result.text = res.toString()
        } catch (e: Exception) {
            println(e)
        }
```
Wenn der Switch-Button aktiviert ist, wird das Ergebnis in die Liste hinzugefügt.

```
 private fun save(s: String, res: Double) {
        if (sw_save){
            list.add(findViewById<TextView>(R.id.nr1).text.toString() + s + findViewById<TextView>(R.id.nr2).text.toString() + " = " + res.toString())
        }
    }
```
Der zweite Screen besteht aus einer ScrollView mit einem LinearLayout. 
```
val receivedData : ArrayList<String>? = intent.getStringArrayListExtra("data")
val sw_save : Boolean = intent.getBooleanExtra("sw_switch", true)

if(receivedData != null){
    for (string in receivedData){
        val value = TextView(this)
        value.textSize = 15f
        value.text = string
        findViewById<LinearLayout>(R.id.linear).addView(value)
    }
}

findViewById<Button>(R.id.button2).setOnClickListener{
    val intent = Intent(this, MainActivity::class.java)
    intent.putExtra("data", receivedData)
    intent.putExtra("sw_save", sw_save)
    startActivity(intent)
}
```
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
