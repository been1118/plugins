package org.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.plugin.Money.*;

public class MoneyCommand {

    private final Main plugin = Main.getInstance();

    public MoneyCommand(CommandSender sender, Command command, String[] args) {
        switch (args.length) {

            case 0:
                showPlayerDataOnCommand((Player) sender, command, args);
                break;
            case 1://돈 A
                if (args[0].equals("저장")) { //돈 저장
                    if (sender.isOp()){
                        saveMoneyData();
                    }else {
                        sender.sendMessage("관리자 전용 명령어 입니다.");
                    } break;
                }

                    sender.sendMessage("대상을 입력해주세요");

                break;
            case 2://돈 주기 DDT
                sender.sendMessage("금액을 입력해주세요");
                break;
            case 3: //돈 주기 DDT 1000
                if (args[0].equals("설정")) { //돈 설정 DDT 1000
                    if (sender.isOp()){
                        setMoney(sender.getName(), Integer.parseInt(args[2]));

                    }else {
                        sender.sendMessage("관리자 전용 명령어 입니다.");
                    } break;
                }





                try {
                    if (Integer.parseInt(args[2]) >= 0 && (Integer.parseInt(args[2]) <= getMoney(plugin.getName()))) {
                        giveMoney(args[1],Integer.getInteger(args[2]));
                        takeMoney(sender.getName(), Integer.parseInt(args[2]));
                    } else {
                        sender.sendMessage("가진것보다 많네요");
                    }
                } catch (NumberFormatException e) {
                    sender.sendMessage("숫자를 입력해주세요");
                }
                break;

        }

    }

    public void giveMoney(String name, int amount) {
        Money.addMoney(name,amount);  //sender한테 돈줌
    }

    public void takeMoney(String name, int amount) { //sender한테 돈 뺌
        Money.addMoney(name,amount*-1);
    }
    public void setMoney(String name, int amount) {
        Money.setMoney(name, amount);
    }
}
