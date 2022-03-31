package me.link33d.freddie;

import me.link33d.freddie.utils.CommandManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;

public class FreddieBot {

    public static JDA jda;
    public static CommandManager cmdMan;

    public static void main(String[] args) {
        try {
            new FreddieBot();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    public FreddieBot() throws LoginException, IllegalArgumentException {

        JDABuilder builder = JDABuilder.createDefault(System.getenv("TOKEN"), EnumSet.allOf(GatewayIntent.class));
        builder.addEventListeners();
        jda = builder.build();

        jda.addEventListener(cmdMan = new CommandManager());

    }
}
