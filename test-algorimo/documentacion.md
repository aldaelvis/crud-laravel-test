# Algoritmo de rendimiento java test

**Problema:**

Tienes una gran lista de URLs almacenadas en un archivo de texto plano.

Algunas URLs pueden estar repetidas y pertenecen a diferentes dominios.

## PROCESO

1. Requerimientos:
    1. Java version 11: [https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
    2. Un IDE o Editar que pueda leer archivos java: (VisualCode, Intellij)
    3. Path de java para ejecutar el programa: al instalar el jdk se agrega el path al sistema para poder usar el comando `java` y `javac`
2. Ejecucion del archivo
    1. Ubicarse en la carpeta principal
    2. Luego navegar a src
        
        `cd src/` 
        
    3. Luego de frente se puede ejecutar , o tambien si se modifica el codigo compilar nuevamente:
        
        Ejecutar programa
        
        `java Main` 
        
        Opcional: Si se modifica el codigo ejecutar nuevamente la compilacion
        
        Compilar:
        
        `javac Main.java`
        
        Ejecutar programa
        
        `java Main`
        
3. Proceso del algoritmo
    
    Se utilizo el algorimo mas conocido como divide y venceras, para poder ejecutar cada linea y agruparlos por bloques dependiendo la cantidad de bloques que se defina en el codigo se definio con 10000 lineas.
    
    Tambien se utilizo concurrencia para poder realizar el algoritmo y sea mas eficiente a nivel de lectura y memora,
    
    En este caso utilize java para poder realizar el algoritmo de busquedas y contar
    
    Las pruebas se realizaron con un metodo adicional que crea archivo con dominios y urls aleatorios para luego poder resolver el problema propuesto.
    
    Se uso `BufferedReader` para cargar el archivo y usar `while` para poder leer linea por linea y despues agruparlos en bloques, cada bloque tiene un contenido de 10000 lineas, y para poder procesarlo cree un pool de Hilos en la cual trabajaran de manera simultanea procesando la informacion de conteo y busqueda, para luego mostrar al final la cantidad final encontrada de “shop”, “.html”
    
    Tambien use los Set y Hash concurrent para poder descartar los duplicados y no se procesen innesesariamente los conteos y busquedas.
    
    En el metodo :`generarDominio` se puede configurar la salida de cuantos datos se puede generar.
    
    El programa fue probado con un archivo de texto de peso de 18GB y el proceso es mas eficiente que de la manera tradicional de busquedas, sin tener problemas de de memoria por que se esta agrupando por bloques como ya mencionado antes.