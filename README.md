# myrestaurant
Favorite restaurant and rate. Spring Boot API example.

Routes:

USERS
------------------
**GET**: /api/users
```
[
    {
        "id": 1,
        "name": "Parente"
    }
]
```

**POST**: /api/users
```
{
	"name":"Parente"
}
```

RESTAURANTS
------------------
**GET**: /api/restaurants
```
[
    {
        "id": 2,
        "name": "Restaurant Search Example",
        "ratesCount": 0
    }
]
```
**POST**: /api/restaurants
```
{
	"name":"Restaurant 1000 Example Creating"
}
```

**GET**: /api/restaurants/rate
```
{
    "id": 1,
    "name": "Restaurant 01",
    "ratesCount": 100
}
```
**POST**: /api/restaurants/rate
```
 {
      "restaurant": {
        "id" : "2"
      },
     "user": {
        "id" : "1"
      }
}
```
