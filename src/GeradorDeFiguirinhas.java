import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorDeFiguirinhas {
    
    public void criar(InputStream inputStream, String nomeArquivo) throws Exception {

        BufferedImage imgOriginal = ImageIO.read(inputStream);

        //criar nova imagem em memória com transparencia e novo tamanho
        int largura = imgOriginal.getWidth();
        int altura = imgOriginal.getHeight();
        // Pixel é a unidade
        int novaAltura = altura + 200;

        BufferedImage imgNova = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para a nova (memória)

        Graphics2D graphics = (Graphics2D) imgNova.getGraphics();
        graphics.drawImage(imgOriginal, 0, 0, null);

        // escrever uma frase na nova imagem

        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 64));
        graphics.setColor(Color.darkGray);
        graphics.drawString("TOPZERA", 20, novaAltura - 100);

        // salvar a nova imagem da memória em um arquivo
        ImageIO.write(imgNova, "png", new File("saida/" + nomeArquivo));
    }

}
