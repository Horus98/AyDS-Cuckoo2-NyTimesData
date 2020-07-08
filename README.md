# New York Times Data.

## Descripción.
Dicha librería provee información de una película desde la fuente New York Times, la cual es una breve descripción de la misma, sumado al link de  una crítica completa.

## Métodos asociados.
**getMovieReview(title : String, year : String) : NyTimesReview**

La librería consta de un único método denominado getMovieReview, que recibe como parámetro el título de una película y el año de la misma. Dicho método retorna un objeto de tipo NyTimesReview, el cual posee los siguientes atributos : <br>
- Título.<br>
- Summary.<br>
- Link a una imagen representativa.<br>
- Link a la crítica completa.<br>

## Excepciones.

En caso de no encontrarse la review de la película solicitada se retornara un objeto **EmptyReview**, cuyos atributos son los mismo que de **NyTimesReview**, pero inicializados de la siguiente manera : 
- Titulo = "".
- Summary = "No Results".
- Link imagen = "https://www.shareicon.net/data/256x256/2016/06/25/618683_new_256x256.png".
- Link a crítica completa = "".

En caso de no poder realizar una conexión con el servicio externo se retornará Review Not Found.



