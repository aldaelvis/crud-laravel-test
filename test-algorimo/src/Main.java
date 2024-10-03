import java.io.*;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        System.out.println("Procesando...");
        // descomentar la linea si se desa generar el archivo txt para generar dominios
        generarDominio();
        buscarDominiosShop();
        System.out.println("Finalizado!");
    }


    // Implementacion de de buscar dominios que tengan la palabra "shop"
    public static void buscarDominiosShop() {
        long startTime = System.currentTimeMillis();
        AtomicInteger dominiosConShop = new AtomicInteger();
        AtomicInteger urlsConHtml = new AtomicInteger();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        //Se usa para agrupar, y procesar por bloques
        int numero_bloques = 10000;
        List<Future<Void>> futures = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("dominios.txt"))) {

            Set<String> uniqueDomains = Collections.newSetFromMap(new ConcurrentHashMap<>());
            List<String> block = new ArrayList<>(numero_bloques);
            String linea;

            //lee el archivo linea por linea
            while ((linea = reader.readLine()) != null) {

                //Nos aseguramos que no se procesen duplicados con Set
                if (uniqueDomains.add(linea)) {
                    //Agrupamos en base al cantidad de bloques definidos
                    block.add(linea);
                    if (block.size() == numero_bloques) {

                        // Si se junto ya la cantidad de bloques definido mandamos a procesar con el executor
                        futures.add(procesarBloque(block, dominiosConShop, urlsConHtml, executor));

                        // Entonces luego de procesar necesitamos vaciar la lista para comenzar con otros bloques
                        block = new ArrayList<>(numero_bloques);
                    }
                }

            }

            // Si hay bloques que no han alcanzado la cantidad definida tambien se enviar para procesar
            if (!block.isEmpty()) {
                futures.add(procesarBloque(block, dominiosConShop, urlsConHtml, executor));
            }

            //Se espera la finalizacion de todas ls tareas concurrentes
            for (Future<Void> future : futures) {
                future.get();
            }


        } catch (IOException | ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
        }

        //Medimos el tiempo que demora
        long endTime = System.currentTimeMillis(); // Fin de la medición del tiempo
        long executionTime = endTime - startTime; // Tiempo de ejecución en milisegundos
        System.out.println("Tiempo de ejecución: " + executionTime + " ms");

        //imprimimos los resultados
        System.out.println("Cantidad de dominios que contienen la palabra shop: " + dominiosConShop.get());
        System.out.println("Cantidad de urls que terminan con la extension .html: " + urlsConHtml.get());

    }

    private static Future<Void> procesarBloque(List<String> block, AtomicInteger dominiosConShop,
                                               AtomicInteger urlsConHtml, ExecutorService executor) {

        return executor.submit(() -> {
            block.forEach(dominio -> {
                if (dominio.contains("shop")) {
                    dominiosConShop.incrementAndGet();
                }

                if (dominio.endsWith(".html")) {
                    urlsConHtml.incrementAndGet();
                }
            });

            return null;
        });

    }

    // Metodo para generar dominios en el txt - para las pruebas
    private static void generarDominio() {

        //Definimos el array con los datos que se van a generar de manera aleatoria
        final String[] DOMINIOS = {
                "example.com", "test.com", "myshop.com", "shoponline.com", "website.com",
                "onlineshop.net", "domain.org", "webshop.com", "shopnow.com", "site.net"
        };
        final String[] PATHS = {
                "/producto.html", "/index.html", "/contacto.html", "/about.html", "/servicios.html"
        };


        String fileName = "dominios.txt";
        Random random = new Random();

        // Usamos el bufferewriter para escribir archivos de txt,
        // y usar el try para que se cierre automaticamente luego de escribir
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName))) {

            // Genero datos aleatorios en base a la cantidad
            IntStream.range(0, 1_000_000)
                    .mapToObj(i -> {
                        // Generamos los dominios en base al array
                        String domain = DOMINIOS[random.nextInt(DOMINIOS.length)];
                        // 50% de probabilidad de agregar una ruta con .html
                        if (random.nextBoolean()) {
                            String path = PATHS[random.nextInt(PATHS.length)];
                            return domain + path;
                        } else {
                            // el otro 50% de solo generar dominios
                            return domain;
                        }
                    })
                    .forEach(domain -> { // Escribirmos cada dominio generado por el random en el txt
                        try {
                            writer.write(domain);
                            writer.newLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}