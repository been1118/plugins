package org.plugin.domain.scoreBoard;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import org.plugin.domain.money.Money;
import org.plugin.util.TextDesign;


import java.awt.*;
import java.util.Arrays;
import java.util.Objects;

import static org.bukkit.Bukkit.getLogger;

public class ScoreBoard {

    public static void createScoreBoard(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = Objects.requireNonNull(manager).getNewScoreboard();
        Objective obj = scoreboard.registerNewObjective("scoreboard", Criteria.DUMMY, "dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        obj.setDisplayName(scoreBoardColorStyle(0,player));
        Score line1 = obj.getScore(scoreBoardColorStyle(1,player)+Money.getMoney(player.getName()));
        line1.setScore(10);
        Score line2 = obj.getScore(scoreBoardColorStyle(2,player));
        line2.setScore(9);

        player.setScoreboard(scoreboard);
    }

    public static void updateScoreBoard() {
        for (Player online : Bukkit.getOnlinePlayers()) {
//            String money = Objects.requireNonNull(online.getScoreboard().getObjective(DisplaySlot.SIDEBAR).getName());

//            Score line1 = Objects.requireNonNull(online.getScoreboard().getObjective(DisplaySlot.SIDEBAR)).getScore(scoreBoardColorStyle(1,online));
//            //시발 이거 어케고치지
//            line1.setScore(10);
           Objects.requireNonNull(online.getScoreboard().getObjective(DisplaySlot.SIDEBAR)).unregister();
           createScoreBoard(online);
        }
    }

    public static String scoreBoardColorStyle(int line,Player player) {
        final String line0 = "순무서버";
        final String[] color0 = {"#54DAF4","#549CD5","#545EB6","#AD5CCA"};
        final String[][] style0 = {{"BOLD","ITALIC"},{"BOLD","ITALIC"},{"BOLD","ITALIC"},{"BOLD","ITALIC"}};

        final String line1 = "소지금 : ";//오브젝티브 이름만 핵스코드 되고 내용물은 핵스코드 안됨 ㅅㅂ
//        final String[] color1 = {"#54DAF4","#549CD5","#545EB6"," ", "#AD5CCA"," "};
//        final String[][] style1 = {{"BOLD"},{"BOLD"},{"BOLD"},{" "},{"BOLD"},{" "}};

        final String line2 = "직업 : "; /*TODO"구현예정"*/;
//        final String[] color2 = {"#43C8AC","#7FA191"," ", "#F6525C", " "};
//        final String[][] style2 = {{"BOLD"},{"BOLD"},{" "},{"BOLD"},{" "}};

        TextDesign textDesign = new TextDesign();
        return switch (line) {
            case 0 -> textDesign.getText(line0, color0, style0);
            case 1 -> ChatColor.YELLOW + line1;
            case 2 -> ChatColor.GREEN + line2;
            default -> "";
        };
    }
}
