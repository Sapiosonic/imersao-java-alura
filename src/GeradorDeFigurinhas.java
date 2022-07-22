import java.io.File;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {

   public void cria() throws Exception{

    // leitura da imagem
    BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme1.jpg"));

    // cria nova imagem em memória com transparência e com tamanho novo
    int largura = imagemOriginal.getWidth();
    int altura = imagemOriginal.getHeight();
    int novaAltura = altura + 200;
    BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    // copiar a imagem original pra novo imagem (em memória)

    // escrever uma frase na nova imagem 

    // escrever a nova imagem em um arquivo
   }
}
