package com.daimamingong.common.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class CaptchaUtil {

    // 图片的宽度。
    private int width = 160;

    // 图片的高度。
    private int height = 40;

    // 验证码字符个数
    private int codeCount = 5;

    // 验证码干扰线数
    private int lineCount = 150;

    // 验证码
    private String code = null;

    // 验证码图片Buffer
    private BufferedImage buffImg = null;

    private char[] codeSequence = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
            'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'
    };

    public CaptchaUtil() {
        this.createImage();
    }

    /**
     * @param width  图片宽
     * @param height 图片高
     */
    public CaptchaUtil(int width, int height) {
        this.width = width;
        this.height = height;
        this.createImage();
    }

    /**
     * @param width     图片宽
     * @param height    图片高
     * @param codeCount 字符个数
     * @param lineCount 干扰线条数
     */
    public CaptchaUtil(int width, int height, int codeCount, int lineCount) {
        this.width = width;
        this.height = height;
        this.codeCount = codeCount;
        this.lineCount = lineCount;
        this.createImage();
    }

    /**
     * 生成图片
     */
    private void createImage() {
        // 图像buffer
        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = buffImg.createGraphics();
        // 将图像填充为白色
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // 创建字体
        this.createImgaeFont(g);

        // 生成干扰线
        this.createInterferenceLines(g);

        // randomCode记录随机产生的验证码
        this.createCaptchaCode(g);
    }

    /**
     * 产生随机验证码
     *
     * @param g
     */
    private void createCaptchaCode(Graphics2D g) {
        int red, green, blue;
        int x = width / (codeCount + 2);// 每个字符的宽度
        int codeY = height - 4;
        // 生成随机数
        Random random = new Random();

        // randomCode记录随机产生的验证码
        StringBuffer randomCode = new StringBuffer();
        for (int i = 0; i < codeCount; i++) {
            String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
            // 产生随机的颜色值，让输出的每个字符的颜色值都将不同。
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            g.setColor(new Color(red, green, blue));
            g.drawString(strRand, (i + 1) * x, codeY);
            randomCode.append(strRand);
        }
        code = randomCode.toString();
    }

    /**
     * 创建图片字体
     *
     * @return
     */
    private void createImgaeFont(Graphics2D g) {
        int fontHeight = height - 2;// 字体的高度
        ImgFontByte imgFont = new ImgFontByte();
        g.setFont(imgFont.getFont(fontHeight));
    }

    /**
     * 生成干扰线
     *
     * @param g
     */
    private void createInterferenceLines(Graphics2D g) {
        int red, green, blue;
        // 生成随机数
        Random random = new Random();
        for (int i = 0; i < lineCount; i++) {
            int xs = random.nextInt(width);
            int ys = random.nextInt(height);
            int xe = xs + random.nextInt(width / 8);
            int ye = ys + random.nextInt(height / 8);
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            g.setColor(new Color(red, green, blue));
            g.drawLine(xs, ys, xe, ye);
        }
    }

    public void write(String path) throws IOException {
        this.write(new FileOutputStream(path));
    }

    public void write(OutputStream sos) throws IOException {
        ImageIO.write(buffImg, "JPEG", sos);
    }

    public BufferedImage getBuffImg() {
        return buffImg;
    }

    public String getCode() {
        return code;
    }

}

