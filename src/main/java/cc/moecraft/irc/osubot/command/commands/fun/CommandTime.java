package cc.moecraft.irc.osubot.command.commands.fun;

import cc.moecraft.irc.osubot.Main;
import cc.moecraft.irc.osubot.command.Command;
import org.pircbotx.Channel;
import org.pircbotx.User;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 此类由 Hykilpikonna 在 2018/04/22 创建!
 * Created by Hykilpikonna on 2018/04/22!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 */
public class CommandTime extends Command
{
    public CommandTime()
    {
        super("time", "currenttime", "ct", "sj", "时间");
    }

    @Override
    public void run(GenericMessageEvent event, User sender, Channel channel, String command, ArrayList<String> args)
    {
        Main.getMessenger().respond(event, "当前时间: " + Main.getLogger().getCurrentTime());
    }

    @Override
    public String permissionRequired()
    {
        return "irc.user.regular.command.time";
    }
}
