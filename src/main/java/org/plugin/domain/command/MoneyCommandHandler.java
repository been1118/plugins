package org.plugin.domain.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.plugin.Main;
import org.plugin.domain.money.Money;

public class MoneyCommandHandler {

    private final Main plugin = Main.getInstance();

    public static void moneyCommandHandler(CommandSender sender, Player player, String[] args) {
        if (args.length == 0) {
            sendHelp(sender);
        }

        String sub = args[0];

        switch (sub) {
            case "송금" -> sendMoney(sender, player, args);
            case "수표" -> checkMoney(sender, player, args);
            case "저장" -> saveMoney(sender);
            case "설정" -> sendMoney(sender, player, args);
            case "빼기" -> minusMoney(sender, player, args);
            case "확인" -> checkMoney(sender, player, args);
            default     -> sender.sendMessage("알 수 없는 명령어입니다. /돈 help");
        }
    }

    private static void sendMoney(CommandSender sender, Player player, String[] args) {
        String target = args[1];
        String amountStr = args[2];

        int amount;
        try {
            amount = Integer.parseInt(amountStr);
        } catch (NumberFormatException e) {
            sender.sendMessage("숫자를 입력해주세요.");
            return;
        }

        int senderMoney = Money.getMoney(player.getName());

        if (amount <= 0) {
            sender.sendMessage("1 이상의 금액을 입력해주세요.");
            return;
        }

        if (amount > senderMoney) {
            sender.sendMessage("보유 금액보다 많습니다!");
            return;
        }

        Money.addMoney(target, amount);
        Money.addMoney(player.getName(), -amount);

        sender.sendMessage(target + "에게 " + amount + "원을 보냈습니다.");
    }

    private static void checkMoney(CommandSender sender, Player player, String[] args) {
        /*
        * todo: 수표 아이템 코드 작성 이후 개발
         */
    }

    private static void saveMoney(CommandSender sender) {
        opCheck(sender);

        Money.saveMoneyData();
        sender.sendMessage("Money Data 저장 완료.");
    }

    private static void minusMoney(CommandSender sender, Player player, String[] args) {
        /*
        * todo
         */
    }

    private static void checkPlayerMoney(CommandSender sender, Player player, String[] args) {
        /*
         * todo
         */
    }

    private static void setMoney(CommandSender sender, Player player, String[] args) {
        /*
         * todo
         */
    }

    private static void opCheck(CommandSender sender) {
        if (!sender.isOp()) sender.sendMessage("관리자 전용 명령어입니다.");
    }

    private static void sendHelp(CommandSender sender) {
        /*
        * todo: help 메세지 적기
         */
        sender.sendMessage("");
    }
}
