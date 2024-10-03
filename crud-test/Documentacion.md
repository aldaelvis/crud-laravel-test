# Documentacion Laravel CRUD (1)

## Requisitos para ejecutar el programa

- Tener instalado PHP 8.2 en adelante
- Tener instalado composer
- Tener el path de php para poder ejecutar en la linea de comandos.

Una vez cumplido los requisitos, ejecutar comando de inicio: 

1. Instalar los componentes de laravel
    
    `composer install`
    
2. Una vez instalados los archivos se puede ejecutar el proyecto
    
    `php artisan serve` 
    

La base de datos es un **sqlite** asi que no necesita instalar ninguna base de datos adicional

### Proceso del desarrollo

A lo largo del desarrollo para agilizar la construccion de clases y metodos use sus lineas de comandos

1. Crear el modelo, junto con su migración
    
    `php artisan make:model Producto -m`
    
    `-m` indica que debe de crear la migracion el archivo
    
2. En el archivo de migracion definir los campos
    
    `$table->id();`
    
    `$table->string('nombre');`
    
    `$table->text('descripcion')->nullable();`
    
    `$table->decimal('precio', 8, 2);`
    
    `$table->integer('cantidad_en_stock');$table->timestamps();` 
    
3. Crear los controladores que serviran para servir las peticiones HTTP en este caso 
`ProductoController` en este caso tambien utilice el comando por comando para que se cree el archivo
    
    `php artisan make:controller ProductoController --resource`
    
    Esta clase tiene los metodos para poder realizar el crud con sus validaciones, tambien sirve los templates blade dependiendo que funcion se pida.
    
4. Definir la ruta en el routes `web.php`
5. Se crean los templates en blade para poder mostrar la informacion, formularios para crear editar en la carpeta `resources`

[](https://www.notion.so/1141159a77278178bf46dbb7f7db5f4d?pvs=21)

[Algoritmo de rendimiento java test](https://www.notion.so/Algoritmo-de-rendimiento-java-test-1141159a7727817ca97bd22e62678b0f?pvs=21)

[CRUD EN FRAMEWORK DJANGO](https://www.notion.so/CRUD-EN-FRAMEWORK-DJANGO-1141159a772781309c50eb5222931a25?pvs=21)