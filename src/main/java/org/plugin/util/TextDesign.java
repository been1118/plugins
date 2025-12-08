package org.plugin.util;

import net.md_5.bungee.api.ChatColor;

import java.util.Objects;

public class TextDesign {

    public String getText(String line1,String[] color1,String[][] style1) {
        String result = " "+ ChatColor.RESET;
        for (int i = 0; i < line1.length(); i++) {
            if (color1[i].equals(" ")){result+=ChatColor.WHITE + " "; continue;}
            ChatColor color = ChatColor.of(color1[i]);
            char text = line1.charAt(i);
            result += color + "";
            for (int j = 0; j < style1[i].length; j++) {
                if (style1[i][j].equals(" ")){result+=ChatColor.RESET; continue;}
                switch (style1[i][j]) {
                    case "BOLD":
                        result += ChatColor.BOLD;
                        break;
                    case "ITALIC":
                        result += ChatColor.ITALIC;
                        break;
                    case "UNDERLINE":
                        result += ChatColor.UNDERLINE;
                        break;
                    case "STRIKETHROUGH":
                        result += ChatColor.STRIKETHROUGH;
                        break;
                    case "RESET":
                        result += ChatColor.RESET;
                        break;
                    default:
                }
            }
            result += text;
        }

        return result;
    }

}
