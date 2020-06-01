# Backend Animales Varados

El servidor se encuentra alojado en la siguiente URI:

http://107.180.91.147:8080/animales_varados-0.1/

Todas las rutas excepto */signup* y */authenticate* se encuentra protegidas por *JSONwebTokens*.

## Signup

*Ruta*: [/signup](http://107.180.91.147:8080/animales_varados-0.1/signup)  
*Método*: `POST`  
*JSON Body*:  
```JSON
{
	"deviceId":"3a43ADF",
	"name":"Christian",
	"lastName":"Ledgard",
	"email":"christian",
	"password":"123",
	"telephone":"1234",
	"mobilephone":"434134"
}
```

> Todos los campos menos deviceId son opcionales.

## Authenticate

*Ruta*: [/authenticate](http://107.180.91.147:8080/animales_varados-0.1/authenticate)  
*Método*: `POST`  
*JSON Body*:
```JSON
{
	"email":"christian",
	"password":"123"
}
```
La acción retornara el usuarioId y un *JSONwebToken* con el que podrán continuar su interacción con el Backend.

## Authenticate Guest

*Ruta*: [/authenticateGuest](http://107.180.91.147:8080/animales_varados-0.1/authenticateGuest)  
*Método*: `POST`  
*JSON Body*:
```JSON
{
	"deviceId":"asva123s"
}
```
La acción retornara el usuarioId y un *JSONwebToken* con el que podrán continuar su interacción con el Backend.

## Animal

*Ruta*: [/animales](http://107.180.91.147:8080/animales_varados-0.1/animales)  
*Método*: `POST`  
*JSON Body*:
```JSON
{
	"name": "lobo marino",
	"color": "gris"
}
```

*Ruta*: [/animales](http://107.180.91.147:8080/animales_varados-0.1/animales)  
*Método*: `GET`  
> Retornara un JSON con la lista de todos los animales actualmente registrados.

*Ruta*: [/animales/{id}](http://107.180.91.147:8080/animales_varados-0.1/animales/{id})  
*Método*: `PUT`  
*JSON Body*:
```JSON
{
	"name": "lobo marino",
	"color": "gris"
}
```

*Ruta*: [/animales/{id}](http://107.180.91.147:8080/animales_varados-0.1/animales/{id})  
*Método*: `GET`  
> Retornara un JSON con los datos de un animal en especifico.

## Pregunta
Para crear una pregunta, debes tener el texto de la pregunta.

*Ruta*: [/preguntas](http://107.180.91.147:8080/animales_varados-0.1/preguntas)  
*Método*: `POST`  
*JSON Body*:
```JSON
{
	"name": "lobo marino",
	"color": "gris",
	"peso": "200"
}
```

## Reporte
Para crear un reporte, deberás de tener un animal y una pregunta en la DB.

*Ruta*: [/reportes](http://107.180.91.147:8080/animales_varados-0.1/reportes)  
*Método*: `POST`  
*JSON Body*:
```JSON
{
	"date":"2020-05-18T16:04:49.122+0000",
	"latitude":10.0,
	"comment": "esto es un comentario",
	"longitude":10.0,
	"picturesURLs": [
		"google.com",
		"unaimagen.com"
		],
	"animal":{
		"id":1
	},
	"usuario":{
		"id":1
	},
	"respuestas": [
            {
                "textoRespuesta": "esto es una respuesta con otro id nueva",
                "pregunta": {
                    "id": 1
                }
            },
            {
                "textoRespuesta": "new answer",
                "pregunta": {
                    "id": 1
                }
            },
            {
                "textoRespuesta": "esto es una respuesta",
                "pregunta": {
                    "id": 1
                }
            }
    ]
}
```

> El campo comentario es opcional.
