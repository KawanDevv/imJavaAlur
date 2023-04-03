import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        // leitura da imagem

        // InputStream inputStream = 
        //              new FileInputStream(new File("alura-stickers/entrada/imgTeste.jpg"));
        // InputStream inputStream = 
        //              new URL("https://m.media-amazon.com/images/M/MV5BOWEwODJmZDItYTNmZC00OGM4LThlNDktOTQzZjIzMGQxODA4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_UX128_CR0,12,128,176_AL_.jpg")
        //              .openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria nova imagem em memória com transparência e com tamanho novo 

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem =  new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);



        // copiar a imagem original pra nova imagem (em memória)

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);


        // configurar fonte

        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setFont(fonte);
        graphics.setColor(Color.YELLOW);    
        // escrever uma mensagem na nova imagem

        graphics.drawString("TOPZERA", largura , novaAltura - 100);


        // escrever a nova imagem em um arquivo

         ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }
 
    
}
