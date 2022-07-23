import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        //fazer uma conexão HTTP e buscar o top 250 filmes
        //String url = "https://api.mocki.io/v2/549a5d8b";
        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-07-19&end_date=2022-07-20";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
       

        //pegar só os dados que nos interessam (título, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
  
        //exibir e manipular os dados
        var geradora = new GeradorDeFigurinhas();
        for (Map<String,String> filme : listaDeFilmes){
            //for(int i = 0; i < 10; i++){
                //Map<String,String> filme = listaDeFilmes.get(i);


            String urlImagem = filme.get("url");
            //.replaceAll("(@+)(.*).jpg$", "$1.jpg");
                //filme.get("image");
                
            String titulo = filme.get("title");
            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = "saida/" + titulo + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(titulo);
            System.out.println();
        }
    }
}
