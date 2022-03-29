package link33d.freddie;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;

public class FreddieBot {


    public static void main(String[] args) throws LoginException, InterruptedException {
        JDA jda = JDABuilder.createDefault(System.getenv("TOKEN"), EnumSet.allOf(GatewayIntent.class))
                .build();
        jda.getPresence().setActivity(Activity.playing("FreddieBot..."));
    }
}
