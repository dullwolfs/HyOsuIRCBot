package cc.moecraft.irc.osubot;

import cc.moecraft.yaml.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 此类由 Hykilpikonna 在 2018/04/21 创建!
 * Created by Hykilpikonna on 2018/04/21!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 */
public class BotConfig extends Config
{
    private Logger logger = LoggerFactory.getLogger(BotConfig.class);

    public BotConfig()
    {
        super(Main.VERSION, Main.PATH, "Config", "yml", false, true, true);

        logger.info("配置文件路径: " + getConfigFile().getAbsolutePath());
    }

    /**
     * 获取配置中的用户名
     * irc的用户名就是Osu账号的用户名, 空格用"_"代替
     * @return 用户名
     */
    public String getUsername()
    {
        return getString("AccountProperties.Username");
    }

    /**
     * 设置用户名, 用来生成默认配置
     * @param username 用户名
     */
    public void setUsername(String username)
    {
        addDefault("AccountProperties.Username", username);
    }

    /**
     * 获取配置中的密码
     * Osu有独立的irc密码, 不是Osu账号的登录密码
     * 获取独立密码: https://osu.ppy.sh/p/irc
     * @return 密码
     */
    public String getPassword()
    {
        return getString("AccountProperties.Password");
    }

    /**
     * 设置密码, 用来生成默认配置
     * @param password 密码
     */
    public void setPassword(String password)
    {
        addDefault("AccountProperties.Password", password);
    }

    /**
     * TODO: 写用户系统的权限组系统替代这个管理员系统
     *
     * 获取配置中的管理员用户名列表
     * @return 管理员用户名列表
     */
    public ArrayList<String> getAdminUsernames()
    {
        return new ArrayList<>(getStringList("BotProperties.AdminUsernames"));
    }

    /**
     * 设置管理员用户名列表
     * @param adminUsernames 管理员用户名列表
     */
    public void setAdminUsernames(ArrayList<String> adminUsernames)
    {
        set("BotProperties.AdminUsernames", adminUsernames);
        save();
    }

    @Override
    public void readConfig() {

    }

    @Override
    public void writeConfig() {

    }

    @Override
    public void writeDefaultConfig()
    {
        addDefault("ServerProperties.Address", "irc.ppy.sh");
        addDefault("ServerProperties.Port", 6667);

        setUsername("ChangeThisToTheUsername");
        setPassword("ChangeThisToThePassword");
        setAdminUsernames(new ArrayList<>(Arrays.asList("Hykilpikonna", "dullwolf")));

        addDefault("BotProperties.CommandPrefix", "!");
        addDefault("BotProperties.AutoJoinChannels", new String[]{"#general", "#chinese"});
        save();
    }
}
