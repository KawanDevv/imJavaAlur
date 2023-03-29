import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    
    public void cria() throws Exception {

        // leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(new File("alura-stickers/entrada/imgTeste.jpg"));

        // cria nova imagem em memória com transparência e com tamanho novo

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem =  new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);



        // copiar a imagem original pra nova imagem (em memória)

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // escrever uma mensagem na nova imagem
        ImageIO.write(novaImagem, "png", new File("alura-stickers/saida/figurinha.png"));
        // escrever a nova imagem em um arquivo


    }
    public static void main(String[] args) throws Exception {
        var geradora = new GeradoraDeFigurinhas();
        geradora.cria();
    }
}
