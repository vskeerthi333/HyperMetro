##Stage 3/6: A real metro
###Description
Our metro is growing, and now it is time to combine the different lines into a single underground system. In places where the lines connect, there are large interchange stations where people can cross from one line to another. Our program should store such interchange stations and which line they connect to.

In order to store this kind of data, we need to add a new field to the item class which is a pointer to another station (to store several stations, it should be an array). This upgrade will allow us to connect the lines and make the metro a more advanced system.

A corresponding field has to be added to the JSON file, as well. Its name is "transfer" and its value is either the name of the line and the station, or null if there are no transfer stations.

###Objective
* Add the ability to read transfer the stations from a JSON file:
```
{
    "Metro-Railway": {
        "3": {
            "name": "Baker street",
            "transfer": [{
                "line": "Hammersmith-and-City",
                "station": "Baker street"
            }]
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
            "transfer": [{
                "line": "Metro-Railway",
                "station": "Baker street"
            }]
        }
    }
}
```
* Connect the stations using the command ` /connect "[line 1]" "[station 1]" "[line 2]" "[station 2]"`.
* The program should print the name of the connected station.

For your updated metro map, you may use the real stations of [Prague Metro](https://en.wikipedia.org/wiki/Prague_Metro). Don't forget to [get the file](https://stepik.org/media/attachments/lesson/373079/prague_subway.json) with the station names!

###Examples
The greater-than symbol followed by a space `>` represents the user input. Note that it's not part of the input.

**Input file example**
```
{
    "Metro-Railway": {
        "3": {
            "name": "Baker street",
            "transfer": [{
                "line": "Hammersmith-and-City",
                "station": "Baker street"
            }]
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
            "transfer": [{
                "line": "Metro-Railway",
                "station": "Baker street"
            }]
        }
    }
}
```
**Example**
```
> java Main test-file.json
> /output Hammersmith-and-City
depot
Hammersmith
Westbourne-park
Baker-street - Baker-street (Metro-Railway line)
depot
> /connect Hammersmith-and-City Hammersmith Metro-Railway "Edgver road"
> /output Hammersmith-and-City
depot
Hammersmith - Edgver road (Metro-Railway line)
Westbourne-park
Baker-street - Baker-street (Metro-Railway line)
depot
```
