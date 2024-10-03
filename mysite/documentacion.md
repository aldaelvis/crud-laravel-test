# CRUD EN FRAMEWORK DJANGO

Primeramente entre a la documentacion de django de como instalar que requisitos hay que tener para poder iniciar un proyecto:

[https://docs.djangoproject.com/en/5.1/intro/install/](https://docs.djangoproject.com/en/5.1/intro/install/)

Requerimientos:

1. tener instalado python 3
2. Tener instalado Django que tiene que estar en el path para poder crear proyectos
3. No se necesita instalar ninguna base de datos porque por default uso sqllite3

Ejecucion del programa, estar ubicado en la carpeta de proyecto django y ejecutar:

`python3 [manage.py](http://manage.py) runserver`

Para poder crear la tabla y generar la migracion entre a la documentacion de django y me apoye en stackoverflow para conseguir informacion sobre validaciones de los campos y como crear mis campos de la tabla.

[https://docs.djangoproject.com/en/5.1/topics/db/models/](https://docs.djangoproject.com/en/5.1/topics/db/models/)

Segui la misma logica de Laravel framework que ya conosco y trate de siguir los pasos que se hace en hay.

1. crear modelo
2. crear campos de la tabla
3. crear controlador
4. crear rutas
5. crear templates
6. ejecutar la migraciones

Entonces en las vistas cree las rutas que van a servir las peticiones HTTP de los metodos crud renderisando las plantillas

Tambien cree una carpeta de templates donde se ubican los templates de los productos, tambien use la herencia de plantillas para poder facilitar.

[https://docs.hektorprofe.net/django/web-personal/herencia-plantillas-templates/](https://docs.hektorprofe.net/django/web-personal/herencia-plantillas-templates/)

Algo que note es que tambien django tiene para generar formularios desde sus archivos constructores, y tambien un administrador ya hecho.