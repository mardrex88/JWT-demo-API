# JWT-demo-API
Ejercicio 1 JWT-demo-API springboot

Solucion a la tarea.

1. En la funcion login y validamos username y contraseña para poder generar y retornar el token.
2. Tambien adicionamos la funcion register que permite crear un registro de usuario en la BD
 ![image](https://user-images.githubusercontent.com/36330412/171532428-8f90192f-88b0-4209-8732-88fa1e7a4bf5.png)

3. Agregamos los endpont que no deberian tener restriccion de acceso.
![image](https://user-images.githubusercontent.com/36330412/171531916-eb6bbb52-55e9-4b18-87fd-031c464882d2.png)

4. Como podemos observar que desde la url /register se guardan los datos en la base de datos
 ![image](https://user-images.githubusercontent.com/36330412/171533327-fa0321d2-b908-46fc-8a27-63fa8b000c61.png)
 
5. si ingresamos datos errados al login podemos observar que nos devuelve un error
 ![image](https://user-images.githubusercontent.com/36330412/171534502-7d88235b-601c-4178-9c2e-12d45f54627d.png)
 
6. Luego de validar user y pwd retorna el user con su token

![image](https://user-images.githubusercontent.com/36330412/171534839-95c4455f-f0d1-48a8-8f6c-2253ad4ceef6.png)

