##  Stage 4/6: The shortest route
### Description
Now that our metro has gotten big, the passengers are finding it difficult to find their way around it. Your task is to create an application that can pave the route from one station to another, displaying all the necessary stations and transitions. The application must also find the path from one point to another so that people don't have to be stuck underground for too long.

In the previous step, our data structure looked like a Graph, and we need to use a special algorithm to find the shortest way from one point to another. In this case, let's use the **Breadth-First search algorithm** , which is really common and quite easy to understand.

### Objective
* Add a feature to search for a path with the command `/route "[line 1]" "[station 1]" "[line 2]" "[station 2]"`.
* The program should print every passed station and every transition.
For your updated metro map, you may use the real stations of [Prague Metro](https://en.wikipedia.org/wiki/Prague_Metro). Don't forget to [get the file](https://stepik.org/media/attachments/lesson/373079/prague_subway.json) with the station names!

### Examples
The greater-than symbol followed by a space > represents the user input. Note that it's not part of the input.

**Input file example**
```
{
    "Metro-Railway": {
        "3": {
            "name": "Baker street",
            "transfer": {
                "line": "Hammersmith-and-City",
                "station": "Baker street"
            }
        },
        "1": {
            "name": "Bishops-road",
            "transfer": null
        },
        "2": {
            "name": "Edgver road",
            "transfer": null
        }
    },
    "Hammersmith-and-City": {
        "2": {
            "name": "Westbourne-park",
            "transfer": null
        },
        "1": {
            "name": "Hammersmith",
            "transfer": null
        },
        "3": {
            "name": "Baker street",
            "transfer": {
                "line": "Metro-Railway",
                "station": "Baker street"
            }
        }
    }
}
```
**Example 1**
```
> java Main test-file.json
> /route Metro-Railway "Edgver road" Hammersmith-and-City Westbourne-park
Edgver road
Baker street
Transition to line Hammersmith-and-City
Baker street
Westbourne-park
> exit
```

**Example 2**
```
> java Main test-file.json
> /add Hammersmith-and-City "Test station"
> /output Hammersmith-and-City
depot - Hammersmith - Westbourne-park
Hammersmith - Westbourne-park - Test station
Westbourne-park - Test station - depot
> /exit
```
**Example 3**

```
> java Main test-file.json
> /remove Hammersmith-and-City Hammersmith
> /output Hammersmith-and-City
depot - Westbourne-park - depot
> /exit
```