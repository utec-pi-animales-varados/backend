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
	"name":"Christian",
	"lastName":"Ledgard",
	"email":"christian",
	"password":"123",
	"telephone":"1234",
	"mobilephone":"434134"
}
```

> Los campos telephone y mobilephone son opcionales

## Authenticate

*Ruta*: [/authenticate](http://107.180.91.147:8080/animales_varados-0.1/authenticate)  
*Método*: `POST`  
*JSON Body*:
```JSON
{
	"username":"christian",
	"password":"123"
}
```
La acción retornara un *JSONwebToken* con el que podran continuar su interración con el Backend.

## Animal

*Ruta*: [/animales](http://107.180.91.147:8080/animales_varados-0.1/animales)  
*Método*: `POST`  
*JSON Body*:
```JSON
{
	"name": "lobo marino",
	"color": "gris",
	"peso": "200"
}
```

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
	"date":"2000-10-10",
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
