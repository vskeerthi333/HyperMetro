##Stage 2/6: Several directions
###Description
It's time to expand our metro! To provide the citizens with more efficient transportation, we will extend our existing metro line and start a new one. Since now we will have several lines, there should be a possibility to choose which one to use. Also, let's not forget that trains go both directions (except for the end stations). In this case, it makes sense to use a linked list with access to the previous element: a **doubly-linked list**. Its main feature, as you might have guessed, is that each element stores pointers to both the previous and the next element.

Since the file stores not just one metro line but two, it is easier to organize the data by splitting it up between the two lines. In this case, we use a JSON file. It is a popular data-interchange format consisting of a map, where a key is a string type and a value can be any type. A key is separated from a value by a colon, and different key-value pairs are separated by a comma. You can find a comprehensive [JSON tutorial at qhmit.com](https://qhmit.com/json/tutorial/). By default, Java has no functionality to work with the JSON format, but Google made a special library `GSON`, which you can use in this project: see [zetcode.com for more information on GSON](http://zetcode.com/java/gson/).

###Objective
* Switch to using a JSON file instead of a simple text file.
* Add new stations in the given order:
```
{
    "line 1": {
        "3": "station3",
        "1": "station 1",
        "2": "station 2"
    },
    "line 2": {
        "2": "station 2",
        "1": "station 1"
    }
}
```
* The program should have the following commands: `/append "[line name]" "[station name]"`, `/add-head "[line name]" "[station name]"`, and `/remove "[line name]" "[station name]"`. Append adds a new station at the end and of the line, while add-head adds a new station at the beginning. Note that if the name of the line or station consists of several words, you should write it in quotation marks (after, they should be excluded from the name).
* The program should print a line that has been chosen with the command `/print "[line name]"`.
* The program should handle incorrect format of the file records and output the message `Incorrect file`.
* Also, your program should handle incorrect format of the command and print the message `Invalid command`.
* Add a special command `/exit` to finish the work of the program.

For your updated metro map, you may use the real stations of [Lausanne Subway](https://en.wikipedia.org/wiki/Lausanne_Métro):

```
{
    "m1": {
        "1": "Renes-Gare",
        "2": "Epenex",
        "3": "Crochy",
        "4": "Cerisaie",
        "5": "Bassenges",
        "6": "EPFL",
        "7": "UNL-Sorge",
        "8": "Mouline",
        "9": "UNL-Chemberonne",
        "10": "Bourdonnette",
        "11": "Melley",
        "12": "Provence",
        "13": "Montelly",
        "14": "Vigie",
        "15": "Lausanne-Flon"
    },
        "m2":{
        "1":"Croisettes",
        "2":"Vennes",
        "3": "Fourmi",
        "4": "Sallaz",
        "5":"CHUV",
        "6":"Ours",
        "7":"Riponne M.Bejart",
        "8":"Bessieres",
        "9":"Lausanne-Flon",
        "10":"Lausanne Gare CFF",
        "11":"Grancy",
        "12": "Delices",
        "13":"Jourdils",
        "14": "Ouchy-Olympique"
    }
}
```
###Examples
The greater-than symbol followed by a space (`>`) represents the user input. Note that it's not part of the input.

####Input file example

```
{
    "Metro-Railway": {
        "3": "Baker Street",
        "1": "Bishops-road",
        "2": "Edgver road",
        "6": "Kings cross",
        "4": "Portland road",
        "5": "Gower street",
        "7": "Farringdon street"
    },
    "Hammersmith-and-City": {
        "2": "Westbourne-park",
        "1": "Hammersmith"
    }
}
```
####Example 1

```
> java Main test-file.json
> /output Hammersmith-and-City
depot - Hammersmith - Westbourne-park
Hammersmith - Westbourne-park - destination
> /exit
```
####Example 2

```
> java Main test-file.json
> /add Hammersmith-and-City "Test station"
> /output Hammersmith-and-City
depot - Hammersmith - Westbourne-park
Hammersmith - Westbourne-park - Test station
Westbourne-park - Test station - depot
> /exit
```
####Example 3
```
> java Main test-file.json
> /remove Hammersmith-and-City Hammersmith
> /output Hammersmith-and-City
depot - Westbourne-park - depot
> /exit
```