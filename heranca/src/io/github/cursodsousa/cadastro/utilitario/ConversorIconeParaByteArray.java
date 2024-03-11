package io.github.cursodsousa.cadastro.utilitario;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ConversorIconeParaByteArray {
    public static byte[] iconToByteArray(Icon icon){
        if (icon == null)
            return null;

        BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        // Desenhar o ícone na imagem
        icon.paintIcon(null, g2d, 0, 0);
        g2d.dispose();

        // Converter a imagem em array de bytes
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, "jpg", baos);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return baos.toByteArray();
    }
}