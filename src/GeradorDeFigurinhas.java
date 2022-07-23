import java.io.File;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {

   /**
 * @throws Exception
 */
public void cria() throws Exception{

    // leitura da imagem
    BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme1.jpg"));

    // cria nova imagem em memória com transparência e com tamanho novo
    int largura = imagemOriginal.getWidth();
    int altura = imagemOriginal.getHeight();
    int novaAltura = altura + 200;
    BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    // copiar a imagem original pra novo imagem (em memória)
    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(imagemOriginal, 0, 0, null);

    // escrever uma frase na nova imagem 
    graphics.drawString("TOPZERA", 0, novaAltura - 100);

    // escrever a nova imagem em um arquivo
    ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));
   }

   public static void main(String[] args) throws Exception {
    var geradora = new GeradorDeFigurinhas();
    geradora.cria();
   }
}
