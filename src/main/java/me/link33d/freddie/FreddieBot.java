package me.link33d.freddie;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.io.IOException;
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

        JDABuilder builder = JDABuilder.createDefault("OTU5MDMxMjMxMTI5OTc2ODYy.YkV9bw.YooJs_4UT7go7r4G12u_Q5sszSc", EnumSet.allOf(GatewayIntent.class));
        builder.addEventListeners();
        jda = builder.build();

        jda.addEventListener(cmdMan = new CommandManager());

    }
}
